package massiveOctoAdventure.utils;

import net.minecraft.nbt.NBTTagCompound;

public class utilTileEntityInfo {
	public NBTTagCompound data;
	public int x, y, z;
	
	public utilTileEntityInfo(NBTTagCompound data, int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.data = data;
	}
}
