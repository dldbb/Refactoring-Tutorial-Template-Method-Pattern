import java.util.Vector;
import java.util.Iterator;

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    /*
    public String statement() {
        //double totalAmount = 0;
        //int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : _rentals) {
            //double thisAmount = 0;
            //double thisAmount = each.getCharge();
            //frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result.append("\t").append(each.getTitle());
            result.append("\t").append(String.valueOf(each.getCharge()));
            result.append("\n");

            //totalAmount += each.getCharge();
        }

        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(getTotalCharge()));
        result.append("\n");
        result.append("You earned ").append(String.valueOf(getTotalFrequentRenterPoints()));
        result.append(" frequent renter points");
        return result.toString();
    }*/

    public double getTotalCharge() {
        double result = 0;
        for (Rental each : _rentals) {
            result += each.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints(){
        int result = 0;
        for (Rental each : _rentals){
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
    /*
    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>").append(getName());
        result.append("</EM></H1><P>\n");
        for (Rental each : _rentals) {
            //show figures for each rental
            result.append(each.getTitle()).append(": ");
            result.append(String.valueOf(each.getCharge())).append("<BR>\n");
        }
        //add footer lines
        result.append("<P>You owe <EM>" + String.valueOf(getTotalCharge()));
        result.append("</EM><P>\n");
        result.append("On this rental you earned <EM>");
        result.append(String.valueOf(getTotalFrequentRenterPoints()));
        result.append("</EM> frequent renter points<P>");

        return result.toString();
    }*/


    public String statement() {
        statement theStatement = new statement();
        return theStatement.value(_rentals, this);
    }

    public String htmlStatement() {
        htmlStatement theStatement = new htmlStatement();
        return theStatement.value(_rentals, this);
    }

}

abstract class buildStatement{
    final String value(Vector<Rental> _rentals, Customer customer){
            String result = this.header(customer);
            result += this.figure(_rentals);
            result += this.addFootLines(customer);
            return result;
            }
    abstract String header(Customer customer);
    abstract String figure(Vector<Rental> _rentals);
    abstract String addFootLines(Customer customer);
}

class statement extends buildStatement {
    @Override
    public String header(Customer customer) {
        String result = "Rental Record for " + customer.getName() + "\n";
        return result;
    }

    @Override
    public String figure(Vector<Rental> _rentals) {
        Iterator<Rental> rentals = _rentals.iterator();
        String result = "";
        while(rentals.hasNext()) {
            Rental each = rentals.next();
            // show figures for this rental
            result += "\t" + each.getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        return result;
    }

    @Override
    public String addFootLines(Customer customer) {
        String result = "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
}

class htmlStatement extends buildStatement {
    @Override
    public String header(Customer customer) {
        String result = "<H1>Rentals for <EM> " + customer.getName() + "</EM></H1><P>\n";
        return result;
    }

    @Override
    public String figure(Vector<Rental> _rentals) {
        Iterator<Rental> rentals = _rentals.iterator();
        String result = "";
        while(rentals.hasNext()) {
            Rental each = rentals.next();
            // show figures for this rental
            result += each.getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        return result;
    }

    @Override
    public String addFootLines(Customer customer) {
        String result = "<P>You owe <EM> " + String.valueOf(customer.getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM> " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " </EM> frequent renter points<P>";
        return result;
    }
}
