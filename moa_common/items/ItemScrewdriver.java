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
	
	@Override
	public void updateIcons(IconRegister register) {
		texture = register.registerIcon("massiveoctoadventure:screwDriver");
	}
}
