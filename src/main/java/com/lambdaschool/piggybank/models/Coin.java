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

    private int quantity;
    private double value;
    private String name;
    private String nameplural;

    // constructors
    public Coin() {
    }

    public Coin(int quantity, double value, String name, String nameplural) {
        this.quantity = quantity;
        this.value = value;
        this.name = name;
        this.nameplural = nameplural;
    }

    // getters and setters
    public int getCoinid() {
        return (int) coinid;
    }

    public void setCoinid(int coinid) {
        this.coinid = coinid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameplural() {
        return nameplural;
    }

    public void setNameplural(String nameplural) {
        this.nameplural = nameplural;
    }

    // toString

    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", quantity=" + quantity +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", nameplural='" + nameplural + '\'' +
                '}';
    }
}
