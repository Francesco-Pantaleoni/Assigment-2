////////////////////////////////////////////////////////////////////
// FRANCESCO PANTALEONI 1193461
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class User {

    private String name;
    private String surname;
    private int age;

    public User(String nome, String cognome, int eta) {
        this.name = nome;
        this.surname = cognome;
        this.age = eta;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
} 