package lk.ijse.dep.web.business.custom;

import lk.ijse.dep.web.business.SuperBO;
import lk.ijse.dep.web.dto.OrderDTO;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
public interface OrderBO extends SuperBO {

    public void placeOrder(OrderDTO orderDTO) throws Exception;
}
