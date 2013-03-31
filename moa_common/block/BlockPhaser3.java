package massiveOctoAdventure.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPhaser3 extends BlockPhaser {

	public BlockPhaser3(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		backTexture = register.registerIcon("massiveoctoadventure:phaserFront3");
		otherTexture = register.registerIcon("massiveoctoadventure:phaserSide");
		frontTexture = register.registerIcon("massiveoctoadventure:phaserBack3");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TilePhaser(3);
	}

}
