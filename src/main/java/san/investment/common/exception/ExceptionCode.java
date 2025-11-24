package san.investment.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "-1", "서버에러"),

    // 로그인 관련
    INVALID_USER_ID(HttpStatus.UNAUTHORIZED,"-100", "유효하지 않은 사용자 ID 입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
