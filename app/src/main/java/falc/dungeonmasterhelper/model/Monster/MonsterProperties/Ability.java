package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class Ability {

    private String abilityName;
    private int abilityScore;

    public Ability(String abilityName, int abilityScore) {
        this.abilityName = abilityName;
        this.abilityScore = abilityScore;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public int getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public void setAbilityScore(int abilityScore) {
        this.abilityScore = abilityScore;
    }

}
