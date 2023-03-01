package ss.week2;


public class PricedSafe extends Safe implements Bill.Item {
    private double price;
    private Password password;

    public PricedSafe(double price) {
        super();
        this.price = price;
        password = new Password();
    }

    public double getPrice() {
        return price;
    }


    public void activate(String text) {
        assert text != null;
        if (password.testWord(text)) {
            super.activate();
        }
    }

    @Override
    public void activate() {
        System.out.println("Warning, safe is not activated");
    }

    @Override
    public void deactivate() {
        super.close();
        this.close();
        super.deactivate();
    }


    public void open(String textPass) {
        assert textPass != null;
        if (this.password.testWord(textPass) && this.isActive()) {
            super.open();

        }


    }

    @Override
    public void open() {
        System.out.println("overrides the parent method and does not change the" +
                "state of the safe");
    }


    @Override
    public void close() {
        super.close();

    }

    public Password getPassword() {
        return this.password;
    }


    @Override
    public String toString() {
        return "Priced safe " + getPrice();

    }

}