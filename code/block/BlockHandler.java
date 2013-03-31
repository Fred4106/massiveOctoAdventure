package massiveOctoAdventure.code.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class BlockHandler {
	
	public static int moaPhaserId = 600;
	
	public static Block moaPhaser;
	
	public static void init() {
		moaPhaser = new BlockPhaser(moaPhaserId).setUnlocalizedName("moaPhaser");
		GameRegistry.registerBlock(moaPhaser, "moaPhaser");
		LanguageRegistry.addName(moaPhaser, "Phaser");
	}
	
}
