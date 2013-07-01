package nb.largefactory.network;

import nb.largefactory.network.packet.PacketLargeFactory;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

        // Build a PacketLargeFactory object from the data contained within the
        // Packet250CustomPayload packet
        PacketLargeFactory packetLargeFactory = PacketTypeHandler.buildPacket(packet.data);

        // Execute the appropriate actions based on the PacketLargeFactory type
        packetLargeFactory.execute(manager, player);
    }

}
