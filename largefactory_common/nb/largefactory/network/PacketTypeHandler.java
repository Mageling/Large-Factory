package nb.largefactory.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;



import nb.largefactory.lib.Reference;
import nb.largefactory.network.packet.PacketLargeFactory;
import nb.largefactory.network.packet.PacketTileUpdate;
import nb.largefactory.network.packet.PacketTileWithItemUpdate;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;



public enum PacketTypeHandler {
    TILE(PacketTileUpdate.class),
    TILE_WITH_ITEM(PacketTileWithItemUpdate.class);
    
    private Class<? extends PacketLargeFactory> clazz;

    PacketTypeHandler(Class<? extends PacketLargeFactory> clazz) {

        this.clazz = clazz;
    }

    public static PacketLargeFactory buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        PacketLargeFactory packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static PacketLargeFactory buildPacket(PacketTypeHandler type) {

        PacketLargeFactory packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(PacketLargeFactory packetLargeFactory) {

        byte[] data = packetLargeFactory.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = Reference.CHANNEL_NAME;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = packetLargeFactory.isChunkDataPacket;

        return packet250;
    }

}
