package falc.dungeonmasterhelper.model.Monster;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import falc.dungeonmasterhelper.model.Monster.MonsterAction.*;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.*;
import falc.dungeonmasterhelper.model.Monster.MonsterTrait.*;

/**
 * Created by Falcon24 on 1/15/2017.
 */

public class Monster implements Parcelable, Serializable {

    private static final long serialVersionUID = -7878161794921060077L;
    private String name;
    private String type;
    private String size;
    private String alignment;
    private int numHitDice;
    private int hitDiceType;
    private int extraHP;
    private int armorClass;
    private List<MovementType> speed;
    private List<Ability> abilityScores;
    private List<SavingThrow> savingThrows;
    private List<Skill> skills;
    private List<String> damresistances;
    private List<String> damimmunities;
    private List<String> condimmunities;
    private List<Sense> senses;
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
        numHitDice = 0;
        hitDiceType = 0;
        extraHP = 0;
        armorClass = 0;
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

    public String getSizeTypeAlignment() {
        return size + " " + type + ", " + alignment;
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

    public List<Ability> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(List<Ability> scores) {
        abilityScores = scores;
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

    protected Monster(Parcel in) {
        name = in.readString();
        type = in.readString();
        size = in.readString();
        alignment = in.readString();
        numHitDice = in.readInt();
        hitDiceType = in.readInt();
        extraHP = in.readInt();
        armorClass = in.readInt();
        if (in.readByte() == 0x01) {
            speed = new ArrayList<MovementType>();
            in.readList(speed, MovementType.class.getClassLoader());
        } else {
            speed = null;
        }
        if (in.readByte() == 0x01) {
            abilityScores = new ArrayList<Ability>();
            in.readList(abilityScores, Ability.class.getClassLoader());
        } else {
            abilityScores = null;
        }
        if (in.readByte() == 0x01) {
            savingThrows = new ArrayList<SavingThrow>();
            in.readList(savingThrows, SavingThrow.class.getClassLoader());
        } else {
            savingThrows = null;
        }
        if (in.readByte() == 0x01) {
            skills = new ArrayList<Skill>();
            in.readList(skills, Skill.class.getClassLoader());
        } else {
            skills = null;
        }
        if (in.readByte() == 0x01) {
            damresistances = new ArrayList<String>();
            in.readList(damresistances, String.class.getClassLoader());
        } else {
            damresistances = null;
        }
        if (in.readByte() == 0x01) {
            damimmunities = new ArrayList<String>();
            in.readList(damimmunities, String.class.getClassLoader());
        } else {
            damimmunities = null;
        }
        if (in.readByte() == 0x01) {
            condimmunities = new ArrayList<String>();
            in.readList(condimmunities, String.class.getClassLoader());
        } else {
            condimmunities = null;
        }
        if (in.readByte() == 0x01) {
            senses = new ArrayList<Sense>();
            in.readList(senses, Sense.class.getClassLoader());
        } else {
            senses = null;
        }
        if (in.readByte() == 0x01) {
            languages = new ArrayList<String>();
            in.readList(languages, String.class.getClassLoader());
        } else {
            languages = null;
        }
        if (in.readByte() == 0x01) {
            monsterTraits = new ArrayList<MonsterTrait>();
            in.readList(monsterTraits, MonsterTrait.class.getClassLoader());
        } else {
            monsterTraits = null;
        }
        if (in.readByte() == 0x01) {
            monsterActions = new ArrayList<MonsterAction>();
            in.readList(monsterActions, MonsterAction.class.getClassLoader());
        } else {
            monsterActions = null;
        }
        isLegendary = in.readByte() != 0x00;
        challengeRating = in.readInt();
        experience = in.readInt();
        hasLair = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(size);
        dest.writeString(alignment);
        dest.writeInt(numHitDice);
        dest.writeInt(hitDiceType);
        dest.writeInt(extraHP);
        dest.writeInt(armorClass);
        if (speed == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(speed);
        }
        if (abilityScores == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(abilityScores);
        }
        if (savingThrows == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(savingThrows);
        }
        if (skills == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(skills);
        }
        if (damresistances == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(damresistances);
        }
        if (damimmunities == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(damimmunities);
        }
        if (condimmunities == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(condimmunities);
        }
        if (senses == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(senses);
        }
        if (languages == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(languages);
        }
        if (monsterTraits == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(monsterTraits);
        }
        if (monsterActions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(monsterActions);
        }
        dest.writeByte((byte) (isLegendary ? 0x01 : 0x00));
        dest.writeInt(challengeRating);
        dest.writeInt(experience);
        dest.writeByte((byte) (hasLair ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Monster> CREATOR = new Parcelable.Creator<Monster>() {
        @Override
        public Monster createFromParcel(Parcel in) {
            return new Monster(in);
        }

        @Override
        public Monster[] newArray(int size) {
            return new Monster[size];
        }
    };

    public String toString() {
        return name;
    }

    public String getMovement() {

        if (speed == null || speed.size() == 0) {
            return "None";
        }

        String movement = "";

        for (int i = 0; i < speed.size(); i++) {
                movement += speed.get(i).getName() + " " + speed.get(i).getValue() + " ft.";

            if(i != speed.size() -1)
                movement += ", ";
        }

        return movement;
    }

    public List<SavingThrow> getSavingThrowList() {
        return savingThrows;
    }

    public List<Skill> getSkillList() {
        return skills;
    }

    public List<Sense> getSensesList() {
        return senses;
    }

    public List<String> getDamResistList() {
        return damresistances;
    }

    public List<String> getDamImmuneList() {
        return damimmunities;
    }

    public List<String> getCondImmuneList() {
        return condimmunities;
    }

    public List<String> getLanguageList() {
        return languages;
    }

    public String getSavingThrows() {

        if (savingThrows == null || savingThrows.size() == 0)
            return "None";

            String savingThrow = "";

            for (int i = 0; i < savingThrows.size(); i++) {
                savingThrow += savingThrows.get(i).getName() + " +" + savingThrows.get(i).getValue();

                if(i != savingThrows.size() -1)
                    savingThrow+=", ";
            }

        return savingThrow;

    }

    public String getSkills() {

        if (skills == null || skills.size() == 0)
            return "None";

        String skill = "";

        for (int i = 0; i < skills.size(); i++) {
            skill += skills.get(i).getName() + " +" + skills.get(i).getValue();

            if(i != skills.size() -1)
                skill+=", ";
        }

        return skill;

    }

    public String getDamResist() {
        if (damresistances == null || damresistances.size() == 0)
            return "None";

        String damResists = "";

        for (int i = 0; i < damresistances.size(); i++) {
            damResists += damresistances.get(i);

            if(i != damresistances.size() -1)
                damResists+=", ";
        }

        return damResists;
    }

    public List<MovementType> getMovementList() {
        return speed;
    }

    public void setMovementList(List<MovementType> movement) {
        speed = movement;
    }

    public void setSavingThrowList(List<SavingThrow> saves) {
        savingThrows = saves;
    }

    public void setSkillList(List<Skill> skill) {
        skills = skill;
    }

    public void setDamResistList(List<String> damResist) {
        damresistances = damResist;
    }

    public void setDamImmuneList(List<String> damImmune) {
        damimmunities = damImmune;
    }

    public void setCondImmuneList(List<String> condImmune) {
        condimmunities = condImmune;
    }

    public void setSenseList(List<Sense> sense) {
        senses = sense;
    }

    public void setLanguageList(List<String> lang) {
        languages = lang;
    }

    public String getDamImmunities() {
        if (damimmunities == null || damimmunities.size() == 0)
            return "None";

        String damImmunities = "";

        for (int i = 0; i < damimmunities.size(); i++) {
            damImmunities += damimmunities.get(i);

            if(i != damimmunities.size() -1)
                damImmunities+=", ";
        }

        return damImmunities;
    }

    public String getCondImmunities() {
        if (condimmunities == null || condimmunities.size() == 0)
            return "None";

        String condImmunities = "";

        for (int i = 0; i < condimmunities.size(); i++) {
            condImmunities += condimmunities.get(i);

            if(i != condimmunities.size() -1)
                condImmunities+=", ";
        }

        return condImmunities;
    }

    public String getLanguages() {
        if (languages == null || languages.size() == 0)
            return "None";

        String language = "";

        for (int i = 0; i < languages.size(); i++) {
            language += languages.get(i);

            if(i != languages.size() -1)
                language+=", ";
        }

        return language;
    }

    public String getSenses() {
        if (senses == null || senses.size() == 0)
            return "None";

        String sense = "";

        for (int i = 0; i < senses.size(); i++) {

            sense+= senses.get(i).getName() + " " + senses.get(i).getValue();
            if (!senses.get(i).getName().equals("Passive Perception"))
                sense+= " ft.";

            if(i != senses.size() -1)
                sense+=", ";
        }

        return sense;
    }

    public String formatAbilityScore(Ability ability) {

        int abilityMod = getAbilityMod(ability.getValue());

        if(abilityMod >0)
            return ability.getValue() + " (+" + abilityMod + ")";
        else
            return ability.getValue() + "(" + abilityMod + ")";

    }

    public int getAbilityMod (int abilityScore) {
        return (abilityScore / 2) - 5;
    }
}