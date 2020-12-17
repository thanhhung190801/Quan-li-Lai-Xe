/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Bus implements Serializable {

    private int id;
    private float distance;
    private int station;
    private static int sId = 1000000;

    public Bus() {
        this.id = sId++;
    }

    public Bus(float distance, int station) {
        this.id = sId++;
        this.distance = distance;
        this.station = station;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public static int getsId() {
        return sId;
    }

    public static void setsId(int sId) {
        Bus.sId = sId;
    }

}
