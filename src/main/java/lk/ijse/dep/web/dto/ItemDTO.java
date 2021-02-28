package lk.ijse.dep.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Data @AllArgsConstructor @NoArgsConstructor
public class ItemDTO implements Serializable {
    private String code;
    private String description;
    private BigDecimal unitPrice;
    private Integer qtyOnHand;
}
