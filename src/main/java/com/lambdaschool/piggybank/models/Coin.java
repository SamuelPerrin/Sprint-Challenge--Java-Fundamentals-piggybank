package com.lambdaschool.piggybank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coinid;

    private int number;
    private double value;
    private String singname;
    private String pluralname;

    // constructors
    public Coin() {
    }

    public Coin(int number, double value, String singname, String pluralname) {
        this.number = number;
        this.value = value;
        this.singname = singname;
        this.pluralname = pluralname;
    }

    // getters and setters
    public int getCoinid() {
        return (int) coinid;
    }

    public void setCoinid(int coinid) {
        this.coinid = coinid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSingname() {
        return singname;
    }

    public void setSingname(String singname) {
        this.singname = singname;
    }

    public String getPluralname() {
        return pluralname;
    }

    public void setPluralname(String pluralname) {
        this.pluralname = pluralname;
    }

    // toString

    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", number=" + number +
                ", value=" + value +
                ", singname='" + singname + '\'' +
                ", pluralname='" + pluralname + '\'' +
                '}';
    }
}
