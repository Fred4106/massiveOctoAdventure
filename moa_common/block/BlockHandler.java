package massiveOctoAdventure.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class BlockHandler {
	
	public static int moaPhaserId = 600;
	public static int moaPhaserId2 = 601;
	public static int moaPhaserId3 = 602;
	
	public static Block moaPhaser;
	public static Block moaPhaser1;
	public static Block moaPhaser2;
	
	public static void init() {
		moaPhaser = new BlockPhaser(moaPhaserId).setUnlocalizedName("moaPhaser");
		GameRegistry.registerBlock(moaPhaser, "moaPhaser");
		LanguageRegistry.addName(moaPhaser, "Low power phaser");
		
		moaPhaser1 = new BlockPhaser2(moaPhaserId2).setUnlocalizedName("moaPhaser1");
		GameRegistry.registerBlock(moaPhaser1, "moaPhaser1");
		LanguageRegistry.addName(moaPhaser1, "Medium power Phaser");
		
		moaPhaser2 = new BlockPhaser3(moaPhaserId3).setUnlocalizedName("moaPhaser2");
		GameRegistry.registerBlock(moaPhaser2, "moaPhaser2");
		LanguageRegistry.addName(moaPhaser2, "High power Phaser");
	}
	
}
