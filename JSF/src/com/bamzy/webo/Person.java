package com.bamzy.webo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

@ManagedBean (name = "person")
@RequestScoped
public class Person {
    String firstName;
    String lastName;
    String[] manyCheckbox;
    ArrayList<String> countryList;
    String favoriteLanguage;
    String email;

    int countryCode;
    private int age;

    public Person() {
        countryList = new ArrayList<>();
        countryList.add("IRAN");
        countryList.add("CANADA");
        countryList.add("USA");
        countryList.add("Kuwait");
        countryList.add("UAE");
        countryList.add("GERMANY");

    }

    public ArrayList<String> getCountryList() {
        return countryList;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCountryCode() {
        return this.countryCode;
    }
    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String[] getManyCheckbox() {
        return this.manyCheckbox;
    }

    public void setManyCheckbox(String manyCheckbox[]) {
        this.manyCheckbox = manyCheckbox;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
