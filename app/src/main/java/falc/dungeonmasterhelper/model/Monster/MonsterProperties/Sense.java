package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class Sense implements Parcelable, Serializable {

    private String senseName;
    private int senseRange;

    public Sense() {
    }

    public String getSenseName() {
        return senseName;
    }

    public int getSenseRange(){
        return senseRange;
    }

    public void setSenseName(String senseName) {
        this.senseName = senseName;
    }

    public void setSenseRange(int senseRange) {
        this.senseRange = senseRange;
    }

    protected Sense(Parcel in) {
        senseName = in.readString();
        senseRange = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(senseName);
        dest.writeInt(senseRange);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sense> CREATOR = new Parcelable.Creator<Sense>() {
        @Override
        public Sense createFromParcel(Parcel in) {
            return new Sense(in);
        }

        @Override
        public Sense[] newArray(int size) {
            return new Sense[size];
        }
    };
}