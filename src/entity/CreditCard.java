package entity;

public class CreditCard extends PaymentMethod implements IPaymentMethod, IDisplayable {

    private CreditCardType type;

    public CreditCard(CreditCardType type) {
        super("Credit Card");
        this.type = type;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    @Override
    public double makeDiscount() {
        return 15.0;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getType() + " " + this.getName());
    }

}
