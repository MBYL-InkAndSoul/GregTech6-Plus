/**
 * Copyright (c) 2020 GregTech-6 Team
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

package gregapi.block.metatype;

import static gregapi.data.CS.*;

import gregapi.oredict.OreDictMaterial;
import gregapi.render.IIconContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author Gregorius Techneticies
 */
public abstract class BlockBasePlanksFlammable extends BlockBasePlanks {
	public BlockBasePlanksFlammable(Class<? extends ItemBlock> aItemClass, Material aVanillaMaterial, SoundType aVanillaSoundType, String aNameInternal, String aDefaultLocalised, OreDictMaterial aMaterial, float aResistanceMultiplier, float aHardnessMultiplier, int aHarvestLevel, int aCount, IIconContainer[] aIcons) {
		super(aItemClass, aVanillaMaterial, aVanillaSoundType, aNameInternal, aDefaultLocalised, aMaterial, aResistanceMultiplier, aHardnessMultiplier, aHarvestLevel, aCount, aIcons);
	}
	
	protected BlockBasePlanksFlammable(Class<? extends ItemBlock> aItemClass, Material aVanillaMaterial, SoundType aVanillaSoundType, String aNameInternal, String aDefaultLocalised, OreDictMaterial aMaterial, float aResistanceMultiplier, float aHardnessMultiplier, int aHarvestLevel, int aCount, IIconContainer[] aIcons, byte aSlabType, BlockMetaType aBlock) {
		super(aItemClass, aVanillaMaterial, aVanillaSoundType, aNameInternal, aDefaultLocalised, aMaterial, aResistanceMultiplier, aHardnessMultiplier, aHarvestLevel, aCount, aIcons, aSlabType, aBlock);
	}
	
	@Override public boolean isFireSource(World aWorld, int aX, int aY, int aZ, ForgeDirection aSide) {return F;}
	@Override public int getFlammability(byte aMeta) {return 20;}
	@Override public int getFireSpreadSpeed(byte aMeta) {return 5;}
}
