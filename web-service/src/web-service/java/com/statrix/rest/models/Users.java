package com.statrix.rest.models;

public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    private Integer inviterId = null;
    private Subscriptions subscription;

    // новый пользователь, без приглашения, с подпиской FREE
    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscription = new Subscriptions();
    }
    // новый пользователь с приглашением, подписка выставляется системой
    public Users(String name, String email, String password, Integer inviterId ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.inviterId = inviterId;
    }

    // новый пользователь админ, с подпиской отличной от FREE
    public Users(String name, String email, String password, Subscriptions subscription ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }

    public Subscriptions getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscriptions subscription) {
        this.subscription = subscription;
    }
}
