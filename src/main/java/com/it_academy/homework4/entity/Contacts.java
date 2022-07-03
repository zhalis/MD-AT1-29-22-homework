package com.it_academy.homework4.entity;

import java.util.Objects;

public class Contacts {

    private String address;
    private String tel;
    private String email;
    private String url;

    public Contacts() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ("\n      address - %s\n      tel - %s" +
                "\n      email - %s\n      url - %s")
                .formatted(address, tel, email, url);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return Objects.equals(address, contacts.address)
                && Objects.equals(tel, contacts.tel)
                && Objects.equals(email, contacts.email)
                && Objects.equals(url, contacts.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, tel, email, url);
    }
}
