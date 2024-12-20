package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> addNewDish();
                case 2 -> generateDishCombo();
                case 3 -> {System.out.println("Работа с приложением завершена."); return;}
                default -> System.out.println("Неизвестная команда: " + command);
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dinnerConstructor.saveDish(dishType,dishName);

    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        String nextItem = scanner.nextLine();
        ArrayList<String> categoriesForCombo =  new ArrayList<>();

        while (!nextItem.isEmpty()) {
            if (dinnerConstructor.checkCategory(nextItem)) categoriesForCombo.add(nextItem);
            else System.out.println("Такой категории не существует. Введите существующую категорию.");
            nextItem = scanner.nextLine();
        }
        dinnerConstructor.returnDishes(categoriesForCombo,numberOfCombos);
    }
}
