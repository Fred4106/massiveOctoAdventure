package massiveOctoAdventure.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePhaser extends TileEntity{
	public boolean alt = false;
	private int cubeSize = 1;// the actual cube will be twice this number + 1.  The center will be the phaserBlock
	private utilBlockInfo[] storage = new utilBlockInfo[(int) Math.pow(((cubeSize*2) + 1),3)];
	private utilBlockInfo[] storageAlt = new utilBlockInfo[(int) Math.pow(((cubeSize*2) + 1),3)];
	
	public boolean state = false;
	
	public boolean rotateable = true;
	
	public boolean hasPlan() {
		return alt;
	}
	
	public TilePhaser(int size) {
		cubeSize = size;
		storage = new utilBlockInfo[(int) Math.pow(((cubeSize*2) + 1),3)];
		storageAlt = new utilBlockInfo[(int) Math.pow(((cubeSize*2) + 1),3)];
	}
	
	private void sendBlockUpdate(int x, int y, int z) {
		worldObj.notifyBlocksOfNeighborChange(x, y, z, worldObj.getBlockId(x, y, z));
	}
	
	public void scanPlan(boolean doAlt) {
		rotateable = false;
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		int tempX;
		int tempY;
		int tempZ;
		if(meta == 0) {
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int y = this.yCoord-(cubeSize*2+1); y <= this.yCoord-1; y++) {
						tempX = Math.abs(x - (this.xCoord-cubeSize));
						tempY = Math.abs(y - (this.yCoord-(cubeSize*2+1)));
						tempZ = Math.abs(z - (this.zCoord-cubeSize));
						if(!doAlt) {
							storage[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						} else {
							storageAlt[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						}
					}
				}
			}
		} else if(meta == 1) {
			
			//*
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int y = this.yCoord+1; y <= this.yCoord+(cubeSize*2+1); y++) {
						tempX = Math.abs(x - (this.xCoord-cubeSize));
						tempY = Math.abs(y - (this.yCoord+1));
						tempZ = Math.abs(z - (this.zCoord-cubeSize));
						if(!doAlt) {
							storage[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						} else {
							storageAlt[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						}
					}
				}
			}
			//*/
		} else if(meta == 2) {
			//*
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
					for(int z = this.zCoord-(cubeSize*2+1); z <= this.zCoord-1; z++) {
						tempX = Math.abs(x - (this.xCoord-cubeSize));
						tempZ = Math.abs(z - (this.zCoord-(cubeSize*2+1)));
						tempY = Math.abs(y - (this.yCoord-cubeSize));
						if(!doAlt) {
							storage[tempX+tempY*(cubeSize*2+1)+tempZ*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						} else {
							storageAlt[tempX+tempY*(cubeSize*2+1)+tempZ*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						}
					}
				}
			}
			//*/
		} else if(meta == 3) {
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
					for(int z = this.zCoord+1; z <= this.zCoord+(cubeSize*2+1); z++) {
						tempX = Math.abs(x - (this.xCoord-cubeSize));
						tempZ = Math.abs(z - (this.zCoord+1));
						tempY = Math.abs(y - (this.yCoord-cubeSize));
						if(!doAlt) {
							storage[tempX+tempY*(cubeSize*2+1)+tempZ*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						} else {
							storageAlt[tempX+tempY*(cubeSize*2+1)+tempZ*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						}
					}
				}
			}
		} else if(meta == 4) {
			for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int x = this.xCoord-(cubeSize*2+1); x <= this.xCoord-1; x++) {
						tempY = Math.abs(y - (this.yCoord-cubeSize));
						tempX = Math.abs(x - (this.xCoord-(cubeSize*2+1)));
						tempZ = Math.abs(z - (this.zCoord-cubeSize));
						if(!doAlt) {
							storage[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						} else {
							storageAlt[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						}
					}
				}
			}
		} else if(meta == 5) {
			for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int x = this.xCoord+1; x <= this.xCoord+(cubeSize*2+1); x++) {
						tempY = Math.abs(y - (this.yCoord-cubeSize));
						tempX = Math.abs(x - (this.xCoord+1));
						tempZ = Math.abs(z - (this.zCoord-cubeSize));
						if(!doAlt) {
							storage[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						} else {
							storageAlt[tempX+tempZ*(cubeSize*2+1)+tempY*(cubeSize*2+1)*(cubeSize*2+1)] = new utilBlockInfo(x, y, z, worldObj.getBlockId(x, y, z), worldObj.getBlockMetadata(x, y, z));
						}
					}
				}
			}
		}
	}
	
	public void removeProperArea() {
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		if(meta == 0) {
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int y = this.yCoord-(cubeSize*2+1); y <= this.yCoord-1; y++) {
						worldObj.setBlock(x, y, z, 0, 0, 0x02);
					}
				}
			}
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int y = this.yCoord-(cubeSize*2+1); y <= this.yCoord-1; y++) {
						worldObj.notifyBlocksOfNeighborChange(x, y, z, this.getBlockType().blockID);
					}
				}
			}
		} else if(meta == 1) {
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int y = this.yCoord+1; y <= this.yCoord+(cubeSize*2+1); y++) {
						worldObj.setBlock(x, y, z, 0, 0, 0x02);
					}
				}
			}
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int y = this.yCoord+1; y <= this.yCoord+(cubeSize*2+1); y++) {
						worldObj.notifyBlocksOfNeighborChange(x, y, z, this.getBlockType().blockID);
					}
				}
			}
		} else if(meta == 2) {
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
					for(int z = this.zCoord-(cubeSize*2+1); z <= this.zCoord-1; z++) {
						worldObj.setBlock(x, y, z, 0, 0, 0x02);
					}
				}
			}
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
					for(int z = this.zCoord-(cubeSize*2+1); z <= this.zCoord-1; z++) {
						worldObj.notifyBlocksOfNeighborChange(x, y, z, this.getBlockType().blockID);
					}
				}
			}
		} else if(meta == 3) {
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
					for(int z = this.zCoord+1; z <= this.zCoord+(cubeSize*2+1); z++) {
						worldObj.setBlock(x, y, z, 0, 0, 0x02);
					}
				}
			}
			for(int x = this.xCoord-cubeSize; x <= this.xCoord+cubeSize; x++) {
				for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
					for(int z = this.zCoord+1; z <= this.zCoord+(cubeSize*2+1); z++) {
						worldObj.notifyBlocksOfNeighborChange(x, y, z, this.getBlockType().blockID);
					}
				}
			}
		} else if(meta == 4) {
			for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int x = this.xCoord-(cubeSize*2+1); x <= this.xCoord-1; x++) {
						worldObj.setBlock(x, y, z, 0, 0, 0x02);
					}
				}
			}
			for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int x = this.xCoord-(cubeSize*2+1); x <= this.xCoord-1; x++) {
						worldObj.notifyBlocksOfNeighborChange(x, y, z, this.getBlockType().blockID);
					}
				}
			}
		} else if(meta == 5) {
			for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int x = this.xCoord+1; x <= this.xCoord+(cubeSize*2+1); x++) {
						worldObj.setBlock(x, y, z, 0, 0, 0x02);
					}
				}
			}
			for(int y = this.yCoord-cubeSize; y <= this.yCoord+cubeSize; y++) {
				for(int z = this.zCoord-cubeSize; z <= this.zCoord+cubeSize; z++) {
					for(int x = this.xCoord+1; x <= this.xCoord+(cubeSize*2+1); x++) {
						worldObj.notifyBlocksOfNeighborChange(x, y, z, this.getBlockType().blockID);
					}
				}
			}
		}
	}
	
	public void placePlan(boolean doAlt) {
		if(!doAlt) {
			for(int a = 0; a < storage.length; a++) {
				if(storage[a] != null) {
					this.worldObj.setBlock(storage[a].x, storage[a].y, storage[a].z, storage[a].id, storage[a].meta, 0x02);
					this.worldObj.markBlockForUpdate(storage[a].x, storage[a].y, storage[a].z);
				}
			}
		} else {
			for(int a = 0; a < storageAlt.length; a++) {
				if(storageAlt[a] != null) {
					this.worldObj.setBlock(storageAlt[a].x, storageAlt[a].y, storageAlt[a].z, storageAlt[a].id, storageAlt[a].meta, 0x02);
					this.worldObj.markBlockForUpdate(storageAlt[a].x, storageAlt[a].y, storageAlt[a].z);
				}
			}
		}
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
		nbt.setBoolean("hasPlan", alt);
		nbt.setBoolean("state", state);
		nbt.setBoolean("rotateable", rotateable);
		nbt.setInteger("cubeSize", cubeSize);
		nbt.setIntArray("storage", createIntArray(storage));
		nbt.setIntArray("storageAlt", createIntArray(storageAlt));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		alt = nbt.getBoolean("hasPlan");
		state = nbt.getBoolean("state");
		rotateable = nbt.getBoolean("state");
		cubeSize = nbt.getInteger("cubeSize");
		storage = createBlockInfo(nbt.getIntArray("storage"));
		storageAlt = createBlockInfo(nbt.getIntArray("storageAlt"));
	}
}
