package san.investment.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PortfolioType {

    PROGRESS("P", "진행"),
    COMPLETE("C", "완료")
    ;

    private final String key;
    private final String desc;

    public static PortfolioType findPortfolioType(String key) {
        return Arrays.stream(PortfolioType.values())
                .filter(i -> i.key.equals(key))
                .findFirst()
                .orElse(null);
    }
}
