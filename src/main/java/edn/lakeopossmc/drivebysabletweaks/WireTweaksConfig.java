package edn.lakeopossmc.drivebysabletweaks;

import net.neoforged.neoforge.common.ModConfigSpec;

// --- SETUP CONFIG --- //
// * Config file setup so recipe changes will be optional (i luv options)
public class WireTweaksConfig {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.BooleanValue USE_ORIGINAL_RECIPES;

    // --- DEFINE THE VALUE IN CONFIG AND ADD DESC --- //
    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        USE_ORIGINAL_RECIPES = builder
                .comment("If true, use Drive-By-Wire's original recipes. Use /reload in chat to update after changing.")
                .define("useOriginalRecipes", false);
        SPEC = builder.build();
    }

    private WireTweaksConfig() {
    }
}