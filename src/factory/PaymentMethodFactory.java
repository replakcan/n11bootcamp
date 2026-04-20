package factory;

import annotation.RequiresCardType;
import entity.CreditCardType;
import entity.IPaymentMethod;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class PaymentMethodFactory {

    public static IPaymentMethod scanPaymentMethod() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a PaymentMethod: ");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName("entity." + className);
            IPaymentMethod paymentMethod;

            if (cls.isAnnotationPresent(RequiresCardType.class)) {
                System.out.print("enter CreditCardType (VISA, MASTERCARD, TROY): ");
                String cardTypeInput = scanner.nextLine().toUpperCase();
                CreditCardType cardType = CreditCardType.valueOf(cardTypeInput);

                Constructor<?> ctor = cls.getConstructor(CreditCardType.class);
                paymentMethod = (IPaymentMethod) ctor.newInstance(cardType);
            } else {
                Constructor<?> ctor = cls.getConstructor();
                paymentMethod = (IPaymentMethod) ctor.newInstance();
            }

            return paymentMethod;

        } catch (ClassNotFoundException e) {
            System.out.println("Hata kodu: 404 Payment method bulunamadı.");
        } catch (NoSuchMethodException e) {
            System.out.println("Hata kodu: 405 || Uygun method bulunamadı.");
        } catch (IllegalArgumentException e) {
            System.out.println("Hata kodu: 400 || Geçersiz kart tipi girdin.");
        } catch (Exception e) {
            System.out.println("Hata kodu: 500 || Beklenmeyen bir hata oluştu.");
        }

        return null;
    }
}