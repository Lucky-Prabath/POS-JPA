package lk.ijse.dep.web.dao;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
public interface SuperDAO {

    EntityManager getEntityManager(EntityManager em);
}
