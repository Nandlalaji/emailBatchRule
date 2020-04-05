package com.nand.model;

import com.nand.backend.User;

/*
 *  Sample input item which could contain many information including the user info
 *  @author Nand
 */
public class InputItem {
    private User user;

    public InputItem(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return user.toString();
    }
}
