/**
 * Copyright (c) 2021 GregTech-6 Team
 *
 * This file is part of GregTech6.
 *
 * GregTech6 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech6 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech6. If not, see <http://www.gnu.org/licenses/>.
 */

package gregtech6.items.tools.pocket;

import static gregapi.data.CS.*;

import gregapi.data.MT;
import gregapi.item.multiitem.MultiItemTool;
import gregapi.item.multiitem.behaviors.Behavior_Switch_Metadata;
import gregapi.old.Textures;
import gregapi.render.IIconContainer;
import gregtech6.items.tools.early.GT_Tool_Chisel;
import net.minecraft.item.ItemStack;

public class GT_Tool_Pocket_Chisel extends GT_Tool_Chisel {
	@Override public float getMaxDurabilityMultiplier() {return 4.0F;}
	public final int mSwitchIndex;
	
	public GT_Tool_Pocket_Chisel(int aSwitchIndex) {
		mSwitchIndex = aSwitchIndex;
	}
	
	@Override
	public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
		return aIsToolHead ? Textures.ItemIcons.POCKET_MULTITOOL_CHISEL : Textures.ItemIcons.VOID;
	}
	
	@Override
	public short[] getRGBa(boolean aIsToolHead, ItemStack aStack) {
		return MultiItemTool.getPrimaryMaterial(aStack, MT.Steel).mRGBaSolid;
	}
	
	@Override
	public void onStatsAddedToTool(MultiItemTool aItem, int aID) {
		super.onStatsAddedToTool(aItem, aID);
		aItem.addItemBehavior(aID, new Behavior_Switch_Metadata(mSwitchIndex, T, T));
	}
}