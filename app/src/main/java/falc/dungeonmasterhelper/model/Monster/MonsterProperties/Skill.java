package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class Skill extends Trait implements Parcelable, Serializable {

    private String skillName;
    private int skillBonus;

  public Skill() {
    }

    public String getName() {
        return skillName;
    }

    public int getValue() {
        return skillBonus;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setSkillBonus(int skillBonus) {
        this.skillBonus = skillBonus;
    }


    protected Skill(Parcel in) {
        skillName = in.readString();
        skillBonus = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(skillName);
        dest.writeInt(skillBonus);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Skill> CREATOR = new Parcelable.Creator<Skill>() {
        @Override
        public Skill createFromParcel(Parcel in) {
            return new Skill(in);
        }

        @Override
        public Skill[] newArray(int size) {
            return new Skill[size];
        }
    };
}
