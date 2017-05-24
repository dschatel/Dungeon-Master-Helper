package falc.dungeonmasterhelper.model.Monster.MonsterProperties;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Falcon24 on 1/22/2017.
 */

public class MovementType implements Parcelable, Serializable {

    private String movementName;
    private int movementAmount;

  public MovementType() {
    }

    public String getMovementName() {
        return movementName;
    }

    public int getMovementAmount() {
        return movementAmount;
    }

    public void setMovementName(String movementName){
        this.movementName = movementName;
    }

    public void setMovementAmount(int movementAmount) {
        this.movementAmount = movementAmount;
    }


    protected MovementType(Parcel in) {
        movementName = in.readString();
        movementAmount = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movementName);
        dest.writeInt(movementAmount);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MovementType> CREATOR = new Parcelable.Creator<MovementType>() {
        @Override
        public MovementType createFromParcel(Parcel in) {
            return new MovementType(in);
        }

        @Override
        public MovementType[] newArray(int size) {
            return new MovementType[size];
        }
    };
}