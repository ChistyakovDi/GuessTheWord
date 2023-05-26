package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        boolean startGame = true;
        Scanner scanner = new Scanner(System.in);
        String menuIn;
        System.out.println("Добро пожаловать в игру!!!");

        while (startGame) {
            System.out.println(" ");
            System.out.println("Меню");
            System.out.println("========================");
            System.out.println("1. Новая игра");
            System.out.println("2. Выход");
            System.out.println("========================");
            menuIn = scanner.next();
            if ((int) menuIn.charAt(0) == '2') {
                System.out.println("Игра окончена");
                startGame = false;
            } else if ((int) menuIn.charAt(0) == '1') {
                String[] chArray = Reader.getWord().split("");
                Game.go(chArray, scanner);
            } else
                System.out.println("Вы ввели некорректный пункт меню, повторите попытку");
        }
    }
}