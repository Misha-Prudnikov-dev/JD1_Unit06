package by.tc.task01.dao.impl;

import java.util.Map;
import by.tc.task01.entity.criteria.*;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;

public class ApplianceFactory {

	public static Appliance findTypeAppliance(Criteria criteria, Map<String, String> params) {

		Appliance newAppliance = null;
		String titleAppliance = criteria.getGroupSearchName();

		switch (titleAppliance) {

		case "Oven":

			newAppliance = createOven(params);
			break;
		case "Laptop":

			newAppliance = createLaptop(params);
			break;
		case "Refrigerator":

			newAppliance = createRefrigerator(params);
			break;
		case "Speakers":

			newAppliance = createSpeakers(params);
			break;
		case "TabletPC":

			newAppliance = createTabletPC(params);
			break;
		case "VacuumCleaner":

			newAppliance = createVacuumCleaner(params);
			break;

		}
		return newAppliance;
	}

	public static Oven createOven(Map<String, String> params) {

		Oven oven = new Oven("Oven", Integer.parseInt(params.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString())),
				Integer.parseInt(params.get(SearchCriteria.Oven.WEIGHT.toString())),
				Integer.parseInt(params.get(SearchCriteria.Oven.CAPACITY.toString())),
				Integer.parseInt(params.get(SearchCriteria.Oven.DEPTH.toString())),
				Double.parseDouble(params.get(SearchCriteria.Oven.HEIGHT.toString())),
				Double.parseDouble(params.get(SearchCriteria.Oven.WIDTH.toString())));

		return oven;
	}

	public static Laptop createLaptop(Map<String, String> params) {

		Laptop laptop = new Laptop("Laptop",
				Double.parseDouble(params.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString())),
				params.get(SearchCriteria.Laptop.OS.toString()),
				Integer.parseInt(params.get(SearchCriteria.Laptop.MEMORY_ROM.toString())),
				Integer.parseInt(params.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString())),
				Double.parseDouble(params.get(SearchCriteria.Laptop.CPU.toString())),
				Integer.parseInt(params.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString())));

		return laptop;
	}

	public static Refrigerator createRefrigerator(Map<String, String> params) {

		Refrigerator refrigerator = new Refrigerator("Refrigerator",
				Integer.parseInt(params.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString())),
				Integer.parseInt(params.get(SearchCriteria.Refrigerator.WEIGHT.toString())),
				Integer.parseInt(params.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString())),
				Double.parseDouble(params.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString())),
				Integer.parseInt(params.get(SearchCriteria.Refrigerator.HEIGHT.toString())),
				Integer.parseInt(params.get(SearchCriteria.Refrigerator.WIDTH.toString())));

		return refrigerator;
	}

	public static Speakers createSpeakers(Map<String, String> params) {

		Speakers speakers = new Speakers("Speakers",
				Integer.parseInt(params.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString())),
				Integer.parseInt(params.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString())),
				params.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()),
				Integer.parseInt(params.get(SearchCriteria.Speakers.CORD_LENGTH.toString())));

		return speakers;
	}

	public static TabletPC createTabletPC(Map<String, String> params) {

		TabletPC tabletPC = new TabletPC("TabletPC",
				Integer.parseInt(params.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString())),
				Integer.parseInt(params.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString())),
				Integer.parseInt(params.get(SearchCriteria.TabletPC.MEMORY_ROM.toString())),
				Integer.parseInt(params.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString())),
				params.get((SearchCriteria.TabletPC.COLOR.toString())));

		return tabletPC;
	}

	public static VacuumCleaner createVacuumCleaner(Map<String, String> params) {

		VacuumCleaner vacuumCleaner = new VacuumCleaner("VacuumCleaner",
				Integer.parseInt(params.get(SearchCriteria.Oven.POWER_CONSUMPTION.toString())),
				params.get((SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())),
				params.get((SearchCriteria.VacuumCleaner.WAND_TYPE.toString())),
				Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString())),
				Integer.parseInt(params.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString())),
				params.get((SearchCriteria.VacuumCleaner.BAG_TYPE.toString())));

		return vacuumCleaner;
	}
}
