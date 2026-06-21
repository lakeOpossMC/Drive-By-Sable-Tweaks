package edn.lakeopossmc.drivebysabletweaks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.neoforge.common.conditions.ICondition;

// --- CONDITION FOR CONFIG FILE --- //
// * Sets up the condition to use in recipe checks
public record UseOriginalRecipesCondition(boolean expected) implements ICondition {
    public static final MapCodec<UseOriginalRecipesCondition> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.BOOL.optionalFieldOf("expected", true).forGetter(UseOriginalRecipesCondition::expected)
            ).apply(instance, UseOriginalRecipesCondition::new)
    );

    @Override
    public boolean test(IContext context) {
        return WireTweaksConfig.USE_ORIGINAL_RECIPES.get() == expected;
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}