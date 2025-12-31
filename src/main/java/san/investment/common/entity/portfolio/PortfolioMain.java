package san.investment.common.entity.portfolio;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import san.investment.common.entity.BaseEntity;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * packageName : san.investment.common.entity.portfolio
 * className : PortfolioMain
 * user : jwlee
 * date : 2025. 12. 29.
 * description :
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "portfolio_main")
public class PortfolioMain extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer portfolioMainNo;

    @Column(name = "order_num")
    @Comment("순번")
    private Integer orderNum;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "portfolio_no")
    private Portfolio portfolio;

    @Builder
    public PortfolioMain(Integer portfolioMainNo, Integer orderNum, Portfolio portfolio) {
        this.portfolioMainNo = portfolioMainNo;
        this.orderNum = orderNum;
        this.portfolio = portfolio;
    }

    public void increaseOrderNum() {
        this.orderNum++;
    }

    public void decreaseOrderNum() {
        this.orderNum--;
    }
}
