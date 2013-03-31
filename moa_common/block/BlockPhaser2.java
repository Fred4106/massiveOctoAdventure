package massiveOctoAdventure.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPhaser2 extends BlockPhaser{

	public BlockPhaser2(int id) {
		super(id);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		backTexture = register.registerIcon("massiveoctoadventure:phaserFront2");
		otherTexture = register.registerIcon("massiveoctoadventure:phaserSide");
		frontTexture = register.registerIcon("massiveoctoadventure:phaserBack2");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TilePhaser(2);
	}

}
