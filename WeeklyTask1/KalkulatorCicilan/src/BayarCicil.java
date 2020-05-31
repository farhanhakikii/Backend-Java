import java.text.NumberFormat;

public class BayarCicil {
    private static final int BULAN_DALAM_TAHUN = 12;
    private static final int PERCENT = 100;

    public static double totalBayar(int harga, int durasi, double bunga) {
        return (harga + (harga * (bunga / PERCENT)));
    }
    public static double hitungBayaranPerBulan(int harga, int durasi, double bunga) {
        return (harga + (harga * (bunga / PERCENT))) / (durasi * BULAN_DALAM_TAHUN);
    }
    
    public static void tampilBayaran(double totalPembayaran, double bayaranPerBulan) {
        System.out.println("---------- TOTAL PEMBAYARAN ----------");
        System.out.println(NumberFormat.getCurrencyInstance().format(totalPembayaran));
        System.out.println("---------- PEMBAYARAN SETIAP BULAN ----------");
        System.out.println(NumberFormat.getCurrencyInstance().format(bayaranPerBulan));
    }

    public static void hitungSisaBayaranPerBulan(int harga, int durasi, double bunga, double bayaranPerBulan) {
        System.out.println("---------- SISA BAYARAN PER BULAN ----------");
        double sisaBayaran = harga + (harga * (bunga / PERCENT));
        for (int i = 0; i < durasi * BULAN_DALAM_TAHUN; i++) {
            sisaBayaran -= bayaranPerBulan;
            System.out.println(NumberFormat.getCurrencyInstance().format(sisaBayaran));
        }
    }
}