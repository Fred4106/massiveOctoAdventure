package massiveOctoAdventure;

import massiveOctoAdventure.block.BlockHandler;
import massiveOctoAdventure.items.ItemHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="MOA", name="MassiveOctoAdventure", version="0.0.1")
@NetworkMod(serverSideRequired=true, clientSideRequired=true, packetHandler=MoaPacketHandler.class)
public class MassiveOctoAdventure {
	@Instance("MOA")
	public static MassiveOctoAdventure instance;
	@SidedProxy(serverSide="massiveOctoAdventure.CommonProxy", clientSide="massiveOctoAdventure.ClientProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent e) {
		//Config stuffs
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		try {
			config.load();
			BlockHandler.moaPhaserId = config.get("Blocks", "Small Phaser", BlockHandler.moaPhaserId).getInt();
			BlockHandler.moaPhaserId1 = config.get("Blocks", "Med Phaser", BlockHandler.moaPhaserId1).getInt();
			BlockHandler.moaPhaserId2 = config.get("Blocks", "Large Phaser", BlockHandler.moaPhaserId2).getInt();
			ItemHandler.moaScrewdriverId = config.get("Items", "ScrewDriver", ItemHandler.moaScrewdriverId).getInt();
		} catch(Exception ex) {
			
		} finally {
			if (config.hasChanged()) {
				config.save();
			}
		}
	}
	
	@Init
	public void init(FMLInitializationEvent e) {
		
		//Do creative tab here
		
		//Initialize blocks
		BlockHandler.init();
		
		//Initialize items
		ItemHandler.init();
		
		GameRegistry.addRecipe(new ItemStack(BlockHandler.moaPhaser), "XGX", "XRX", "XXX", 'X', new ItemStack(Item.ingotIron, 1), 'G', new ItemStack(Block.glass, 1), 'R', new ItemStack(Item.redstone, 1));
		GameRegistry.addRecipe(new ItemStack(BlockHandler.moaPhaser1), "XGX", "XRX", "XXX", 'X', new ItemStack(Item.ingotGold, 1), 'G', new ItemStack(Block.glass, 1), 'R', new ItemStack(BlockHandler.moaPhaser, 1));
		GameRegistry.addRecipe(new ItemStack(BlockHandler.moaPhaser2), "XGX", "XRX", "XXX", 'X', new ItemStack(Item.diamond, 1), 'G', new ItemStack(Block.glass, 1), 'R', new ItemStack(BlockHandler.moaPhaser1, 1));
		GameRegistry.addRecipe(new ItemStack(ItemHandler.moaScrewdriver), "X", "I", 'X', new ItemStack(Item.ingotIron, 1), 'I', new ItemStack(Item.stick, 1));
		
		//Initializes TileEntities
		proxy.registerTileEntities();
	}

}