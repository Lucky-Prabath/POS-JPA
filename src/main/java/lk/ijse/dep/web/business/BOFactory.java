package lk.ijse.dep.web.business;

import lk.ijse.dep.web.business.custom.impl.CustomerBOImpl;
import lk.ijse.dep.web.business.custom.impl.ItemBOImpl;
import lk.ijse.dep.web.business.custom.impl.OrderBOImpl;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory != null) ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends SuperBO> T getBO(BOTypes boType) {
        switch (boType) {
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case ORDER:
                return (T) new OrderBOImpl();
            default:
                return null;
        }
    }
}
