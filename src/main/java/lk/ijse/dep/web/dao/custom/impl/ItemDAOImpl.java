package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.CrudDAOImpl;
import lk.ijse.dep.web.dao.custom.ItemDAO;
import lk.ijse.dep.web.entity.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Repository
public class ItemDAOImpl extends CrudDAOImpl<Item, String> implements ItemDAO {

}
