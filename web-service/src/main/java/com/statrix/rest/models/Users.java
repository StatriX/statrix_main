package com.statrix.rest.models;

public class Users {
    private long id;
    private String name;
    private String email;
    private String password;
    private Long inviterId = null;
    private Subscriptions subscription = new Subscriptions();// по-умолчанию FREE

    //--------------USER constructors-----------

    // новый пользователь с приглашением, подписка выставляется системой
    public Users(String name, String email, String password, long inviterId ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.inviterId = inviterId;
        //TODO: после создания такого пользователя, который указал inviterId, нужно выставить ему подписку его админа
    }

    // Конструктор для PUT запроса
    // TODO: переделать PUT так чтобы не создавать нового пользователя с повтором параметров, а из старого делать нового с измененными
    public Users(long id, String name, String email, String password, long inviterId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.inviterId = inviterId;
    }

    //--------------ADMIN constructors-----------

    // новый пользователь, без приглашения, с подпиской FREE
    // по-умолчанию это админ, если потом выставит приглашение, то пользователь
    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    // Конструктор для PUT запроса
    public Users(long id, String name, String email,  String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    // новый пользователь админ, с подпиской отличной от FREE
    public Users(String name, String email, String password, Subscriptions subscription ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscription = subscription;
    }
    // Конструктор для PUT запроса
    public Users(long id, String name, String email, String password, Subscriptions subscription ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscription = subscription;
    }

    //--------------SYSTEM constructors-----------
    // конструкторы для отладки, где вручную задаем все параметры

    // пустой конструтор - обязательно! иначе спринг не может передавать такие объекты
    public Users(){
    }

    public Users(long id, String name, String email, String password, long inviterId, Subscriptions subscription) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.inviterId = inviterId;
        this.subscription = subscription;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getInviterId() {
        return inviterId;
    }

    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    public Subscriptions getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscriptions subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "User [id = " + this.id + ", name = " + this.name + ", email = " + this.email + ", password = " + this.password + ", inviter_id = " + this.inviterId +"]";
    }
}
