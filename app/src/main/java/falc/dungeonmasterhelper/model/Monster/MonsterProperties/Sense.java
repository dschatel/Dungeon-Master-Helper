package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class Sense {

    private String senseName;
    private int senseRange;

    public Sense(String senseName, int senseRange) {
        this.senseName = senseName;
        this.senseRange = senseRange;
    }

    public String getSenseName() {
        return senseName;
    }

    public int getSenseRange(){
        return senseRange;
    }

    public void setSenseName(String senseName) {
        this.senseName = senseName;
    }

    public void setSenseRange(int senseRange) {
        this.senseRange = senseRange;
    }
}
