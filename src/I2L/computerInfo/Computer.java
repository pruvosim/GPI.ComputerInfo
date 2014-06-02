package I2L.computerInfo;

import java.net.UnknownHostException;

import org.hyperic.sigar.SigarException;

public class Computer {
	
	//Classe gérant les informations d'un ordinateur
	
	//Basic informations
	String ipAdress;
	String physicalMemory;
	String completeHostName;
	String hostName;
	String language;
	String user;
	String home;
	
	Os os;
	Java java;
	Processor proc;
	Hdd hdd;
	
	public Computer()
	{
		user = System.getProperty("user.name");
		home = System.getProperty("user.home");
		
		//OS informations
		os = new Os();
		
		//JAVA informations
		java = new Java();
		
		//Hardware informations
		proc = new Processor();
		
		//Hard Drive Disc informations
		hdd = new Hdd();
		
	}
	
	public void getInfos() throws SigarException, UnknownHostException
	{
		//On récupère diverses informations grace a Sigar
		RecuperationInfos.printInfo(System.out, this);
		CpuInfo cpui = new CpuInfo();
		cpui.output(null, this);
		Free free = new Free();
		free.output(null, this);
		
	}
	
	public String insertQuery() throws UnknownHostException, SigarException
	{
		//Methode qui retourne la requete d'insertion des informations d'un ordinateur
		
		//On récupère d'abord les infos
		this.getInfos();
				
		//Création de la requete d'insertion
		String query = "INSERT INTO ordinateur (nom_ordinateur,adresse_ip, service_pack, system_root,"
				+ " processors,processor_type, physical_memory, langue, architecture,"
				+ " vitesse_processeur, systeme_exploitation,version_systeme_exploitation, bits,"
				+ " version_java, home_java) " 
				+ "VALUES ("
				+ ComputerInfoUtils.q(hostName) + ", " + ComputerInfoUtils.q(ipAdress) + ", " + ComputerInfoUtils.q(os.getOsPatchLevel()) + ", " + ComputerInfoUtils.q(home) + ", "
				+ ComputerInfoUtils.q(proc.getAvailableProcessors()) + ", "
				+ ComputerInfoUtils.q(proc.getProcessorModel()) + ", " + ComputerInfoUtils.q(physicalMemory) + ", " + ComputerInfoUtils.q(language) + ", " 
				+ ComputerInfoUtils.q(os.getOsArch()) + ", " + ComputerInfoUtils.q(proc.getProcessorMhz()) + ", " + ComputerInfoUtils.q(os.getOs()) + ", "
				+ ComputerInfoUtils.q(os.getOsVersion()) + ", " + ComputerInfoUtils.q(os.getOsDataModel()) + ", " 
				+ ComputerInfoUtils.q(java.getJavaVmVersion()) + ", " + ComputerInfoUtils.q(java.getJavaHome()) + ");";
		
		System.out.println("Requete : " + query);
		return query;
	}
	
	public String updateQuery() throws UnknownHostException, SigarException
	{
		//Méthode qui retourne la requete de mise a jour d'un ordinateur
		
		//on récupère d'abord les infos
		this.getInfos();
		
		//Création de la requete d'update
		String query = "UPDATE ordinateur SET "
				+ "nom_ordinateur = " + ComputerInfoUtils.q(hostName) + ", "
				+ "adresse_ip = " + ComputerInfoUtils.q(ipAdress) + ", "
				+ "service_pack = " + ComputerInfoUtils.q(os.getOsPatchLevel()) + ", "
				+ "system_root = " + ComputerInfoUtils.q(home) + ", "
				+ "processors = " + ComputerInfoUtils.q(proc.getAvailableProcessors()) + ", "
				+ "processor_type = " + ComputerInfoUtils.q(proc.getProcessorModel()) + ", "
				+ "physical_memory = " + ComputerInfoUtils.q(physicalMemory) + ", "
				+ "langue = " + ComputerInfoUtils.q(language) + ", "
				+ "architecture = " + ComputerInfoUtils.q(os.getOsArch()) + ", "
				+ "vitesse_processeur = " + ComputerInfoUtils.q(proc.getProcessorMhz()) + ", "
				+ "systeme_exploitation = " + ComputerInfoUtils.q(os.getOs()) + ", "
				+ "version_systeme_exploitation = " + ComputerInfoUtils.q(os.getOsVersion()) + ", "
				+ "bits = " + ComputerInfoUtils.q(os.getOsDataModel()) + ", "
				+ "version_java = " + ComputerInfoUtils.q(java.getJavaVmVersion()) + ", "
				+ "home_java = " + ComputerInfoUtils.q(java.getJavaHome())
				+" WHERE nom_ordinateur = " + ComputerInfoUtils.q(hostName) + ";";
		
		System.out.println("Requete : " + query);
		return query;
	}



	@Override
	public String toString() {
		return "[Computer] \nComplete Host Name : " + completeHostName + "\nHost Name : "
				+ hostName + "\nIP Adress : " + ipAdress + "\nLanguage : " + language + "\nUser : " + user
				+ "\nPhysical Memory : " + physicalMemory + "MB"
				+ "\nHome : " + home + "\n\n" + os.toString() + "\n\n"
				+ java.toString() + "\n\n" + proc.toString() + "\n\n" + hdd.toString();
	}



	public Os getOs() {
		return os;
	}

	public Java getJava() {
		return java;
	}

	public Processor getProc() {
		return proc;
	}
	
	public Hdd getHdd() {
		return hdd;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public String getPhysicalMemory() {
		return physicalMemory;
	}

	public String getCompleteHostName() {
		return completeHostName;
	}

	public String getHostName() {
		return hostName;
	}

	public String getLanguage() {
		return language;
	}

	public String getUser() {
		return user;
	}

	public String getHome() {
		return home;
	}

}
