package san.investment.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * packageName : san.investment.common.enums
 * className : DataStatus
 * user : jwlee
 * date : 2025. 12. 21.
 * description :
 */
@Getter
@RequiredArgsConstructor
public enum DataStatus {

    Yes("Y", "사용"),
    No("N", "미사용"),
    Delete("D", "삭제")
    ;

    private final String key;
    private final String desc;

    public static DataStatus findDataStatus(String key) {
        return Arrays.stream(DataStatus.values())
                .filter(i -> i.key.equals(key))
                .findAny()
                .orElse(DataStatus.Yes);
    }
}
