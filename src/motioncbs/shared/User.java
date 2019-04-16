package motioncbs.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    private String password;
    private char gender;
    private int medlemstype;


    //default constructor
    public User() {

    }

    //constructor for User
    public User(int id, String firstName, String lastName, int age, String username, String password, char gender, int medlemstype) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.medlemstype = medlemstype;
    }

    // getters og saetters for users attributter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getMedlemstype() {
        return medlemstype;
    }

    public void setMedlemstype(int medlemstype) {
        this.medlemstype = medlemstype;
    }
}