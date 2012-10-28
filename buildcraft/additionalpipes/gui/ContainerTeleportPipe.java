package buildcraft.additionalpipes.gui;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import buildcraft.additionalpipes.pipes.PipeTeleport;
import buildcraft.transport.TileGenericPipe;

public class ContainerTeleportPipe extends Container {

	private PipeTeleport pipe;
	private int freq = 0;
	private boolean canReceive = false;

	public ContainerTeleportPipe(TileGenericPipe tile) {
		pipe = (PipeTeleport) tile.pipe;
		canReceive = !pipe.logic.canReceive;
		freq = -1;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void updateCraftingResults() {
		super.updateCraftingResults();
		for (Object crafter : crafters) {
			if(freq != pipe.logic.freq) {
				((ICrafting) crafter).updateCraftingInventoryInfo(this, 0, pipe.logic.freq);
			}
			if(canReceive != pipe.logic.canReceive) {
				((ICrafting) crafter).updateCraftingInventoryInfo(this, 1, pipe.logic.canReceive ? 1 : 0);
			}
		}
		canReceive = pipe.logic.canReceive;
		freq = pipe.logic.freq;
	}

	@Override
	public void updateProgressBar(int i, int j) {
		switch(i) {
		case 1:
			pipe.logic.freq = j;
			break;
		case 2:
			pipe.logic.canReceive = (j == 1);
			break;
		}
	}

}
