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

package gregtech6.items.behaviors;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.block.IPrefixBlock;
import gregapi.data.LH;
import gregapi.item.multiitem.MultiItem;
import gregapi.item.multiitem.behaviors.IBehavior;
import gregapi.item.multiitem.behaviors.IBehavior.AbstractBehaviorDefault;
import gregapi.tileentity.ITileEntity;
import gregapi.util.WD;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Behavior_Worldgen_Debugger extends AbstractBehaviorDefault {
	public static final IBehavior<MultiItem> INSTANCE = new Behavior_Worldgen_Debugger();
	
	@Override
	public boolean onItemUseFirst(MultiItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, byte aSide, float hitX, float hitY, float hitZ) {
		if (aWorld.isRemote) return F;
		for (int tX = (aX&~15), eX = (aX&~15)+16; tX < eX; tX++) for (int tZ = (aZ&~15), eZ = (aZ&~15)+16; tZ < eZ; tZ++) for (int tY = 1; tY < 250; tY++) {
			Block tBlock = WD.block(aWorld, tX, tY, tZ);
			if (tBlock instanceof IPrefixBlock) {
				TileEntity aTileEntity = aWorld.getTileEntity(tX, tY, tZ);
				if (aTileEntity instanceof ITileEntity) ((ITileEntity)aTileEntity).onAdjacentBlockChange(tX, tY, tZ);
			} else {
				WD.set(aWorld, tX, tY, tZ, NB, 0, 2);
			}
		}
		return T;
	}
	
	static {
		LH.add("gt.behaviour.worldgendebug", "Testing Tool for executing Code based on Coordinates");
	}
	
	@Override
	public List<String> getAdditionalToolTips(MultiItem aItem, List<String> aList, ItemStack aStack) {
		aList.add(LH.get("gt.behaviour.worldgendebug"));
		aList.add("Currently deletes a single Chunk, except for bottom most Bedrock and GT6 Ores");
		return aList;
	}
}
