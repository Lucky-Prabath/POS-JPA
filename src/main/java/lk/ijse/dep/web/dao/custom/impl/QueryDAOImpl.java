package lk.ijse.dep.web.dao.custom.impl;

import lk.ijse.dep.web.dao.custom.QueryDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager(EntityManager em) {
        return em;
    }
}
