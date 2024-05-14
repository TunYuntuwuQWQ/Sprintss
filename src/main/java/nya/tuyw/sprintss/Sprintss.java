package nya.tuyw.sprintss;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.logging.LogUtils;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nya.tuyw.sprintss.Common.Sounds.Sounds;
import org.slf4j.Logger;

@Mod(Sprintss.MODID)
public class Sprintss {
    public static final String MODID = "sprintss";
    public static final String KEY_SPRINTSS_CATEGORY = "category.sprintss.sprintss";
    public static final String KEY_SPRINTSS_SPRINT = "key.sprintss.sprint";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final KeyMapping KEY_SPRINT = new KeyMapping(KEY_SPRINTSS_SPRINT, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, InputConstants.KEY_R,KEY_SPRINTSS_CATEGORY);
    public Sprintss(){
        Sounds.SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    @Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModClientEventHandler {
        @SubscribeEvent
        public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
            event.register(KEY_SPRINT);
        }
    }
}
