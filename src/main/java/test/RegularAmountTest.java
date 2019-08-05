package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;

import annotation.Frequency;
import bean.RegularAmount;

public class RegularAmountTest {
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	Set<ConstraintViolation<RegularAmount>> constraintViolations;

	@Test
    public void testOneWeek() {
    	RegularAmount ra = new RegularAmount(Frequency.WEEK, "57.91");
    	constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
       	
    	ra = new RegularAmount(Frequency.WEEK, "57.9");
        constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
        
        
    	ra = new RegularAmount(Frequency.WEEK, "57");
        constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
	}
	
	@Test
    public void testTwoWeek() {
    	RegularAmount ra = new RegularAmount(Frequency.TWO_WEEK, "57.91");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
       	
    	ra = new RegularAmount(Frequency.TWO_WEEK, "57.9");
        constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
        
        
    	ra = new RegularAmount(Frequency.TWO_WEEK, "57");
        constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
	}
	
	@Test
    public void testFourWeek() {
    	RegularAmount ra = new RegularAmount(Frequency.FOUR_WEEK, "57.91");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
       	
    	ra = new RegularAmount(Frequency.FOUR_WEEK, "57.9");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
        
        
    	ra = new RegularAmount(Frequency.FOUR_WEEK, "57");
        constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
	}
	
	@Test
    public void testQuarterWeek() {
    	RegularAmount ra = new RegularAmount(Frequency.QUARTER, "57.91");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
       	
    	ra = new RegularAmount(Frequency.QUARTER, "57.9");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
        
    	ra = new RegularAmount(Frequency.QUARTER, "52.65");
        constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
        
       	
    	ra = new RegularAmount(Frequency.QUARTER, "57");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
	}
	
	@Test
    public void testYearWeek() {
    	RegularAmount ra = new RegularAmount(Frequency.YEAR, "57.91");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
       	
    	ra = new RegularAmount(Frequency.YEAR, "57.9");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
        
    	ra = new RegularAmount(Frequency.YEAR, "156");
        constraintViolations = validator.validate( ra );
       	assertEquals(0, constraintViolations.size());
        
       	
    	ra = new RegularAmount(Frequency.YEAR, "57");
        constraintViolations = validator.validate( ra );
       	assertEquals(1, constraintViolations.size());
	}

}
