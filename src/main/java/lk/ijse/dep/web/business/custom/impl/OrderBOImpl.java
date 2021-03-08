package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.OrderBO;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.ItemDAO;
import lk.ijse.dep.web.dao.OrderDAO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.entity.Item;
import lk.ijse.dep.web.entity.Order;
import lk.ijse.dep.web.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Service
@Transactional
public class OrderBOImpl implements OrderBO {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private EntityDTOMapper mapper;

    public OrderBOImpl() {
    }


    @Override
    public void placeOrder(OrderDTO orderDTO) throws Exception {

            Order order = mapper.getOrder(orderDTO);
            orderDAO.save(order);
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                Item item = itemDAO.findById(orderDetail.getOrderDetailPK().getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                if (item.getQtyOnHand() < 0){
                    throw new RuntimeException("Invalid Qty.");
                }
                itemDAO.save(item);
            }

    }
}
