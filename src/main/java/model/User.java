package model;

import java.io.Serializable;

/**
 * 用户
 */
public class User implements Cloneable, Serializable {

    private String name;
    private Address address;

    // constructors, getters and setters


    public User() {
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.setAddress(this.address.clone());
        return user;
    }

}
