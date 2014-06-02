package I2L.computerInfo;

import java.io.File;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarLoader;
import org.hyperic.sigar.cmd.Shell;
import org.hyperic.sigar.cmd.SigarCommandBase;
import org.hyperic.sigar.cmd.Version;
import org.hyperic.sigar.win32.LocaleInfo;

public class RecuperationInfos extends SigarCommandBase {

	public RecuperationInfos(Shell shell) {
		super(shell);
	}

	public RecuperationInfos() {
		super();
	}

	public String getUsageShort() {
		return "Display sigar and system version info";
	}

	private static String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			return "unknown";
		}
	}

	private static void printNativeInfo(PrintStream os, Computer comp) {
		String version =
				"java=" + Sigar.VERSION_STRING +
				", native=" + Sigar.NATIVE_VERSION_STRING;
		String build =
				"java=" + Sigar.BUILD_DATE +
				", native=" + Sigar.NATIVE_BUILD_DATE;
		String scm =
				"java=" + Sigar.SCM_REVISION +
				", native=" + Sigar.NATIVE_SCM_REVISION;
		String archlib =
				SigarLoader.getNativeLibraryName();

		String host = getHostName();
		String fqdn;
		Sigar sigar = new Sigar(); 
		try {
			File lib = sigar.getNativeLibrary();
			/*if (lib != null) {
                archlib = lib.getName();
            }*/
			fqdn = sigar.getFQDN();
		} catch (SigarException e) {
			fqdn = "unknown";
		} finally {
			sigar.close();
		}


		comp.completeHostName = fqdn;
		if (!fqdn.equals(host)) {
			comp.hostName = host;
		}        

		if (SigarLoader.IS_WIN32) {
			LocaleInfo info = new LocaleInfo();
			comp.language = info.toString();
		}
	}

	public static void printInfo(PrintStream os, Computer comp) throws UnknownHostException {
		try {
			printNativeInfo(os, comp);
		} catch (UnsatisfiedLinkError e) {
			os.println("*******ERROR******* " + e);
		}


		OperatingSystem sys = OperatingSystem.getInstance();
		comp.getOs().setOsDescription(sys.getDescription());
		comp.getOs().setOsName(sys.getName());
		comp.getOs().setOsArch(sys.getArch());
		comp.getOs().setOsMachine(sys.getMachine());
		comp.getOs().setOsVersion(sys.getVersion());
		comp.getOs().setOsPatchLevel(sys.getPatchLevel());
		comp.getOs().setOsVendor(sys.getVendor());
		comp.getOs().setOsVendorVersion(sys.getVendorVersion());
		if (sys.getVendorCodeName() != null) {
			comp.getOs().setOsCodeName(sys.getVendorCodeName());
		}
		comp.getOs().setOsDataModel(sys.getDataModel());
		
		InetAddress thisIp =InetAddress.getLocalHost();
		comp.ipAdress = thisIp.getHostAddress();

		comp.getJava().setJavaVmVersion(System.getProperty("java.vm.version"));
		comp.getJava().setJavaVmVendor(System.getProperty("java.vm.vendor"));
		comp.getJava().setJavaHome(System.getProperty("java.home"));

		comp.getProc().setProcessorIdentifier(System.getenv("PROCESSOR_IDENTIFIER"));

	}

	public void output(String[] args, Computer comp) throws UnknownHostException {
		printInfo(this.out, comp);
	}

	public static void main(String[] args) throws Exception {
		new Version().processCommand(args);
	}

	@Override
	public void output(String[] arg0) throws SigarException {
		// TODO Auto-generated method stub

	}
}