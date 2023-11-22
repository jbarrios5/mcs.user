package py.com.jmbr.mcs.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import py.com.jmbr.java.commons.exception.ExceptionResponse;
import py.com.jmbr.java.commons.exception.JMBRException;

@ControllerAdvice
public class UserException {
    @ExceptionHandler( value = {JMBRException.class})
    public ResponseEntity<ExceptionResponse> handleException(JMBRException e){
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(e.getMessage(),e.getType()),e.getCode());
    }
}
