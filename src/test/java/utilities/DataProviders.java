package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "biranvaron", "12345" }, { "varonbiran", "54321" }, { "username", "password1541" },
				{ "userBiran", "mycode88" } };
		return myData;
	}
}
