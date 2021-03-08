package lk.ijse.dep.web.api;

import lk.ijse.dep.web.business.custom.CustomerBO;
import lk.ijse.dep.web.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-08
 **/

@RequestMapping("/api/v1/customers")
@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerBO customerBO;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerBO.findAllCustomers();
    }

    @GetMapping(value = "/{id:C\\d{3}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomer(@PathVariable String id) throws Exception {
        return customerBO.findCustomer(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        customerBO.saveCustomer(customerDTO);
        return customerDTO.getId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id:C\\d{3}}")
    public void deleteCustomer(@PathVariable String id) throws Exception {
        customerBO.deleteCustomer(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id:C\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        customerBO.updateCustomer(customerDTO);
    }
}
