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
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "-6", "유효하지 않은 파라미터입니다."),
    // 로그인 관련
    INVALID_USER_ID(HttpStatus.UNAUTHORIZED,"-100", "유효하지 않은 사용자 ID 입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "-101", "비밀번호가 일치하지 않습니다."),

    // 회사 관련
    NOT_FOUND_COMPANY(HttpStatus.NOT_FOUND, "-110", "존재하지 않는 회사입니다."),

    // 메뉴 관련
    MENU_NOT_FOUND(HttpStatus.NOT_FOUND, "-120", "존재하지 않는 메뉴입니다."),

    // 포트폴리오 관련
    PORTFOLIO_NOT_FOUND(HttpStatus.NOT_FOUND, "-130", "존재하지 않는 포트폴리오입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
