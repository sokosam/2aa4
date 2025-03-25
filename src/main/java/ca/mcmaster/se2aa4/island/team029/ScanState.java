package ca.mcmaster.se2aa4.island.team029;

public class ScanState {
    public enum states {
        // Move horizontally to scan the island for X1, X2 (leftmost and rightmost
        // points of the island)
        HORIZONTAL,
        // Transition into the vertical scan
        TRANSITION1,
        // Move vertically to scan the island for Y1, Y2 (topmost and bottommost points
        // of the island)
        VERTICAL,
        // Move towards Y2 (bottommost point of the island)
        UPSHIFT,
        // Move towards X2 (rightmost point of the island)
        LEFTSHIFT,
        // At this point we are at the bottom right corner of the island (X2, Y2)
        // Move towards X1 (leftmost point of the island), scanning each tile
        LEFTPASS,
        // Move towards X2 (rightmost point of the island), scanning each tile
        RIGHTPASS,
        // Left to Right 1, this is the first part of the turn to turn a left pass
        // (scan) to a right pass (scan)
        L2R1,
        // Left to Right 2, this is the second part of the turn to turn a left pass
        // (scan) to a right pass (scan)
        L2R2,
        // Right to Left 1, this is the first part of the turn to turn a right pass
        // (scan) to a left pass (scan)
        R2L1,
        // Right to Left 2, this is the second part of the turn to turn a right pass
        // (scan) to a left pass (scan)
        R2L2,
        // Due to the movement of the drone during turns, we skip a row after
        // tranisitioning from a left pass to right pass
        // We must scan all the remaining rows in the island (Below is the pattern of
        // scan)

        //
        // xxxxxx
        //
        // xxxxxx
        //
        // xxxxxx
        //

        // Scan shift prepares the drone to scan in the new pattern with this movement
        // below:

        /*
         *  x
         * x x
         * x xxxxxxxx <- final row of the left pass
         *  xx ->
         * 
         * order of moves (When starting from left pass): right -> left -> left ->
         * forward -> left -> forward
         * order of moves (When starting from right pass): left -> right -> right ->
         * forward -> right -> forward
         */
        SCANSHIFT1,
        SCANSHIFT2,
        SCANSHIFT3,
        SCANSHIFT4,
        SCANSHIFT5,
        SCANSHIFT6,
        // Similar logic to rightpass1
        RIGHTPASS2,
        // Similar logic to leftpass1
        LEFTPASS2,
        // Transition from left pass to right pass
        L2R3,
        L2R4,
        // Transition from right pass to left pass
        R2L3,
        R2L4,
        // end state, return to base
        END,
    }

    private states state;

    public ScanState() {
        // Initialize at the start state
        this.state = states.HORIZONTAL;
    }

    public states getState() {
        return this.state;
    }

    public void setState(states state) {
        this.state = state;
    }
}
