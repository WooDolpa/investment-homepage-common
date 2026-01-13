package san.investment.common.entity.portfolio;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import san.investment.common.converter.DataStatusConverter;
import san.investment.common.entity.BaseEntity;
import san.investment.common.enums.DataStatus;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "portfolio_news")
public class PortfolioNews extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer portfolioNewsNo;

    @Column(name = "news_title")
    @Comment("뉴스 제목")
    private String newsTitle;

    @Column(name = "news_agency")
    @Comment("뉴스 언론사")
    private String newsAgency;

    @Column(name = "news_link")
    @Comment("뉴스 링크")
    private String newsLink;

    @Column(name = "order_num")
    @Comment("순번")
    private Integer orderNum;

    @Convert(converter = DataStatusConverter.class)
    @Column(name = "data_status", nullable = false)
    @Comment("데이터 상태")
    private DataStatus dataStatus;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "portfolio_no")
    @Comment("포트폴리오")
    private Portfolio portfolio;

    @Builder
    public PortfolioNews(Integer portfolioNewsNo, String newsTitle, String newsAgency, String newsLink, Integer orderNum, DataStatus dataStatus, Portfolio portfolio) {
        this.portfolioNewsNo = portfolioNewsNo;
        this.newsTitle = newsTitle;
        this.newsAgency = newsAgency;
        this.newsLink = newsLink;
        this.orderNum = orderNum;
        this.dataStatus = dataStatus;
        this.portfolio = portfolio;
    }

    public void increaseOrderNum() {
        orderNum++;
    }

    public void decreaseOrderNum() {
        orderNum--;
    }
}
