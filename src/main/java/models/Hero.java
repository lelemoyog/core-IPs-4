package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private int age;
    private String specialPower;
    private String weakness;
    private int id;

    public Hero(String name,int age,String specialPower,String weakness) {
        this.name=name;
        this.age=age;
        this.specialPower=specialPower;
        this.weakness=weakness;
        instances.add(this);
        this.id = instances.size();
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void clearAllHeroes(){
        instances.clear();}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public int getId() {
        return id;
    }

    public static Hero findById(int id) {
        return instances.get(id-1);
    }

    public void update(String name,int age,String specialPower,String weakness) {
        this.name=name;
        this.age=age;
        this.specialPower=specialPower;
        this.weakness=weakness;
    }

    public void deleteHero() {
        instances.remove(id-1);
    }
}
