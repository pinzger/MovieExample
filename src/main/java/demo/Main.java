package demo;

public class Main {

	public static void main(String[] args) {
        Customer customer = new Customer("Paul");
        
        Movie movie1 = new Movie("Eyes Wide Shut", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("Bambi", Movie.CHILDRENS);
        Movie movie3 = new Movie("God Father", Movie.REGULAR);
        Movie movie4 = new Movie("Nothing", -10);
                
        customer.addRental(new Rental(movie1, 2));
//        customer.addRental(new Rental(movie2, 4));
//        customer.addRental(new Rental(movie2, 2));
//        customer.addRental(new Rental(movie3, 10));
//        customer.addRental(new Rental(movie3, 2));
//        customer.addRental(new Rental(movie4, 2));
                
        System.out.println(customer.statement());
    }
}
