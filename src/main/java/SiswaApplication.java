import knn.SiswaKNN;
import model.siswa.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SiswaApplication {

    private static SiswaKNN siswaKNN;

    public static void main(String[] args) throws IOException {
        List<Siswa> dataset = new ArrayList<>();

        siswaKNN = new SiswaKNN(dataset);
        String csvLoc = "C:\\Users\\marij_mokoginta\\Desktop\\data.csv";
        String datatest = "C:\\Users\\marij_mokoginta\\Desktop\\data_siswa_test.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvLoc));

            String lineText;

            // skip one line
            reader.readLine();

            while ((lineText = reader.readLine()) != null) {
                String[] line = lineText.split(",");

                Siswa siswa = Siswa.builder()
                        .setNama(line[0])
                        .setAgama(Double.parseDouble(line[1]))
                        .setPkn(Double.parseDouble(line[2]))
                        .setBhs_indo(Double.parseDouble(line[3]))
                        .setMatematika(Double.parseDouble(line[4]))
                        .setIpa(Double.parseDouble(line[5]))
                        .setIps(Double.parseDouble(line[6]))
                        .setBhs_inggris(Double.parseDouble(line[7]))
                        .setSeni_budaya(Double.parseDouble(line[8]))
                        .setPenjas(Double.parseDouble(line[9]))
                        .setPrakarya(Double.parseDouble(line[10]))
                        .setBhs_daerah(Double.parseDouble(line[11]))
                        .setMinat(new Minat(line[12]))
                        .setJurusan(Jurusan.valueOf(line[13]))
                        .build();

                dataset.add(siswa);

                SiswaOrdinal siswaOrdinal = SiswaOrdinal.builder()
                        .setNama(siswa.getNama())
                        .setAgama(convertToOrdinal(siswa.getAgama()))
                        .setPkn(convertToOrdinal(siswa.getPkn()))
                        .setBhs_indo(convertToOrdinal(siswa.getBhs_indo()))
                        .setMatematika(convertToOrdinal(siswa.getMatematika()))
                        .setIpa(convertToOrdinal(siswa.getIpa()))
                        .setIps(convertToOrdinal(siswa.getIps()))
                        .setBhs_inggris(convertToOrdinal(siswa.getBhs_inggris()))
                        .setSeni_budaya(convertToOrdinal(siswa.getSeni_budaya()))
                        .setPenjas(convertToOrdinal(siswa.getPenjas()))
                        .setPrakarya(convertToOrdinal(siswa.getPrakarya()))
                        .setBhs_daerah(convertToOrdinal(siswa.getBhs_daerah()))
                        .setMinat(siswa.getMinat().getNama())
                        .setJurusan(siswa.getJurusan())
                        .build();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        testDataKNN(datatest);
        inputDataTestKNN(dataset);
    }
    private static void testDataKNN(String datatest) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(datatest));

        reader.readLine();

        String line;

        int correct = 0;
        int incorrect = 0;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");

            Siswa siswa = Siswa.builder()
                    .setNama(values[0])
                    .setAgama(Double.parseDouble(values[1]))
                    .setPkn(Double.parseDouble(values[2]))
                    .setBhs_indo(Double.parseDouble(values[3]))
                    .setMatematika(Double.parseDouble(values[4]))
                    .setIpa(Double.parseDouble(values[5]))
                    .setIps(Double.parseDouble(values[6]))
                    .setBhs_inggris(Double.parseDouble(values[7]))
                    .setSeni_budaya(Double.parseDouble(values[8]))
                    .setPenjas(Double.parseDouble(values[9]))
                    .setPrakarya(Double.parseDouble(values[10]))
                    .setBhs_daerah(Double.parseDouble(values[11]))
                    .setMinat(new Minat(values[12]))
                    .setJurusan(Jurusan.valueOf(values[13]))
                    .build();
            siswaKNN.predict(siswa, 15);
            if (siswa.getJurusan() == siswa.getJurusanPredict()) {
                System.out.println("jurusan : " + siswa.getJurusan() + ", prediksi : " + siswa.getJurusanPredict() + " -> correct");
                correct++;
            } else {
                System.out.println("jurusan : " + siswa.getJurusan() + ", prediksi : " + siswa.getJurusanPredict() + " -> incorrect");
                incorrect++;
            }
        }
        System.out.println();
        System.out.println("correct : " + correct);
        System.out.println("incorrect : " + incorrect);
        System.out.println("accuracy : " + (100 * correct / (correct + incorrect)) + "%");

        reader.close();
    }

    private static Nilai convertToOrdinal(double value) {
        if (value < 59.99) {
            return Nilai.SANGAT_KURANG;
        } else if (value < 69.99) {
            return Nilai.KURANG;
        } else if (value < 79.99) {
            return Nilai.CUKUP;
        } else if (value < 89.99) {
            return Nilai.BAIK;
        } else {
            return Nilai.SANGAT_BAIK;
        }

    }

    private static void inputDataTestKNN(List<Siswa> dataset) {
        SiswaKNN siswaKNN = new SiswaKNN(dataset);
        Siswa siswa = new Siswa();

        Scanner input = new Scanner(System.in);
        System.out.println("=======Prediksi Penjurusan SMK Menggunakan Algoritma KNN=======");

        System.out.print("Masukkan nama anda: ");
        siswa.setNama(input.nextLine());
        System.out.print("Minat: ");
        siswa.setMinat(new Minat(input.nextLine()));
        System.out.print("Agama: ");
        siswa.setAgama(input.nextDouble());
        System.out.print("PKN: ");
        siswa.setPkn(input.nextDouble());
        System.out.print("Bahasa Indo: ");
        siswa.setBhs_indo(input.nextDouble());
        System.out.print("Matematika: ");
        siswa.setMatematika(input.nextDouble());
        System.out.print("IPA: ");
        siswa.setIpa(input.nextDouble());
        System.out.print("IPS: ");
        siswa.setIps(input.nextDouble());
        System.out.print("Bahasa Inggris: ");
        siswa.setBhs_inggris(input.nextDouble());
        System.out.print("Seni Budaya: ");
        siswa.setSeni_budaya(input.nextDouble());
        System.out.print("Penjas: ");
        siswa.setPenjas(input.nextDouble());
        System.out.print("Prakarya: ");
        siswa.setPrakarya(input.nextDouble());
        System.out.print("Bahasa Daerah: ");
        siswa.setBhs_daerah(input.nextDouble());

        System.out.print("\nMasukkan jumlah K: ");
        siswaKNN.predict(siswa, input.nextInt());
        System.out.println(siswa);

        input.close();
    }

}