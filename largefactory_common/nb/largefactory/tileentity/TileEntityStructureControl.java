package nb.largefactory.tileentity;

import java.util.ArrayList;

import nb.largefactory.structure.StructureCreationErrors;
import nb.largefactory.structure.StructureType;
import nb.largefactory.xml.XMLDecoder;
import net.minecraft.tileentity.TileEntity;

public class TileEntityStructureControl extends TileEntityStructure {

    public TileEntityStructureControl(String componentName) {
        super(componentName);
        controlBlockLocation = new int[3];
        controlBlockLocation[0] = xCoord;
        controlBlockLocation[1] = yCoord;
        controlBlockLocation[2] = zCoord;
    }

    protected int[][] innerBlocks = null;
    protected int[][] casingBlocks = null;
    protected boolean isNotified = false;

    @Override
    public boolean validateStructure(StructureType structureType) {
        if (this.getStructureType() != structureType) {
            StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord,
                    zCoord);
            return false;
        }
        if (numAdjacentInner(structureType) == 1) {
            if (numAdjacent(structureType) != 5) {
                StructureCreationErrors.CONTROL_BLOCK.printError(xCoord,
                        yCoord, zCoord);
                return false;
            }
            if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord + 1, yCoord, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord - 1, yCoord,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord - 1, yCoord,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    StructureCreationErrors.CONTROL_BLOCK.printError(xCoord,
                            yCoord, zCoord);
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord - 1, yCoord, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord + 1, yCoord,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord + 1, yCoord,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    StructureCreationErrors.CONTROL_BLOCK.printError(xCoord,
                            yCoord, zCoord);
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord + 1, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord - 1,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    StructureCreationErrors.CONTROL_BLOCK.printError(xCoord,
                            yCoord, zCoord);
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord - 1, zCoord)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord + 1,
                            zCoord) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1,
                                zCoord) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1,
                                            zCoord)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    StructureCreationErrors.CONTROL_BLOCK.printError(xCoord,
                            yCoord, zCoord);
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord, zCoord + 1)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord,
                            zCoord - 1) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord,
                                zCoord - 1) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord,
                                            zCoord - 1)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    StructureCreationErrors.CONTROL_BLOCK.printError(xCoord,
                            yCoord, zCoord);
                    return false;
                }
            }
            if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
                if (((TileEntityStructureInner) worldObj.getBlockTileEntity(
                        xCoord, yCoord, zCoord - 1)).getStructureType() == structureType) {
                    if (!(worldObj.getBlockTileEntity(xCoord, yCoord,
                            zCoord + 1) instanceof TileEntityStructure)) {
                        return true;
                    } else {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord,
                                zCoord + 1) instanceof TileEntityStructureInner) {
                            if (((TileEntityStructureInner) worldObj
                                    .getBlockTileEntity(xCoord, yCoord,
                                            zCoord + 1)).getStructureType() != structureType) {
                                return true;
                            }
                        }
                    }
                    StructureCreationErrors.CONTROL_BLOCK.printError(xCoord,
                            yCoord, zCoord);
                    return false;
                }
            }
        }
        StructureCreationErrors.OTHER.printError(xCoord, yCoord, zCoord);
        return false;
    }

    @Override
    public boolean setControlBlockLocation(int x, int y, int z) {
        if (x == xCoord) {
            if (y == yCoord) {
                if (z == zCoord) {
                    return true;
                }
            }
        }
        StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord,
                zCoord);
        return false;
    }

    @Override
    public void onBlockBreak() {
        if (inStructure) {
            this.deleteStructure();
        }
    }

    private void deleteStructure() {
        // TODO Auto-generated method stub

    }

    @Override
    public StructureType getStructureType() {
        return XMLDecoder.getStructureType(componentName);
    }

    @Override
    public boolean isFace(StructureType structureType) {
        return this.getStructureType() == structureType;
    }

    public void createStructure() {
        StructureType structureType = this.getStructureType();
        ArrayList<int[]> arrayListInner = new ArrayList<int[]>();
        ArrayList<int[]> arrayListCasing = new ArrayList<int[]>();
        TileEntity te;
        int[] coords;
        int[] coordsBase;
        int innerIndex = 0;
        int casingIndex = 0;

        if (!this.validateStructure(structureType)) {
            return;
        }

        coords = coordToArray(xCoord + 1, yCoord, zCoord);
        te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
        if (te instanceof TileEntityStructure) {
            if (te instanceof TileEntityStructureControl) {
                if (((TileEntityStructure) te).getStructureType() == structureType) {
                    StructureCreationErrors.TWO_CONTROL_BLOCK.printError(
                            xCoord, yCoord, zCoord);
                    return;
                }
            } else {
                if (te instanceof TileEntityStructureInner) {
                    if (((TileEntityStructure) te).getStructureType() == structureType) {
                        arrayListInner.add(coords);
                    }
                } else {
                    if (te instanceof TileEntityStructureCasing) {
                        arrayListCasing.add(coords);
                    }
                }
            }
        }

        coords = coordToArray(xCoord - 1, yCoord, zCoord);
        te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
        if (te instanceof TileEntityStructure) {
            if (te instanceof TileEntityStructureControl) {
                if (((TileEntityStructure) te).getStructureType() == structureType) {
                    StructureCreationErrors.TWO_CONTROL_BLOCK.printError(
                            xCoord, yCoord, zCoord);
                    return;
                }
            } else {
                if (te instanceof TileEntityStructureInner) {
                    if (((TileEntityStructure) te).getStructureType() == structureType) {
                        arrayListInner.add(coords);
                    }
                } else {
                    if (te instanceof TileEntityStructureCasing) {
                        arrayListCasing.add(coords);
                    }
                }
            }
        }

        coords = coordToArray(xCoord, yCoord + 1, zCoord);
        te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
        if (te instanceof TileEntityStructure) {
            if (te instanceof TileEntityStructureControl) {
                if (((TileEntityStructure) te).getStructureType() == structureType) {
                    StructureCreationErrors.TWO_CONTROL_BLOCK.printError(
                            xCoord, yCoord, zCoord);
                    return;
                }
            } else {
                if (te instanceof TileEntityStructureInner) {
                    if (((TileEntityStructure) te).getStructureType() == structureType) {
                        arrayListInner.add(coords);
                    }
                } else {
                    if (te instanceof TileEntityStructureCasing) {
                        arrayListCasing.add(coords);
                    }
                }
            }
        }

        coords = coordToArray(xCoord, yCoord - 1, zCoord);
        te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
        if (te instanceof TileEntityStructure) {
            if (te instanceof TileEntityStructureControl) {
                if (((TileEntityStructure) te).getStructureType() == structureType) {
                    StructureCreationErrors.TWO_CONTROL_BLOCK.printError(
                            xCoord, yCoord, zCoord);
                    return;
                }
            } else {
                if (te instanceof TileEntityStructureInner) {
                    if (((TileEntityStructure) te).getStructureType() == structureType) {
                        arrayListInner.add(coords);
                    }
                } else {
                    if (te instanceof TileEntityStructureCasing) {
                        arrayListCasing.add(coords);
                    }
                }
            }
        }

        coords = coordToArray(xCoord, yCoord, zCoord + 1);
        te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
        if (te instanceof TileEntityStructure) {
            if (te instanceof TileEntityStructureControl) {
                if (((TileEntityStructure) te).getStructureType() == structureType) {
                    StructureCreationErrors.TWO_CONTROL_BLOCK.printError(
                            xCoord, yCoord, zCoord);
                    return;
                }
            } else {
                if (te instanceof TileEntityStructureInner) {
                    if (((TileEntityStructure) te).getStructureType() == structureType) {
                        arrayListInner.add(coords);
                    }
                } else {
                    if (te instanceof TileEntityStructureCasing) {
                        arrayListCasing.add(coords);
                    }
                }
            }
        }

        coords = coordToArray(xCoord, yCoord, zCoord - 1);
        te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
        if (te instanceof TileEntityStructure) {
            if (te instanceof TileEntityStructureControl) {
                if (((TileEntityStructure) te).getStructureType() == structureType) {
                    StructureCreationErrors.TWO_CONTROL_BLOCK.printError(
                            xCoord, yCoord, zCoord);
                    return;
                }
            } else {
                if (te instanceof TileEntityStructureInner) {
                    if (((TileEntityStructure) te).getStructureType() == structureType) {
                        arrayListInner.add(coords);
                    }
                } else {
                    if (te instanceof TileEntityStructureCasing) {
                        arrayListCasing.add(coords);
                    }
                }
            }
        }

        while (innerIndex < arrayListInner.size()
                || casingIndex < arrayListCasing.size()) {
            while (innerIndex < arrayListInner.size()) {
                coordsBase = arrayListInner.get(innerIndex);

                if (!((TileEntityStructure) worldObj.getBlockTileEntity(
                        coordsBase[0], coordsBase[1], coordsBase[2]))
                        .validateStructure(structureType)) {
                    return;
                }

                coords = coordToArray(coordsBase[0] + 1, coordsBase[1],
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0] - 1, coordsBase[1],
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1] + 1,
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1] - 1,
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1],
                        coordsBase[2] + 1);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1],
                        coordsBase[2] - 1);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                innerIndex++;
            }

            while (casingIndex < arrayListCasing.size()) {
                coordsBase = arrayListCasing.get(casingIndex);

                if (!((TileEntityStructure) worldObj.getBlockTileEntity(
                        coordsBase[0], coordsBase[1], coordsBase[2]))
                        .validateStructure(structureType)) {
                    return;
                }

                coords = coordToArray(coordsBase[0] + 1, coordsBase[1],
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0] - 1, coordsBase[1],
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1] + 1,
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1] - 1,
                        coordsBase[2]);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1],
                        coordsBase[2] + 1);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                coords = coordToArray(coordsBase[0], coordsBase[1],
                        coordsBase[2] - 1);
                if (!(arrayListInner.contains(coords) || arrayListCasing
                        .contains(coords))) {
                    te = worldObj.getBlockTileEntity(coords[0], coords[1],
                            coords[2]);
                    if (te instanceof TileEntityStructure) {
                        if (te instanceof TileEntityStructureControl) {
                            if (((TileEntityStructure) te).getStructureType() == structureType) {
                                StructureCreationErrors.TWO_CONTROL_BLOCK
                                        .printError(coordsBase[0],
                                                coordsBase[1], coordsBase[2]);
                                return;
                            }
                        } else {
                            if (te instanceof TileEntityStructureInner) {
                                if (((TileEntityStructure) te)
                                        .getStructureType() == structureType) {
                                    arrayListInner.add(coords);
                                }
                            } else {
                                if (te instanceof TileEntityStructureCasing) {
                                    arrayListCasing.add(coords);
                                }
                            }
                        }
                    }
                }

                casingIndex++;
            }
        }

        // TODO final cleanup stuff
    }

    private int[] coordToArray(int x, int y, int z) {
        int[] array = new int[3];
        array[0] = x;
        array[1] = y;
        array[2] = z;
        return array;
    }

    @Override
    public void onNotified() {
        if (!isNotified) {
            isNotified = true;
            this.deleteStructure();
            isNotified = false;
        }
    }

    @Override
    protected void notifyControlBlock() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void removeFromStructure() {
        // TODO Auto-generated method stub

    }
}
