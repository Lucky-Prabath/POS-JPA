package lk.ijse.dep.web.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-08
 **/

@RestControllerAdvice
public class AppWideExceptionHandler {

    Logger logger = LoggerFactory.getLogger(AppWideExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public String globalExceptionHandler(Throwable t){
        logger.error(null, t);
        return "Something went wrong, please contact DEP-6 students";
    }
}
