package nya.tuyw.sprintss.ClientEvent;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nya.tuyw.sprintss.Common.Sounds.Sounds;
import nya.tuyw.sprintss.Sprintss;

@Mod.EventBusSubscriber(modid = Sprintss.MODID,value = Dist.CLIENT)
public class InputKey {
    @SubscribeEvent
    public static void onInput(InputEvent.Key event){
        if (Sprintss.KEY_SPRINT.consumeClick()){
            Player player = Minecraft.getInstance().player;
            float f7 = player.getYRot();
            float f = player.getXRot();
            float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
            float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
            float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
            float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
            float f5 = 4.0F;
            f1 *= f5 / f4;
            f2 *= f5 / f4;
            f3 *= f5 / f4;
            player.push((double)f1, (double)f2, (double)f3);
            if (player.onGround()) {
                float f6 = 1.1999999F;
                player.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));
            }
            player.playSound(Sounds.SPRINT.get());
            Minecraft.getInstance().player.sendSystemMessage(Component.translatable("message.key.sprint"));
        }
    }
}