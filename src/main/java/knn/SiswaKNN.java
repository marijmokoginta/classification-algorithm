package knn;

import model.siswa.Jurusan;
import model.siswa.KSiswa;
import model.siswa.Siswa;

import java.util.ArrayList;
import java.util.List;

public record SiswaKNN(List<Siswa> dataset) {

    public void predict(Siswa datatest, int k) {
        List<Siswa> dataDistance = new ArrayList<>();

        // distance
        for (Siswa data : dataset) {
//            double x0 = data.getAgama() - datatest.getAgama();
            double x1 = data.getPkn() - datatest.getPkn();
            double x2 = data.getBhs_indo() - datatest.getBhs_indo();
            double x3 = data.getMatematika() - datatest.getMatematika();
            double x4 = data.getIpa() - datatest.getIpa();
            double x5 = data.getIps() - datatest.getIps();
            double x6 = data.getBhs_inggris() - datatest.getBhs_inggris();
            double x7 = data.getSeni_budaya() - datatest.getSeni_budaya();
            double x8 = data.getPenjas() - datatest.getPenjas();
            double x9 = data.getPrakarya() - datatest.getPrakarya();
            double x10 = data.getBhs_daerah() - datatest.getBhs_daerah();
            double x11 = data.getMinat().getValue() - datatest.getMinat().getValue();
            double sqd = (x1 * x1) + (x2 * x2) + (x3 * x3) + (x4 * x4) + (x5 * x5) + (x6 * x6) + (x7 * x7) + (x8 * x8) + (x9 * x9) + (x10 * x10) + (x11 * x11);
            data.setDistance(sqd);
            dataDistance.add(data);
        }

        // sorting (bubble sort)
        for (int i = 0; i < (dataDistance.size() - 1); i++) {
            for (int j = i + 1; j < dataDistance.size(); j++) {
                if (dataDistance.get(i).getDistance() > dataDistance.get(j).getDistance()) {
                    Siswa tempSiswa = dataDistance.get(i);
                    dataDistance.set(i, dataDistance.get(j));
                    dataDistance.set(j, tempSiswa);
                }
            }
        }

        // calculate
        int PSPR = 0;
        int PSPT = 0;
        int TKJ = 0;
        int RPL = 0;
        int MM = 0;
        int UPW = 0;
        int AKL = 0;
        int OTKP = 0;
        int BDP = 0;
        int APL = 0;

        for (int i = 0; i < k; i++) {
            switch (dataDistance.get(i).getJurusan()) {
                case PSPR -> PSPR++;
                case PSPT -> PSPT++;
                case TKJ -> TKJ++;
                case RPL -> RPL++;
                case MM -> MM++;
                case UPW -> UPW++;
                case AKL -> AKL++;
                case OTKP -> OTKP++;
                case BDP -> BDP++;
                case APL -> APL++;
            }
        }

        List<KSiswa> kSiswa = new ArrayList<>();
        kSiswa.add(new KSiswa(Jurusan.PSPR, PSPR));
        kSiswa.add(new KSiswa(Jurusan.PSPT, PSPT));
        kSiswa.add(new KSiswa(Jurusan.TKJ, TKJ));
        kSiswa.add(new KSiswa(Jurusan.RPL, RPL));
        kSiswa.add(new KSiswa(Jurusan.MM, MM));
        kSiswa.add(new KSiswa(Jurusan.UPW, UPW));
        kSiswa.add(new KSiswa(Jurusan.AKL, AKL));
        kSiswa.add(new KSiswa(Jurusan.OTKP, OTKP));
        kSiswa.add(new KSiswa(Jurusan.BDP, BDP));
        kSiswa.add(new KSiswa(Jurusan.APL, APL));

        for (int i = 0; i < kSiswa.size()-1; i++) {
            for (int j = i+1; j < kSiswa.size(); j++) {
                if (kSiswa.get(i).count < kSiswa.get(j).count) {
                    KSiswa tempSiswa = kSiswa.get(i);
                    kSiswa.set(i, kSiswa.get(j));
                    kSiswa.set(j, tempSiswa);
                }
            }
        }

//        System.out.println(kSiswa.get(0).jurusan + " : " + kSiswa.get(0).count);
//        System.out.println(kSiswa.get(1).jurusan + " : " + kSiswa.get(1).count);
//        System.out.println(kSiswa.get(2).jurusan + " : " + kSiswa.get(2).count);
//        System.out.println(kSiswa.get(3).jurusan + " : " + kSiswa.get(3).count);
//        System.out.println(kSiswa.get(4).jurusan + " : " + kSiswa.get(4).count);
//        System.out.println(kSiswa.get(5).jurusan + " : " + kSiswa.get(5).count);
//        System.out.println(kSiswa.get(6).jurusan + " : " + kSiswa.get(6).count);
//        System.out.println(kSiswa.get(7).jurusan + " : " + kSiswa.get(7).count);
//        System.out.println(kSiswa.get(8).jurusan + " : " + kSiswa.get(8).count);
//        System.out.println(kSiswa.get(9).jurusan + " : " + kSiswa.get(9).count);
        datatest.setJurusanPredict(kSiswa.get(0).jurusan);

    }
}
