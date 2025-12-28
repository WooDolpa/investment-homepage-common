package san.investment.common.entity.portfolio;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.util.StringUtils;
import san.investment.common.converter.DataStatusConverter;
import san.investment.common.entity.BaseEntity;
import san.investment.common.enums.DataStatus;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * packageName : san.investment.common.entity.portfolio
 * className : Portfolio
 * user : jwlee
 * date : 2025. 12. 27.
 * description :
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "portfolio")
public class Portfolio extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Comment("포트폴리오 번호")
    private Integer portfolioNo;

    @Column(name = "portfolio_title")
    @Comment("포트폴리오 제목")
    private String portfolioTitle;

    @Column(name = "portfolio_summary")
    @Comment("포트폴리오 요약")
    private String portfolioSummary;

    @Column(name = "portfolio_img_url")
    @Comment("포트폴리오 이미지")
    private String portfolioImgUrl;

    @Column(name = "portfolio_contents")
    @Comment("포트폴리오 내용")
    private String portfolioContents;

    @Column(name = "order_num")
    @Comment("순번")
    private Integer orderNum;

    @Convert(converter = DataStatusConverter.class)
    @Column(name = "data_status", nullable = false)
    @Comment("데이터 상태")
    private DataStatus dataStatus;

    @Builder
    public Portfolio(Integer portfolioNo, String portfolioTitle, String portfolioSummary, String portfolioImgUrl, String portfolioContents, Integer orderNum, DataStatus dataStatus) {
        this.portfolioNo = portfolioNo;
        this.portfolioTitle = portfolioTitle;
        this.portfolioSummary = portfolioSummary;
        this.portfolioImgUrl = portfolioImgUrl;
        this.portfolioContents = portfolioContents;
        this.orderNum = orderNum;
        this.dataStatus = dataStatus;
    }

    public void addPortfolioImgUrl(String portfolioImgUrl) {
        if(StringUtils.hasText(portfolioImgUrl)) {
            this.portfolioImgUrl = portfolioImgUrl;
        }
    }

    public void increaseOrderNum() {
        orderNum++;
    }

    public void decreaseOrderNum() {
        orderNum--;
    }

    public void changePortfolioTitle(String portfolioTitle) {
        if(StringUtils.hasText(portfolioTitle)) {
            this.portfolioTitle = portfolioTitle;
        }
    }

    public void changePortfolioSummary(String portfolioSummary) {
        if(StringUtils.hasText(portfolioSummary)) {
            this.portfolioSummary = portfolioSummary;
        }
    }

    public void changePortfolioImgUrl(String portfolioImgUrl) {
        if(StringUtils.hasText(portfolioImgUrl)) {
            this.portfolioImgUrl = portfolioImgUrl;
        }
    }
    public void changePortfolioContents(String portfolioContents) {
        if(StringUtils.hasText(portfolioContents)) {
            this.portfolioContents = portfolioContents;
        }
    }

    public void changeOrderNum(Integer orderNum) {
        if(orderNum != null && orderNum > 0) {
            this.orderNum = orderNum;
        }
    }

    public void changeDataStatus(DataStatus dataStatus) {
        if(dataStatus != null) {
            this.dataStatus = dataStatus;
        }
    }

    public void deleteOrderNum(Integer orderNum) {
        if(orderNum != null) {
            this.orderNum = orderNum;
        }
    }
}
