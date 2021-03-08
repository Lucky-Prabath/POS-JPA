package lk.ijse.dep.web.business.util;

import lk.ijse.dep.web.WebAppInitializer;
import lk.ijse.dep.web.dao.custom.CustomerDAO;
import lk.ijse.dep.web.dto.CustomerDTO;
import lk.ijse.dep.web.dto.ItemDTO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.dto.OrderDetailDTO;
import lk.ijse.dep.web.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Mapper(componentModel = "spring")
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    Customer getCustomer(CustomerDTO dto);

    CustomerDTO getCustomerDTO(Customer customer);

    List<CustomerDTO> getCustomerDTOs(List<Customer> customers);

    Item getItem(ItemDTO dto);

    ItemDTO getItemDTO(Item item);

    List<ItemDTO> getItemDTOs(List<Item> item);


    @Mapping(source = "orderId", target = "id")
    @Mapping(source = ".", target = "date")
    @Mapping(source = ".", target = "customer")
    Order getOrder(OrderDTO dto);

    default Date toDate(OrderDTO dto){
        return Date.valueOf(dto.getOrderDate());
    }

    default Customer getCustomer(OrderDTO dto) throws Exception {
            CustomerDAO dao = WebAppInitializer.getContext().getBean(CustomerDAO.class);
            return dao.get(dto.getCustomerId());
    }

    @Mapping(source = ".", target = "orderDetailPK", qualifiedByName = "pk")
    OrderDetail getOrderDetail(OrderDetailDTO dto);

    @Named("pk")
    default OrderDetailPK toOrderDetailPK(OrderDetailDTO dto){
        return new OrderDetailPK(dto.getOrderId(), dto.getItemCode());
    }
}
