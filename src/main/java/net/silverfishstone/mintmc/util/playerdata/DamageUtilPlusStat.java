package net.silverfishstone.mintmc.util.playerdata;


import net.silverfishstone.mintmc.MintMain;

public class DamageUtilPlusStat {
    public static float getDamageLeft(float damageAmount, int defenseType, double armorToughness) {
        double defense = (armorToughness/6);
        float armor = (float) ((damageAmount * ((defenseType + Math.pow(defenseType, defense)) / 100)) / 1.4);
        float damageDealt = damageAmount - armor;
        MintMain.LOGGER.info("Logged {} damage dealt", damageDealt);
        MintMain.LOGGER.info("(Logging for testing purposes)");
        return damageDealt;
    }
}
