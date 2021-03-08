package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
public interface CustomerDAO extends JpaRepository<Customer, String> {
}
