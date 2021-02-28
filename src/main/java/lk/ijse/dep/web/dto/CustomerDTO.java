package lk.ijse.dep.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Data @AllArgsConstructor @NoArgsConstructor
public class CustomerDTO implements Serializable {
    private String id;
    private String name;
    private String address;
}
