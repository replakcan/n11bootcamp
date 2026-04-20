package entity;

public class Person {

    private Profile profile;
    private IPaymentMethod iPaymentMethod;
    private Wallet wallet;
    private Cart cart;

    public Person(Profile profile, IPaymentMethod iPaymentMethod, Wallet wallet, Cart cart) {
        this.profile = profile;
        this.iPaymentMethod = iPaymentMethod;
        this.wallet = wallet;
        this.cart = cart;
    }

    public Profile getProfile() {
        return profile;
    }

    public IPaymentMethod getiPaymentMethod() {
        return iPaymentMethod;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Cart getCart() {
        return cart;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setiPaymentMethod(IPaymentMethod iPaymentMethod) {
        this.iPaymentMethod = iPaymentMethod;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void checkoutCart() {
        double totalCheckoutAmount = this.calculateCheckoutAmount();

        if (wallet.getBalance() < totalCheckoutAmount) {
            System.out.println("Your cart is too heavy! Reconsider your priorities!");

        } else {
            this.wallet.setBalance(this.wallet.getBalance() - totalCheckoutAmount);
            this.cart.emptyCart();

            System.out.println("Checkout successful! Your new balance: " + this.wallet.getBalance() + "TRY");
        }
    }

    public double addBalance(int amount) {
        this.wallet.setBalance(this.wallet.getBalance() + amount);

        return this.wallet.getBalance();
    }

    public void addItemToCart(CartItem item) {
        this.cart.addItem(item);
    }

    public void removeItemFromCart(CartItem item) {
        this.cart.dropItem(item);
    }

    public void listCartItems() {
        this.cart.listCartItems();
    }

    public double calculateCheckoutAmount() {
        double cartTotal = this.cart.calculateCartTotal();
        double discount = this.iPaymentMethod.makeDiscount() / 100;

        return cartTotal - (cartTotal * discount);
    }

    public void printPersonInfo() {
        System.out.println("Default payment method: " + this.iPaymentMethod.getName());
        System.out.println("------------------------");
        System.out.println("Wallet balance: " + this.wallet.getBalance() + "TRY");
        System.out.println("------------------------");
        System.out.println("Shopping cart state: " + this.cart.getItemList().size() + " items in the cart");
    }
}
