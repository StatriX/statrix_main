package com.statrix.rest.models;

import java.util.Date;

public class Subscriptions {

    // TODO: переделать в enum
    public static final int FREE = 1;
    public static final int BASIC = 2;
    public static final int PREMIUM = 3;

    private int id;
    private int chargingType;
    private Date startDate;
    private Date endDate;

    public Subscriptions() {
        this.chargingType = FREE;
        this.startDate = new Date();
        this.endDate = null;
    }
    public Subscriptions(int chargingType) {
        this.chargingType = chargingType;
        this.startDate = new Date();
        this.endDate = endDate;// будет рассчитываться исходя из тиа подписки?
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChargingType() {
        return chargingType;
    }

    public void setChargingType(int chargingType) {
        this.chargingType = chargingType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
