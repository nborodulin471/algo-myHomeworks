package recursion;

public class Main {

    private static int n = 10;

    public static void main(String[] args) {

        char[][] field = new char[n][n];
        demoField(field);
        find_path(field, 3, 8);

    }

    private static void demoField(char[][] field) {
        field[0][0] = 'Щ';
        field[0][3] = '*';
        field[0][4] = '*';
        field[1][4] = '*';
        field[1][6] = '*';
        field[1][7] = '*';
        field[2][3] = '*';
        field[2][5] = '*';
        field[2][9] = '*';
        field[3][1] = '*';
        field[4][6] = '*';
        field[5][2] = '*';
        field[5][5] = '*';
        field[6][3] = '*';
        field[6][6] = '*';
        field[6][7] = '*';
        field[6][8] = '*';
        field[7][7] = '*';
        field[8][7] = '*';
        field[9][5] = '*';
        field[9][6] = '*';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == '\u0000') {
                    field[i][j] = '-';
                }
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }

    }

    private static int where_from(char[][] field, int x, int y, char[][] memory) {

        int left_x;
        int left_y;
        int up_x;
        int up_y;

        if (memory[x][y] != '?') {
            return memory[x][y];
        }

        if (x > 0) {
            left_x = x - 1;
            left_y = y;
            if (left_x == 0 && left_y == 0) {
                memory[x][y] = 'L';
                return 'L';
            }
            if (field[left_x][left_y] != '*') {
                if (where_from(field, left_x, left_y, memory) != 'N') {
                    memory[x][y] = 'L';
                    return 'L';
                }
            }
        }

        if (y > 0) {
            up_x = x;
            up_y = y - 1;
            if (up_x == 0 && up_y == 0) {
                memory[x][y] = 'U';
                return 'U';
            }
            if (field[up_x][up_y] != '*') {
                if (where_from(field, up_x, up_y, memory) != 'N') {
                    memory[x][y] = 'U';
                    return 'U';
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }

    public static void find_path(char[][] field, int x0, int y0) {

        char[][] memory = new char[n][n];
        int direction = 0;
        int x = x0;
        int y = y0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memory[i][j] = '?';
            }
        }

        while (x != 0 || y != 0) {
            direction = where_from(field, x, y, memory);
            if (direction == 'N') {
                System.out.println("Нет такого пути :(");
                return;
            } else if (direction == 'U') {
                field[x][y] = 'X';
                y -= 1;
            } else if (direction == 'L') {
                field[x][y] = 'X';
                x -= 1;
            }
        }
        System.out.println("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == x0 && j == y0) {
                    System.out.print('Ч');
                } else if (field[i][j] == 'X') {
                    System.out.print('X');
                } else {
                    System.out.print(field[i][j]);
                }
            }
            System.out.println("");
        }
    }
}
