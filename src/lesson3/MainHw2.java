package lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainHw2 {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        // 1 Угадать число
        guessPassword();

        sc.reset();

        // 2 Угадать слово
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        guessWord(words);

    }

    public static void guessPassword() {
        int repeat = 1;
        while(repeat == 1) {
            System.out.println("Введите число от 0 до 9. У Вас 3 попытки, чтобы угадать число!");
            int password = new Random().nextInt(10);
            int userPassword = 0;
            final int maxTry = 3;
            for (int i = 0; i < maxTry; i++) {
                userPassword = sc.nextInt();
                if (userPassword == password) {
                    System.out.println("Поздравляю! Вы угадали!");
                    break;
                } else if (userPassword < password) {
                    System.out.println("Слишком маленькое число! Попробуйте еще!");
                } else if (userPassword > password) {
                    System.out.println("Слишком большое число! Попробуйте еще!");
                }
            }
            if(userPassword != password)
                System.out.println("Вы не угадали! Исходное число " + password);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            repeat = sc.nextInt();
        }
    }

    public static void guessWord(String[] arr) {
        System.out.println("Угадайте слово! Нажмите 0, чтобы закончить игру!");

        String word = arr[new Random().nextInt(arr.length)];
        String userWord;
        while (true) {
            userWord = sc.next();
            if (userWord.equals("0")) {
                break;
            } else if (userWord.equals(word)) {
                System.out.println("Поздравляю! Вы угадали!");
                break;
            } else {
                System.out.println("Вы не угадали! Пордсказка: " +  compareWords(word, userWord));
            }
        }
    }

    public static String compareWords(String original , String str2) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            res.append("#");
        }

        for (int i = 0; i < Math.min(str2.length(), original.length()); i++) {
            if(str2.charAt(i) == original.charAt(i))
                res.setCharAt(i, original.charAt(i));
        }

        return res.toString();
    }


}
