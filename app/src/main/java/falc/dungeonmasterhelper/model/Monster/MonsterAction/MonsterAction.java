package falc.dungeonmasterhelper.model.Monster.MonsterAction;

import java.util.List;
import java.util.ArrayList;

import falc.dungeonmasterhelper.model.MiscData.Damage;
import falc.dungeonmasterhelper.model.Monster.Monster;

/**
 * Created by Falcon24 on 1/15/2017.
 */

//Superclass for monster actions
public class MonsterAction extends Monster{

    //Boolean checks that determine formatting of action description
    private boolean requiresAttackRoll;
    private boolean doesDamage;
    private boolean requiresSavingThrow;
    private boolean hasRecharge;
    private boolean rechargeOnShortRest;
    private boolean rechargeOnLongRest;
    private boolean hasSingleRange;
    private boolean hasPerDayLimit;

    //Action data common to all actions
    private String actionName;
    private int reach;
    private int targets;
    private String flavorText;

    //Data for weapon attacks
    private String weapAttackType;
    private int toHit;

    //List of damage rolls for the action
    List<Damage> damage;

    //Saving throw data if requiresSavingThrow is true
    private int saveDC;
    private String saveAbility;
    private String onSuccess;
    private String onFailure;

    //Recharge data if hasRecharge is true
    private int[] rechargeRange;

    //perDay data if hasPerDayLimit is true
    private int perDay;

    //Final action description
    private String actionDesc;

    public MonsterAction(String actionName) {
        this.actionName = actionName;
        this.damage = new ArrayList<Damage>();
    }

    public void setRequiresAttackRoll(boolean requiresAttackRoll) {
        this.requiresAttackRoll = requiresAttackRoll;
    }

    public boolean getRequiresAttackRoll() {
        return requiresAttackRoll;
    }

    public void setDoesDamage(boolean doesDamage) {
        this.doesDamage = doesDamage;
    }

    public boolean getDoesDamage() {
        return doesDamage;
    }

    public void setRequiresSavingThrow(boolean requiresSavingThrow) {
        this.requiresSavingThrow = requiresSavingThrow;
    }

    public boolean getRequiresSavingThrow() {
        return requiresSavingThrow;
    }

    public void setHasRecharge(boolean hasRecharge) {
        this.hasRecharge = hasRecharge;
    }

    public boolean getHasRecharge() {
        return hasRecharge;
    }

    public void setHasSingleRange(boolean hasSingleRange) {
        this.hasSingleRange = hasSingleRange;
    }

    public boolean getHasSingleRange() {
        return hasSingleRange;
    }

    public void setRechargeOnShortRest(boolean rechargeOnShortRest) {
        this.rechargeOnShortRest = rechargeOnShortRest;
    }

    public boolean getRechargeOnShortRest() {
        return rechargeOnShortRest;
    }

    public void setRechargeOnLongRest(boolean rechargeOnLongRest) {
        this.rechargeOnLongRest = rechargeOnLongRest;
    }

    public boolean getRechargeOnLongRest() {
        return rechargeOnLongRest;
    }

    public void setHasPerDayLimit(boolean hasPerDayLimit) {
        this.hasPerDayLimit = hasPerDayLimit;
    }

    public boolean getHasPerDayLimit() {
        return hasPerDayLimit;
    }

    public void formatSavingThrow(int saveDC, String onSuccess, String onFailure, String saveAbility) {
        this.saveDC = saveDC;
        this.saveAbility = saveAbility;
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
    }

    public int getToHit() {
        return toHit;
    }

    public void setToHit(int toHit) {
        this.toHit = toHit;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getSaveDC() {
        return saveDC;
    }

    public void setSaveDC(int saveDC) {
        this.saveDC = saveDC;
    }

    public String getSaveAbility() {
        return saveAbility;
    }

    public void setSaveAbility(String saveAbility) {
        this.saveAbility = saveAbility;
    }

    public void setOnSuccess(String onSuccess) {
        this.onSuccess = onSuccess;
    }

    public String getOnSuccess() {
        return onSuccess;
    }

    public void setOnFailure(String onFailure) {
        this.onFailure = onFailure;
    }

    public String getOnFailure() {
        return onFailure;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public int getRechargeRangeStart() {
        return rechargeRange[0];
    }

    public void setRechargeRange(int rangeStart, int rangeEnd) {
        if (rechargeRange == null)
            rechargeRange = new int[2];
        rechargeRange[0] = rangeStart;
        rechargeRange[1] = rangeEnd;
    }

    public int getRechargeRangeEnd() {
        return rechargeRange[1];
    }

    public int getPerDay() {
        return perDay;
    }

    public void addToDamageList(Damage dmg) {
        damage.add(dmg);
    }

    public ArrayList<Damage> getDamageList() {
        return (ArrayList) damage;
    }

    public void removeFromDamageList(int index) {
        damage.remove(index);
    }

    public void setPerDay(int perDay) {
        this.perDay = perDay;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public void formatActionDesc() {

        //Actions always have a name
        actionDesc = actionName;

        //If action recharges based on some criteria
        if(hasRecharge) {

            if(rechargeOnShortRest && rechargeOnLongRest)
                actionDesc += "(Recharge on short or long rest)";
            else if (rechargeOnShortRest)
                actionDesc += "(Recharge on short rest)";
            else if (rechargeOnLongRest)
                actionDesc += ("Recharge on long rest)");
            else if(hasSingleRange)
                actionDesc += " (Recharge " + rechargeRange[0] + ")";
            else
                actionDesc += " (Recharge " + rechargeRange[0] + "-" + rechargeRange[1] + ")";
        }


        //If action can only be used a certain number of times per day
        if(hasPerDayLimit)
            actionDesc += " (" + perDay + "/Day)";

        //End of name formatting
        actionDesc+=". ";

        //Body of action text

        if (requiresAttackRoll) {
            actionDesc += weapAttackType + "Weapon Attack: +" + toHit + "to hit, reach" + reach + " ft., " + targets + ". Hit: ";
            for (Damage d: damage) {
                actionDesc += d.formatDamage();
                if (damage.indexOf(d) != damage.size() -1)
                    actionDesc += " plus ";
            }
            if (requiresSavingThrow) {
                actionDesc += ", and the target must succeed on a DC " + saveDC + " " + saveAbility + " saving throw. On failure: " + onFailure + "; On Success: " + onSuccess;
            }

            actionDesc += flavorText;

        }
        else {
            actionDesc += flavorText + "Targets: " + targets + ". ";
            if (requiresSavingThrow) {
                actionDesc += "Each affected target must make a DC " + saveDC + " " + saveAbility + "saving throw. On failure: ";
                if (doesDamage) {
                    actionDesc += "Targets take ";
                    for (Damage d: damage) {
                        actionDesc += d.formatDamage();
                        if (damage.indexOf(d) != damage.size() -1)
                            actionDesc += " plus ";
                    }
                }
                else
                    actionDesc += onFailure;
                actionDesc += "; On Success: " + onSuccess;
            }

        }

    }

    public void setTargets (int targets) {
        this.targets = targets;
    }

    public int getTargets () {
        return targets;
    }

    public void setWeapAttackType (String weapAttackType) {
        this.weapAttackType = weapAttackType;
    }

    public String getWeapAttackType () {
        return weapAttackType;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getFlavorText() {
        return flavorText;
    }


}
