package edn.lakeopossmc.drivebysable.cable;

import java.util.List;

public interface MultiChannelCableSource {
    List<String> cable$getChannels();

    String cable$nextChannel(String current, boolean forward);
}
