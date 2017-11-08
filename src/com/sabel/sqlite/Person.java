package com.sabel.sqlite;

public class Person {

    private static int letzteID = 0;
    private int id;
    private int jahrgang;
    private String nachname;

    private Person() {
        super();
        this.id = ++letzteID;
    }

    public Person(int jahrgang, String nachname) {
        this();
        this.jahrgang = jahrgang;
        this.nachname = nachname;
    }

    public int getJahrgang() {
        return jahrgang;
    }

    public String getNachname() {
        return nachname;
    }

    public int getId() {
        return id;
    }

    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (jahrgang != person.jahrgang) return false;
        return nachname != null ? nachname.equals(person.nachname) : person.nachname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + jahrgang;
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person: " + this.id + ", Name: " + this.nachname + ", Jahrgang: " + this.jahrgang;
    }
}
