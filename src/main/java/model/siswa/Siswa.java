package model.siswa;

public class Siswa {

    private String nama;
    private double agama;
    private double pkn;
    private double bhs_indo;
    private double matematika;
    private double ipa;
    private double ips;
    private double bhs_inggris;
    private double seni_budaya;
    private double penjas;
    private double prakarya;
    private double bhs_daerah;
    private Minat minat;
    private Jurusan jurusan;

    private Jurusan jurusanPredict;

    public static SiswaBuilder builder() {
        return new SiswaBuilder();
    }

    private double distance;

    public Siswa(){
    }

    public Siswa(String nama, double agama, double pkn, double bhs_indo, double matematika, double ipa, double ips, double bhs_inggris, double seni_budaya, double penjas, double prakarya) {
        this.nama = nama;
        this.agama = agama;
        this.pkn = pkn;
        this.bhs_indo = bhs_indo;
        this.matematika = matematika;
        this.ipa = ipa;
        this.ips = ips;
        this.bhs_inggris = bhs_inggris;
        this.seni_budaya = seni_budaya;
        this.penjas = penjas;
        this.prakarya = prakarya;
    }

    public Siswa(String nama, double agama, double pkn, double bhs_indo, double matematika, double ipa, double ips, double bhs_inggris, double seni_budaya, double penjas, double prakarya, double bhs_daerah, Minat minat, Jurusan jurusan) {
        this.nama = nama;
        this.agama = agama;
        this.pkn = pkn;
        this.bhs_indo = bhs_indo;
        this.matematika = matematika;
        this.ipa = ipa;
        this.ips = ips;
        this.bhs_inggris = bhs_inggris;
        this.seni_budaya = seni_budaya;
        this.penjas = penjas;
        this.prakarya = prakarya;
        this.bhs_daerah = bhs_daerah;
        this.minat = minat;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getAgama() {
        return agama;
    }

    public void setAgama(double agama) {
        this.agama = agama;
    }

    public double getPkn() {
        return pkn;
    }

    public void setPkn(double pkn) {
        this.pkn = pkn;
    }

    public double getBhs_indo() {
        return bhs_indo;
    }

    public void setBhs_indo(double bhs_indo) {
        this.bhs_indo = bhs_indo;
    }

    public double getMatematika() {
        return matematika;
    }

    public void setMatematika(double matematika) {
        this.matematika = matematika;
    }

    public double getIpa() {
        return ipa;
    }

    public void setIpa(double ipa) {
        this.ipa = ipa;
    }

    public double getIps() {
        return ips;
    }

    public void setIps(double ips) {
        this.ips = ips;
    }

    public double getPenjas() {
        return penjas;
    }

    public void setPenjas(double penjas) {
        this.penjas = penjas;
    }

    public double getPrakarya() {
        return prakarya;
    }

    public void setPrakarya(double prakarya) {
        this.prakarya = prakarya;
    }

    public double getBhs_inggris() {
        return bhs_inggris;
    }

    public void setBhs_inggris(double bhs_inggris) {
        this.bhs_inggris = bhs_inggris;
    }

    public double getSeni_budaya() {
        return seni_budaya;
    }

    public void setSeni_budaya(double seni_budaya) {
        this.seni_budaya = seni_budaya;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public double getBhs_daerah() {
        return bhs_daerah;
    }

    public void setBhs_daerah(double bhs_daerah) {
        this.bhs_daerah = bhs_daerah;
    }

    public Minat getMinat() {
        return minat;
    }

    public void setMinat(Minat minat) {
        this.minat = minat;
    }

    public Jurusan getJurusanPredict() {
        return jurusanPredict;
    }

    public void setJurusanPredict(Jurusan jurusanPredict) {
        this.jurusanPredict = jurusanPredict;
    }

    @Override
    public String toString() {
        return "Siswa{" +
                "name='" + nama + '\'' +
                ", agama=" + agama +
                ", pkn=" + pkn +
                ", bhsIndo=" + bhs_indo +
                ", matematika=" + matematika +
                ", ipa=" + ipa +
                ", ips=" + ips +
                ", bhsInggris=" + bhs_inggris +
                ", seniBudaya=" + seni_budaya +
                ", penjas=" + penjas +
                ", prakarya=" + prakarya +
                ", bhsDaerah=" + bhs_daerah +
                ", minat=" + minat.getNama() +
                ", minat value=" + minat.getValue() +
                ", jurusan=" + jurusan +
                ", jurusanPredict=" + jurusanPredict +
                '}';
    }
}
