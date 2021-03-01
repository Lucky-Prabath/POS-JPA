package lk.ijse.dep.web.business;

import javax.persistence.EntityManager;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

public interface SuperBO {

    void setEntityManager(EntityManager em);

    EntityManager getEntityManager(); //use for aspectj
}
