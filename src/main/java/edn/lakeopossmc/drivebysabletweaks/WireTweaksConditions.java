package edn.lakeopossmc.drivebysabletweaks;

import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

// --- THE LAST STEPS FOR RECIPE CONFIG --- //
// * Register the condition for the config so the game can actually use and recognize it
public final class WireTweaksConditions {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, DriveBySableTweaks.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<UseOriginalRecipesCondition>> USE_ORIGINAL_RECIPES =
            CONDITION_CODECS.register("use_original_recipes", () -> UseOriginalRecipesCondition.CODEC);

    private WireTweaksConditions() {
    }

    public static void register(final IEventBus modEventBus) {
        CONDITION_CODECS.register(modEventBus);
    }
}