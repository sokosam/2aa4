package ca.mcmaster.se2aa4.island.team029;

import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;;

public class DecisionTest {

    private DecisionMaker decisionMaker;
    private Drone drone;

    @BeforeEach
    public void initializeDecisionMaker() {
        drone = new Drone(1, 1, 7000, Direction.E);
        decisionMaker = new DecisionMaker(drone);
    }

    @Test
    public void testMakeDecision() {
        JSONObject decision = decisionMaker.makeDecision();
        assertEquals(decision.getString("action"), "scan");
        decision = decisionMaker.makeDecision();
        assertEquals(decision.getString("action"), "heading");
        decision = decisionMaker.makeDecision();
        assertEquals(decision.getString("action"), "heading");
    }
}
