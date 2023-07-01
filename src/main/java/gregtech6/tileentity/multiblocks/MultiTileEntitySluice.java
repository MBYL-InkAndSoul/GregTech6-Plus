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

package gregtech6.tileentity.multiblocks;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.tileentity.energy.ITileEntityEnergy;
import gregapi.tileentity.machines.ITileEntityAdjacentOnOff;
import gregapi.tileentity.multiblocks.ITileEntityMultiBlockController;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import gregapi.tileentity.multiblocks.TileEntityBase10MultiBlockMachine;
import gregapi.util.WD;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

/**
 * @author Gregorius Techneticies
 */
public class MultiTileEntitySluice extends TileEntityBase10MultiBlockMachine {
	@Override
	public boolean checkStructure2() {
		int
		tMinX = xCoord-(SIDE_X_NEG==mFacing?0:SIDE_X_POS==mFacing?6:1),
		tMinZ = zCoord-(SIDE_Z_NEG==mFacing?0:SIDE_Z_POS==mFacing?6:1),
		tMaxX = xCoord+(SIDE_X_POS==mFacing?0:SIDE_X_NEG==mFacing?6:1),
		tMaxZ = zCoord+(SIDE_Z_POS==mFacing?0:SIDE_Z_NEG==mFacing?6:1),
		tD = (mActive?mFacing+2:mFacing-2);
		
		if (worldObj.blockExists(tMinX, yCoord, tMinZ) && worldObj.blockExists(tMaxX, yCoord+2, tMaxZ)) {
			boolean tSuccess = T;
			for (int tX = tMinX; tX <= tMaxX; tX++) for (int tZ = tMinZ; tZ <= tMaxZ; tZ++) {
				if (SIDES_AXIS_X[mFacing] ? tX == xCoord : tZ == zCoord) {
				if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(this, tX, yCoord  , tZ, 18006, getMultiTileEntityRegistryID(), 1, MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID_OUT)) tSuccess = F;
				} else {
				if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(this, tX, yCoord  , tZ, 18006, getMultiTileEntityRegistryID(), 0, MultiTileEntityMultiBlockPart.NOTHING)) tSuccess = F;
				}
				
				if (SIDES_AXIS_X[mFacing] ? Math.abs(tX-xCoord)==5 && tZ != zCoord : Math.abs(tZ-zCoord)==5 && tX != xCoord) {
				if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(this, tX, yCoord+1, tZ, 18006, getMultiTileEntityRegistryID(), 3, MultiTileEntityMultiBlockPart.ONLY_ENERGY_IN)) tSuccess = F;
				} else {
				if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(this, tX, yCoord+1, tZ, 18006, getMultiTileEntityRegistryID(), 0, MultiTileEntityMultiBlockPart.NOTHING)) tSuccess = F;
				}
				
				if (SIDES_AXIS_X[mFacing] ? Math.abs(tX-xCoord)==6 : Math.abs(tZ-zCoord)==6) {
				if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(this, tX, yCoord+2, tZ, 18106, getMultiTileEntityRegistryID(),tD, MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID_IN)) tSuccess = F;
				} else {
				if (!ITileEntityMultiBlockController.Util.checkAndSetTarget(this, tX, yCoord+2, tZ, 18106, getMultiTileEntityRegistryID(),tD, MultiTileEntityMultiBlockPart.NOTHING)) tSuccess = F;
				}
			}
			return tSuccess;
		}
		return mStructureOkay;
	}
	
	static {
		LH.add("gt.tooltip.multiblock.sluice.1", "Two 3x7 Layers of Titanium Walls");
		LH.add("gt.tooltip.multiblock.sluice.2", "3x7 Layer of Sluice Parts ontop of that");
		LH.add("gt.tooltip.multiblock.sluice.3", "Main Block centered on Slim-Side-Bottom and facing outwards");
		LH.add("gt.tooltip.multiblock.sluice.4", "Input only at the Top of the Far Side");
		LH.add("gt.tooltip.multiblock.sluice.5", "Output only at the Bottom of the Close Side");
	}
	
	@Override
	public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
		aList.add(Chat.CYAN     + LH.get(LH.STRUCTURE) + ":");
		aList.add(Chat.WHITE    + LH.get("gt.tooltip.multiblock.sluice.1"));
		aList.add(Chat.WHITE    + LH.get("gt.tooltip.multiblock.sluice.2"));
		aList.add(Chat.WHITE    + LH.get("gt.tooltip.multiblock.sluice.3"));
		aList.add(Chat.WHITE    + LH.get("gt.tooltip.multiblock.sluice.4"));
		aList.add(Chat.WHITE    + LH.get("gt.tooltip.multiblock.sluice.5"));
		super.addToolTips(aList, aStack, aF3_H);
	}
	
	@Override
	public boolean isInsideStructure(int aX, int aY, int aZ) {
		return
		aX >= xCoord-(SIDE_X_NEG==mFacing?0:SIDE_X_POS==mFacing?6:1) &&
		aY >= yCoord   &&
		aZ >= zCoord-(SIDE_Z_NEG==mFacing?0:SIDE_Z_POS==mFacing?6:1) &&
		aX <= xCoord+(SIDE_X_POS==mFacing?0:SIDE_X_NEG==mFacing?6:1) &&
		aY <= yCoord+2 &&
		aZ <= zCoord+(SIDE_Z_POS==mFacing?0:SIDE_Z_NEG==mFacing?6:1);
	}
	
	@Override
	public void updateAdjacentToggleableEnergySources() {
		DelegatorTileEntity<TileEntity> tDelegator;
		if (SIDES_AXIS_X[mFacing]) {
			tDelegator = WD.te(worldObj, getOffsetXN(mFacing, 5), yCoord+1, zCoord - 2, SIDE_Z_POS, F);
			if (tDelegator.mTileEntity instanceof ITileEntityAdjacentOnOff && tDelegator.mTileEntity instanceof ITileEntityEnergy && ((ITileEntityEnergy)tDelegator.mTileEntity).isEnergyEmittingTo(mEnergyTypeAccepted, tDelegator.mSideOfTileEntity, T)) ((ITileEntityAdjacentOnOff)tDelegator.mTileEntity).setAdjacentOnOff(getStateOnOff());
			tDelegator = WD.te(worldObj, getOffsetXN(mFacing, 5), yCoord+1, zCoord + 2, SIDE_Z_NEG, F);
			if (tDelegator.mTileEntity instanceof ITileEntityAdjacentOnOff && tDelegator.mTileEntity instanceof ITileEntityEnergy && ((ITileEntityEnergy)tDelegator.mTileEntity).isEnergyEmittingTo(mEnergyTypeAccepted, tDelegator.mSideOfTileEntity, T)) ((ITileEntityAdjacentOnOff)tDelegator.mTileEntity).setAdjacentOnOff(getStateOnOff());
		} else {
			tDelegator = WD.te(worldObj, xCoord - 2, yCoord+1, getOffsetZN(mFacing, 5), SIDE_X_POS, F);
			if (tDelegator.mTileEntity instanceof ITileEntityAdjacentOnOff && tDelegator.mTileEntity instanceof ITileEntityEnergy && ((ITileEntityEnergy)tDelegator.mTileEntity).isEnergyEmittingTo(mEnergyTypeAccepted, tDelegator.mSideOfTileEntity, T)) ((ITileEntityAdjacentOnOff)tDelegator.mTileEntity).setAdjacentOnOff(getStateOnOff());
			tDelegator = WD.te(worldObj, xCoord + 2, yCoord+1, getOffsetZN(mFacing, 5), SIDE_X_NEG, F);
			if (tDelegator.mTileEntity instanceof ITileEntityAdjacentOnOff && tDelegator.mTileEntity instanceof ITileEntityEnergy && ((ITileEntityEnergy)tDelegator.mTileEntity).isEnergyEmittingTo(mEnergyTypeAccepted, tDelegator.mSideOfTileEntity, T)) ((ITileEntityAdjacentOnOff)tDelegator.mTileEntity).setAdjacentOnOff(getStateOnOff());
		}
	}
	
	@Override
	public DelegatorTileEntity<IFluidHandler> getFluidOutputTarget(byte aSide, Fluid aOutput) {
		return getAdjacentTank(SIDE_BOTTOM);
	}
	
	@Override
	public DelegatorTileEntity<TileEntity> getItemOutputTarget(byte aSide) {
		return getAdjacentTileEntity(SIDE_BOTTOM);
	}
	
	@Override public DelegatorTileEntity<IInventory> getItemInputTarget(byte aSide) {return null;}
	@Override public DelegatorTileEntity<IFluidHandler> getFluidInputTarget(byte aSide) {return null;}
	
	@Override public boolean refreshStructureOnActiveStateChange() {return T;}
	
	@Override public String getTileEntityName() {return "gt.multitileentity.multiblock.sluice";}
}
