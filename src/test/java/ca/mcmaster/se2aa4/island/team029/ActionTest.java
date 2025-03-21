package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionTest {

    private Drone drone;

    @BeforeEach
    public void initializeDrone() {
        drone = new Drone(1, 1, 7000, Direction.E);
    }

    @Test
    public void testFlyForwards() {
        JSONObject action = Actions.flyForward();
        assertTrue(action.has("action"));
        assertEquals("fly", action.getString("action"));
    }

    @Test
    public void testScan() {
        JSONObject action = Actions.scan();
        assertTrue(action.has("action"));
        assertEquals("scan", action.getString("action"));
    }

    @Test
    public void testStop() {
        JSONObject action = Actions.stop();
        assertTrue(action.has("action"));
        assertEquals("stop", action.getString("action"));
    }

    @Test
    public void testTurnRightEast() {
        JSONObject action = Actions.turnRight(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testTurnRightSouth() {
        drone.setDirection(Direction.S);
        JSONObject action = Actions.turnRight(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

    @Test
    public void testTurnRightWest() {
        drone.setDirection(Direction.W);
        JSONObject action = Actions.turnRight(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testTurnRightNorth() {
        drone.setDirection(Direction.N);
        JSONObject action = Actions.turnRight(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testTurnLeftEast() {
        JSONObject action = Actions.turnLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testTurnLeftSouth() {
        drone.setDirection(Direction.S);
        JSONObject action = Actions.turnLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testTurnLeftWest() {
        drone.setDirection(Direction.W);
        JSONObject action = Actions.turnLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testTurnLeftNorth() {
        drone.setDirection(Direction.N);
        JSONObject action = Actions.turnLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("heading", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

    @Test
    public void testEchoForwardsEast() {
        JSONObject action = Actions.echoForward('E');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testEchoForwardsSouth() {
        JSONObject action = Actions.echoForward('S');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testEchoForwardsWest() {
        JSONObject action = Actions.echoForward('W');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

    @Test
    public void testEchoForwardsNorth() {
        JSONObject action = Actions.echoForward('N');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightEast() {
        JSONObject action = Actions.echoRight('E');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightSouth() {
        JSONObject action = Actions.echoRight('S');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightWest() {
        JSONObject action = Actions.echoRight('W');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightNorth() {
        JSONObject action = Actions.echoRight('N');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftEast() {
        JSONObject action = Actions.echoLeft('E');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftSouth() {
        JSONObject action = Actions.echoLeft('S');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftWest() {
        JSONObject action = Actions.echoLeft('W');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftNorth() {
        JSONObject action = Actions.echoLeft('N');
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

}
