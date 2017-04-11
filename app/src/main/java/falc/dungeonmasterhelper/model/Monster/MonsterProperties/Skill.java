package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class Skill {

    private String skillName;
    private int skillBonus;

    public Skill(String skillName, int skillBonus) {
        this.skillBonus = skillBonus;
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getSkillBonus() {
        return skillBonus;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setSkillBonus(int skillBonus) {
        this.skillBonus = skillBonus;
    }

}
