package ru.geekbrains.homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;

public class TelephoneDirectory {
    //        Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
//        телефонных номеров. В этот телефонный справочник с помощью метода add() можно
//        добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
//
//
//        Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//                тогда при запросе такой фамилии должны выводиться все телефоны.
//
//                Желательно не добавлять
//        лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
//        через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
//        справочника.


    private HashMap <String, List<Abonent>> telephoneMap = new HashMap<>();

    public void add(Abonent abonent) {

        if (telephoneMap.containsKey(abonent.getSurname())) {
            telephoneMap.get(abonent.getSurname()).add( abonent);

        } else {
            List<Abonent> abonents = new ArrayList<>();
            abonents.add (abonent);
            telephoneMap.put(abonent.getSurname(), abonents);
        }
    }

    public List<Abonent> get (String surname) {
        return telephoneMap.get(surname);
    }

    public HashMap<String,List<Abonent>> getAllAbonents(){
        return this.telephoneMap;
    }
}
