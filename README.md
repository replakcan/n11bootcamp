# n11bootcamp - 1. ödevi

Person class'ı bir alışveriş sitesine üye olan kullanıcıyı temsil ediyor.
Bu yüzden Person'ın bir alışveriş sitesinde var olması için gerekli ve yeter koşullar olarak:

    ProfilBilgileri(class Profile)
    Cüzdan(class Wallet)
    Sepet(class Cart)
    ÖdemeYöntemi(interface iPaymentMethod üzerinden)

belirlendi.

## **SOLID** ve **OOP** prensiplerinin uygulanması:
Person direkt olarak alt seviyelere bağımlı kalmadan, abstraction oluşturarak üst seviye classlarla **composite, has-a** ilişkisi kurar.

**Encapsulation** pratiği için tasarım genelinde class verilerine dışarıdan ulaşılamamsı için private access-modifier'lar kullanıldı.
    --istisna: Cart içersinde **collections framework**'ünden ArrayList<> kullanıyorum, bu collection'a dışarıdan şu an müdahele edilebiliyor. *unmodifable değil*, bu tarafı tam araştırmadığım için kodumu henüz düzeltmedim.

**Interface Segregation** için IDisplayable interface'i tanımladım ve ilgili methodu o interface üzerinden classlarda implement ediyorum. Bunun yerine classlarda toString() methodunu override edilerek de *polymorphism* örneği sunulabilirdi.

### Yeni bir PaymentMethod sisteme eklenmesi gerektiğinde:
Diğer classlar ödeme yöntemlerine direkt bağımlı olmadığı, IPaymentMethod(interface) üzerinden haberleştikleri için rahatlıkla yeni ödeme sistemleri PaymentMethod abstract class'ını base-class olarak kullanıp, IPaymentMethod'u implement ederek eklenebilir.
    --Burada hem PaymentMethod hem de IPaymentMethod olması biraz zorlama ve kötü bir tasarım olabilir. Abstract class içersinde, IPaymentMethod methodlarını abstract keyword'ü ile tanımlayarak, interface'e gerek olmadan da bir inheritance ilişkisiyle problemi çözebilirdim. Ancak ikisini ayrı ayrı kullanmayı deneyimlemek istedim, ödev teslim sonrasında tasarım iyileştirilebilir.

Kullanıcının ödeme yöntemi set edilirken main içersinde çağırdığım **PaymentMethodFactory**'yi kullanıyorum. Bu factory, scanner ile kullanıcı girdisini okuyarak runtime'da **reflection** ile başarılı bir ödeme-yöntemi(PaymentMethod) yakalarsa o ödeme-yöntemi'nin constructorını çağırıyor. Aynı zamanda "her yeni eklenen ödeme yöntemi aynı şekilde çalışmayabilir" mantığını test etmek için CreditCard yöntemine CardType field'ı ekledim ve CreditCard yöntemine de oluşturduğum **@RequiresCardType anotasyonunu** ekledim. Scanner, kullanıcı girdisini okurken, girilen PaymentMethod'da *isAnnotationPresent() reflection methodu* ile anotasyon kontrolü yapıyor, anotasyon varsa CreditCardType set edilmesini zorunlu kılıyor.