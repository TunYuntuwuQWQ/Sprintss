package nya.tuyw.sprintss.Common;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

public class CooldownTicker {
    private static long lastgt = 0;
    public static void setlastgt(long i){
        lastgt = i;
    }
    public static boolean refreshCooldown(){
        Level level = Minecraft.getInstance().level;
        long newgt = level.getGameTime();
        if (newgt - lastgt >= 80){
            setlastgt(level.getGameTime());
            return true;
        }else {
            return false;
        }
    };
}
