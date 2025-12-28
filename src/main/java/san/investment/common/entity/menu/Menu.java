package san.investment.common.entity.menu;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.util.StringUtils;
import san.investment.common.converter.DataStatusConverter;
import san.investment.common.entity.BaseEntity;
import san.investment.common.enums.DataStatus;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * packageName : san.investment.common.entity.menu
 * className : Menu
 * user : jwlee
 * date : 2025. 12. 21.
 * description :
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Comment("메뉴 아이디")
    private Integer menuId;

    @Column(name = "menu_name", length = 32)
    @Comment("메뉴명")
    private String menuName;

    @Column(name = "menu_url")
    @Comment("메뉴 경로")
    private String menuUrl;

    @Column(name = "order_num")
    @Comment("순번")
    private Integer orderNum;

    @Convert(converter = DataStatusConverter.class)
    @Column(name = "data_status", nullable = false)
    @Comment("데이터 상태")
    private DataStatus dataStatus;

    public void changeMenuName(String menuName) {
        if(StringUtils.hasText(menuName)) {
            this.menuName = menuName;
        }
    }

    public void changeOrderNum(Integer orderNum) {
        if(orderNum != null) {
            this.orderNum = orderNum;
        }
    }

    public void changeDataStatus(DataStatus dataStatus) {
        if(dataStatus != null) {
            this.dataStatus = dataStatus;
        }
    }

    public void increaseOrderNum() {
        orderNum++;
    }

    public void decreaseOrderNum() {
        orderNum--;
    }
}
