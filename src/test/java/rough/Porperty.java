package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Porperty {
	public static void main(String[] args) throws IOException {
		Properties global = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Api_Automation\\Api_Workspace\\ApiFrameworkCucmber\\src\\test\\java\\resources\\global.properties");
		global.load(fis);

		String s = global.getProperty("baseURl");
		System.out.println(s);
	}
}
