package massiveOctoAdventure;

import massiveOctoAdventure.block.BlockHandler;
import net.minecraft.creativetab.CreativeTabs;
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
		
		//Initializes TileEntities
		proxy.registerTileEntities();
	}

}