package edn.lakeopossmc.drivebysabletweaks;

import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class WireTweaksItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("drivebywire");

    public static final DeferredItem<BlockItem> CONTROLLER_HUB_BLOCK = ITEMS.registerSimpleBlockItem("controller_hub", WireTweaksBlocks.CABLE_HUB);
    public static final DeferredItem<BlockItem> TWEAKED_CONTROLLER_HUB_BLOCK = ITEMS.registerSimpleBlockItem("tweaked_controller_hub", WireTweaksBlocks.ADVANCED_CABLE_HUB);

    private WireTweaksItems() {
    }

    public static void register(final IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
