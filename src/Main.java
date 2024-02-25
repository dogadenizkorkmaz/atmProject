import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String userName, password; //string değerler tanımlandı
        Scanner input = new Scanner(System.in); //scanner tanımlandı

        int right = 3;
        int balance = 1500;
        int select;

        while (right > 0) {
            System.out.print("Kullanıcı Adınız :");
            userName = input.nextLine();//kullanıcıdan değerleri al
            System.out.print("Parolanız : ");
            password = input.nextLine();

            if (userName.equals("patika") && password.equals("dev123")) {//bilgiler doğru ise;
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");
                do {
                    System.out.println("1-Para yatırma\n" + "2-Para Çekme\n" + "3-Bakiye Sorgula\n" + "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = input.nextInt();
                    switch (select) {
                        case 1: //para yatırma işlemi
                            System.out.print("Para miktarı : ");
                            int price = input.nextInt();
                            balance += price;
                            break;
                        case 2: // para çekme işlemi
                            System.out.print("Para miktarı : ");
                            price = input.nextInt();
                            if (price > balance) {
                                System.out.println("Bakiye yetersiz.");
                            } else {
                                balance -= price;
                            }
                            break;
                        case 3: //bakiye sorgulama işlemi
                            System.out.println("Bakiyeniz : " + balance);
                            break;
                        case 4: //çıkış yapma işlemi
                            System.out.println("Tekrar görüşmek üzere.");
                            break;
                        default: //1,2,3,4 dışındaki hatalı seçimler için;
                            System.out.println("Geçersiz işlem! Lütfen tekrar deneyin.");
                            break;
                    }
                } while (select != 4); //4 ten farklı değerler için "do" döngüsüne geri dönülsün
                break;
            } else {//giriş bilgileri doğru değilse
                right--;//hatalı giriş denemeleri için deneme hakkı 3 ten geriye azalsın
                System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");
                if (right == 0) { // deneme hakkı bittiğinde;
                    System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                } else {//deneme hakkı bitmediyse;
                    System.out.println("Kalan Hakkınız : " + right);
                }
            }
        }
    }
}