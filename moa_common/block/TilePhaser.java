package massiveOctoAdventure.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePhaser extends TileEntity{
	private boolean hasPlan = false;
	private int cubeSize = 8;// the actual cube will be twice this number + 1.  The center will be the phaserBlock
	private int[] storage = new int[(int) Math.pow(((cubeSize*2) + 1),3)];
	
	public boolean hasPlan() {
		return hasPlan;
	}
	
	public void placePlan() {
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("hasPlan", hasPlan);
		nbt.setInteger("cubeSize", cubeSize);
		nbt.setIntArray("storage", storage);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		hasPlan = nbt.getBoolean("hasPlan");
		cubeSize = nbt.getInteger("cubeSize");
		storage = nbt.getIntArray("storage");
	}
}
