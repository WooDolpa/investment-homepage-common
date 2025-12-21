package san.investment.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
import san.investment.common.enums.DataStatus;
import san.investment.common.exception.CustomException;
import san.investment.common.exception.ExceptionCode;

/**
 * packageName : san.investment.common.converter
 * className : DataStatusConverter
 * user : jwlee
 * date : 2025. 12. 21.
 * description :
 */
@Slf4j
@Converter(autoApply = true)
public class DataStatusConverter implements AttributeConverter<DataStatus, String> {

    @Override
    public String convertToDatabaseColumn(DataStatus dataStatus) {
        if (dataStatus == null) {
            return null;
        }
        return dataStatus.getKey();
    }

    @Override
    public DataStatus convertToEntityAttribute(String s) {

        if(s == null) {
            return null;
        }

        DataStatus dataStatus = DataStatus.findDataStatus(s);
        if(dataStatus != null) {
            return dataStatus;
        }

        log.error("[DataStatusConverter][convertToEntityAttribute] dataStatus is null....");
        throw new CustomException(ExceptionCode.SERVER_ERROR);
    }
}
