package problem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyShares {
	static void processCompanyShareInfo(String[] shares) {

		Map<String, CompanyShareInfo> map = new HashMap<String, CompanyShareInfo>();
		String headers[] = shares[0].split("\\,");

		int nameIndex;
		for (int j = 1; j < shares.length; j++) {
			String[] monthlyShares = shares[j].split("\\,");
			nameIndex = 2;
			for (int i = 2; i < monthlyShares.length; i++) {

				BigDecimal shareValue = new BigDecimal(monthlyShares[i].trim());
				int year = Integer.valueOf(monthlyShares[0].trim());
				String companyName = headers[nameIndex].trim();
				String key = companyName + year;

				if (map.containsKey(key)) {
					// update month and share, if new share value is greater
					if (shareValue.compareTo(map.get(key).getShare()) > 0) {
						CompanyShareInfo company = map.get(key);
						company.setShare(shareValue);
						company.setMonth(monthlyShares[1].trim());
					}
				} else {
					CompanyShareInfo company = new CompanyShareInfo();
					company.setMonth(monthlyShares[1].trim());
					company.setYear(Integer.valueOf(monthlyShares[0].trim()));
					company.setName(headers[nameIndex].trim());
					company.setShare(shareValue);
					map.put(key, company);
				}
				nameIndex++;
			}

		}

		printInfo(map);

	}

	static void printInfo(Map<String, CompanyShareInfo> map) {
		List<String> keys = new ArrayList<String>(map.keySet());
		// Sort keys by company name, followed by Year
		Collections.sort(keys);

		for (String key : keys) {
			CompanyShareInfo value = map.get(key);
			System.out.println(value.getName() + " has share "
					+ value.getShare() + " in the month " + value.getMonth()
					+ "," + value.getYear());

		}
	}

	public static void main(String[] args) {
		String[] shares = { "Year, Month, A, B, C, D",
				"1990, Jan, 10, 15, 20,50", "1990, Feb, 10, 15, 20, 50",
				"1990, Mar, 50, 90, 70,80", "1990, Apr, 78, 23, 11, 45",
				"1990, May, 234, 56, 80", "1990, Jun, 134, 121,6674,384",

				"1991, Jan, 99, 88, 33, 44", "1991, Feb, 676, 234, 56, 23",
				"1991, Mar, 75, 234, 2, 45", "1991, apr, 61, 34, 57, 13",
				"1991, May, 345, 673, 45611,24",
				"1991, Jun, 435, 2343, 141,465",

				"1992, Jan, 1, 2, 3, 4", "1992, Feb, 3, 4, 4, 6",
				"1992, Mar, 122, 34, 67, 45", "1992, Apr, 989, 78678, 34, 56",
				"1992, May, 345, 673, 45611,345",
				"1992, Jun, 908, 5263, 142,478", };
		processCompanyShareInfo(shares);
	}
}
