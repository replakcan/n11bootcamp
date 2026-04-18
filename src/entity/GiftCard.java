package entity;

public class GiftCard extends PaymentMethod implements IPaymentMethod, IDisplayable {

    public GiftCard() {
        super("Gift card");
    }

    @Override
    public double makeDiscount() {
        return 10.0;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getName());
    }
}
