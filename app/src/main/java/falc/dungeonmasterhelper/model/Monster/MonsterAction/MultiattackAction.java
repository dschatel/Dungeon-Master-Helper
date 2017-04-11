package falc.dungeonmasterhelper.model.Monster.MonsterAction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import falc.dungeonmasterhelper.model.MiscData.Damage;

/**
 * Created by Falcon24 on 1/22/2017.
 */

//Monster possesses a multiattack -- used for calculating challenge rating
public class MultiattackAction extends MonsterAction {

    private int numAttacks;
    private HashMap<MonsterAction, Integer> attacks;

    public MultiattackAction(String name, int numAttacks) {

        //Before construction, include a check for whether the attack does damage. If it doesn't, prevent multiattack
        super(name);
        this.numAttacks = numAttacks;
        attacks = new HashMap<MonsterAction, Integer>();
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public void addAttack(MonsterAction attackAction, int attackNum) {

            attacks.put(attackAction, attackNum);
    }

    public void deleteAttack(int index) {
        attacks.remove(index);
    }

    //Used to determine challenge rating
    public int getDamage() {
        int sum = 0;

        for(Map.Entry<MonsterAction, Integer> e: attacks.entrySet()) {
            for(int i = 0; i < e.getValue(); i++) {
                for(Damage d: e.getKey().getDamageList())
                    sum+= d.getAvgDmg();
            }
        }

        return sum;
    }

    public void formatActionDesc() {
        String description = "Multiattack. The " + getMonsterName() + "makes " + numAttacks + " attacks: ";

        Iterator it = attacks.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<MonsterAction, Integer> pair = (Map.Entry<MonsterAction, Integer>) it.next();
            description += pair.getValue() + "with its " + pair.getKey().getActionName();
            if (it.hasNext())
                description += ", ";
            else
                description += ".";
        }

        setActionDesc(description);
    }


}
