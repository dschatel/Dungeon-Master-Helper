package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class MovementType {

    private String movementName;
    private int movementAmount;

    public MovementType(String movementName, int movementAmount) {
        this.movementAmount = movementAmount;
        this.movementName = movementName;
    }

    public String getMovementName() {
        return movementName;
    }

    public int getMovementAmount() {
        return movementAmount;
    }

    public void setMovementName(String movementName){
        this.movementName = movementName;
    }

    public void setMovementAmount(int movementAmount) {
        this.movementAmount = movementAmount;
    }

}
