import model.telephone_customer.Block;
import model.telephone_customer.Call;
import model.telephone_customer.Card;
import model.telephone_customer.TelephoneCustomer;
import naive_bayes.NaiveBayes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NaiveBayesApplication {

    private static final List<TelephoneCustomer> telephoneCustomers = new ArrayList<>();

    public static void main(String[] args) {

        NaiveBayes naiveBayes = new NaiveBayes(telephoneCustomers);

        TelephoneCustomer dataTest = new TelephoneCustomer();
        int card;
        int call;
        int block;

        Scanner userInput = new Scanner(System.in);

        System.out.println("=======Prediksi Bonus Pelanggan Telepon Seluler=======");
        System.out.print("Masukan nama pelanggan : ");
        dataTest.setName(userInput.nextLine());

        System.out.println("Pilih Tipe Kartu : ");
        System.out.println("1. Prabayar");
        System.out.println("2. Parcabayar");
        System.out.print("Pilih : ");
        card = userInput.nextInt();
        if(card == 1) {
            dataTest.setCard(Card.PRABAYAR);
        } else if(card == 2) {
            dataTest.setCard(Card.PASCABAYAR);
        }

        System.out.println("Pilih Jumlah Panggilan : ");
        System.out.println("1. Sedikit");
        System.out.println("2. Cukup");
        System.out.println("3. Banyak");
        System.out.print("Pilih : ");
        call = userInput.nextInt();
        if(call == 1) {
            dataTest.setCall(Call.SEDIKIT);
        } else if(call == 2) {
            dataTest.setCall(Call.CUKUP);
        } else if(call == 3) {
            dataTest.setCall(Call.BANYAK);
        }

        System.out.println("Pilih Block : ");
        System.out.println("1. Rendah");
        System.out.println("2. Sedang");
        System.out.println("3. Tinggi");
        System.out.print("Pilih : ");
        block = userInput.nextInt();
        if(block == 1) {
            dataTest.setBlock(Block.RENDAH);
        } else if(block == 2) {
            dataTest.setBlock(Block.SEDANG);
        } else if(block == 3) {
            dataTest.setBlock(Block.TINGGI);
        }

        dataTest = naiveBayes.predict(dataTest);
        System.out.println("\nHasil Prediksi : ");
        if(dataTest.isBonus()) {
            System.out.println("Pelanggan " + dataTest.getName() + " Mendapatkan bonus");
        } else {
            System.out.println("Pelanggan " + dataTest.getName() + " TIDAK mendapatkan bonus");
        }

        userInput.close();

    }

    static {
        telephoneCustomers.add(new TelephoneCustomer("Andi", Card.PRABAYAR, Call.SEDIKIT, Block.SEDANG, false));
        telephoneCustomers.add(new TelephoneCustomer("Budi", Card.PASCABAYAR, Call.BANYAK, Block.SEDANG, true));
        telephoneCustomers.add(new TelephoneCustomer("Citra", Card.PRABAYAR, Call.BANYAK, Block.SEDANG, true));
        telephoneCustomers.add(new TelephoneCustomer("Dedi", Card.PRABAYAR, Call.SEDIKIT, Block.RENDAH, false));
        telephoneCustomers.add(new TelephoneCustomer("Evan", Card.PASCABAYAR, Call.CUKUP, Block.TINGGI, true));
        telephoneCustomers.add(new TelephoneCustomer("Feni", Card.PASCABAYAR, Call.CUKUP, Block.SEDANG, true));
        telephoneCustomers.add(new TelephoneCustomer("Gito", Card.PRABAYAR, Call.CUKUP, Block.SEDANG, true));
        telephoneCustomers.add(new TelephoneCustomer("Hani", Card.PRABAYAR, Call.CUKUP, Block.RENDAH, false));
        telephoneCustomers.add(new TelephoneCustomer("Jodi", Card.PASCABAYAR, Call.SEDIKIT, Block.TINGGI, true));
        telephoneCustomers.add(new TelephoneCustomer("Kafi", Card.PASCABAYAR, Call.BANYAK, Block.TINGGI, true));
        telephoneCustomers.add(new TelephoneCustomer("Linda", Card.PASCABAYAR, Call.SEDIKIT, Block.RENDAH, true));
    }

}

