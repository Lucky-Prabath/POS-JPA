package lk.ijse.dep.web.business.custom;

import lk.ijse.dep.web.business.SuperBO;
import lk.ijse.dep.web.dto.CustomerDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
public interface CustomerBO extends SuperBO {

    public void saveCustomer(CustomerDTO customerDTO) throws Exception;

    public void updateCustomer(CustomerDTO customerDTO) throws Exception;

    public void deleteCustomer(String customerId) throws Exception;

    public List<CustomerDTO> findAllCustomers() throws Exception;

    CustomerDTO findCustomer(String customerId) throws Exception;
}
