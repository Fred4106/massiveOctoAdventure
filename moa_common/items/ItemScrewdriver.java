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
		setMaxDamage(200);
	}

	@Override
	public Icon getIconFromDamage(int damage) {
		return texture;
	}
	
	public void onWrenched(World world, int x, int y, int z, EntityPlayer player, ItemStack wrench) {
		if (!player.capabilities.isCreativeMode) {
			wrench.damageItem(1, player);
		}
	}
	
	@Override
	public void updateIcons(IconRegister register) {
		texture = register.registerIcon("massiveoctoadventure:screwDriver");
	}
}
