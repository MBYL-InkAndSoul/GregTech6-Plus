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

package gregtech6.items.tools.electric;

import static gregapi.data.CS.*;

import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.item.multiitem.MultiItemTool;
import gregapi.old.Textures;
import gregapi.render.IIconContainer;
import gregapi.util.ST;
import net.minecraft.item.ItemStack;

public class GT_Tool_Wrench_MV extends GT_Tool_Wrench_LV {
	
	public GT_Tool_Wrench_MV(int aSwitchIndex) {
		super(aSwitchIndex);
	}
	
	@Override
	public int getToolDamagePerBlockBreak() {
		return 200;
	}
	
	@Override
	public int getToolDamagePerDropConversion() {
		return 400;
	}
	
	@Override
	public int getToolDamagePerContainerCraft() {
		return 3200;
	}
	
	@Override
	public int getToolDamagePerEntityAttack() {
		return 800;
	}
	
	@Override
	public int getBaseQuality() {
		return 1;
	}
	
	@Override
	public float getBaseDamage() {
		return 1.5F;
	}
	
	@Override
	public float getSpeedMultiplier() {
		return 3.0F;
	}
	
	@Override
	public float getMaxDurabilityMultiplier() {
		return 2.0F;
	}
	
	@Override
	public boolean canBlock() {
		return F;
	}
	
	@Override
	public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
		return aIsToolHead ? Textures.ItemIcons.POWER_UNIT_MV : ST.meta(aStack) % 2 != 0 ? Textures.ItemIcons.VOID : MultiItemTool.getPrimaryMaterial(aStack, MT.Steel).mTextureSetsItems.get(OP.toolHeadWrench.mIconIndexItem);
	}
}