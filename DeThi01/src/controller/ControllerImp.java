/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bus;
import model.Driver;
import model.Manager;
import model.Pair;

/**
 *
 * @author ADMIN
 */
public class ControllerImp implements Controller {

    @Override
    public <T> void writeToFile(List<T> list, String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readDataFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        File file = new File(fileName);
        if (file.length() > 0) {
            try {
                file.createNewFile();
                FileInputStream fos = new FileInputStream(file);
                ObjectInputStream oos = new ObjectInputStream(fos);
                Object o = oos.readObject();
                list = (List<T>) o;
                oos.close();
                fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public boolean isAccepted(List<Manager> managers, Driver driver, Pair<Bus, Integer> pair) {
        for (Manager manager : managers) {
            if (manager.getDriver().getId() == driver.getId()) {
                return (manager.getTongSoLuot() + pair.getSoLuot()) <= 15;
            }
        }
        return true;
    }

    public Manager getManager(List<Manager> managers, Driver driver) {
        for (Manager manager : managers) {
            if (manager.getDriver().getId() == driver.getId()) {
                return manager;
            }
        }
        return null;
    }

    public void addOrUpdate(List<Manager> managers, Driver driver, Pair<Bus, Integer> pair) {
        Manager m = this.getManager(managers, driver);
        if (m == null) { // chua lai luot nao
            Manager man = new Manager(driver, pair);
            managers.add(man);
        } else { // cap nhat
            // 1. tuyen xe hien thoi (pair) chua duoc lai
            // 2. da lai n luot tuyen xe trong pair
            boolean isExist = false;
            for (int i = 0; i < m.getPairs().size(); i++) {
                Pair<Bus, Integer> p = m.getPairs().get(i);
                if (p.getTuyen().getId() == pair.getTuyen().getId()) {
                    isExist = true;
                    p.setSoLuot(p.getSoLuot() + pair.getSoLuot());
                    break;
                }
            }
            if (!isExist) {
                m.getPairs().add(pair);
            }
        }
    }

    @Override
    public <T> void sortByName(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    String fullname = m1.getDriver().getName().trim();
                    String fullname2 = m2.getDriver().getName().trim();
                    String name1 = fullname.substring(fullname.lastIndexOf(" "));
                    String name2 = fullname2.substring(fullname2.lastIndexOf(" "));
                    System.out.println("ten: "+name1);
                     System.out.println("ten: "+name2);
                  //  return name1.compareTo(name2);//mac dinh la tang dan
                    return name1.compareTo(name2)>=0?-1:1;//tang dan
                }

                return 0;
            }
        });
    }

    @Override
    public <T> void sortByBuses(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Manager) {
                    Manager m1 = (Manager) o1;
                    Manager m2 = (Manager) o2;
                    return m2.getPairs().size() >= m1.getPairs().size()?1:-1;
                }//1 là thực hiện âm thì khong
                return 0;
            }
        });
    }

}
