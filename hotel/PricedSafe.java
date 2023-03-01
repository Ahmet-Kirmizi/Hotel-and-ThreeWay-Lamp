package ss.week2.hotel;

import ss.hotel.bill.Bill;
import ss.week2.hotel.password.Password;

public class PricedSafe extends Safe implements Bill.Item {
    private double price;
    private Password password;

    /**
     * Constructor  for PricedSafe
     *
     * @param price to set a price of a safe
     */
    /*@
        requires price > 0;
    */
    public PricedSafe(double price) {
        this.price = price;
        password = new Password();
    }

    /**
     * Getter for price of a safe
     *
     * @return price of a safe
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method to activate safe
     *
     * @param text is a given password to be checked
     */
    /*@
        requires text != null;
        ensures super.isActive() == true;
    */
    public void activate(String text) {
        assert null != text;
        if (password.testWord(text)) {
            super.activate();
        }
    }

    /**
     * Override method form Safe as in Priced safe its req to take parameter
     */
    @Override
    public void activate() {
        System.out.println("Warning, safe is not activated");
    }

    /**
     * Method to deactivate and close the safe
     */
    /*@
        ensures super.isActive() == false;
        ensures super.isOpen() == false;
    */
    @Override
    public void deactivate() {
        super.close();
        this.close();
        super.deactivate();
    }

    /**
     * opens the safe
     *
     * @param textPass
     */
    /*@
        requires textPass != null;
        ensures super.isOpen()  == true;
    */
    public void open(String textPass) {
        assert textPass != null;
        if (this.password.testWord(textPass) && this.isActive()) {
            super.open();

        }
    }

    /**
     * overrides parent method
     */
    @Override
    public void open() {
        System.out.println("overrides the parent method and does not change the" +
                "state of the safe");
    }

    /**
     * closes the safe
     */
    @Override
    public void close() {
        super.close();

    }

    /**
     * gives the password
     *
     * @return this.password
     */
    public Password getPassword() {
        return this.password;
    }

    /**
     * gives the price for the safe
     *
     * @return "Priced safe " + getPrice()
     */
    @Override
    public String toString() {
        return "Priced safe " + getPrice();
    }

    public static void main(String[] args) {
        PricedSafe safe = new PricedSafe(42.23);
        safe.activate(null);

    }



}