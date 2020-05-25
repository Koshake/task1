package lesson4;

import java.util.Random;
import java.util.Scanner;

public class XoGame {

    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWinUniversal(DOT_X)) {
                System.out.println("Ты победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();

            if (checkWinUniversal(DOT_O)) {
                System.out.println("Компьютер победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (!isCellValid(i, j))
                        continue;
                    map[i][j] = DOT_X;
                    if (checkWinUniversal(DOT_X)) {
                        map[i][j] = DOT_O;
                        y = i;
                        x = j;
                        break;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // old version
    public static boolean checkWin(char c) {
        if (map[0][0] == c && map[0][1] == c && map[0][2] == c) {
            return true;
        }
        if (map[1][0] == c && map[1][1] == c && map[1][2] == c) {
            return true;
        }
        if (map[2][0] == c && map[2][1] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][0] == c && map[1][0] == c && map[2][0] == c) {
            return true;
        }
        if (map[0][1] == c && map[1][1] == c && map[2][1] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][2] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            return true;
        }
        return false;
    }

    // new version
    public static boolean checkWinUniversal(char c) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkWinHorizontalLine(i, j, c)) {
                    return true;
                }
                if (checkWinVerticalLine(i, j, c)) {
                    return true;
                }
                if (checkWinDiagonalUpLine(i, j, c)) {
                    return true;
                }
                if (checkWinDiagonalDownLine(i, j, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWinHorizontalLine(int y, int x, char c) {
        if (map[y][x] != c)
            return false;

        char prev = map[y][x];
        boolean equals = true;
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((x + i >= SIZE) || (map[y][x + i] != prev)) {
                equals = false;
                break;
            }
            prev = map[y][x + i];
        }
        return equals;
    }

    public static boolean checkWinVerticalLine(int y, int x, char c) {
        if (map[y][x] != c)
            return false;

        char prev = map[y][x];
        boolean equals = true;
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((y + i >= SIZE) || (map[y + i][x] != prev)) {
                equals = false;
                break;
            }
            prev = map[y + i][x];
        }
        return equals;
    }

    public static boolean checkWinDiagonalDownLine(int y, int x, char c) {
        if (map[y][x] != c)
            return false;

        char prev = map[y][x];
        boolean equals = true;
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((y + i >= SIZE) || (x + i >= SIZE) || (map[y + i][x + i] != prev)) {
                equals = false;
                break;
            }
            prev = map[y + i][x + i];
        }
        return equals;
    }

    public static boolean checkWinDiagonalUpLine(int y, int x, char c) {
        if (map[y][x] != c)
            return false;

        char prev = map[y][x];
        boolean equals = true;
        for (int i = 1; i < DOTS_TO_WIN; i++) {
            if ((y - i < 0) || (x + i >= SIZE) || (map[y - i][x + i] != prev)) {
                equals = false;
                break;
            }
            prev = map[y - i][x + i];
        }
        return equals;
    }

}
