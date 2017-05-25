package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class Ability extends Trait implements Parcelable, Serializable {

    private String abilityName;
    private int abilityScore;

    public Ability(String abilityName, int abilityScore) {
        this.abilityName = abilityName;
        this.abilityScore = abilityScore;
    }

    public String getName() {
        return abilityName;
    }

    public int getValue() {
        return abilityScore;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public void setAbilityScore(int abilityScore) {
        this.abilityScore = abilityScore;
    }


    protected Ability(Parcel in) {
        abilityName = in.readString();
        abilityScore = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(abilityName);
        dest.writeInt(abilityScore);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Ability> CREATOR = new Parcelable.Creator<Ability>() {
        @Override
        public Ability createFromParcel(Parcel in) {
            return new Ability(in);
        }

        @Override
        public Ability[] newArray(int size) {
            return new Ability[size];
        }
    };
}