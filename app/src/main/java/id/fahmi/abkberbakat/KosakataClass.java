package id.fahmi.abkberbakat;

/**
 * Created by Fahmi on 25/05/2017.
 */

class KosakataClass {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KosakataClass that = (KosakataClass) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    int id;
    int banyakobjek;
    int jumlahdata;
    String kosakata;
    String ilustrasi;
    String katadasar;
    String imbuhanawal;
    String imbuhanakhir;
    String alias;
    String kategori;
    String namalatin;
    String sumberilustasi;
    String sumberketerangan;
    String keterangan;
    String audiokosakata;
    String audioketerangan;

    String jawaban_a;
    String jawaban_b;
    String jawaban_c;
    String jawaban_d;
    String jawaban;

    String soal;
    String suara_objek;


    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getSuara_Objek() {
        return suara_objek;
    }

    public void setSuara_Objek(String suara_objek) {
        this.suara_objek = suara_objek;
    }


    public String getJawaban_A() {
        return jawaban_a;
    }

    public void setJawaban_A(String jawaban_a) {
        this.jawaban_a = jawaban_a;
    }

    public String getJawaban_B() {
        return jawaban_b;
    }

    public void setJawaban_B(String jawaban_b) {
        this.jawaban_b = jawaban_b;
    }

    public String getJawaban_C() {
        return jawaban_c;
    }

    public void setJawaban_C(String jawaban_c) {
        this.jawaban_c = jawaban_c;
    }

    public String getJawaban_D() {
        return jawaban_d;
    }

    public void setJawaban_D(String jawaban_d) {
        this.jawaban_d = jawaban_d;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNamalatin() {
        return namalatin;
    }

    public void setNamaLatin(String namalatin) {
        this.namalatin = namalatin;
    }

    public String getSumberIlustasi() {
        return sumberilustasi;
    }

    public void setSumberIlustasi(String sumberilustasi) {
        this.sumberilustasi = sumberilustasi;
    }

    public String getSumberKeterangan() {
        return sumberketerangan;
    }

    public void setSumberKeterangan(String sumberketerangan) {
        this.sumberketerangan = sumberketerangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getAudioKosakata() {
        return audiokosakata;
    }

    public void setAudioKosakata(String audiokosakata) {
        this.audiokosakata = audiokosakata;
    }

    public String getAudioKeterangan() {
        return audioketerangan;
    }

    public void setAudioKeterangan(String audioketerangan) {
        this.audioketerangan = audioketerangan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKosakata() {
        return kosakata;
    }

    public void setKosakata(String kosakata) {
        this.kosakata = kosakata;
    }

    public String getIlustrasi() {
        return ilustrasi;
    }

    public void setIlustrasi(String ilustrasi) {
        this.ilustrasi = ilustrasi;
    }

    public int getJumlahData() {
        return jumlahdata;
    }

    public void setJumlahData(int jumlahdata) {
        this.jumlahdata = jumlahdata;
    }

    public int getBanyakObjek() {
        return banyakobjek;
    }

    public void setBanyakObjek(int banyakobjek) {
        this.banyakobjek = banyakobjek;
    }

    public String getKataDasar() {
        return katadasar;
    }

    public void setKataDasar(String katadasar) {
        this.katadasar = katadasar;
    }

    public String getImbuhanAwal() {
        return imbuhanawal;
    }

    public void setImbuhanAwal(String imbuhanawal) {
        this.imbuhanawal = imbuhanawal;
    }

    public String getImbuhanAkhir() {
        return imbuhanakhir;
    }

    public void setImbuhanAkhir(String imbuhanakhir) {
        this.imbuhanakhir = imbuhanakhir;
    }

}
