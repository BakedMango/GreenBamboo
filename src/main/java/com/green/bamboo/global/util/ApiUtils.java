package com.green.bamboo.global.util;

import com.green.bamboo.global.fault.apierror.ApiError;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Noninstantiable utility class
public class ApiUtils {

    /**
     * 	Suppress default constructor for noninstantiability
     */
    private ApiUtils() {
        throw new AssertionError();
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, data, null);
    }

    public static ApiResult<?> error(ApiError errorResponse) {
        return new ApiResult<>(false, null, errorResponse);
    }

    public static class ApiResult<T> {
        private final boolean success;
        private final T data;
        private final ApiError error;

        private ApiResult(boolean success, T data, ApiError error) {
            this.success = success;
            this.data = data;
            this.error = error;
        }

        public boolean isSuccess() {
            return success;
        }

        public ApiError getError() {
            return error;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("success", success)
                    .append("data", data)
                    .append("error", error)
                    .toString();
        }
    }

}
