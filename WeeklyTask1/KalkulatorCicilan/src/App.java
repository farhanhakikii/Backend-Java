import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true){
            int harga = (int) Console.readInputNumber("Masukkkan Harga: ");
            new Cicilan(harga, 1, 0);
            int durasi = (int) Console.readInputNumber("Masukkkan Durasi: ");
            new Cicilan(harga, durasi, 0);
            int bunga = (int) Console.readInputNumber("Masukkkan Bunga: ");
            new Cicilan(harga, durasi, bunga);
            
            double totalBayar = BayarCicil.totalBayar(harga, durasi, bunga);
            double bayarPerBulan = BayarCicil.hitungBayaranPerBulan(harga, durasi, bunga);
            BayarCicil.tampilBayaran(totalBayar, bayarPerBulan);
            BayarCicil.hitungSisaBayaranPerBulan(harga, durasi, bunga, bayarPerBulan);

            System.out.println("Lagi?Y/N");
            String opsi = scanner.next();
            if(opsi.equalsIgnoreCase("N")){
                break;
            }
        }
    }
}