package nya.tuyw.sprintss.Common;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;

public class CooldownTicker {
    private static boolean canSprint = true;
    public static boolean getCanSprint(){
        return canSprint;
    }
    public static void setCanSprint(boolean i){
        canSprint = i;
    }
    private static long lastgt = 0;
    public static void setlastgt(long i){
        lastgt = i;
    }
    public static void refreshCooldown(){
        Level level = Minecraft.getInstance().level;
        long newgt = level.getGameTime();
        if (newgt - lastgt >= 80){
            canSprint = true;
        }else {
            canSprint = false;
        }
    };
}
