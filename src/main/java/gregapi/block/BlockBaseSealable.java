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

package gregapi.block;

import gregapi.compat.galacticraft.IBlockSealable;
import gregapi.util.UT;
import gregapi.util.WD;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author Gregorius Techneticies
 */
public abstract class BlockBaseSealable extends BlockBase implements IBlockSealable {
	public BlockBaseSealable(Class<? extends ItemBlock> aItemClass, String aNameInternal, Material aMaterial, SoundType aSoundType) {
		super(aItemClass, aNameInternal, aMaterial, aSoundType);
	}
	
	@Override public boolean isSealed(World aWorld, int aX, int aY, int aZ, ForgeDirection aDirection) {return isSealable(WD.meta(aWorld, aX, aY, aZ), (byte)(UT.Code.side(aDirection) ^ 1));}
}
