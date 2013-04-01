package massiveOctoAdventure.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import massiveOctoAdventure.items.ItemScrewdriver;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockPhaser extends BlockContainer{
	@SideOnly(Side.CLIENT)
	protected Icon frontTexture;
	@SideOnly(Side.CLIENT)
	protected Icon otherTexture;
	@SideOnly(Side.CLIENT)
	protected Icon backTexture;
	
	int[] rotationTable = new int[]{1, 2, 4, 3, 5, 0};
	int[] opRotationTable = new int[]{0, 3, 5, 2, 4, 1};
	
	public BlockPhaser(int id) {
		super(id, Material.iron);
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(1F);
		setResistance(1F);
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, rotationTable[0], 0x02);
	}
	
	public void onNeighborBlockChange(World par1World, int x, int y, int z, int par5) {
		TilePhaser p = (TilePhaser) par1World.getBlockTileEntity(x, y, z);
		if(par1World.isBlockIndirectlyGettingPowered(x, y, z)) {
			if(p.state == false) {
				p.state = true;
				if(!p.alt) {
					p.scanPlan(true);
					p.alt = true;
					p.removeProperArea();
					p.placePlan(false);
					p.placeTE(false);
				} else {
					p.scanPlan(false);
					p.alt = false;
					p.removeProperArea();
					p.placePlan(true);
					p.placeTE(true);
				}
			}
		} else {
			p.state = false;
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		//*
		if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemScrewdriver) {
			int meta = world.getBlockMetadata(x, y, z);
			TilePhaser entity = (TilePhaser) world.getBlockTileEntity(x, y, z);
			if(!entity.rotateable || world.isRemote) {
				return false;
			}
			for(int a = 0; a < rotationTable.length; a++) {
				if(meta == rotationTable[a]) {
					world.setBlockMetadataWithNotify(x, y, z, rotationTable[(a+1)%rotationTable.length], 0x02);
					break;
					
				}
			}
			world.markBlockForRenderUpdate(x, y, z);
			return true;
		}
		/*
		if(player.isSneaking()) {
			TilePhaser entity = (TilePhaser) world.getBlockTileEntity(x, y, z);
			if(!entity.hasPlan()) {
				entity.scanPlan();
				entity.removeProperArea();
			} else {
				entity.placePlan();
			}
			return true;
		}
		//*/
		return false;
	}
	
	private int getOp(int inp) {
		if(inp%2 == 0) {
			return inp+1;
		} else {
			return inp-1;
		}
	}
	
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta) {
		if(side == meta) {
			return frontTexture;
		} else if(side == getOp(meta)){
			return backTexture;
		} else {
			return otherTexture;
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		backTexture = register.registerIcon("massiveoctoadventure:phaserFront");
		otherTexture = register.registerIcon("massiveoctoadventure:phaserSide");
		frontTexture = register.registerIcon("massiveoctoadventure:phaserBack");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TilePhaser(1);
	}
	
}
