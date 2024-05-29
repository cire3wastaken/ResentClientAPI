package prelude.network.packets.clientbound;

import prelude.network.ClientBoundPacket;
import prelude.network.ClientBoundPacketBuilder;

import java.util.Objects;

public class ModDisablePacket extends ClientBoundPacket {
    public ModDisablePacket() {
        super(ModInitPacket.class);
    }

    private ModDisablePacket(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String serialize() {
        return GENERIC_PACKET_FORMAT
                .replace("%packet_receiver%", receiver)
                .replace("%message%", "disable");
    }

    @Override
    public ModDisablePacketBuilder builder() {
        return new ModDisablePacketBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModDisablePacket)) return false;
        ModDisablePacket that = (ModDisablePacket) o;
        return Objects.equals(receiver, that.receiver);
    }

    public static class ModDisablePacketBuilder extends ClientBoundPacketBuilder<ModDisablePacket> {
        private ModDisablePacketBuilder() {}

        @Override
        public ModDisablePacketBuilder receiver(String receiver) {
            super.receiver(receiver);
            return this;
        }

        @Override
        public ModDisablePacket build() {
            return new ModDisablePacket(receiver);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ModDisablePacketBuilder)) return false;
            ModDisablePacketBuilder that = (ModDisablePacketBuilder) o;
            return Objects.equals(receiver, that.receiver);
        }
    }
}
