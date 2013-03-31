package massiveOctoAdventure.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

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
	public void registerIcons(IconRegister register) {
		frontTexture = register.registerIcon("massiveoctoadventure:phaserFront");
		otherTexture = register.registerIcon("massiveoctoadventure:phaserFront");
	}
	
}
