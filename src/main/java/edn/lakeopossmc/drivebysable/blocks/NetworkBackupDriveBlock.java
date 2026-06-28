package edn.lakeopossmc.drivebysable.blocks;

import com.mojang.serialization.MapCodec;
import edn.lakeopossmc.drivebysable.CableBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class NetworkBackupDriveBlock extends Block implements EntityBlock {
    public static final MapCodec<NetworkBackupDriveBlock> CODEC = simpleCodec(NetworkBackupDriveBlock::new);

    public NetworkBackupDriveBlock(final Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(final BlockPos pos, final BlockState state) {
        return new NetworkBackupDriveBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(
        final Level level,
        final BlockState state,
        final BlockEntityType<T> blockEntityType
    ) {
        if (level.isClientSide() || blockEntityType != CableBlockEntities.BACKUP_DRIVE.get()) {
            return null;
        }

        return (tickLevel, tickPos, tickState, blockEntity) -> NetworkBackupDriveBlockEntity.serverTick(
            tickLevel,
            tickPos,
            tickState,
            (NetworkBackupDriveBlockEntity) blockEntity
        );
    }
}
