package nb.largefactory.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import nb.largefactory.LargeFactory;
import nb.largefactory.network.PacketTypeHandler;
import net.minecraft.network.INetworkManager;
import cpw.mods.fml.common.network.Player;

public class PacketTileUpdate extends PacketLargeFactory {

    public int    x, y, z;
    public String customName;

    public PacketTileUpdate() {

        super(PacketTypeHandler.TILE, true);
    }

    public PacketTileUpdate(int x, int y, int z, String customName) {

        super(PacketTypeHandler.TILE, true);
        this.x = x;
        this.y = y;
        this.z = z;
        this.customName = customName;
    }

    @Override
    public void writeData(DataOutputStream data) throws IOException {

        data.writeInt(x);
        data.writeInt(y);
        data.writeInt(z);
        data.writeUTF(customName);
    }

    @Override
    public void readData(DataInputStream data) throws IOException {

        x = data.readInt();
        y = data.readInt();
        z = data.readInt();
        customName = data.readUTF();
    }

    @Override
    public void execute(INetworkManager manager, Player player) {

        LargeFactory.proxy.handleTileEntityPacket(x, y, z, customName);
    }

}
