package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.CrudDAOImpl;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.entity.Customer;
import org.springframework.stereotype.Component;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Component
public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {

}
