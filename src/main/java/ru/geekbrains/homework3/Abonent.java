package ru.geekbrains.homework3;

public class Abonent {

    private String Name;
    private String surname;
    private String telephoneNumber;

    public Abonent(String name, String surname, String telephoneNumber) {
        Name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public String toString() {
        return "Abonent{" +
                "Name='" + Name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
