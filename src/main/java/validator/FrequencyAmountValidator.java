package validator;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import bean.RegularAmount;

public class FrequencyAmountValidator implements ConstraintValidator<FrequencyAmount, RegularAmount> {

	@Override
	public void initialize(FrequencyAmount constraintAnnotation) {

	}

	@Override
	public boolean isValid(RegularAmount value, ConstraintValidatorContext context) {

		if (value == null || value.getFrequency() == null || value.getAmount() == null) {
			return false;
		}
		
		BigDecimal amount = new BigDecimal(value.getAmount());
		BigDecimal amountWeek;
		
		try {
			switch(value.getFrequency()) {
			  case TWO_WEEK:
				amountWeek = amount.divide(new BigDecimal(2));
			  	break;
			  case FOUR_WEEK:
				amountWeek = amount.divide(new BigDecimal(4));
			    break;
			  case QUARTER:
				amountWeek = amount.divide(new BigDecimal(13));
				break;
			  case YEAR:
				amountWeek = amount.divide(new BigDecimal(52));
			    break;
			default:
				amountWeek = BigDecimal.ZERO;
				break;
			}
			if(amountWeek.scale()<=2)
				return true;
			else
				return false;
		}catch (ArithmeticException e) {
			return false;
		}
		
		
	}

}