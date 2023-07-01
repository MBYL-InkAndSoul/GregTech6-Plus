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

package gregapi.tileentity.render;

import gregapi.tileentity.ITileEntityUnloadable;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

/**
 * @author Gregorius Techneticies
 */
public interface ITileEntityOnDrawBlockHighlight extends ITileEntityUnloadable {
	/** Gets called Client Side, when you mouse over this TileEntity. return true to prevent other things from rendering. */
	public boolean onDrawBlockHighlight(DrawBlockHighlightEvent aEvent);
}
