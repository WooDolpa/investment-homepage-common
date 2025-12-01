package san.investment.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "-1", "서버에러"),
    EXPIRE_TOKEN(HttpStatus.UNAUTHORIZED, "-2", "토큰이 만료 되었습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "-3", "유효하지 않은 토큰입니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "-4", "유효하지 않은 리플래쉬 토큰입니다."),
    EXPIRE_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "-5", "리플래쉬 토큰이 만료 되었습니다."),
    // 로그인 관련
    INVALID_USER_ID(HttpStatus.UNAUTHORIZED,"-100", "유효하지 않은 사용자 ID 입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "-101", "비밀번호가 일치하지 않습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
