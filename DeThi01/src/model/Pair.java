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
public class Pair<K, V> implements Serializable {
    private K tuyen;
    private V soLuot;

    public Pair() {
    }

    public Pair(K tuyen, V soLuot) {
        this.tuyen = tuyen;
        this.soLuot = soLuot;
    }

    public K getTuyen() {
        return tuyen;
    }

    public void setTuyen(K tuyen) {
        this.tuyen = tuyen;
    }

    public V getSoLuot() {
        return soLuot;
    }

    public void setSoLuot(V soLuot) {
        this.soLuot = soLuot;
    }
    
}
