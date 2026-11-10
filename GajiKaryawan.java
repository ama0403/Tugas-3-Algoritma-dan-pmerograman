
import java.util.Scanner;

public class GajiKaryawan {

    public static void main(String[] args) {

        // Array Gaji
        int[] gaji = {5000000, 6500000, 9500000};

        // Array Persentase Lembur
        int[] persenLembur = {30, 32, 34, 36, 38};

        // Scanner untuk input
        Scanner scanner = new Scanner(System.in);

        // Input Golongan dan Jam Lembur
        System.out.print("Masukkan Golongan (A/B/C): ");
        String golongan = scanner.nextLine().toUpperCase();

        System.out.print("Masukkan Jumlah Jam Lembur: ");
        int jamLembur = scanner.nextInt();

        // Menentukan Gaji Pokok
        int gajiPokok = 0;

        if (golongan.equals("A")) {
            gajiPokok = gaji[0];
        } else if (golongan.equals("B")) {
            gajiPokok = gaji[1];
        } else if (golongan.equals("C")) {
            gajiPokok = gaji[2];
        } else {
            System.out.println("Golongan tidak valid!");
            scanner.close();
            return;
        }

        // Validasi Jam Lembur
        if (jamLembur < 0) {
            System.out.println("Jumlah jam lembur tidak valid!");
            scanner.close();
            return;
        }

        // Menghitung Gaji Lembur
        int gajiLemburTotal = 0;

        if (jamLembur > 0) {
            int indeksLembur;

            if (jamLembur >= 5) {
                indeksLembur = 4;
            } else {
                indeksLembur = jamLembur - 1;
            }

            gajiLemburTotal =
                    gajiPokok * persenLembur[indeksLembur] / 100;
        }

        // Menghitung Total Gaji
        int totalGaji = gajiPokok + gajiLemburTotal;

        // Menampilkan Hasil
        System.out.println("==============================");
        System.out.println("Golongan       : " + golongan);
        System.out.println("Jam Lembur     : " + jamLembur);
        System.out.println("Gaji Pokok     : Rp." + gajiPokok);
        System.out.println("Persen Lembur  : "
                + (jamLembur > 0 ? persenLembur[Math.min(jamLembur - 1, 4)] : 0)
                + "%");
        System.out.println("Gaji Lembur    : Rp." + gajiLemburTotal);
        System.out.println("Total Gaji     : Rp." + totalGaji);
        System.out.println("==============================");

        scanner.close();
    }
}
