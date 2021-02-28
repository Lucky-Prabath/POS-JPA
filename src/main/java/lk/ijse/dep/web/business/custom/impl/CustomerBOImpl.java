package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.DAOFactory;
import lk.ijse.dep.web.dao.DAOTypes;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Component
public class CustomerBOImpl implements CustomerBO {

    private final CustomerDAO customerDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public CustomerBOImpl() {
        customerDAO = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        customerDAO.setEntityManager(em);
    }

    @Override
    public void saveCustomer(CustomerDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            customerDAO.save(mapper.getCustomer(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        try {
            em.getTransaction().begin();
            customerDAO.update(mapper.getCustomer(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        try {
            em.getTransaction().begin();
            customerDAO.delete(customerId);
            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }

    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
        try {
            em.getTransaction().begin();
            List<CustomerDTO> customerDTOs = mapper.getCustomerDTOs(customerDAO.getAll());
            em.getTransaction().commit();
            return customerDTOs;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        }
    }
}

