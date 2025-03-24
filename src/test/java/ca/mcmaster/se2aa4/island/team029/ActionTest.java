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
        JSONObject action = Actions.flyForward(drone);
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
        JSONObject action = Actions.echoForward(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testEchoForwardsSouth() {
        drone.setDirection(Direction.S);
        JSONObject action = Actions.echoForward(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testEchoForwardsWest() {
        drone.setDirection(Direction.W);
        JSONObject action = Actions.echoForward(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

    @Test
    public void testEchoForwardsNorth() {
        drone.setDirection(Direction.N);
        JSONObject action = Actions.echoForward(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightEast() {
        JSONObject action = Actions.echoRight(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightSouth() {
        drone.setDirection(Direction.S);
        JSONObject action = Actions.echoRight(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightWest() {
        drone.setDirection(Direction.W);
        JSONObject action = Actions.echoRight(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testEchoRightNorth() {
        drone.setDirection(Direction.N);
        JSONObject action = Actions.echoRight(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftEast() {
        JSONObject action = Actions.echoLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("N", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftSouth() {
        drone.setDirection(Direction.S);
        JSONObject action = Actions.echoLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("E", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftWest() {
        drone.setDirection(Direction.W);
        JSONObject action = Actions.echoLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("S", parameters.getString("direction"));
    }

    @Test
    public void testEchoLeftNorth() {
        drone.setDirection(Direction.N);
        JSONObject action = Actions.echoLeft(drone);
        assertTrue(action.has("action"));
        assertEquals("echo", action.getString("action"));
        assertTrue(action.has("parameters"));

        JSONObject parameters = action.getJSONObject("parameters");
        assertTrue(parameters.has("direction"));
        assertEquals("W", parameters.getString("direction"));
    }

}
