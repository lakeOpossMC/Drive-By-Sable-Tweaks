package edn.lakeopossmc.drivebysable;

import edn.lakeopossmc.drivebysable.items.CableCutterItem;
import edn.lakeopossmc.drivebysable.items.CableItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class CableItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DriveBySableMod.MOD_ID);

    public static final DeferredItem<CableItem> CABLE = ITEMS.register("cable", () -> new CableItem(new Item.Properties()));
    public static final DeferredItem<CableCutterItem> CABLE_CUTTER = ITEMS.register(
        "cable_cutter",
        () -> new CableCutterItem(new Item.Properties().stacksTo(1))
    );
    public static final DeferredItem<Item> CABLE_IO_BUS = ITEMS.registerSimpleItem("cable_io_bus");
    public static final DeferredItem<Item> INCOMPLETE_CABLE_IO_BUS = ITEMS.registerSimpleItem("incomplete_cable_io_bus");
    public static final DeferredItem<BlockItem> BACKUP_DRIVE = ITEMS.registerSimpleBlockItem("backup_drive", CableBlocks.BACKUP_DRIVE);
    public static final DeferredItem<BlockItem> CABLE_HUB_BLOCK = ITEMS.registerSimpleBlockItem("cable_hub", CableBlocks.CABLE_HUB);
    public static final DeferredItem<BlockItem> ADVANCED_CABLE_HUB_BLOCK = ITEMS.registerSimpleBlockItem(
        "advanced_cable_hub",
        CableBlocks.ADVANCED_CABLE_HUB
    );

    private CableItems() {
    }

    public static void register(final IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
