package edn.lakeopossmc.drivebysabletweaks;

import dev.simulated_team.simulated.registrate.SimulatedRegistrate;
import edn.stratodonut.drivebywire.WireItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public final class WireTweaksSimulatedTab {

    private static final ResourceLocation SECTION_ID = DriveBySableTweaks.asResource("drivebywire_section");

    public static void register() {
        DriveBySableTweaks.LOGGER.info("WireTweaksSimulatedTab.register() running, section id = {}", SECTION_ID);
        addItem(WireTweaksItems.CABLE_IO_BUS.get());
        addItem(WireItems.WIRE.get());
        addItem(WireItems.WIRE_CUTTER.get());
        addItem(WireTweaksItems.CONTROLLER_HUB_BLOCK.get());
        addItem(WireTweaksItems.TWEAKED_CONTROLLER_HUB_BLOCK.get());
        addItem(WireItems.BACKUP_BLOCK.get());
        DriveBySableTweaks.LOGGER.info("TAB_ITEMS now has {} total entries", SimulatedRegistrate.TAB_ITEMS.size());
    }

    private static void addItem(final Item item) {
        final ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        SimulatedRegistrate.TAB_ITEMS.add(() -> item);
        SimulatedRegistrate.ITEM_TO_SECTION.put(itemId, SECTION_ID);
        DriveBySableTweaks.LOGGER.info("Added {} -> section {}", itemId, SECTION_ID);
    }

    private WireTweaksSimulatedTab() {
    }
}