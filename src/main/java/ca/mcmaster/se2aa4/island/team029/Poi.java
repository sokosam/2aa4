package ca.mcmaster.se2aa4.island.team029;

public abstract class Poi {
    private String id;
    private int x;
    private int y;

    public Poi(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return this.id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
