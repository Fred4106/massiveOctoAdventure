package massiveOctoAdventure;

import massiveOctoAdventure.block.TilePhaser;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerRenders() {}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TilePhaser.class, "moaTilePhaser");
	}

}