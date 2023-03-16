package ru.geekbrains.homework3;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class MainApp{
    public static void main(String[] args) {

//        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
//вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//Посчитать, сколько раз встречается каждое слово.

        String[] words = {
                "Cat", "Cafe", "People", "Apple", "Home", "Knife", "TV",
                "Boy", "People", "Flowers", "Apple", "Boy", "Cat", "Apple",
                "Spoons", "TV", "Copybook", "Library", "Apple", "Flowers", "Home"

        };

        HashSet<String> uniqueList = new HashSet<>();
        for (String word : words) {
            uniqueList.add(word);
        }
        System.out.println(uniqueList.toString());

        HashMap <String, Integer> amountWords = new HashMap<>();


        for (String word : words) {

            if (amountWords.containsKey(word)) {

                int y = amountWords.get(word) + 1;

                amountWords.put(word, y);
            }else {
                int x = 1;
                amountWords.put(word, x);
            }
        }
        System.out.println(amountWords);

        System.out.println();

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();


        Abonent abonent = new Abonent("Петр","Иванов","89167377754");
        Abonent abonent1 = new Abonent("Иван","Иванов","89167567754");




        telephoneDirectory.add(abonent);
        telephoneDirectory.add(abonent1);

        System.out.println(telephoneDirectory.get("Иванов"));


        System.out.println(telephoneDirectory.getAllAbonents());

    }



}
