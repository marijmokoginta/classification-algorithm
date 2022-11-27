package model.siswa;

public class Minat {

    private String nama;
    private int value;

    public  Minat(String nama) {
        this.nama = nama;
        if (nama!=null) {
            switch (nama) {
                case "PSPR" -> this.value = 1;
                case "PSPT" -> this.value = 2;
                case "TKJ" -> this.value = 3;
                case "RPL" -> this.value = 4;
                case "MM" -> this.value = 5;
                case "UPW" -> this.value = 6;
                case "AKL" -> this.value = 7;
                case "OTKP" -> this.value = 8;
                case "BDP" -> this.value = 9;
                case "APL" -> this.value = 10;
            }
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getValue() {
        return value;
    }
}
