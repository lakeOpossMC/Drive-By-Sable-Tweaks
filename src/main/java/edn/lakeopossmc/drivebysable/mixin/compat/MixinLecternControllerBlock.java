package edn.lakeopossmc.drivebysable.mixin.compat;

import com.simibubi.create.content.redstone.link.controller.LecternControllerBlock;
import edn.lakeopossmc.drivebysable.cable.MultiChannelCableSource;
import edn.lakeopossmc.drivebysable.compat.LinkedControllerCableServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Arrays;
import java.util.List;

@Mixin(LecternControllerBlock.class)
public abstract class MixinLecternControllerBlock implements MultiChannelCableSource {
    @Unique
    private static final List<String> DRIVEBYSABLE$CHANNELS = Arrays.stream(LinkedControllerCableServerHandler.KEY_TO_CHANNEL).toList();

    @Override
    public List<String> cable$getChannels() {
        return DRIVEBYSABLE$CHANNELS;
    }

    @Override
    public String cable$nextChannel(final String current, final boolean forward) {
        final int currentIndex = DRIVEBYSABLE$CHANNELS.indexOf(current);
        if (currentIndex == -1) {
            return DRIVEBYSABLE$CHANNELS.getFirst();
        }
        return DRIVEBYSABLE$CHANNELS.get(Math.floorMod(currentIndex + (forward ? 1 : -1), DRIVEBYSABLE$CHANNELS.size()));
    }
}
