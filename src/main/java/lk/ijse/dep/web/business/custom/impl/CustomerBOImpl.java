package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.business.util.DEPTransaction;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Component
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    private CustomerDAO customerDAO;
    private EntityManager em;
    @Autowired
    private EntityDTOMapper mapper;

    public CustomerBOImpl() {
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        customerDAO.setEntityManager(em);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.em;
    }

    @DEPTransaction
    @Override
    public void saveCustomer(CustomerDTO dto) throws Exception {
            customerDAO.save(mapper.getCustomer(dto));
    }

    @DEPTransaction
    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        customerDAO.update(mapper.getCustomer(dto));
    }

    @DEPTransaction
    @Override
    public void deleteCustomer(String customerId) throws Exception {
            customerDAO.delete(customerId);
    }

    @DEPTransaction
    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
            List<CustomerDTO> customerDTOs = mapper.getCustomerDTOs(customerDAO.getAll());
            return customerDTOs;
    }
}

