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

    public static String flyForward() {
        JSONObject decision = new JSONObject();
        decision.put("action", "fly");
        return decision.toString();
    }

    public static String turnRight(char currentDir) {
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
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])))
                .toString();

    }

    public static String turnLeft(char currentDir) {
        int currentIndex = getDirectionIndex(currentDir);
        int newIndex = currentIndex - 1;
        if (newIndex < 0) {
            newIndex = directions.length - 1;
        }

        return new JSONObject()
                .put("action", "heading")
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])))
                .toString();
    }

    public static String echoLeft(char currentDir) {
        int currentIndex = getDirectionIndex(currentDir);
        int newIndex = currentIndex - 1;
        if (newIndex < 0) {
            newIndex = directions.length - 1;
        }

        return new JSONObject()
                .put("action", "echo")
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])))
                .toString();
    }

    public static String echoRight(char currentDir) {
        int currentIndex = getDirectionIndex(currentDir);
        int newIndex = (currentIndex + 1) % directions.length;

        return new JSONObject()
                .put("action", "echo")
                .put("parameters", new JSONObject().put("direction", String.valueOf(directions[newIndex])))
                .toString();
    }

    public static String echoForward(char currentDir) {
        return new JSONObject()
                .put("action", "echo")
                .put("parameters", new JSONObject().put("direction", String.valueOf(currentDir)))
                .toString();
    }

    public static String scan() {
        return new JSONObject()
                .put("action", "scan")
                .toString();
    }

    public static String stop() {
        return new JSONObject()
                .put("action", "stop")
                .toString();
    }

}