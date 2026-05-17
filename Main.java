package JobsheetCM2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DLLPembeli antrean = new DLLPembeli();
        DLLPesanan pesanan = new DLLPesanan();

        int pilih;

        do {
            System.out.println("\n====================================");
            System.out.println("   SISTEM RESTO ROYAL DELISH");
            System.out.println("====================================");
            System.out.println("1. Tambah Antrean");
            System.out.println("2. Cetak Antrean");
            System.out.println("3. Hapus Antrean dan Input Pesanan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();

                    System.out.print("No HP : ");
                    String hp = sc.nextLine();

                    antrean.tambahAntrian(nama, hp);
                    break;

                case 2:
                    antrean.cetakAntrian();
                    break;

                case 3:
                    Pembeli pb = antrean.hapusAntrian();

                    if (pb != null) {

                        System.out.println("Pembeli dipanggil:");
                        System.out.println("No Antrean : " + pb.noAntrian);
                        System.out.println("Nama       : " + pb.namaPembeli);

                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nama Pesanan : ");
                        String menu = sc.nextLine();

                        System.out.print("Harga : ");
                        int harga = sc.nextInt();
                        sc.nextLine();

                        pesanan.tambahPesanan(kode, menu, harga, pb.namaPembeli);
                    }
                    break;

                case 4:
                    pesanan.tampilPesanan();
                    break;

                case 0:
                    System.out.println("Program selesai");
                    break;

                default:
                    System.out.println("Menu tidak tersedia");
            }

        } while (pilih != 0);
    }
}