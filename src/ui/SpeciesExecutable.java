package ui;

import java.util.Scanner;

import model.Species;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController controller;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		controller = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();
			reader.nextLine();

			switch (mainOption) {

				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:
					deleteSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;

			}

		}

	}

	public void registerSpecies() {

		System.out.println("Type the new Species' name: ");
		String name = reader.nextLine();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		System.out.println("Type the new Species' type:\n 1. Fauna\n 2. Flora");
		int type = reader.nextInt();
		reader.nextLine();

		Boolean success = false;

		if (type == 1) {
			// Especie Fauna
			System.out.println("Is the species migratory?:\n 1. Yes\n 2. No");
			int migratory = reader.nextInt();

			System.out.println("Type the new Species' max weight: ");
			double maxWeight = reader.nextInt();

			System.out.println("Type the new Species' fauna type:\n 1. Bird\n 2. Mammal\n 3. Aquatic Fauna");
			int specificType = reader.nextInt();

			success = controller.registerSpecies(name, scientificName, migratory, maxWeight, specificType);
		}
		if (type == 2) {
			// Especie Flora
			System.out.println("The species have flowers?:\n 1. Yes\n 2. No");
			int flowers = reader.nextInt();

			System.out.println("The species have fruits?:\n 1. Yes\n 2. No");
			int fruits = reader.nextInt();

			System.out.println("Type the new Species' max height: ");
			double maxHeight = reader.nextInt();

			System.out.println("Type the new Species' flora type:\n 1. Land Flora\n 2. Aquatic Flora");
			int specificType = reader.nextInt();

			success = controller.registerSpecies(name, scientificName, flowers, fruits, maxHeight, specificType);
		}

		if (success) {
			System.out.println("Species registered successfully");
		} else {
			System.out.println("Error, Species couldn't be registered");
		}
		System.out.println(controller.showSpeciesList());

	}

	public void editSpecies() {
		String query = controller.showSpeciesList();
		if (!query.equals("")) {
			System.out.println("Which Species do you want to edit?");
			System.out.println(query);
			int selection = reader.nextInt();
			reader.nextLine(); // Consumir el enter

			Species species = controller.getSpecies(selection);
			if (species != null) {
				System.out.println("Editing Species: " + species.getName());
				System.out.println("Type the new Species' name (current: " + species.getName() + "): ");
				String name = reader.nextLine();
				System.out.println(
						"Type the new Species' scientific name (current: " + species.getScientificName() + "): ");
				String scientificName = reader.nextLine();

				System.out.println(
						"Type the new Species' type:\n 1. Fauna\n 2. Flora \n(current: "
								+ controller.getTypeSpecie(species) + "): ");
				int type = reader.nextInt();
				reader.nextLine();

				boolean success = false;

				if (type == 1) {
					System.out.println("Is the species migratory?:\n 1. Yes\n 2. No");
					int migratory = reader.nextInt();
					reader.nextLine();
					System.out.println("Type the new Species' max weight: ");
					double maxWeight = reader.nextDouble();
					reader.nextLine();

					System.out.println(
							"Type the new Species' fauna type:\n1. Bird\n2. Mammal\n3. Aquatic Fauna");
					int specificType = reader.nextInt();
					reader.nextLine();

					success = controller.editSpecies(selection, name, scientificName, migratory, maxWeight,
							specificType);
				} else if (type == 2) {
					System.out.println("The species have flowers?:\n 1. Yes\n 2. No");
					int flowers = reader.nextInt();
					reader.nextLine();

					System.out.println("The species have fruits?:\n 1. Yes\n 2. No");
					int fruits = reader.nextInt();
					reader.nextLine();

					System.out.println("Type the new Species' max height: ");
					double maxHeight = reader.nextDouble();
					reader.nextLine();

					System.out.println("Type the new Species' flora type:\n1. Land Flora\n2. Aquatic Flora");
					int specificType = reader.nextInt();
					reader.nextLine();

					success = controller.editSpecies(selection, name, scientificName, flowers, fruits, maxHeight,
							specificType);
				}

				if (success) {
					System.out.println("Species edited successfully");
					System.out.println(controller.showSpeciesList());
				} else {
					System.out.println("Error, Species couldn't be edited");
				}

			} else {
				System.out.println("Invalid selection");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}
	}

	public void deleteSpecies() {
		String query = controller.showSpeciesList();

		if (!query.equals("")) {
			System.out.println("Which Species do you want to delete?");
			System.out.println(query);
			int deleteSelection = reader.nextInt();
			Boolean success = controller.deleteSpecies(deleteSelection);
			if (success) {
				System.out.println("Species deleted successfully");
			} else {
				System.out.println("Error, Species couldn't be deleted");
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}
