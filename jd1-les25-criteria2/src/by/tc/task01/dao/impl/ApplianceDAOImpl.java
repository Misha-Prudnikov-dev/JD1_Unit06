package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO {

	final String SOURCE = "resources\\appliances_db.txt";

	@Override
	public List<Appliance> find(Criteria criteria) throws DAOException {

		List<Appliance> groupAppliance = new ArrayList<Appliance>();
		Map<String, String> params = new HashMap<String, String>();

		try (BufferedReader br = new BufferedReader(new FileReader(SOURCE))) {

			while (br.ready()) {

				String line = br.readLine();
				String titleAppliance = line.split(":")[0].trim();

				if (titleAppliance.equals(criteria.getGroupSearchName())) {

					params = getParams(params, line);

					if (compareParams(params, criteria)) {

						groupAppliance.add(ApplianceFactory.findTypeAppliance(criteria, params));
					}

				}
			}

		} catch (IOException e) {

			throw new DAOException(e);
		}

		return groupAppliance;
	}

	public Map<String, String> getParams(Map<String, String> params, String line) {

		Pattern pattern = Pattern.compile("\\s?[,:;]?\\s+");

		String[] params1 = pattern.split(line);

		for (int i = 1; i < params1.length; i++) {

			String[] params2 = params1[i].split("=");

			params.put(params2[0], params2[1]);

		}
		return params;
	}

	public boolean compareParams(Map<String, String> params, Criteria criteria) {

		boolean b = true;

		for (Map.Entry<String, Object> entry : criteria.getCriteria().entrySet()) {

			String key = entry.getKey();

			if (!(criteria.getCriteria().get(key).toString().equalsIgnoreCase(params.get(key)))) {

				b = false;
				break;
			}
		}
		return b;
	}

}
