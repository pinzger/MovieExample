package demo;

import org.junit.Assert;
import org.junit.Test;

public class TestStatement {
	final String expectedResult = "Rental Record for Paul\n"
        	+ "\tEyes Wide Shut\t6.0\n"
        	+ "\tBambi\t3.0\n"
        	+ "Amount owed is 9.0";

	@Test
	public void testStatement() {
	    Customer customer = new Customer("Paul");
	    
        Movie movie1 = new Movie("Eyes Wide Shut", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Bambi", Movie.CHILDRENS);
	            
	    customer.addRental(new Rental(movie1, 2));
	    customer.addRental(new Rental(movie2, 4));
	    
	    Assert.assertEquals(expectedResult, customer.statement());
	}
}
