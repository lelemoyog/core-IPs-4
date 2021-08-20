package models;

import java.util.ArrayList;
import java.util.Objects;

public class Squad {
    private static ArrayList<Squad> instances = new ArrayList<Squad>();
    private static int squadId;
    private  String SquadName;

    public Squad(int squadId, String squadName) {
        SquadName = squadName;
        instances.add(this);
        this.squadId = instances.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Squad)) return false;
        Squad squad = (Squad) o;
        return getSquadName().equals(squad.getSquadName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSquadName());
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Squad> instances) {
        Squad.instances = instances;
    }

    public static int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public String getSquadName() {
        return SquadName;
    }

    public void setSquadName(String squadName) {
        SquadName = squadName;
    }
    public static void clearAllSquads(){
        instances.clear();
    }

    public static Squad findById(int squadId) {
        return instances.get(squadId-1);
    }

    public void update(int i, String squadName) {
        this.SquadName = squadName;

    }

    public void deleteSquad() {
        instances.remove(squadId-1);
    }
}
