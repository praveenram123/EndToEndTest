package Helper;

public class FileReadManager {
	
	private FileReadManager() {
		// TODO Auto-generated constructor stub
	}
		
	public static FileReadManager fm = new FileReadManager();
	
	public static FileReadManager getInstance() {
		return fm;
	}
	
	public static ConfigReader cr;

	public ConfigReader getCr() throws Throwable {
		if (cr==null) {
			cr = new ConfigReader();
		}
		return cr;
	}

}
