import knn.KNN;
import model.healthy.Healthy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KNNApplication {

    private static final List<Healthy> dataset = new ArrayList<>();

    public static void main(String[] args) {

        KNN knn = new KNN(dataset);
        Healthy healthy = new Healthy();

        Scanner input = new Scanner(System.in);
        System.out.println("=======Prediksi Kesehatan Menggunakan Algoritma KNN=======");

        System.out.print("Masukkan nama anda: ");
        healthy.setName(input.nextLine());
        System.out.print("Masukkan umur anda: ");
        healthy.setAge(input.nextInt());
        System.out.print("Masukkan berat badan anda: ");
        healthy.setWeight(input.nextInt());

        System.out.print("\nMasukkan jumlah K: ");
        knn.predict(healthy, input.nextInt());
        System.out.println(healthy);

        input.close();

    }

    static {
        dataset.add(new Healthy("Ani", 25, 50, true));
        dataset.add(new Healthy("Budi", 26, 48, true));
        dataset.add(new Healthy("Cinta", 35, 65, true));
        dataset.add(new Healthy("Dewi", 67, 60, false));
        dataset.add(new Healthy("Endang", 55, 65, false));
        dataset.add(new Healthy("Fitrah", 53, 60, false));
        dataset.add(new Healthy("Gunawan", 34, 48, true));
        dataset.add(new Healthy("Henro", 48, 50, false));
    }

}
