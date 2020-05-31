public class Cicilan {
    private int harga;
    private int durasi;
    private int bunga;

    public Cicilan(int harga, int durasi, int bunga){
        setHarga(harga);
        setDurasi(durasi);
        setBunga(bunga);
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        if(harga >= 1_000_000 && harga <= 100_000_000){
            this.harga = harga;
        }else{
            throw new IllegalArgumentException("Harga Harus diatas 1.000.000 dan dibawah 100.000.000");
        }
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        if(durasi >= 1){
            this.durasi = durasi;
        }else{
            throw new IllegalArgumentException("Durasi Minimal 1 Tahun");
        }
    }

    public int getBunga() {
        return bunga;
    }

    public void setBunga(int bunga) {
        if(bunga >= 0){
            this.bunga = bunga;
        }else{
            throw new IllegalArgumentException("Bunga minimal 0");
        }
    }
}