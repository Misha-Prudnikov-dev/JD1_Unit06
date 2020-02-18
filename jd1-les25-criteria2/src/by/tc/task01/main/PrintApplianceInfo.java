package by.tc.task01.main;

import java.util.List;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {

	public static void print(List<Appliance> appliance) {

		if (appliance != null) {
			if (appliance.isEmpty()) {

				System.out.println("Not Found :( ");
			} else {
				for (Appliance a : appliance) {
					System.out.println(a.toString());
				}

			}
		} else {
			System.out.println("Wrong data!!!!!!!!!");
		}
	}

}
