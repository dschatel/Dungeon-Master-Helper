package falc.dungeonmasterhelper.model.Monster.MonsterTrait;

import falc.dungeonmasterhelper.model.Monster.Monster;

/**
 * Created by Falcon24 on 1/15/2017.
 */


//Superclass for monster traits
public class MonsterTrait extends Monster {

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

}
