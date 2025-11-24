package san.investment.common.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
import san.investment.common.enums.AdminStatus;
import san.investment.common.exception.CustomException;
import san.investment.common.exception.ExceptionCode;

@Slf4j
@Converter(autoApply = true)
public class AdminStatusConverter implements AttributeConverter<AdminStatus, String> {

    @Override
    public String convertToDatabaseColumn(AdminStatus adminStatus) {
        if(adminStatus == null) {
            return null;
        }
        return adminStatus.getKey();
    }

    @Override
    public AdminStatus convertToEntityAttribute(String s) {
        if(s == null) {
            return null;
        }
        AdminStatus adminStatus = AdminStatus.findAdminStatus(s);
        if(adminStatus != null) {
            return adminStatus;
        }
        log.error("[AdminStatusConverter][convertToEntityAttribute] adminStatus is null....");
        throw new CustomException(ExceptionCode.SERVER_ERROR);
    }
}
