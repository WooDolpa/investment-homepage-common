package san.investment.common.entity.auth;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import san.investment.common.entity.BaseEntity;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cc_auth")
public class CcAuth extends BaseEntity {

    @Id
    @Comment("관리자 번호")
    private Integer adminNo;

    @Column(name = "refresh_token", nullable = false, length = 512)
    @Comment("refresh token")
    private String refreshToken;

    @Column(name = "expire_date", nullable = false)
    @Comment("만료 일자")
    private LocalDateTime expireDate;

    @Builder
    public CcAuth(Integer adminNo, String refreshToken, LocalDateTime expireDate) {
        this.adminNo = adminNo;
        this.refreshToken = refreshToken;
        this.expireDate = expireDate;
    }

    public void changeRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void changeExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }
}
