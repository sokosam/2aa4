package ca.mcmaster.se2aa4.island.team029;

public class ScanState {
    public enum states {
        HORIZONTAL,
        TRANSITION1,
        VERTICAL,
        UPSHIFT,
        LEFTSHIFT,
        RIGHTPASS,
        LEFTPASS,

        END,
    }

    private states state;

    public ScanState() {
        this.state = states.HORIZONTAL;
    }

    public states getState() {
        return this.state;
    }

    public void setState(states state) {
        this.state = state;
    }
}
