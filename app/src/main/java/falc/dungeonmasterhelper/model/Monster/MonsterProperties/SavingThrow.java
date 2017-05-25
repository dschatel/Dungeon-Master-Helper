package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class SavingThrow extends Trait implements Parcelable, Serializable {

    private String save;
    private int bonus;

    public SavingThrow() {
    }

    public String getName() {
        return save;
    }

    public int getValue() {
        return bonus;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }


    protected SavingThrow(Parcel in) {
        save = in.readString();
        bonus = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(save);
        dest.writeInt(bonus);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SavingThrow> CREATOR = new Parcelable.Creator<SavingThrow>() {
        @Override
        public SavingThrow createFromParcel(Parcel in) {
            return new SavingThrow(in);
        }

        @Override
        public SavingThrow[] newArray(int size) {
            return new SavingThrow[size];
        }
    };
}