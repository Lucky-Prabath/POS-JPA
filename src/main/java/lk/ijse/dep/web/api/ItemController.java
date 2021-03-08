package lk.ijse.dep.web.api;

import lk.ijse.dep.web.business.custom.ItemBO;
import lk.ijse.dep.web.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-08
 **/

@RequestMapping("/api/v1/items")
@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    private ItemBO itemBO;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() throws Exception {
        return itemBO.findAllItems();
    }

    @GetMapping(value = "/{code:I\\d{3}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO getItem(@PathVariable String code) throws Exception {
        return itemBO.findItem(code);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveItem(@RequestBody ItemDTO itemDTO) throws Exception {
        itemBO.saveItem(itemDTO);
        return itemDTO.getCode();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{code:I\\d{3}}")
    public void deleteItem(@PathVariable String code) throws Exception {
        itemBO.deleteItem(code);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{code:I\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@RequestBody ItemDTO itemDTO) throws Exception {
        itemBO.updateItem(itemDTO);
    }
}
