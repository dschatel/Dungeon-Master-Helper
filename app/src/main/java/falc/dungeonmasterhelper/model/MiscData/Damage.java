package falc.dungeonmasterhelper.model.MiscData;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Falcon24 on 4/10/2017.
 */

public class Damage implements Parcelable {

    private int numDice;
    private int diceType;
    private int extraDam;
    private String damageType;

    public Damage(int numDice, int diceType, int extraDam, String damageType) {

        this.numDice = numDice;
        this.diceType = diceType;
        this.extraDam = extraDam;
        this.damageType = damageType;
    }

    public int getNumDice() {
        return numDice;
    }

    public int getDiceType (){
        return diceType;
    }

    public void setNumDice(int numDice) {
        this.numDice = numDice;
    }

    public void setDiceType (int diceType) {
        this.diceType = diceType;
    }

    public int getMinDmg() {
        return 1*numDice;
    }

    public String getDamageType() { return damageType; }

    public void setDamageType(String damageType) { this.damageType = damageType; }

    public int getExtraDam () {
        return extraDam;
    }

    public void setExtraDam (int extraDam) {
        this.extraDam = extraDam;
    }

    public int getMaxDmg () {
        return numDice * diceType;
    }

    public int getAvgDmg() {

        double mean = (diceType / 2) + 0.5;

        return (int) ((numDice * mean) + extraDam);
    }

    public String formatDamage() {
        return getAvgDmg() + "(" + numDice + "d" + diceType + " + " + extraDam + ") " + damageType + "damage";
    }

    protected Damage(Parcel in) {
        numDice = in.readInt();
        diceType = in.readInt();
        extraDam = in.readInt();
        damageType = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numDice);
        dest.writeInt(diceType);
        dest.writeInt(extraDam);
        dest.writeString(damageType);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Damage> CREATOR = new Parcelable.Creator<Damage>() {
        @Override
        public Damage createFromParcel(Parcel in) {
            return new Damage(in);
        }

        @Override
        public Damage[] newArray(int size) {
            return new Damage[size];
        }
    };
}