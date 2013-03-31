package massiveOctoAdventure.items;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemHandler {
	public static int moaScrewdriverId = 4000;
	
	public static Item moaScrewdriver;
	
	public static void init() {
		moaScrewdriver = new ItemScrewdriver(moaScrewdriverId).setUnlocalizedName("moaScrewdriver");
		GameRegistry.registerItem(moaScrewdriver, "moaScrewdriver");
		LanguageRegistry.addName(moaScrewdriver, "Screwdriver");
	}
}
