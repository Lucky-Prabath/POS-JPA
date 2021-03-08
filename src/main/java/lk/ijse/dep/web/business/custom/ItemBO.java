package lk.ijse.dep.web.business.custom;

import lk.ijse.dep.web.business.SuperBO;
import lk.ijse.dep.web.dto.ItemDTO;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
public interface ItemBO extends SuperBO {

    public void saveItem(ItemDTO itemDTO) throws Exception;

    public void updateItem(ItemDTO itemDTO) throws Exception;

    public void deleteItem(String itemCode) throws Exception;

    public List<ItemDTO> findAllItems() throws Exception;

    ItemDTO findItem(String itemCode) throws Exception;

}
