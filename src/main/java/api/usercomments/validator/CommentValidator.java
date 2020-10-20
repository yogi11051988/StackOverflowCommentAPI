package api.usercomments.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CommentValidator implements 
ConstraintValidator<CustomizedAnnotation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Validator constraint"+value);
		return false;
	}

	@Override
	public void initialize(CustomizedAnnotation constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

}
