
import entity.*;

public class Main {

// [TODO] [Alper] create a README.md file
    public static void main(String[] args) {

        Profile profile = new Profile("alper", 20);

        IPaymentMethod visa = new CreditCard(CreditCardType.VISA);
        IPaymentMethod mastercard = new CreditCard(CreditCardType.MASTERCARD);
        IPaymentMethod shoppingcard = new ShoppingCard();
        IPaymentMethod giftcard = new GiftCard();

        CartItem item_1 = new CartItem("tttt-a23", "DVD Film", 2500.0);
        CartItem item_2 = new CartItem("sagakg-489049", "OMO Deterjan", 150.0);
        CartItem item_3 = new CartItem("1234s4-489049", "Oyuncak", 44.0);

        Wallet cuzdan = new Wallet(10000.0);

        Cart shoppingCart = new Cart();

        Person alper = new Person(profile, visa, cuzdan, shoppingCart);

        alper.printPersonInfo();
        alper.addItemToCart(item_1);
        alper.addItemToCart(item_1);
        alper.addItemToCart(item_1);
        alper.addItemToCart(item_2);

        System.out.println(alper.calculateCheckoutAmount() + "TRY");

        alper.listCartItems();

        alper.setiPaymentMethod(giftcard);

        alper.printPersonInfo();
        alper.checkoutCart();
        alper.printPersonInfo();

    }
}
