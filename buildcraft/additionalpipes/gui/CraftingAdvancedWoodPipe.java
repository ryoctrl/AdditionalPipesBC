/**
 * BuildCraft is open-source. It is distributed under the terms of the
 * BuildCraft Open Source License. It grants rights to read, modify, compile
 * or run the code. It does *NOT* grant the right to redistribute this software
 * or its modifications in any form, binary or source, except if expressively
 * granted by the copyright holder.
 */

package buildcraft.additionalpipes.gui;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Slot;
import buildcraft.core.gui.BuildCraftContainer;

public class CraftingAdvancedWoodPipe extends BuildCraftContainer {

	IInventory playerIInventory;
	IInventory filterIInventory;

	public CraftingAdvancedWoodPipe (IInventory playerInventory, IInventory filterInventory) {
		super (filterInventory.getSizeInventory());
		playerIInventory = playerInventory;
		filterIInventory = filterInventory;

		int k = 0;

		for(int j1 = 0; j1 < 9; j1++) {
			addSlotToContainer(new Slot(filterInventory, j1 + k * 9, 8 + j1 * 18, 18 + k * 18));
		}


		for(int l = 0; l < 3; l++) {
			for(int k1 = 0; k1 < 9; k1++) {
				addSlotToContainer(new Slot(playerInventory, k1 + l * 9 + 9, 8 + k1 * 18, 76 + l * 18));
			}

		}

		for(int i1 = 0; i1 < 9; i1++) {
			addSlotToContainer(new Slot(playerInventory, i1, 8 + i1 * 18, 134));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

}