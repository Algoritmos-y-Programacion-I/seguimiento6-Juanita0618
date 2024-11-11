package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	// para el caso de fauna
	public Boolean registerSpecies(String name, String scientificName, int migratory, double maxWeight,
			int specificType) {

		Boolean migratoryBool;
		if (migratory == 1) {
			migratoryBool = true;
		} else {
			migratoryBool = false;
		}

		SpeciesType type;
		switch (specificType) {
			case 1:
				type = SpeciesType.BIRD;
				break;
			case 2:
				type = SpeciesType.MAMMAL;
				break;
			case 3:
				type = SpeciesType.AQUATIC_FAUNA;
				break;
			default:
				return false;
		}
		SpeciesFauna newSpecies = new SpeciesFauna(name, scientificName, type, migratoryBool, maxWeight);
		return addSpecies(newSpecies);
	}

	// para el caso de flora
	public Boolean registerSpecies(String name, String scientificName, int flowers, int fruits, double maxHeight,
			int specificType) {
		Boolean flowersBool;
		if (flowers == 1) {
			flowersBool = true;
		} else {
			flowersBool = false;
		}

		Boolean fruitsBool;
		if (fruits == 1) {
			fruitsBool = true;
		} else {
			fruitsBool = false;
		}

		SpeciesType type;
		switch (specificType) {
			case 1:
				type = SpeciesType.BIRD;
				break;
			case 2:
				type = SpeciesType.MAMMAL;
				break;
			case 3:
				type = SpeciesType.AQUATIC_FAUNA;
				break;
			default:
				return false;
		}
		SpeciesFlora newSpecies = new SpeciesFlora(name, scientificName, type, flowersBool, fruitsBool, maxHeight);
		return addSpecies(newSpecies);
	}

	public boolean addSpecies(Species newSpecies) {

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = newSpecies;
				return true;
			}

		}

		return false;

	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg +=(i + 1) + ". " + species[i].getName()+"\n";
			}
		}

		return msg;

	}

	public Boolean deleteSpecies(int i) {
		int position = i - 1;
		if (species[position] != null) {
			species[position] = null;
			return true;
		}
		return false;

	}

	// case fauna
	public Boolean editSpecies(int selection, String name, String scientificName, int migratory, double maxWeight,
			int specificType) {
		int position = selection - 1;

		Boolean migratoryBool;
		if (migratory == 1) {
			migratoryBool = true;
		} else {
			migratoryBool = false;
		}

		SpeciesType type;
		switch (specificType) {
			case 1:
				type = SpeciesType.BIRD;
				break;
			case 2:
				type = SpeciesType.MAMMAL;
				break;
			case 3:
				type = SpeciesType.AQUATIC_FAUNA;
				break;
			default:
				return false;
		}
		SpeciesFauna updatedSpecies = new SpeciesFauna(name, scientificName, type, migratoryBool, maxWeight);

		if (species[position] != null) {
			species[position] = updatedSpecies;
			return true;
		}
		return false;
	}

	// case flora
	public Boolean editSpecies(int selection, String name, String scientificName, int flowers, int fruits,
			double maxHeight,
			int specificType) {
		int position = selection - 1;

		Boolean flowersBool;
		if (flowers == 1) {
			flowersBool = true;
		} else {
			flowersBool = false;
		}

		Boolean fruitsBool;
		if (fruits == 1) {
			fruitsBool = true;
		} else {
			fruitsBool = false;
		}

		SpeciesType type;
		switch (specificType) {
			case 1:
				type = SpeciesType.BIRD;
				break;
			case 2:
				type = SpeciesType.MAMMAL;
				break;
			case 3:
				type = SpeciesType.AQUATIC_FAUNA;
				break;
			default:
				return false;
		}
		SpeciesFlora updatedSpecies = new SpeciesFlora(name, scientificName, type, flowersBool, fruitsBool, maxHeight);

		if (species[position] != null) {
			species[position] = updatedSpecies;
			return true;
		}
		return false;
	}

	public Species getSpecies(int i) {
		int posicion = i - 1;
		if (species[posicion] != null) {
			return species[posicion];
		}
		return null;
	}

	public String getTypeSpecie(Species speciesSelected) {
		String msg = "";
		if (speciesSelected instanceof SpeciesFauna) {
			msg = "Fauna";
		} else {
			msg = "Flora";
		}
		return msg;
	}

}
