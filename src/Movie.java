public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    //private int _priceCode;
    private Price _price;

    public int getPriceCode() {
        //return _priceCode;
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        //this._priceCode = _priceCode;
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public Movie(String title, int priceCode) {
        _title = title;
        //_priceCode = priceCode;
        setPriceCode(priceCode);
    }

    double getCharge(int daysRented) {
        //determine amounts for each line
        /*
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;*/
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }

    public class ChildrensPrice extends Price {
        @Override
        public int getPriceCode() {
            return Movie.CHILDRENS;
        }

        @Override
        double getCharge(int daysRented) {
            //determine amounts for each line
            double result = 0;
            result += 1.5;
            if (daysRented > 3) {
                result += (daysRented - 3) * 1.5;
            }
            return result;
        }

        @Override
        public int getFrequentRenterPoints(int daysRented) {
            // add frequent renter points
            int frequentRenterPoints = 1;
            return frequentRenterPoints;
        }
    }

    public class NewReleasePrice extends Price {
        @Override
        public int getPriceCode() {
            return Movie.NEW_RELEASE;
        }

        @Override
        double getCharge(int daysRented) {
            //determine amounts for each line
            double result = 0;
            result += daysRented * 3;
            return result;
        }

        @Override
        public int getFrequentRenterPoints(int daysRented) {
            // add frequent renter points
            int frequentRenterPoints = 1;
            if (daysRented > 1){
                frequentRenterPoints++;
            }
            return frequentRenterPoints;
        }
    }

    public class RegularPrice extends Price{
        @Override
        public int getPriceCode() {
            return Movie.REGULAR;
        }

        @Override
        double getCharge(int daysRented) {
            //determine amounts for each line
            double result = 0;
            result += 2;
            if (daysRented > 2) {
                result += (daysRented - 2) * 1.5;
            }
            return result;
        }

        @Override
        public int getFrequentRenterPoints(int daysRented) {
            // add frequent renter points
            int frequentRenterPoints = 1;
            return frequentRenterPoints;
        }

    }
}