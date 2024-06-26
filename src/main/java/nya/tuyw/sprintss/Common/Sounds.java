package nya.tuyw.sprintss.Common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nya.tuyw.sprintss.Sprintss;

public class Sounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Sprintss.MODID);
    public static final RegistryObject<SoundEvent> SPRINT = registerSoundEvent("sounds_sprint");
    public static final RegistryObject<SoundEvent> WAAH = registerSoundEvent("sounds_waah");
    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name,() -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Sprintss.MODID,name)));
    }
}
