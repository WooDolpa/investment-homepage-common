package san.investment.common.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import san.investment.common.constants.ApiConstants;
import san.investment.common.exception.CustomException;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class ApiResponseDto {

    /**
     * 성공 응답
     *
     * @return
     */
    public static String makeSuccessResponse() {
        return makeResponseData(ApiConstants.RESPONSE_SUCCESS_CODE, ApiConstants.RESPONSE_SUCCESS_MESSAGE, null);
    }

    /**
     * 실패 응답
     *
     * @return
     */
    public static String makeFailureResponse() {
        return makeResponseData(ApiConstants.RESPONSE_FAILURE_CODE, ApiConstants.RESPONSE_FAILURE_MESSAGE, null);
    }

    /**
     * 조회시 사용
     *
     * @param data
     * @return
     */
    public static String makeResponse(Object data) {
        return makeResponseData(ApiConstants.RESPONSE_SUCCESS_CODE, ApiConstants.RESPONSE_SUCCESS_MESSAGE, data);
    }

    /**
     * 에러 발생시 응답
     *
     * @param e
     * @return
     */
    public static String makeResponse(CustomException e) {
        return makeResponseData(e.getCode(), e.getMessage(), null);
    }

    /**
     * response 데이터 생성
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    private static String makeResponseData(String code, String message, Object data) {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> responseMap = new LinkedHashMap<>();
        String result = "";

        responseMap.put("code", code);
        responseMap.put("message", message);
        if(data != null) {
            responseMap.put("data", data);
        }

        try {
            result = objectMapper.writeValueAsString(responseMap);
        }catch (Exception e) {
            log.error("[ApiResponseDto][makeSuccessResponse] objectMapper parsing error : {}", e.getMessage());
        }
        return result;
    }
}
