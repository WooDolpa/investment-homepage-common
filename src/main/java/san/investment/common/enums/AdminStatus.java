package san.investment.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum AdminStatus {

    YES("Y", "사용"),
    NO("N", "사용안함"),
    DELETE("D", "삭제")
    ;

    private final String key;
    private final String description;

    public static AdminStatus findAdminStatus(String key) {
        return Arrays.stream(AdminStatus.values())
                .filter(i -> i.key.equals(key))
                .findFirst()
                .orElse(null);
    }
}
