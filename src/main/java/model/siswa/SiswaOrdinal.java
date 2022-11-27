package model.siswa;

public class SiswaOrdinal {

    private String nama;
    private Nilai agama;
    private Nilai pkn;
    private Nilai bhs_indo;
    private Nilai matematika;
    private Nilai ipa;
    private Nilai ips;
    private Nilai bhs_inggris;
    private Nilai seni_budaya;
    private Nilai penjas;
    private Nilai prakarya;
    private Nilai bhs_daerah;
    private String minat;
    private Jurusan jurusan;

    public static SiswaOrdinalBuilder builder() {
        return new SiswaOrdinalBuilder();
    }

    private double distance;

    public SiswaOrdinal(){
    }

    public SiswaOrdinal(String nama, Nilai agama, Nilai pkn, Nilai bhs_indo, Nilai matematika, Nilai ipa, Nilai ips, Nilai bhs_inggris, Nilai seni_budaya, Nilai penjas, Nilai prakarya) {
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

    public SiswaOrdinal(String nama, Nilai agama, Nilai pkn, Nilai bhs_indo, Nilai matematika, Nilai ipa, Nilai ips, Nilai bhs_inggris, Nilai seni_budaya, Nilai penjas, Nilai prakarya, Nilai bhs_daerah, String minat, Jurusan jurusan) {
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

    public Nilai getAgama() {
        return agama;
    }

    public void setAgama(Nilai agama) {
        this.agama = agama;
    }

    public Nilai getPkn() {
        return pkn;
    }

    public void setPkn(Nilai pkn) {
        this.pkn = pkn;
    }

    public Nilai getBhs_indo() {
        return bhs_indo;
    }

    public void setBhs_indo(Nilai bhs_indo) {
        this.bhs_indo = bhs_indo;
    }

    public Nilai getMatematika() {
        return matematika;
    }

    public void setMatematika(Nilai matematika) {
        this.matematika = matematika;
    }

    public Nilai getIpa() {
        return ipa;
    }

    public void setIpa(Nilai ipa) {
        this.ipa = ipa;
    }

    public Nilai getIps() {
        return ips;
    }

    public void setIps(Nilai ips) {
        this.ips = ips;
    }

    public Nilai getPenjas() {
        return penjas;
    }

    public void setPenjas(Nilai penjas) {
        this.penjas = penjas;
    }

    public Nilai getPrakarya() {
        return prakarya;
    }

    public void setPrakarya(Nilai prakarya) {
        this.prakarya = prakarya;
    }

    public Nilai getBhs_inggris() {
        return bhs_inggris;
    }

    public void setBhs_inggris(Nilai bhs_inggris) {
        this.bhs_inggris = bhs_inggris;
    }

    public Nilai getSeni_budaya() {
        return seni_budaya;
    }

    public void setSeni_budaya(Nilai seni_budaya) {
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

    public Nilai getBhs_daerah() {
        return bhs_daerah;
    }

    public void setBhs_daerah(Nilai bhs_daerah) {
        this.bhs_daerah = bhs_daerah;
    }

    public String getMinat() {
        return minat;
    }

    public void setMinat(String minat) {
        this.minat = minat;
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
                ", minat=" + minat +
                ", jurusan=" + jurusan +
                '}';
    }

}
