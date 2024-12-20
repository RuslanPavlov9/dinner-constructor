package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> dishByCategories = new HashMap<>();
    private Random random = new Random();

    DinnerConstructor() {
        ArrayList<String> listOfDishes = new ArrayList<>();
        listOfDishes.add("Щи");
        listOfDishes.add("Борщ");
        listOfDishes.add("Молочный суп");
        listOfDishes.add("Рассольник");
        dishByCategories.put("Первое",listOfDishes);

        listOfDishes = new ArrayList<>();
        listOfDishes.add("Мясо");
        listOfDishes.add("Рыба");
        listOfDishes.add("Люля");
        listOfDishes.add("Котлета");
        dishByCategories.put("Второе",listOfDishes);

        listOfDishes = new ArrayList<>();
        listOfDishes.add("Рис");
        listOfDishes.add("Гречка");
        listOfDishes.add("Пюре");
        listOfDishes.add("Овощи");
        dishByCategories.put("Гарнир",listOfDishes);

        listOfDishes = new ArrayList<>();
        listOfDishes.add("Сок");
        listOfDishes.add("Шиповник");
        listOfDishes.add("Чай");
        listOfDishes.add("Кофе");
        dishByCategories.put("Напитки",listOfDishes);

    }

    void saveDish(String dishCategory, String dish){
//        dishByCategories.computeIfAbsent(dishCategory, k-> new ArrayList<>()).add(dish);
        if(checkCategory(dishCategory))  {
            ArrayList<String> list = dishByCategories.get(dishCategory);
            list.add(dish);
        }
        else {
            ArrayList<String> listOfDishes = new ArrayList<>();
            listOfDishes.add(dish);
            dishByCategories.put(dishCategory, listOfDishes);
        }

    }

    boolean checkCategory (String dishCategory) {
        return (dishByCategories.containsKey(dishCategory));
    }

    void returnDishes (ArrayList<String> categories, int numbersOfCombos) {

        for (int i = 0; i < numbersOfCombos; i++) {
            System.out.println("Комбо " + (i + 1) + " :" );
            for (String category : categories) {
                    ArrayList<String> dishes = dishByCategories.get(category);
                    if (dishes != null && !dishes.isEmpty()) {
                        int boardArray = dishes.size();
                        int randomNumber = random.nextInt(boardArray);
                        String toList = dishes.get(randomNumber);
                        System.out.println(category + " : " + toList);
                    }
                    else {
                        System.out.println(category + " : Нет доступных блюд. Заполните категорию.");
                    }
            }
        }
    }

}
