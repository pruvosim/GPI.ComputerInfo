package I2L.computerInfo;

public class Os {
	
	String osDescription;
	String os;
	String osName;
	String osArch;
	String osMachine;
	String osVersion;
	String osPatchLevel;
	String osVendor;
	String osVendorVersion;
	String osCodeName;
	String osDataModel;
	
	public Os()
	{
		os = System.getProperty("os.name");
		osArch = System.getProperty("os.arch");
		osVersion = System.getProperty("os.version");
	}

	@Override
	public String toString() {
		return "[OS] \nOS Description : " + osDescription + "\nOS : " + os
				+ "\nOS Name : " + osName + "OS Architecture : " + osArch + "\nOS Machine : "
				+ osMachine + "\nOS Version : " + osVersion + "\nOS PatchLevel : "
				+ osPatchLevel + "\nOS Vendor : " + osVendor
				+ "\nOS Vendor Version : " + osVendorVersion + "\nOS Code Name : "
				+ osCodeName + "\nOS Data Model : " + osDataModel;
	}

	public String getOsDescription() {
		return osDescription;
	}

	public void setOsDescription(String osDescription) {
		this.osDescription = osDescription;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsArch() {
		return osArch;
	}

	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	public String getOsMachine() {
		return osMachine;
	}

	public void setOsMachine(String osMachine) {
		this.osMachine = osMachine;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOsPatchLevel() {
		return osPatchLevel;
	}

	public void setOsPatchLevel(String osPatchLevel) {
		this.osPatchLevel = osPatchLevel;
	}

	public String getOsVendor() {
		return osVendor;
	}

	public void setOsVendor(String osVendor) {
		this.osVendor = osVendor;
	}

	public String getOsVendorVersion() {
		return osVendorVersion;
	}

	public void setOsVendorVersion(String osVendorVersion) {
		this.osVendorVersion = osVendorVersion;
	}

	public String getOsCodeName() {
		return osCodeName;
	}

	public void setOsCodeName(String osCodeName) {
		this.osCodeName = osCodeName;
	}

	public String getOsDataModel() {
		return osDataModel;
	}

	public void setOsDataModel(String osDataModel) {
		this.osDataModel = osDataModel;
	}

}
