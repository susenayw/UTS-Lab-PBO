import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private int remainingSafeCells;

    public LotreBoard() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];
        remainingSafeCells = 18;
        generateBoard();
    }

    public void generateBoard() {
        Random rand = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }

        int bomCount = 0;
        while (bomCount < 2) {
            int row = rand.nextInt(4);
            int col = rand.nextInt(5);
            if (data[row][col] != 1) {
                data[row][col] = 1;
                bomCount++;
            }
        }
    }

    public void displayBoard() {
        System.out.println("Papan permainan:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (revealed[i][j]) {
                    if (data[i][j] == 1) {
                        board[i][j] = 'X';
                    } else {
                        board[i][j] = 'O';
                    }
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= 4 || col < 0 || col >= 5 || revealed[row][col]) {
            System.out.println("Tebakan tidak valid atau sudah dibuka.");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            return false;
        } else {
            remainingSafeCells--;
            return true;
        }
    }

    public boolean isGameOver() {
        if (remainingSafeCells == 0) {
            System.out.println("Selamat! Anda berhasil membuka semua kotak aman.");
            return true;
        }
        return false;
    }
}