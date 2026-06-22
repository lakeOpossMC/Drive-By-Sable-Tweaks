package edn.lakeopossmc.drivebysabletweaks;

import com.mojang.logging.LogUtils;
import edn.stratodonut.drivebywire.WireItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

// --- MAIN MOD CLASS --- //
// * Handles block and item registers and tells the game "hey, they exist"
// * Fixes creative menu tab to show MY blocks not the og
@Mod(DriveBySableTweaks.MOD_ID)
public class DriveBySableTweaks {
    public static final String MOD_ID = "drivebysabletweaks";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ResourceKey<CreativeModeTab> DRIVE_BY_WIRE_TAB =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath("drivebywire", "base"));

    public DriveBySableTweaks(final IEventBus modEventBus, final ModContainer modContainer, final Dist dist) {
        // registry contents
        WireTweaksBlocks.register(modEventBus);
        WireTweaksItems.register(modEventBus);
        WireTweaksConditions.register(modEventBus);

        // config and event stuffs
        modContainer.registerConfig(net.neoforged.fml.config.ModConfig.Type.COMMON, WireTweaksConfig.SPEC);
        modEventBus.addListener(this::buildContents);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // optional integration with Create Simulated's tab
        if (ModList.get().isLoaded("simulated")) {
            event.enqueueWork(WireTweaksSimulatedTab::register);
        }
    }

    // --- CREATIVE TAB FIXES --- //
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() != DRIVE_BY_WIRE_TAB) {
            return;
        }

        // kill the og items pls
        event.remove(WireItems.CONTROLLER_HUB_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        event.remove(WireItems.TWEAKED_CONTROLLER_HUB_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        // find my freaking items do NOT clone them.
        final ItemStack newHub = WireTweaksItems.CONTROLLER_HUB_BLOCK.get().getDefaultInstance();
        final ItemStack newTweakedHub = WireTweaksItems.TWEAKED_CONTROLLER_HUB_BLOCK.get().getDefaultInstance();
        final ItemStack cableIoBus = WireTweaksItems.CABLE_IO_BUS.get().getDefaultInstance();

        event.remove(newHub, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        event.remove(newTweakedHub, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        event.remove(cableIoBus, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        event.accept(newHub);
        event.accept(newTweakedHub);
        event.accept(cableIoBus);
    }

    public static ResourceLocation asResource(final String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}