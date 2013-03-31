package massiveOctoAdventure.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePhaser extends TileEntity{
	private boolean hasPlan = false;
	private int cubeSize = 3;// the actual cube will be twice this number + 1.  The center will be the phaserBlock
	private utilBlockInfo[] storage = new utilBlockInfo[(int) Math.pow(((cubeSize*2) + 1),3)];
	
	public boolean hasPlan() {
		return hasPlan;
	}
	
	public void scanPlan() {
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		int tempX;
		int tempY;
		int tempZ;
		for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
			for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
				for(int y = this.yCoord+1; y <= this.yCoord+(cubeSize*2+1); y++) {
					tempX = Math.abs(x - this.xCoord-cubeSize);
					tempY = Math.abs(y - this.yCoord+1);
					tempZ = Math.abs(z - this.zCoord-cubeSize);
					storage[tempY+tempZ*tempY+tempZ*tempY*tempX] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
				}
			}
		}
	}
	
	public void removeProperArea() {
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		int tempX;
		int tempY;
		int tempZ;
		for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
			for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
				for(int y = this.yCoord+1; y <= this.yCoord+(cubeSize*2+1); y++) {
					tempX = x - this.xCoord-cubeSize;
					tempY = y - this.yCoord+1;
					tempZ = z - this.zCoord-cubeSize;
					worldObj.setBlock(x, y, z, 0, 0, 0x02);
				}
			}
		}
	}
	
	public void placePlan() {
		for(int a = 0; a < storage.length; a++) {
			this.worldObj.setBlock(storage[a].x, storage[a].y, storage[a].z, storage[a].id, storage[a].meta, 0x02);
			this.worldObj.markBlockForUpdate(storage[a].x, storage[a].y, storage[a].z);
		}
		this.hasPlan = false;
	}
	
	private int[] createIntArray(utilBlockInfo[] blocks) {
		int[] toReturn = new int[blocks.length*5];
		int[] blocksInfo;
		for(int a = 0; a < blocks.length; a++) {
			if(blocks[a] != null) {
				blocksInfo = blocks[a].getArray();
			} else {
				blocksInfo = new int[]{0, 0, 0, 0, 0};
			}
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
