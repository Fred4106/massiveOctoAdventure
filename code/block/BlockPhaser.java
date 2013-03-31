package massiveOctoAdventure.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class BlockPhaser extends Block{

	private Icon frontTexture;
	private Icon otherTexture;
	
	public BlockPhaser(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(1F);
		setResistance(1F);
	}
	
	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) {
		ForgeDirection sideForge = ForgeDirection.getOrientation(side);
		return frontTexture;
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		frontTexture = register.registerIcon("massiveoctoadventure:phaserFront");
		otherTexture = register.registerIcon("massiveoctoadventure:phaserFront");
	}
	
}
