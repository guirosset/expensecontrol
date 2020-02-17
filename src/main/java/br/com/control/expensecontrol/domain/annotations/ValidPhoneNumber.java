package br.com.control.expensecontrol.domain.annotations;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp="((\\(\\d{2}\\) ?)|(\\d{4}-))?\\d{4}-\\d{4}")
@Constraint(validatedBy = {})
public @interface ValidPhoneNumber {

    String value() default "";

    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
