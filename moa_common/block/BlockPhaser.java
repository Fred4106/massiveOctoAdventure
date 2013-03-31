package massiveOctoAdventure.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import massiveOctoAdventure.items.ItemScrewdriver;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPhaser extends Block{
	@SideOnly(Side.CLIENT)
	private Icon frontTexture;
	@SideOnly(Side.CLIENT)
	private Icon otherTexture;
	
	int[] rotationTable = new int[]{1, 2, 4, 3, 5, 0};
	
	public BlockPhaser(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(1F);
		setResistance(1F);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemScrewdriver) {
			int meta = world.getBlockMetadata(x, y, z);
			for(int a = 0; a < rotationTable.length; a++) {
				if(meta == rotationTable[a]) {
					world.setBlockMetadataWithNotify(x, y, z, rotationTable[(a+1)%rotationTable.length], 0x04);
					System.out.println(meta);
					break;
				}
			}
			world.markBlockForRenderUpdate(x, y, z);
			((ItemScrewdriver)player.getHeldItem().getItem()).onWrenched(world, x, y, z, player, player.getHeldItem());
			return true;
		}
		return false;
	}
	
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta) {
		if(side == meta) {
			return frontTexture;
		} else {
			return otherTexture;
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		frontTexture = register.registerIcon("massiveoctoadventure:phaserFront");
		otherTexture = register.registerIcon("massiveoctoadventure:phaserSide");
	}
	
}
