package massiveOctoAdventure.utils;

public class utilBlockInfo {
	public int x, y, z, id, meta;
	
	public utilBlockInfo(int x, int y, int z, int id, int meta) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.id = id;
		this.meta = meta;
	}
	
	public utilBlockInfo(int[] values) {
		this.x = values[0];
		this.y = values[1];
		this.z = values[2];
		this.id = values[3];
		this.meta = values[4];
	}
	
	
	
	public int[] getArray() {
		return new int[] {x, y, z, id, meta};
	}
}
