
import entity.*;
import factory.PaymentMethodFactory;

public class Main {

// [TODO] [Alper] create a README.md file
    public static void main(String[] args) {

        Profile profile = new Profile("alper", 20);
        Wallet wallet = new Wallet(10000.0);
        Cart shoppingCart = new Cart();

        IPaymentMethod paymentMethod = PaymentMethodFactory.scanPaymentMethod();

        CartItem item_1 = new CartItem("tttt-a23", "DVD Film", 2500.0);
        CartItem item_2 = new CartItem("sagakg-489049", "OMO Deterjan", 150.0);
        CartItem item_3 = new CartItem("1234s4-489049", "Oyuncak", 44.0);

        Person alper = new Person(profile, paymentMethod, wallet, shoppingCart);

        alper.printPersonInfo();
        alper.addItemToCart(item_1);
        alper.addItemToCart(item_1);
        alper.addItemToCart(item_1);
        alper.addItemToCart(item_2);

        System.out.println(alper.calculateCheckoutAmount() + "TRY");

        alper.listCartItems();

        alper.printPersonInfo();
        alper.checkoutCart();
        alper.printPersonInfo();

    }
}
