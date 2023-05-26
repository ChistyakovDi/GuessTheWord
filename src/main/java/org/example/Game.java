package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    public static void go(String[] secretWordLetters, Scanner scanner) {
        String ch;
        HashSet<String> misspelledLetters = new HashSet<>();
        int errorCount = 0;
        String regex = "^\\[|]|,";
        StringBuilder errorLetter = new StringBuilder();
        String[] wordMask = new String[secretWordLetters.length];

        Arrays.fill(wordMask, "_");
        System.out.println("У вас есть 7 попыток угадать буквы, из которых состоит загаданное слово");
        System.out.println("Маска слова: " + Arrays.toString(wordMask).replaceAll(regex, "") + "\n");

        while (!Arrays.equals(secretWordLetters, wordMask) && errorCount < 7) {
            System.out.println("Введите букву: ");
            ch = scanner.next().toLowerCase();

            if (!misspelledLetters.contains(ch)) {
                boolean incorrectGuess = true;
                misspelledLetters.add(ch);

                for (int i = 0; i < secretWordLetters.length; i++) {
                    if (ch.equals(secretWordLetters[i])) {
                        wordMask[i] = ch;
                        incorrectGuess = false;
                    }
                }
                if (incorrectGuess) {
                    System.out.println("Вы не угадали букву!");
                    errorCount++;
                    errorLetter.append(ch).append(" ");
                } else {
                    System.out.println("Вы угадали букву!");
                }
            }
            Gallows.print(errorCount);
            System.out.println("Неудачных попыток: " + errorCount + ", неверные буквы - " + errorLetter);
            System.out.println("Отгадываемое слово: " + Arrays.toString(wordMask).replaceAll(regex, "") + "\n");
        }
        System.out.println("Правильное слово: " + Arrays.toString(secretWordLetters).replaceAll(regex, ""));
        System.out.println("\nКонец игры!");
        if (errorCount >= 7) {
            System.out.println("К сожалению, вы не смогли угадать слово. Получится в следующий раз!");
        } else {
            switch (errorCount) {
                case 1: System.out.println("Вам удалось угадать слово с " + errorCount + " ошибкой");
                case 2,3,4,5,6: System.out.println("Поздравляю! Вам удалось угадать слово с " + errorCount + " ошибками!");
            }
        }
    }
}