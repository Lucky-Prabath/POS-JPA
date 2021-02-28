package lk.ijse.dep.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Data @NoArgsConstructor @AllArgsConstructor
public class ErrorDTO implements Serializable {
    private int status;
    private String error;
    private String message;
}
