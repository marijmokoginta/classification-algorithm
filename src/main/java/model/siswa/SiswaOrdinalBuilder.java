package model.siswa;

public class SiswaOrdinalBuilder {

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

    public SiswaOrdinalBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public SiswaOrdinalBuilder setAgama(Nilai agama) {
        this.agama = agama;
        return this;
    }

    public SiswaOrdinalBuilder setPkn(Nilai pkn) {
        this.pkn = pkn;
        return this;
    }

    public SiswaOrdinalBuilder setBhs_indo(Nilai bhs_indo) {
        this.bhs_indo = bhs_indo;
        return this;
    }

    public SiswaOrdinalBuilder setMatematika(Nilai matematika) {
        this.matematika = matematika;
        return this;
    }

    public SiswaOrdinalBuilder setIpa(Nilai ipa) {
        this.ipa = ipa;
        return this;
    }

    public SiswaOrdinalBuilder setIps(Nilai ips) {
        this.ips = ips;
        return this;
    }

    public SiswaOrdinalBuilder setBhs_inggris(Nilai bhs_inggris) {
        this.bhs_inggris = bhs_inggris;
        return this;
    }

    public SiswaOrdinalBuilder setSeni_budaya(Nilai seni_budaya) {
        this.seni_budaya = seni_budaya;
        return this;
    }

    public SiswaOrdinalBuilder setPenjas(Nilai penjas) {
        this.penjas = penjas;
        return this;
    }

    public SiswaOrdinalBuilder setPrakarya(Nilai prakarya) {
        this.prakarya = prakarya;
        return this;
    }

    public SiswaOrdinalBuilder setBhs_daerah(Nilai bhs_daerah) {
        this.bhs_daerah = bhs_daerah;
        return this;
    }

    public SiswaOrdinalBuilder setMinat(String minat) {
        this.minat = minat;
        return this;
    }

    public SiswaOrdinalBuilder setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
        return this;
    }

    public SiswaOrdinal build() {
        return new SiswaOrdinal(
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
