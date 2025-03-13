package ca.mcmaster.se2aa4.island.team029;

public class Drone {

    private int xCoord;
    private int yCoord;
    private int batteryLevel;
    private char direction;

    // Drone constructor

    public Drone(int xCoord, int yCoord, int batteryLevel, char direction){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.batteryLevel = batteryLevel;
        this.direction = direction;
    }

    // Getter methods

    public int getBatteryLevel(){
        return this.batteryLevel;
    }

    public int getxCoord(){
        return this.xCoord;
    }

    public int getyCoord(){
        return this.yCoord;
    }

    public char getDirection(){
        return this.direction;
    }

    // Method to drain drone battery

    public void drainBattery(int cost){
        this.batteryLevel -= cost;
    }

    // Method to update coordinates

    public void updateX(int steps){
        this.xCoord += steps;
    }

    public void updateY(int steps){
        this.yCoord += steps;
    }

    // Method to set heading

    public void setDirection(char direction) {
        this.direction = direction;
    }

}
