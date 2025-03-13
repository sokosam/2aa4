package ca.mcmaster.se2aa4.island.team029.Actions;

import org.json.JSONObject;

public class Actions {
    private static char[] directions = { 'N', 'E', 'S', 'W' };

    private static int getDirectionIndex(char currentDir) {
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == currentDir) {
                return i;
            }
        }
        return -1;
    }

    public static JSONObject flyForward() {
        JSONObject decision = new JSONObject();
        decision.put("action", "fly");
        return decision;
    }

    public static JSONObject turnRight(char currentDir) {
        int currentIndex = -1;
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == currentDir) {
                currentIndex = i;
                break;
            }
        }
        int newIndex = (currentIndex + 1) % directions.length;

        return new JSONObject()
                .put("action", "heading")
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])));

    }

    public static JSONObject turnLeft(char currentDir) {
        int currentIndex = getDirectionIndex(currentDir);
        int newIndex = currentIndex - 1;
        if (newIndex < 0) {
            newIndex = directions.length - 1;
        }

        return new JSONObject()
                .put("action", "heading")
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])));
    }

    public static JSONObject echoLeft(char currentDir) {
        int currentIndex = getDirectionIndex(currentDir);
        int newIndex = currentIndex - 1;
        if (newIndex < 0) {
            newIndex = directions.length - 1;
        }

        return new JSONObject()
                .put("action", "echo")
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])));
    }

    public static JSONObject echoRight(char currentDir) {
        int currentIndex = getDirectionIndex(currentDir);
        int newIndex = (currentIndex + 1) % directions.length;

        return new JSONObject()
                .put("action", "echo")
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])));
    }

    public static JSONObject echoForward(char currentDir) {
        return new JSONObject()
                .put("action", "echo")
                .put("parameters", new JSONObject().put("direction", String.valueOf(currentDir)));
    }

    public static JSONObject scan() {
        return new JSONObject()
                .put("action", "scan");
    }

    public static JSONObject stop() {
        return new JSONObject()
                .put("action", "stop");
    }

}