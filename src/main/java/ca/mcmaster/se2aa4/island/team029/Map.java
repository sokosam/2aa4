package ca.mcmaster.se2aa4.island.team029;

import java.util.ArrayList;
import ca.mcmaster.se2aa4.island.team029.Creek;
import ca.mcmaster.se2aa4.island.team029.EmergencySite;

public class Map {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private ArrayList<Creek> creeks;
    private ArrayList<EmergencySite> emergencySites;

    public Map() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
        this.creeks = new ArrayList<Creek>();
        this.emergencySites = new ArrayList<EmergencySite>();
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void addCreek(String id, int x, int y) {
        Creek creek = new Creek(id, x, y);
        this.creeks.add(creek);
    }

    public void addEmergencySite(String id, int x, int y) {
        EmergencySite emergencySite = new EmergencySite(id, x, y);
        this.emergencySites.add(emergencySite);
    }

    public int getX1() {
        return this.x1;
    }

    public int getY1() {
        return this.y1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }

    public ArrayList<Creek> getCreeks() {
        return this.creeks;
    }

    public ArrayList<EmergencySite> getEmergencySites() {
        return this.emergencySites;
    }

}
