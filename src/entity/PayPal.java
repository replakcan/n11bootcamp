package entity;

public class PayPal extends PaymentMethod implements IPaymentMethod, IDisplayable{
    public PayPal(String name) {
        super(name);
    }

    @Override
    public double makeDiscount() {
        return 30;
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getName());
    }
}
