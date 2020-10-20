package api.usercomments.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy = CommentValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomizedAnnotation {
	String message() default "Question id should not be blank.";
    Class<?>[] groups() default {};
    Class<? extends CustomizedAnnotation>[] payload() default {};
}
