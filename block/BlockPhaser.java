package massiveOctoAdventure.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPhaser extends Block{

	public BlockPhaser(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(1F);
		setResistance(1F);
	}
	
}
