package massiveOctoAdventure;

import massiveOctoAdventure.block.TilePhaser;
import massiveOctoAdventure.block.TilePhaser1;
import massiveOctoAdventure.block.TilePhaser2;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerRenders() {}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TilePhaser.class, "moaTilePhaser");
		GameRegistry.registerTileEntity(TilePhaser1.class, "moaTilePhaser1");
		GameRegistry.registerTileEntity(TilePhaser2.class, "moaTilePhaser2");
	}

}