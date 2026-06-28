package edn.lakeopossmc.drivebysable;

import edn.lakeopossmc.drivebysable.blocks.AdvancedCableHubBlock;
import edn.lakeopossmc.drivebysable.blocks.CableHubBlock;
import edn.lakeopossmc.drivebysable.blocks.NetworkBackupDriveBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class CableBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DriveBySableMod.MOD_ID);

    public static final DeferredBlock<NetworkBackupDriveBlock> BACKUP_DRIVE = BLOCKS.register(
        "backup_drive",
        () -> new NetworkBackupDriveBlock(commonProperties())
    );
    public static final DeferredBlock<CableHubBlock> CABLE_HUB = BLOCKS.register(
        "cable_hub",
        () -> new CableHubBlock(commonProperties())
    );
    public static final DeferredBlock<AdvancedCableHubBlock> ADVANCED_CABLE_HUB = BLOCKS.register(
        "advanced_cable_hub",
        () -> new AdvancedCableHubBlock(commonProperties())
    );

    private CableBlocks() {
    }

    public static void register(final IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    private static BlockBehaviour.Properties commonProperties() {
        return BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .sound(SoundType.COPPER)
            .strength(3.0F, 6.0F)
            .requiresCorrectToolForDrops();
    }
}
