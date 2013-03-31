package massiveOctoAdventure.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePhaser extends TileEntity{
	private boolean hasPlan = false;
	private int cubeSize = 1;// the actual cube will be twice this number + 1.  The center will be the phaserBlock
	private utilBlockInfo[] storage = new utilBlockInfo[(int) Math.pow(((cubeSize*2) + 1),3)];
	
	public boolean hasPlan() {
		return hasPlan;
	}
	
	public void placePlan() {
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		for(int x = this.xCoord-cubeSize; x < this.xCoord+cubeSize; x++) {
			
		}
	}
	
	private void placePlan(utilBlockInfo[] blocks) {
		
	}
	
	private int[] createIntArray(utilBlockInfo[] blocks) {
		int[] toReturn = new int[blocks.length*5];
		int[] blocksInfo;
		for(int a = 0; a < toReturn.length; a++) {
			blocksInfo = blocks[a].getArray();
			for(int b = a*5; b < a*5+5; b++) {
				toReturn[b] = blocksInfo[b%5];
			}
		}
		return toReturn;
	}
	
	private utilBlockInfo[] createBlockInfo(int[] v) {
		utilBlockInfo[] toReturn = new utilBlockInfo[v.length/5];
		int[] temp = new int[5];
		for(int a = 0; a < toReturn.length; a++) {
			for(int b = 0; b < 5; b++) {
				temp[b] = v[a*5+b];
			}
			toReturn[a] = new utilBlockInfo(temp);
		}
		return toReturn;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setBoolean("hasPlan", hasPlan);
		nbt.setInteger("cubeSize", cubeSize);
		nbt.setIntArray("storage", createIntArray(storage));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		hasPlan = nbt.getBoolean("hasPlan");
		cubeSize = nbt.getInteger("cubeSize");
		storage = createBlockInfo(nbt.getIntArray("storage"));
	}
}
