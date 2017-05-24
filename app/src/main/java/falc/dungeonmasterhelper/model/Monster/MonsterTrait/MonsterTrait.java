package falc.dungeonmasterhelper.model.Monster.MonsterTrait;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import falc.dungeonmasterhelper.model.Monster.Monster;

/**
 * Created by Falcon24 on 1/15/2017.
 */


//Superclass for monster traits
public class MonsterTrait implements Parcelable, Serializable {

    private String traitName;
    private String flavorText;
    private String traitDesc;

    public MonsterTrait(String name, String desc) {
        traitName = name;
        flavorText = desc;
    }

    public String getName() {
        return traitName;
    }

    public String getDesc() {
        return traitDesc;
    }

    public void setName(String name) {
        traitName = name;
    }

    public String getFlavorText () {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public void formatDesc() {
        traitDesc = traitName + ". " + flavorText;
    }


    protected MonsterTrait(Parcel in) {
        traitName = in.readString();
        flavorText = in.readString();
        traitDesc = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(traitName);
        dest.writeString(flavorText);
        dest.writeString(traitDesc);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MonsterTrait> CREATOR = new Parcelable.Creator<MonsterTrait>() {
        @Override
        public MonsterTrait createFromParcel(Parcel in) {
            return new MonsterTrait(in);
        }

        @Override
        public MonsterTrait[] newArray(int size) {
            return new MonsterTrait[size];
        }
    };
}