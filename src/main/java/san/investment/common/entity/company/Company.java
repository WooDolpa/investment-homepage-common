package san.investment.common.entity.company;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import san.investment.common.converter.DataStatusConverter;
import san.investment.common.entity.BaseEntity;
import san.investment.common.enums.DataStatus;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * packageName : san.investment.common.entity.company
 * className : Company
 * user : jwlee
 * date : 2025. 12. 21.
 * description :
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "company")
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Comment("회사 번호")
    private Integer companyNo;

    @Column(name = "company_name", length = 32)
    @Comment("회사 명")
    private String companyName;

    @Column(name = "logo_url", length = 128)
    @Comment("로고 이미지")
    private String logoUrl;

    @Column(name = "main_img_url", length = 128)
    @Comment("메인 이미지")
    private String mainImgUrl;

    @Column(name = "company_info")
    @Comment("회사 설명")
    private String companyInfo;

    @Column(name = "post_code", length = 5)
    @Comment("우편번호")
    private String postCode;

    @Column(name = "address", length = 128)
    @Comment("주소")
    private String address;

    @Column(name = "address_detail", length = 255)
    @Comment("주소 상세")
    private String addressDetail;

    @Convert(converter = DataStatusConverter.class)
    @Column(name = "data_status", nullable = false)
    @Comment("데이터 상태")
    private DataStatus dataStatus;
}
