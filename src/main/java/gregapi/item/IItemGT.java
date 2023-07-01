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

package gregapi.item;


/**
 * Empty Interface flagging an Item as GregTech6 controlled Item. This essentially means that the Item is more sane and less crash-y.
 * 
 * Setting an Item of this Type to Wildcard Metadata will not cause a Crash.
 * The Internal Name of the Item wont be displayed in the Tooltip.
 * It shows the Mod that a Material based GT Item originally came from.
 * The Item Iteration Loading Step skips over Items with this Interface.
 * Items with this Interface do not trigger visibility of Materials when registered to the OreDict.
 * Blocks can have this marker Interface too, since it is just an empty marker.
 */
public interface IItemGT {
	/**/
}
