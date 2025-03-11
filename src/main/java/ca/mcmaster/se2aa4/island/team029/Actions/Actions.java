package ca.mcmaster.se2aa4.island.team029.Actions;

import org.json.JSONObject;

public class Actions {

    public static String flyForward() {
        JSONObject decision = new JSONObject();
        decision.put("action", "fly");
        return decision.toString();
    }

    public static String changeHeading(char curr, int direction) {
        int currentIndex;
        char[] headings = { 'N', 'E', 'S', 'W' };

        for (int i = 0; i < headings.length; i++) {
            if (headings[i] == curr) {
                currentIndex = i;
                break;
            }
        }

    }

}