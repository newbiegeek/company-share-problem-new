package problem;

import java.math.BigDecimal;

public class CompanyShareInfo {

	private String name;

	private int year;

	private BigDecimal share;

	private String month;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getShare() {
		return share;
	}

	public void setShare(BigDecimal share) {
		this.share = share;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", year=" + year + ", share=" + share
				+ ", month=" + month + "]";
	}

}
