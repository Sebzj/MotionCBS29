package MotionCBS.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    private String password;
    private char gender;
    private String email;
    private int type;
    private boolean administrator;

    public User(int id, String firstName, String lastName, int age, String username, String password, char gender, String email, int type, boolean administrator) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.type = type;
        this.administrator = administrator;
    }

    //constructor for User
    public User(int id, String firstName, String lastName, int age, String username, String password, char gender, String email, int type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.type = type;
    }


    public User() {

    }

    public User(String michael, String username, String password, char m, String email, String s) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}