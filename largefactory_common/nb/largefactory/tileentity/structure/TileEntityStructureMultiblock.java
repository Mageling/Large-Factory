package nb.largefactory.tileentity.structure;

import nb.largefactory.structure.StructureCreationErrors;
import nb.largefactory.structure.StructureType;

public class TileEntityStructureMultiblock extends TileEntityStructureInner {

    public TileEntityStructureMultiblock(String componentName) {
        super(componentName);
    }

    @Override
    public boolean validateStructure(StructureType structureType) {
        if (!super.validateStructure(structureType))
            return false;
        int multiblockType = 0; // TODO function to get the multiblock size and
        // fix case names
        switch (multiblockType) {
        case 0:
            return validate2x2x2Multiblock();
        case 1:
            return validate2x2x1Multiblock();
        case 2:
            return validate2x1x1Multiblock();
        default:
            StructureCreationErrors.OTHER.printError(xCoord, yCoord, zCoord);
            return false;
        }
    }

    private boolean validate2x1x1Multiblock() {
        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                return true;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                return true;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                return true;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                return true;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                return true;
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                return true;
            }
        }
        StructureCreationErrors.INCORRECT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
        return false;
    }

    private boolean validate2x2x1Multiblock() {
        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord + 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord - 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord + 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord - 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord + 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord - 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord + 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord - 1, yCoord, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        StructureCreationErrors.INCORRECT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
        return false;
    }

    private boolean validate2x2x2Multiblock() {
        if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord - 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord + 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord - 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord + 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
            if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
                    .getComponentName() == componentName) {
                if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
                            .getComponentName() == componentName) {
                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                        return false;
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord - 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord - 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord + 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
                if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureMultiblock) {
                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
                            .getComponentName() == componentName) {
                        if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord + 1, zCoord)).getComponentName() == componentName) {
                                StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                return false;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord + 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord - 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureMultiblock) {
                            if (((TileEntityStructureMultiblock) worldObj
                                    .getBlockTileEntity(xCoord, yCoord, zCoord - 1)).getComponentName() == componentName) {
                                if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureMultiblock) {
                                    if (((TileEntityStructureMultiblock) worldObj.getBlockTileEntity(xCoord, yCoord,
                                            zCoord + 1)).getComponentName() == componentName) {
                                        StructureCreationErrors.ADJACENT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }

        StructureCreationErrors.INCORRECT_MULTIBLOCK.printError(xCoord, yCoord, zCoord);
        return false;
    }

}
