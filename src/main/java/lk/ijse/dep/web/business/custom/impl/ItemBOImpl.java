package lk.ijse.dep.web.business.custom.impl;

import lk.ijse.dep.web.business.custom.ItemBO;
import lk.ijse.dep.web.business.util.EntityDTOMapper;
import lk.ijse.dep.web.dao.ItemDAO;
import lk.ijse.dep.web.dto.ItemDTO;
import lk.ijse.dep.web.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Service
@Transactional
public class ItemBOImpl implements ItemBO {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private EntityDTOMapper mapper;

    public ItemBOImpl() {
    }

    @Override
    public void saveItem(ItemDTO itemDTO) throws Exception {
            itemDAO.save(mapper.getItem(itemDTO));
    }

    @Override
    public void updateItem(ItemDTO itemDTO) throws Exception {
            itemDAO.save(mapper.getItem(itemDTO));
    }

    @Override
    public void deleteItem(String itemCode) throws Exception {
            itemDAO.deleteById(itemCode);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ItemDTO> findAllItems() throws Exception {
            List<Item> items = itemDAO.findAll();
            return mapper.getItemDTOs(items);
    }

    @Override
    public ItemDTO findItem(String itemCode) throws Exception {
        return mapper.getItemDTO(itemDAO.findById(itemCode).get());
    }
}
