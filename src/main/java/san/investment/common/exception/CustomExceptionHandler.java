package san.investment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import san.investment.common.dto.ApiResponseDto;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleException(CustomException e) {
        return new ResponseEntity<>(ApiResponseDto.makeResponse(e), e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e) {
        CustomException customException = new CustomException(ExceptionCode.INVALID_PARAMETER);
        return new ResponseEntity<>(ApiResponseDto.makeResponse(customException), HttpStatus.BAD_REQUEST);
    }
}
