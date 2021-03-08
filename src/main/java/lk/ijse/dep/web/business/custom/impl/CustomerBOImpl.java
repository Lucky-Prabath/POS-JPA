package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Service
@Transactional
public class CustomerBOImpl implements CustomerBO {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EntityDTOMapper mapper;

    public CustomerBOImpl() {
    }

    @Override
    public void saveCustomer(CustomerDTO dto) throws Exception {
            customerDAO.save(mapper.getCustomer(dto));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws Exception {
        customerDAO.save(mapper.getCustomer(dto));
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
            customerDAO.deleteById(customerId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CustomerDTO> findAllCustomers() throws Exception {
            List<CustomerDTO> customerDTOs = mapper.getCustomerDTOs(customerDAO.findAll());
            return customerDTOs;
    }

    @Override
    public CustomerDTO findCustomer(String customerId) throws Exception {
        return mapper.getCustomerDTO(customerDAO.findById(customerId).get());
    }
}

