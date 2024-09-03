package com.app.product.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.springframework.util.StringUtils;

import com.app.product.exception.ErrorResponse;
import com.app.product.exception.ProductException;
import com.app.product.model.AuditableEntity;

public class Utilities {

    public static Supplier<Timestamp> GET_CURRENT_TIMESTAMP = () -> new Timestamp(
	    Calendar.getInstance().getTime().getTime());

    public static Predicate<Integer> IS_GREATER_THAN_ZERO = value -> value > 0;

    public static boolean isNotBlank(String string) {
	return StringUtils.hasText(string);
    }

    public static void setAuditFields(int userId, AuditableEntity<String> auditableEntity, boolean isUpdate) {
	if (!isUpdate) {
	    auditableEntity.setCreatedBy(String.valueOf(userId));
	    auditableEntity.setCreatedDate(GET_CURRENT_TIMESTAMP.get());
	}
	// Set update fields
	auditableEntity.setUpdatedBy(String.valueOf(userId));
	auditableEntity.setUpdatedDate(GET_CURRENT_TIMESTAMP.get());
    }

    public static void commonValidation(int userId) {
	if (!IS_GREATER_THAN_ZERO.test(userId)) {
	    throw new ProductException("Invalid User Id",
		    new ErrorResponse(ErrorResponse.NOT_FOUND, "Invalid User Id"));
	}
    }

}
