/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Manager implements Serializable {
    private Driver driver;
    private int tongSoLuot;
    private List<Pair<Bus, Integer>> pairs;

    public Manager() {
        pairs = new ArrayList<>();
        tongSoLuot = 0;
    }

    public Manager(Driver driver, Pair pair) {
        this();
        this.driver = driver;
        this.tongSoLuot = tongSoLuot;
        this.pairs.add(pair);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getTongSoLuot() {
        this.tongSoLuot = 0;
        for (Pair<Bus, Integer> pair : pairs) {
            this.tongSoLuot += pair.getSoLuot();
        }
        return tongSoLuot;
    }

    public void setTongSoLuot(int tongSoLuot) {
        this.tongSoLuot = tongSoLuot;
    }

    public List<Pair<Bus, Integer>> getPairs() {
        return pairs;
    }

    public void setPairs(Pair pair) {
        this.pairs.add(pair);
    }
}
