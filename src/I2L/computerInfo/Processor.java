package I2L.computerInfo;

public class Processor {
	
	String availableProcessors;
	String processorVendor;
	String processorModel;
	String processorMhz;
	String processorIdentifier;
	
	public Processor()
	{
		
	}

	public String getAvailableProcessors() {
		return availableProcessors;
	}

	@Override
	public String toString() {
		return "[Processor] \nAvailable Processors : " + availableProcessors
				+ "\nProcessor Vendor : " + processorVendor + "\nProcessor Model : "
				+ processorModel + "\nProcessor Mhz : " + processorMhz
				+ "\nProcessor Identifier : " + processorIdentifier;
	}

	public void setAvailableProcessors(String availableProcessors) {
		this.availableProcessors = availableProcessors;
	}

	public String getProcessorVendor() {
		return processorVendor;
	}

	public void setProcessorVendor(String processorVendor) {
		this.processorVendor = processorVendor;
	}

	public String getProcessorModel() {
		return processorModel;
	}

	public void setProcessorModel(String processorModel) {
		this.processorModel = processorModel;
	}

	public String getProcessorMhz() {
		return processorMhz;
	}

	public void setProcessorMhz(String processorMhz) {
		this.processorMhz = processorMhz;
	}

	public String getProcessorIdentifier() {
		return processorIdentifier;
	}

	public void setProcessorIdentifier(String processorIdentifier) {
		this.processorIdentifier = processorIdentifier;
	}

}
