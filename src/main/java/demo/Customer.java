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
        for (Rental each: _rentals) {
            double thisAmount = 0;
            
            // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
        		if (each.getDaysRented() > 2) {
        			thisAmount += (each.getDaysRented() - 2) * 1.5;
        		}
                break;
            
            case Movie.NEW_RELEASE:
                thisAmount = each.getDaysRented() * 3;
            	break;
            
            case Movie.CHILDRENS:
                thisAmount += 1.5;
            	if (each.getDaysRented() > 3) {
            	    thisAmount += (each.getDaysRented() - 3) * 1.5;
            	}
            	break;

            default: break;
            }
            
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
            	String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;            
        }
        
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount);

        return result;
    }

//	private double computePriceNewRelease(Rental aRental) {
//		return aRental.getDaysRented() * 3;
//	}
//
//	private double computePriceRegularMovie(Rental aRental) {
//		double amount = 2;
//		if (aRental.getDaysRented() > 2) {
//		    amount += (aRental.getDaysRented() - 2) * 1.5;
//		}
//		return amount;
//	}
    
}
