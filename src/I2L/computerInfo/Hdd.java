package I2L.computerInfo;

public class Hdd {
	
	String name;
	long totalSpace;
	long freeSpace;
	long usableSpace;
	
	public Hdd()
	{
		
	}

	@Override
	public String toString() {
		return "[Hdd]\nName : " + name + "\nTotal Space : " + totalSpace
				+ "\nFree Space : " + freeSpace + "\nUsable Space : " + usableSpace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTotalSpace() {
		return totalSpace;
	}

	public void setTotalSpace(long totalSpace) {
		this.totalSpace = totalSpace;
	}

	public long getFreeSpace() {
		return freeSpace;
	}

	public void setFreeSpace(long freeSpace) {
		this.freeSpace = freeSpace;
	}

	public long getUsableSpace() {
		return usableSpace;
	}

	public void setUsableSpace(long usableSpace) {
		this.usableSpace = usableSpace;
	}

}
