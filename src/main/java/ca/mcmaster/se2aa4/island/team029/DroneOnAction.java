package ca.mcmaster.se2aa4.island.team029;

public class DroneOnAction {

    public static void onTurnRight(Drone drone) {
        // Example variable for switch
        Direction heading = drone.getDirection();

        // Switch should be fine here since it is illogical to extend switch cases for
        // more directions

        switch (heading) {
            case N:
                drone.updateY(-1);
                drone.updateX(1);
                drone.setDirection(Direction.E);
                break;
            case E:
                drone.updateY(1);
                drone.updateX(1);
                drone.setDirection(Direction.S);
                break;
            case S:
                drone.updateY(1);
                drone.updateX(-1);
                drone.setDirection(Direction.W);
                break;
            case W:
                drone.updateY(-1);
                drone.updateX(-1);
                drone.setDirection(Direction.N);
                break;
            default:
                // ...default logic...
                break;
        }
    }

    public static void onTurnLeft(Drone drone) {
        Direction heading = drone.getDirection();
        switch (heading) {
            case N:
                drone.updateY(-1);
                drone.updateX(-1);
                drone.setDirection(Direction.W);
                break;
            case E:
                drone.updateY(-1);
                drone.updateX(1);
                drone.setDirection(Direction.N);
                break;
            case S:
                drone.updateY(1);
                drone.updateX(1);
                drone.setDirection(Direction.E);
                break;
            case W:
                drone.updateY(1);
                drone.updateX(-1);
                drone.setDirection(Direction.S);
                break;
            default:
                // ...default logic...
                break;
        }
    }

    public static void onFlyForward(Drone drone) {
        Direction heading = drone.getDirection();
        switch (heading) {
            case N:
                drone.updateY(-1);
                break;
            case E:
                drone.updateX(1);
                break;
            case S:
                drone.updateY(+1);
                break;
            case W:
                drone.updateX(-1);
                break;
            default:
                // ...default logic...
                break;
        }
    }

}
