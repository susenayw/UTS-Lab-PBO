package soal3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard lotreBoard = new LotreBoard();

        while (true) {
            lotreBoard.displayBoard();

            System.out.println("\nMasukkan tebakan Anda:");
            System.out.print("Baris (0-3): ");
            int row = scanner.nextInt();
            System.out.print("Kolom (0-4): ");
            int col = scanner.nextInt();

            boolean result = lotreBoard.guess(row, col);

            if (!result) {
                lotreBoard.displayBoard();
                System.out.println("\nGame Over! Anda menebak bom.");
                break;
            }

            if (lotreBoard.isGameOver()) {
                lotreBoard.displayBoard();
                System.out.println("\nPermainan selesai! Semua kotak aman telah terbuka.");
                break;
            }
        }

        scanner.close();
    }
}
