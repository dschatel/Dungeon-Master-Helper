package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class InnateSpell {

    private String spellName; //Change this to Spell class once implemented
    private int numPerDay;

    public InnateSpell(String spellName, int numPerDay) {
        this.spellName = spellName;
        this.numPerDay = numPerDay;
    }

    public String getSpellName() {
        return spellName;
    }

    public int getNumPerDay() {
        return numPerDay;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public void setNumPerDay(int numPerDay) {
        this.numPerDay = numPerDay;
    }
}
