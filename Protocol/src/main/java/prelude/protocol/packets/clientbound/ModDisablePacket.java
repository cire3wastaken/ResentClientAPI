package prelude.protocol.packets.clientbound;

import lombok.Builder;
import prelude.protocol.packets.client.ClientBoundPacket;
import prelude.protocol.packets.client.ClientPacketManager;
import prelude.protocol.PacketManager;
import prelude.protocol.ProcessedResult;

import java.util.Objects;
import java.util.regex.Pattern;

@Builder
public class ModDisablePacket extends ClientBoundPacket {
    private String receiver;

    @Override
    public String serialize() {
        return GENERIC_PACKET_FORMAT
                .replace("%packet_receiver%", receiver)
                .replace("%message%", "disable");
    }

    @Override
    public ProcessedResult processPacket(ClientPacketManager manager) {
        return null;
    }

    @Override
    public ClientBoundPacket createNewInstanceWithData(String data) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModDisablePacket)) return false;
        ModDisablePacket that = (ModDisablePacket) o;
        return Objects.equals(receiver, that.receiver);
    }
}
