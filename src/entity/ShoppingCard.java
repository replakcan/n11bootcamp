package entity;

public class ShoppingCard extends PaymentMethod implements IPaymentMethod, IDisplayable {

    public ShoppingCard() {
        super("Shopping Card");
    }

    @Override
    public double makeDiscount() {
        return 20.0;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getName());
    }
}
