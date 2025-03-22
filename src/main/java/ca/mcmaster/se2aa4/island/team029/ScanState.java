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
        L2R1,
        L2R2,
        R2L1,
        R2L2,
        SCANSHIFT1,
        SCANSHIFT2,
        SCANSHIFT3,
        SCANSHIFT4,
        SCANSHIFT5,
        SCANSHIFT6,
        RIGHTPASS2,
        LEFTPASS2,
        L2R3,
        L2R4,
        R2L3,
        R2L4,
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
