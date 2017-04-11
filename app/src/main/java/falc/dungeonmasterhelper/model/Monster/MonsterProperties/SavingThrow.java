package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class SavingThrow {

    private String save;
    private int bonus;

    public SavingThrow(String save, int bonus) {
        this.save = save;
        this.bonus = bonus;
    }

    public String getSave() {
        return save;
    }

    public int getBonus() {
        return bonus;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
