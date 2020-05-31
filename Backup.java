import java.text.NumberFormat;
import java.util.Scanner;

public class Backup {
    public static Scanner scanner = new Scanner(System.in);
    public static final int BULAN_DALAM_TAHUN = 12;
    public static final int PERCENT = 100;

    public static void main(String[] args) throws Exception {
        // Harga Awal = P
        // Durasi Cicilan = D (tahun)
        // Bunga = B
        // Bayaran per bulan = M

        // M = [P + (P * B / 100)] / D * 12
        int harga;
        int durasi;
        double bunga;

        while (true) {
            harga = (int) readInputNumber("Harga Awal: ");

            if (harga >= 1_000_000 && harga <= 100_000_000) {
                break;
            }
            System.out.println("Harga minimal 1.000.000");
        }

        while (true) {
            durasi = (int) readInputNumber("Durasi Cicilan: ");

            if (durasi >= 1) {
                break;
            }
            System.out.println("Tahun minimal 1");
        }

        while (true) {
            bunga = (int) readInputNumber("Bunga: ");

            if (bunga >= 0) {
                break;
            }
            System.out.println("Bunga minimal 0");
        }

        double bayaranPerBulan = hitungBayaranPerBulan(harga, durasi, bunga);

        tampilBayaran(bayaranPerBulan);

        hitungSisaBayaranPerBulan(harga, durasi, bunga, bayaranPerBulan);
    }

    public static double readInputNumber(String message) {
        System.out.print(message);
        return scanner.nextDouble();
    }

    public static void tampilBayaran(double bayaranPerBulan) {
        System.out.println("---------- PEMBAYARAN SETIAP BULAN ----------");
        System.out.println(NumberFormat.getCurrencyInstance().format(bayaranPerBulan));
    }

    public static double hitungBayaranPerBulan(int harga, int durasi, double bunga) {
        return (harga + (harga * (bunga / PERCENT))) / (durasi * BULAN_DALAM_TAHUN);
    }

    public static void hitungSisaBayaranPerBulan(int harga, int durasi, double bunga,
            double bayaranPerBulan) {
        System.out.println("---------- SISA BAYARAN PER BULAN ----------");
        double sisaBayaran = harga + (harga * (bunga / PERCENT));
        for (int i = 0; i < durasi * BULAN_DALAM_TAHUN; i++) {
            sisaBayaran -= bayaranPerBulan;
            System.out.println(NumberFormat.getCurrencyInstance().format(sisaBayaran));
        }
    }
}