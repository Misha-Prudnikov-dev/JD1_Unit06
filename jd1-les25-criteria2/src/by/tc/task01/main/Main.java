package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import java.util.List;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceException;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		List<Appliance> groupAppliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////
		try {
			Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());// "Oven"
			criteriaOven.add(Oven.CAPACITY.toString(), 33);

			groupAppliance = service.find(criteriaOven);

			PrintApplianceInfo.print(groupAppliance);

			//////////////////////////////////////////////////////////////////

			criteriaOven = new Criteria(Oven.class.getSimpleName());
			criteriaOven.add(Oven.HEIGHT.toString(), 200);
			criteriaOven.add(Oven.DEPTH.toString(), 300);

			groupAppliance = service.find(criteriaOven);

			PrintApplianceInfo.print(groupAppliance);

			//////////////////////////////////////////////////////////////////

			Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
			criteriaTabletPC.add(TabletPC.COLOR.toString(), "Blue");
			criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
			criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);

			groupAppliance = service.find(criteriaTabletPC);// find(Object...obj)

			PrintApplianceInfo.print(groupAppliance);

			////////////////////////////////////////////////////////////////

			Criteria criteriaVacuumCleaner = new Criteria(VacuumCleaner.class.getSimpleName());
			criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE.toString(), "AA-89");

			groupAppliance = service.find(criteriaVacuumCleaner);

			PrintApplianceInfo.print(groupAppliance);

			////////////////////////////////////////////////////////////////

			Criteria criteriaLaptop = new Criteria(Laptop.class.getSimpleName());
			criteriaLaptop.add(Laptop.OS.toString(), "Linux");

			groupAppliance = service.find(criteriaLaptop);

			PrintApplianceInfo.print(groupAppliance);

		} catch (ServiceException e) {
			System.out.println("Error!!!!" + e);
		}
	}

}
