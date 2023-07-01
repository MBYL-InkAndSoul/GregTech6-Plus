/**
 * Copyright (c) 2019 Gregorius Techneticies
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

import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

/**
 * @author Gregorius Techneticies
 * 
 * This Interface can be used to get the Block with all of its Data in ItemStack form without breaking it into pieces, like harvesting would.
 */
public interface IBlockRetrievable {
	/** Gets the ItemStack representing this Block. Normally one could just check for getDrops, but this Interface is there for cases where the Block drops more than this Item or drops an NBT Item */
	public ItemStack getItemStackFromBlock(IBlockAccess aWorld, int aX, int aY, int aZ, byte aSide);
}
