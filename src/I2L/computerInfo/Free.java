package I2L.computerInfo;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Swap;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.Shell;
import org.hyperic.sigar.cmd.SigarCommandBase;

/**
 * Display amount of free and used memory in the system.
 */
public class Free extends SigarCommandBase {

    public Free(Shell shell) {
        super(shell);
    }

    public Free() {
        super();
    }

    public String getUsageShort() {
        return "Display information about free and used memory";
    }

    private static Long format(long value) {
        return new Long(value / 1024);
    }

    public void output(String[] args, Computer comp) throws SigarException {
        Mem mem   = this.sigar.getMem();
        Swap swap = this.sigar.getSwap();

        Object[] header = new Object[] { "total", "used", "free" };

       // Object[] memRow = new Object[] {
        	comp.getHdd().name = "C:/";
            comp.getHdd().freeSpace = format(mem.getFree());
            comp.getHdd().totalSpace = format(mem.getTotal());
            comp.getHdd().usableSpace = format(mem.getUsed());
            //format(mem.getTotal()),
            //format(mem.getUsed()),
            //format(mem.getFree())
        //};

        Object[] actualRow = new Object[] {
            format(mem.getActualUsed()),
            format(mem.getActualFree())
        };

        Object[] swapRow = new Object[] {
            format(swap.getTotal()),
            format(swap.getUsed()),
            format(swap.getFree())
        };

        //printf("%18s %10s %10s", header);

        //printf("Mem:    %10ld %10ld %10ld", memRow);

        //e.g. linux
        if ((mem.getUsed() != mem.getActualUsed()) ||
            (mem.getFree() != mem.getActualFree()))
        {
            //printf("-/+ buffers/cache: " + "%10ld %10d", actualRow);
        }

        //printf("Swap:   %10ld %10ld %10ld", swapRow);

        //printf("RAM:    %10ls", new Object[] { mem.getRam() + "MB" });
        comp.physicalMemory = Long.toString(mem.getRam());
        
    }

    public static void main(String[] args) throws Exception {
        new Free().processCommand(args);
    }

	@Override
	public void output(String[] args) throws SigarException {
		// TODO Auto-generated method stub
		
	}
}