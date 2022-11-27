package model.siswa;

public class SiswaBuilder {

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

    public SiswaBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public SiswaBuilder setAgama(double agama) {
        this.agama = agama;
        return this;
    }

    public SiswaBuilder setPkn(double pkn) {
        this.pkn = pkn;
        return this;
    }

    public SiswaBuilder setBhs_indo(double bhs_indo) {
        this.bhs_indo = bhs_indo;
        return this;
    }

    public SiswaBuilder setMatematika(double matematika) {
        this.matematika = matematika;
        return this;
    }

    public SiswaBuilder setIpa(double ipa) {
        this.ipa = ipa;
        return this;
    }

    public SiswaBuilder setIps(double ips) {
        this.ips = ips;
        return this;
    }

    public SiswaBuilder setBhs_inggris(double bhs_inggris) {
        this.bhs_inggris = bhs_inggris;
        return this;
    }

    public SiswaBuilder setSeni_budaya(double seni_budaya) {
        this.seni_budaya = seni_budaya;
        return this;
    }

    public SiswaBuilder setPenjas(double penjas) {
        this.penjas = penjas;
        return this;
    }

    public SiswaBuilder setPrakarya(double prakarya) {
        this.prakarya = prakarya;
        return this;
    }

    public SiswaBuilder setBhs_daerah(double bhs_daerah) {
        this.bhs_daerah = bhs_daerah;
        return this;
    }

    public SiswaBuilder setMinat(Minat minat) {
        this.minat = minat;
        return this;
    }

    public SiswaBuilder setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
        return this;
    }

    public Siswa build() {
        return new Siswa(
                this.nama,
                this.agama,
                this.pkn,
                this.bhs_indo,
                this.matematika,
                this.ipa,
                this.ips,
                this.bhs_inggris,
                this.seni_budaya,
                this.penjas,
                this.prakarya,
                this.bhs_daerah,
                this.minat,
                this.jurusan
        );
    }
}
