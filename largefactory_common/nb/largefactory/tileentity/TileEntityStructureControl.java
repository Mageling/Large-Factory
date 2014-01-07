package nb.largefactory.tileentity;

import java.util.ArrayList;

import nb.largefactory.structure.StructureCreationErrors;
import nb.largefactory.structure.StructureType;
import nb.largefactory.structure.component.ComponentFactory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
	protected String[] componentList = null;
	protected boolean isNotified = false;
	public String resourceLine = null;
	public int timeLine = 0;

	@Override
	public boolean validateStructure(StructureType structureType) {
		if (inStructure) {
			StructureCreationErrors.ALREADY_IN_STRUCTURE.printError(xCoord, yCoord, zCoord);
			return false;
		}
		if (getStructureType() != structureType) {
			StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
			return false;
		}
		if (numAdjacentInner(structureType) == 1) {
			if (numAdjacent(structureType) != 5) {
				StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
				return false;
			}
			if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
				if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
						.getStructureType() == structureType) {
					if (!(worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructure))
						return true;
					else {
						if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
							if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
									.getStructureType() != structureType)
								return true;
						}
					}
					StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
					return false;
				}
			}
			if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
				if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord))
						.getStructureType() == structureType) {
					if (!(worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructure))
						return true;
					else {
						if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityStructureInner) {
							if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord))
									.getStructureType() != structureType)
								return true;
						}
					}
					StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
					return false;
				}
			}
			if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
				if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
						.getStructureType() == structureType) {
					if (!(worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructure))
						return true;
					else {
						if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
							if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
									.getStructureType() != structureType)
								return true;
						}
					}
					StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
					return false;
				}
			}
			if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityStructureInner) {
				if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord))
						.getStructureType() == structureType) {
					if (!(worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructure))
						return true;
					else {
						if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityStructureInner) {
							if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord))
									.getStructureType() != structureType)
								return true;
						}
					}
					StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
					return false;
				}
			}
			if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
				if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
						.getStructureType() == structureType) {
					if (!(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructure))
						return true;
					else {
						if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
							if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
									.getStructureType() != structureType)
								return true;
						}
					}
					StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
					return false;
				}
			}
			if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityStructureInner) {
				if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1))
						.getStructureType() == structureType) {
					if (!(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructure))
						return true;
					else {
						if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityStructureInner) {
							if (((TileEntityStructureInner) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1))
									.getStructureType() != structureType)
								return true;
						}
					}
					StructureCreationErrors.CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
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
				if (z == zCoord)
					return true;
			}
		}
		StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
		return false;
	}

	@Override
	public void onBlockBreak() {
		if (inStructure) {
			deleteStructure();
		}
	}

	private void deleteStructure() {
		for (int[] location : innerBlocks) {
			((TileEntityStructure) worldObj.getBlockTileEntity(location[0], location[1], location[2])).onNotified();
		}
		for (int[] location : casingBlocks) {
			((TileEntityStructure) worldObj.getBlockTileEntity(location[0], location[1], location[2])).onNotified();
		}
		innerBlocks = null;
		casingBlocks = null;
		componentList = null;
		inStructure = false;
	}

	@Override
	public StructureType getStructureType() {
		return ComponentFactory.componentList.get(componentName).getStructureType();
	}

	@Override
	public boolean isFace(StructureType structureType) {
		return getStructureType() == structureType;
	}

	public void createStructure() {
		StructureType structureType = getStructureType();
		ArrayList<int[]> arrayListInner = new ArrayList<int[]>(12);
		ArrayList<int[]> arrayListCasing = new ArrayList<int[]>(12);
		TileEntity te;
		int[] coords;
		int[] coordsBase;
		int innerIndex = 0;
		int casingIndex = 0;

		if (!validateStructure(structureType))
			return;

		coords = coordToArray(xCoord + 1, yCoord, zCoord);
		te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
		if (te instanceof TileEntityStructure) {
			if (te instanceof TileEntityStructureControl) {
				if (((TileEntityStructure) te).getStructureType() == structureType) {
					StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
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
					StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
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
					StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
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
					StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
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
					StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
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
					StructureCreationErrors.TWO_CONTROL_BLOCK.printError(xCoord, yCoord, zCoord);
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

		while (innerIndex < arrayListInner.size() || casingIndex < arrayListCasing.size()) {
			while (innerIndex < arrayListInner.size()) {
				coordsBase = arrayListInner.get(innerIndex);

				if (!((TileEntityStructure) worldObj.getBlockTileEntity(coordsBase[0], coordsBase[1], coordsBase[2]))
						.validateStructure(structureType))
					return;

				coords = coordToArray(coordsBase[0] + 1, coordsBase[1], coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0] - 1, coordsBase[1], coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1] + 1, coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1] - 1, coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1], coordsBase[2] + 1);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1], coordsBase[2] - 1);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				innerIndex++;
				arrayListInner.ensureCapacity(arrayListInner.size() + 6);
			}

			while (casingIndex < arrayListCasing.size()) {
				coordsBase = arrayListCasing.get(casingIndex);

				if (!((TileEntityStructure) worldObj.getBlockTileEntity(coordsBase[0], coordsBase[1], coordsBase[2]))
						.validateStructure(structureType))
					return;

				coords = coordToArray(coordsBase[0] + 1, coordsBase[1], coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0] - 1, coordsBase[1], coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1] + 1, coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1] - 1, coordsBase[2]);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1], coordsBase[2] + 1);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				coords = coordToArray(coordsBase[0], coordsBase[1], coordsBase[2] - 1);
				if (!(arrayListInner.contains(coords) || arrayListCasing.contains(coords))) {
					te = worldObj.getBlockTileEntity(coords[0], coords[1], coords[2]);
					if (te instanceof TileEntityStructure) {
						if (te instanceof TileEntityStructureControl) {
							if (((TileEntityStructure) te).getStructureType() == structureType) {
								StructureCreationErrors.TWO_CONTROL_BLOCK.printError(coordsBase[0], coordsBase[1],
										coordsBase[2]);
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
				}

				casingIndex++;
				arrayListCasing.ensureCapacity(arrayListCasing.size() + 6);
			}
		}

		// final cleanup stuff
		arrayListInner.trimToSize();
		int[][] tempArrayInner = null;
		tempArrayInner = arrayListInner.toArray(tempArrayInner);
		String[] tempComponentList = new String[tempArrayInner.length];
		for (int i = 0; i < tempArrayInner.length; i++) {
			tempComponentList[i] = ((TileEntityStructure) worldObj.getBlockTileEntity(tempArrayInner[i][0],
					tempArrayInner[i][1], tempArrayInner[i][2])).getComponentName();
		}
		if (!structureType.validateStructure(tempComponentList, xCoord, yCoord, zCoord))
			return;

		arrayListCasing.trimToSize();
		int[][] tempArrayCasing = null;
		tempArrayCasing = arrayListCasing.toArray(tempArrayCasing);

		for (int[] location : tempArrayInner) {
			((TileEntityStructure) worldObj.getBlockTileEntity(location[0], location[1], location[2]))
			.setControlBlockLocation(location[0], location[1], location[2]);
			((TileEntityStructure) worldObj.getBlockTileEntity(location[0], location[1], location[2]))
			.setInStructure(true);
		}
		for (int[] location : tempArrayCasing) {
			((TileEntityStructure) worldObj.getBlockTileEntity(location[0], location[1], location[2]))
			.setControlBlockLocation(location[0], location[1], location[2]);
			((TileEntityStructure) worldObj.getBlockTileEntity(location[0], location[1], location[2]))
			.setInStructure(true);
		}

		innerBlocks = tempArrayInner;
		casingBlocks = tempArrayCasing;
		componentList = tempComponentList;
	}

	@Override
	public int[] coordToArray(int x, int y, int z) {
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
			deleteStructure();
			isNotified = false;
		}
	}

	@Override
	protected void notifyControlBlock() {
		onNotified();
	}

	@Override
	protected void removeFromStructure() {
		deleteStructure();
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < componentList.length; ++i) {
			NBTTagCompound nbttagcompound1 = new NBTTagCompound();
			nbttagcompound1.setString("Component List:" + i, componentList[i]);
			nbttaglist.appendTag(nbttagcompound1);
		}

		par1NBTTagCompound.setTag("Component List", nbttaglist);

		nbttaglist = new NBTTagList();

		for (int i = 0; i < innerBlocks.length; ++i) {
			NBTTagCompound nbttagcompound1 = new NBTTagCompound();
			nbttagcompound1.setInteger("Inner Bocks:" + i + ": x", innerBlocks[i][0]);
			nbttagcompound1.setInteger("Inner Bocks:" + i + ": y", innerBlocks[i][1]);
			nbttagcompound1.setInteger("Inner Bocks:" + i + ": z", innerBlocks[i][2]);
			nbttaglist.appendTag(nbttagcompound1);
		}

		par1NBTTagCompound.setTag("Inner Blocks", nbttaglist);

		nbttaglist = new NBTTagList();

		for (int i = 0; i < casingBlocks.length; ++i) {
			NBTTagCompound nbttagcompound1 = new NBTTagCompound();
			nbttagcompound1.setInteger("Casing Bocks:" + i + ": x", casingBlocks[i][0]);
			nbttagcompound1.setInteger("Casing Bocks:" + i + ": y", casingBlocks[i][1]);
			nbttagcompound1.setInteger("Casing Bocks:" + i + ": z", casingBlocks[i][2]);
			nbttaglist.appendTag(nbttagcompound1);
		}

		par1NBTTagCompound.setTag("Casing Blocks", nbttaglist);

		par1NBTTagCompound.setBoolean("Is Notified", isNotified);

		par1NBTTagCompound.setString("Resource Line", resourceLine);

		par1NBTTagCompound.setInteger("Time Line", timeLine);

	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		isNotified = par1NBTTagCompound.getBoolean("Is Notified");

		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Component List");
		componentList = new String[nbttaglist.tagCount()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			componentList[i] = nbttagcompound1.getString("Component List:" + i);

		}

		nbttaglist = par1NBTTagCompound.getTagList("Inner Blocks");
		ArrayList<int[]> tempInnerBlocks = new ArrayList<int[]>(nbttaglist.tagCount());

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			tempInnerBlocks.add(coordToArray(nbttagcompound1.getInteger("Inner Bocks:" + i + ": x"),
					nbttagcompound1.getInteger("Inner Bocks:" + i + ": y"),
					nbttagcompound1.getInteger("Inner Bocks:" + i + ": z")));
		}

		innerBlocks = tempInnerBlocks.toArray(innerBlocks);

		nbttaglist = par1NBTTagCompound.getTagList("Casing Blocks");
		ArrayList<int[]> tempCasingBlocks = new ArrayList<int[]>(nbttaglist.tagCount());

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			tempCasingBlocks.add(coordToArray(nbttagcompound1.getInteger("Casing Bocks:" + i + ": x"),
					nbttagcompound1.getInteger("Casing Bocks:" + i + ": y"),
					nbttagcompound1.getInteger("Casing Bocks:" + i + ": z")));
		}

		casingBlocks = tempCasingBlocks.toArray(casingBlocks);

		resourceLine = par1NBTTagCompound.getString("Resource Line");

		timeLine = par1NBTTagCompound.getInteger("Time Line");

	}

}
