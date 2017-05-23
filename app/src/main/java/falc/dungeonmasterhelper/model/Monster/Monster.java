package falc.dungeonmasterhelper.model.Monster;

import java.util.ArrayList;
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
    private String size;
    private String alignment;
    private int numHitDice;
    private int hitDiceType;
    private int extraHP;
    private int armorClass;
    private List <MovementType> speed;
    private List <Ability> abilityScores;
    private List <SavingThrow> savingThrows;
    private List <Skill> skills;
    private List<String> damresistances;
    private List<String> damimmunities;
    private List<String> condimmunities;
    private List <Sense> senses;
    private List<String> languages;
    private List<MonsterTrait> monsterTraits;
    private List<MonsterAction> monsterActions;
    //Add List of Legendary Actions
    private boolean isLegendary;
   // private boolean isSpellcaster; // Fold this into Traits
    private int challengeRating;
    private int experience;
    private boolean hasLair;

    public Monster (String name) {
        this.name = name;
    }

    public String getMonsterName() {
        return name;
    }

    public void setMonsterName(String name) {
        this.name = name;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize (String size) {
        this.size = size;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getNumHitDice () {
        return numHitDice;
    }

    public void setNumHitDice(int hitDice) {
        this.numHitDice = hitDice;
    }

    public int getHitDiceType() {
        return hitDiceType;
    }

    public void setHitDiceType(int hitDiceType) {
        this.hitDiceType = hitDiceType;
    }

    public int getExtraHP() {
        return extraHP;
    }

    public void setExtraHP (int extraHP) {
        this.extraHP = extraHP;
    }

    public int getAvgHitPoints () {

        double mean = (hitDiceType / 2) + 0.5;

        return (int) ((numHitDice * mean) + extraHP);
    }

    public String formatHitPoints() {
        return getAvgHitPoints() + "(" + numHitDice + "d" + hitDiceType + " + " + extraHP + ")";
    }

    public int getArmorClass () {
        return armorClass;
    }

    public void setArmorClass (int armorClass) {
        this.armorClass = armorClass;
    }

    public void addMovementType(MovementType movement) {
        if (speed == null)
            speed = new ArrayList<MovementType>();
        speed.add(movement);
    }

    public void removeMovementType(int index) {
        speed.remove(index);
    }

    public void addAbility(Ability ability) {
        if (abilityScores == null)
            abilityScores = new ArrayList<Ability>();
        abilityScores.add(ability);
    }

    public void removeAbility(int index) {
        abilityScores.remove(index);
    }

    public void addSavingThrow(SavingThrow savingThrow) {
        if (savingThrows == null)
            savingThrows = new ArrayList<SavingThrow>();
        savingThrows.add(savingThrow);
    }

    public void removeSavingThrow(int index) {
        savingThrows.remove(index);
    }

    public void addSkill(Skill skill) {
        if (skills == null)
            skills = new ArrayList<Skill>();
        skills.add(skill);
    }

    public void removeSkill(int index) {
        skills.remove(index);
    }


    public void addDamResistance(String resistance) {
        if (damresistances == null)
            damresistances = new ArrayList<String>();
        damresistances.add(resistance);
    }

    public void removeDamResistance(int index) {
        damresistances.remove(index);
    }

    public void addDamImmunity(String immunity) {
        if (damimmunities == null)
            damimmunities = new ArrayList<String>();
        damimmunities.add(immunity);
    }

    public void removeDamImmunity(int index) {
        damimmunities.remove(index);
    }

    public void addCondImmunity(String immunity) {
        if (condimmunities == null)
            condimmunities = new ArrayList<String>();
        condimmunities.add(immunity);
    }

    public void removeCondImmunity(int index) {
        condimmunities.remove(index);
    }

    public void addSense(Sense sense) {
        if (senses == null)
            senses = new ArrayList<Sense>();
        senses.add(sense);
    }

    public void removeSense(int index) {
        senses.remove(index);
    }


    public void addLanguage(String language) {
        if (languages == null)
            languages = new ArrayList<String>();
        languages.add(language);
    }

    public void removeLanguage(int index) {
        languages.remove(index);
    }

    public void addMonsterTrait(MonsterTrait trait) {
        if (monsterTraits == null)
            monsterTraits = new ArrayList<MonsterTrait>();
        monsterTraits.add(trait);
    }

    public void removeMonsterTrait(int index) {
        monsterTraits.remove(index);
    }

    public void addMonsterAction(MonsterAction action) {
        if (monsterActions == null)
            monsterActions = new ArrayList<MonsterAction>();
        monsterActions.add(action);
    }

    public void removeMonsterAction(int index) {
        monsterActions.remove(index);
    }

    public boolean getIsLegendary() {
        return isLegendary;
    }

    public void setIsLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    public int getChallengeRating () {
        return challengeRating;
    }

    public void calculateChallengeRating() {

        //Perhaps a static class

    }

    public int getExperience() {
        return experience;
    }

    public boolean getHasLair() {
        return hasLair;
    }

    public void setHasLair(boolean hasLair) {
        this.hasLair = hasLair;
    }

    public String getTypeAndAlignment() {
        return size + " " + type + ", " + alignment;
    }
}
