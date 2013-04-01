package massiveOctoAdventure.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemScrewdriver extends Item{
	private Icon texture;

	public ItemScrewdriver(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
	}

	@Override
	public Icon getIconFromDamage(int damage) {
		return texture;
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		System.out.println(par3World.getBlockMetadata(par4, par5, par6));
        return false;
    }
	
	@Override
	public void updateIcons(IconRegister register) {
		texture = register.registerIcon("massiveoctoadventure:screwDriver");
	}
}
