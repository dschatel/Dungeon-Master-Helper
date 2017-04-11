package falc.dungeonmasterhelper.model.Monster.MonsterTrait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import falc.dungeonmasterhelper.model.Monster.MonsterAction.MonsterAction;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.InnateSpell;

/**
 * Created by Falcon24 on 1/22/2017.
 */

//Innate Spellcasting monster trait
public class InnateSpellcasterTrait extends MonsterTrait {

    private String spellcastingAbility;
    private int saveDC;
    private int spellAttackHit;
    private HashMap<Integer, ArrayList<String>> spells;

    public InnateSpellcasterTrait (String name, String flavorText, String spellcastingAbility, int saveDC, int spellAttackHit) {
        super(name, flavorText);
        this.spellcastingAbility = spellcastingAbility;
        this.saveDC = saveDC;
        this.spellAttackHit = spellAttackHit;
        spells = new HashMap<Integer, ArrayList<String>>();
    }

    public void addSpell(String spellName, int numPerDay) {
        ArrayList<String> arr = spells.get(numPerDay);
        if (arr == null)
            arr = new ArrayList<String>();
        arr.add(spellName);
        spells.put(numPerDay, arr);
    }

    public String getSpellcastingAbility() {
        return spellcastingAbility;
    }

    public int getSaveDC() {
        return saveDC;
    }

    public int getSpellAttackHit() {
        return spellAttackHit;
    }

    public HashMap<Integer,ArrayList<String>> getSpells() {
        return spells;
    }

    public void setSpellcastingAbility(String spellcastingAbility) {
        this.spellcastingAbility = spellcastingAbility;
    }

    public void setSaveDC(int saveDC) {
        this.saveDC = saveDC;
    }

    public void setSpellAttackHit(int spellAttackHit) {
        this.spellAttackHit = spellAttackHit;
    }

    public void removeSpell(int index1, int index2) {

        ArrayList <String> arr = spells.get(index1);
        arr.remove(index2);
    }

    public void formatDesc() {

        String description = "Innate Spellcasting. The " + getMonsterName() +"'s spellcasting ability is " + spellcastingAbility + " (spell save DC " + saveDC + ". The " + getMonsterName() + " can innately case the following spells, requiring no material components:\n";

        Iterator it = spells.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, ArrayList<String>> pair = (Map.Entry<Integer, ArrayList<String>>) it.next();
            if (pair.getKey() == 0)
                description += "At will: ";
            else
                description += pair.getKey() + "/day each: ";

            for(String s: pair.getValue()) {
                if (pair.getValue().indexOf(s) == pair.getValue().size() -1)
                    description += s;
                else
                    description += s + ", ";
            }
            if (it.hasNext())
                description += "\n ";
        }

    }

}
