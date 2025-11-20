package san.investment.common.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import san.investment.common.enums.AdminStatus;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "admin")
public class Admin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer adminNo;

    @Column(name = "login_id", nullable = false, length = 20)
    @Comment("관리자 아이디")
    private String loginId;

    @Column(name = "password", nullable = false, length = 255)
    @Comment("관리자 비밀번호")
    private String password;

    @Column(name = "admin_name", length = 20)
    @Comment("관리자 명")
    private String adminName;

//    @Convert(converter = AdminStatusConverter.class)
    @Column(name = "admin_status")
    @Comment("관리자 상태")
    private AdminStatus adminStatus;
}
