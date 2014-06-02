package I2L.computerInfo;

public class Java {
	
	String javaVmVersion;
	String javaVmVendor;
	String javaHome;
	String memoryAvailableToJvm;
	
	public Java()
	{
		
	}

	@Override
	public String toString() {
		return "[Java] \nJava VM Version : " + javaVmVersion + "\nJava VM Vendor : "
				+ javaVmVendor + "\nJava Home : " + javaHome
				+ "\nMemory Available To JVM : " + memoryAvailableToJvm;
	}

	public String getJavaVmVersion() {
		return javaVmVersion;
	}

	public void setJavaVmVersion(String javaVmVersion) {
		this.javaVmVersion = javaVmVersion;
	}

	public String getJavaVmVendor() {
		return javaVmVendor;
	}

	public void setJavaVmVendor(String javaVmVendor) {
		this.javaVmVendor = javaVmVendor;
	}

	public String getJavaHome() {
		return javaHome;
	}

	public void setJavaHome(String javaHome) {
		this.javaHome = javaHome;
	}

	public String getMemoryAvailableToJvm() {
		return memoryAvailableToJvm;
	}

	public void setMemoryAvailableToJvm(String memoryAvailableToJvm) {
		this.memoryAvailableToJvm = memoryAvailableToJvm;
	}

}
