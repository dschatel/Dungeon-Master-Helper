package falc.dungeonmasterhelper.model.Monster;

import java.util.List;

import falc.dungeonmasterhelper.model.Monster.MonsterAction.*;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.*;
import falc.dungeonmasterhelper.model.Monster.MonsterTrait.*;

/**
 * Created by Falcon24 on 1/15/2017.
 */

public class Monster {

    private String name;
    private String type;
    private char size;
    private String alignment;
    private int hitPoints;
    private int armorClass;
    private List <MovementType> speed;
    private List <Ability> abilityScores;
    private List <SavingThrow> savingThrows;
    private List <Skill> skills;
    private List<String> resistances;
    private List<String> immunities;
    private List <Sense> senses;
    private List<String> languages;
    private List<MonsterTrait> monsterTraits;
    private List<MonsterAction> monsterActions;
    private boolean isLegendary;
    private boolean isSpellcaster;
    private int challengeRating;
    private int experience;
    private boolean hasLair;

    public String getMonsterName() {
        return name;
    }

    public void setMonsterName(String name) {
        this.name = name;
    }


}
