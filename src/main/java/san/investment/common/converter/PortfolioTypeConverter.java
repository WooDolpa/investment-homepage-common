package san.investment.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
import san.investment.common.enums.PortfolioType;
import san.investment.common.exception.CustomException;
import san.investment.common.exception.ExceptionCode;

@Slf4j
@Converter(autoApply = true)
public class PortfolioTypeConverter implements AttributeConverter<PortfolioType, String> {

    @Override
    public String convertToDatabaseColumn(PortfolioType portfolioType) {
        if (portfolioType == null) {
            return null;
        }
        return portfolioType.getKey();
    }

    @Override
    public PortfolioType convertToEntityAttribute(String s) {

        if(s == null) {
            return null;
        }

        PortfolioType portfolioType = PortfolioType.findPortfolioType(s);
        if(portfolioType != null) {
            return portfolioType;
        }

        log.error("[PortfolioTypeConverter][convertToEntityAttribute] portfolioType is null....");
        throw new CustomException(ExceptionCode.SERVER_ERROR);
    }
}
