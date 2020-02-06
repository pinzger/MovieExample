package demo;

public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double computePrice() {
        double thisAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount = comutePriceForRegularMovie();
                break;
            case Movie.NEW_RELEASE:
                thisAmount = computePriceForNewReleaseMovie();
                break;
            case Movie.CHILDRENS:
                thisAmount = computePriceForChildrensMovie();
                break;
            default:
                break;
        }
        return thisAmount;
    }

    public double computePriceForChildrensMovie() {
        double thisAmount = 1.5;
        if (getDaysRented() > 3) {
            thisAmount += (getDaysRented() - 3) * 1.5;
        }
        return thisAmount;
    }

    public double computePriceForNewReleaseMovie() {
        return getDaysRented() * 3;
    }

    public double comutePriceForRegularMovie() {
        double thisAmount = 2;
        if (getDaysRented() > 2) {
            thisAmount += (getDaysRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}
