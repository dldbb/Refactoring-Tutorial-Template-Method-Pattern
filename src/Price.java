public abstract class Price {
    public abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public abstract int getFrequentRenterPoints(int daysRented);
}
