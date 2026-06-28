package edn.lakeopossmc.drivebysable.mixin.client;

import com.simibubi.create.content.redstone.link.controller.LinkedControllerClientHandler;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LinkedControllerClientHandler.class)
public interface MixinLinkedControllerClientHandlerAccessor {
    @Accessor("lecternPos")
    static BlockPos drivebysable$getLecternPos() {
        throw new AssertionError();
    }
}
