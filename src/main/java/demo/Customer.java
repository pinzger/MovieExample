package demo;

import java.util.Vector;

public class Customer {

    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();
    
    public Customer (String name) {
        _name = name;
    }
    
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }
    
    public String getName() {
        return _name;
    }
    
    public String statement() {
        double totalAmount = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental aRental: _rentals) {
            double thisAmount = 0;

            thisAmount = aRental.computePrice();

            // show figures for this rental
            result += "\t" + aRental.getMovie().getTitle() + "\t" +
                    thisAmount + "\n";
            totalAmount += thisAmount;            
        }
        
        // add footer lines
        result += "Amount owed is " + totalAmount;

        return result;
    }

    public String htmlStatement() {
        double totalAmount = 0;
        String result = "<p>Rental Record for " + getName() + "</br>";
        for (Rental aRental: _rentals) {
            double thisAmount = 0;

            thisAmount = aRental.computePrice();

            // show figures for this rental
            result += "\t" + aRental.getMovie().getTitle() + "\t" +
                    thisAmount + "</br>";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "</p>";

        return result;
    }
}
