package fluxedtrinkets.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import fluxedtrinkets.FluxedTrinkets;
import fluxedtrinkets.proxy.ClientProxy;
import fluxedtrinkets.tileEntity.TileEntityTrinketAssembler;

public class BlockTrinketAssembler extends BlockContainer {

	protected BlockTrinketAssembler() {
		super(Material.iron);
		this.setBlockBounds(0, 0, 0, 1, 0.81F, 1);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float par7, float par8, float par9) {
			player.openGui(FluxedTrinkets.instance, 1, world, x, y, z);
			
		return true;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.trinketAssemblerID;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new TileEntityTrinketAssembler();
	}
}
