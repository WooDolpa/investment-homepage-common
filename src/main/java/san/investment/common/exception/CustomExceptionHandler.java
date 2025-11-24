package san.investment.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import san.investment.common.dto.ApiResponseDto;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleException(CustomException e) {
        return new ResponseEntity<>(ApiResponseDto.makeResponse(e), e.getHttpStatus());
    }
}
