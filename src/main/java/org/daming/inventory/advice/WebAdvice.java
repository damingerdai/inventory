package org.daming.inventory.advice;

import org.daming.inventory.constants.ErrorCodeConstants;
import org.daming.inventory.pojo.Error;
import org.daming.inventory.pojo.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-15 09:46
 */
@RestControllerAdvice
public class WebAdvice {

    @ExceptionHandler(Exception.class)
    public ErrorResponse expectionHandler(Exception ex) {
        return new ErrorResponse().setError(new Error().setCode(ErrorCodeConstants.ERR_SYSTEM).setMessage(ex.getMessage()));
    }
}
