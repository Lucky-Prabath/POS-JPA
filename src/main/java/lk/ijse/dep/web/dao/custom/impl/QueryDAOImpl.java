package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.custom.QueryDAO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Component
public class QueryDAOImpl implements QueryDAO {

    @Override
    public void setEntityManager(EntityManager em) {

    }
}
