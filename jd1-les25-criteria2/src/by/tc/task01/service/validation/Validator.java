package by.tc.task01.service.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria.Oven;
import by.tc.task01.entity.criteria.SearchCriteria.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner;

public class Validator {

	public static boolean criteriaValidator(Criteria criteria) {

		boolean b = false;

		String titleAppliance = criteria.getGroupSearchName();

		switch (titleAppliance) {

		case "Oven":

			b = ovenValid(criteria);
			break;
		case "Laptop":

			b = laptopValid(criteria);
			break;
		case "Refrigerator":

			b = refrigeratorValid(criteria);
			break;
		case "Speakers":

			b = speakerValid(criteria);
			break;
		case "TabletPC":

			b = tabletPCValid(criteria);
			break;
		case "VacuumCleaner":

			b = vacuumCleanerValid(criteria);
			break;

		}
		return b;

	}

	public static boolean ovenValid(Criteria criteria) {

		Map<String, String> validator = new HashMap<String, String>();
		validator.put(Oven.POWER_CONSUMPTION.toString(), "[0-9]{3,4}");
		validator.put(Oven.WEIGHT.toString(), "[0-9]{2,3}");
		validator.put(Oven.CAPACITY.toString(), "[0-9]{2,3}");
		validator.put(Oven.DEPTH.toString(), "[0-9]{2,3}");
		validator.put(Oven.HEIGHT.toString(), "[0-9]{1,2}\\.[0-9]");
		validator.put(Oven.WIDTH.toString(), "[0-9]{1,2}\\.[0-9]");

		return paramsValid(validator, criteria);

	}

	public static boolean laptopValid(Criteria criteria) {

		Map<String, String> validator = new HashMap<String, String>();
		validator.put(Laptop.BATTERY_CAPACITY.toString(), "[0-9]\\.[0-9]");
		validator.put(Laptop.OS.toString(), "[a-zA-Z]+\\s?[0-9]?{1,2}");
		validator.put(Laptop.MEMORY_ROM.toString(), "[0-9]{3,4}");
		validator.put(Laptop.SYSTEM_MEMORY.toString(), "[0-9]{3,4}");
		validator.put(Laptop.CPU.toString(), "[0-9]\\.[0-9]");
		validator.put(Laptop.DISPLAY_INCHS.toString(), "[0-9]{1,2}");

		return paramsValid(validator, criteria);
	}

	public static boolean refrigeratorValid(Criteria criteria) {

		Map<String, String> validator = new HashMap<String, String>();
		validator.put(Refrigerator.POWER_CONSUMPTION.toString(), "[0-9]{2,3}");
		validator.put(Refrigerator.WEIGHT.toString(), "[0-9]{2,3}");
		validator.put(Refrigerator.FREEZER_CAPACITY.toString(), "[0-9]{2,3}");
		validator.put(Refrigerator.OVERALL_CAPACITY.toString(), "[0-9]{2,3}\\.[0-9]");
		validator.put(Refrigerator.HEIGHT.toString(), "[0-9]{2,3}");
		validator.put(Refrigerator.WIDTH.toString(), "[0-9]{2,3}");

		return paramsValid(validator, criteria);
	}

	public static boolean speakerValid(Criteria criteria) {

		Map<String, String> validator = new HashMap<String, String>();
		validator.put(Speakers.POWER_CONSUMPTION.toString(), "[0-9]{1,2}");
		validator.put(Speakers.NUMBER_OF_SPEAKERS.toString(), "[0-9]{1,2}");
		validator.put(Speakers.FREQUENCY_RANGE.toString(), "[0-9]{1,2}[\\-][0-9]\\.?[0-9]?");
		validator.put(Speakers.CORD_LENGTH.toString(), "[0-9]{1,2}");

		return paramsValid(validator, criteria);
	}

	public static boolean tabletPCValid(Criteria criteria) {

		Map<String, String> validator = new HashMap<String, String>();
		validator.put(TabletPC.BATTERY_CAPACITY.toString(), "[0-9]{1,2}");
		validator.put(TabletPC.DISPLAY_INCHES.toString(), "[0-9]{1,2}");
		validator.put(TabletPC.MEMORY_ROM.toString(), "[0-9]{4,5}");
		validator.put(TabletPC.FLASH_MEMORY_CAPACITY.toString(), "[0-9]{1,2}");
		validator.put(TabletPC.COLOR.toString(), "[a-zA-Z]+");

		return paramsValid(validator, criteria);

	}

	public static boolean vacuumCleanerValid(Criteria criteria) {

		Map<String, String> validator = new HashMap<String, String>();
		validator.put(VacuumCleaner.POWER_CONSUMPTION.toString(), "[0-9]{2,3}");
		validator.put(VacuumCleaner.FILTER_TYPE.toString(), "[a-zA-Z]");
		validator.put(VacuumCleaner.BAG_TYPE.toString(), "[a-zA-Z]+[\\-]?[0-9]{1,2}");
		validator.put(VacuumCleaner.WAND_TYPE.toString(), "[a-zA-Z]+[\\-][a-zA-Z]+[\\-][a-zA-Z]+");
		validator.put(VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), "[0-9]{3,4}");
		validator.put(VacuumCleaner.CLEANING_WIDTH.toString(), "[0-9]{2,3}");

		return paramsValid(validator, criteria);
	}

	public static boolean paramsValid(Map<String, String> params, Criteria criteria) {

		Set<String> criteriaKey = criteria.getCriteria().keySet();

		for (String key : criteriaKey) {

			String regex = params.get(key);
			String input = criteria.getCriteria().get(key) + "";

			if (!(Pattern.matches(regex, input))) {

				return false;
			}
		}
		return true;
	}
}
