package ca.mcmaster.se2aa4.island.team029;

import java.io.StringReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;

import eu.ace_design.island.bot.IExplorerRaid;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private GridScan decisionMaker;
    private Drone drone;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n {}", info.toString(2));

        // Parse JSON object to get variables to instantiate and initialize drone
        String direction = info.getString("heading");
        int batteryLevel = info.getInt("budget");
        drone = new Drone(1, 1, batteryLevel, Direction.valueOf(direction));
        decisionMaker = new GridScan(drone);

        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);
    }

    @Override
    public String takeDecision() {
        logger.info("Current Drone x pos: {}", drone.getxCoord());
        logger.info("Current Drone y pos: {}", drone.getyCoord());
        logger.info("Current direction: {}", drone.getDirection());
        JSONObject decision = decisionMaker.makeDecision();
        logger.info("** Decision: {}", decision.toString());
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        logger.info("New Drone x pos: {}", drone.getxCoord());
        logger.info("New Drone y pos: {}", drone.getyCoord());
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Response received:\n" + response.toString(2));

        // Decrement drone's battery life
        int cost = response.getInt("cost");
        drone.drainBattery(cost);

        logger.info("The cost of the action was {}", cost);
        String status = response.getString("status");
        logger.info("The status of the drone is {}", status);
        JSONObject extraInfo = response.getJSONObject("extras");

        // Set result for decisionMaker
        decisionMaker.setResult(extraInfo);
        logger.info("prevResult = " + extraInfo.toString(2));
        logger.info("Additional information received: {}", extraInfo);
    }

    @Override
    public String deliverFinalReport() {
        return "no creek found";
    }

}
