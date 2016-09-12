
public class PrinterController {
	public static final int PORTION = 10;
	public static final int N_PORTION = 3;
	static{
		Printer.setPortion(PORTION);
		Printer.setnPortion(N_PORTION);
	}
	public static int nThreads;
	
	public static void main(String[] args) {
		if(args == null) return;
		nThreads = Integer.parseInt(args[0]);
		Printer printer = new Printer((byte)(nThreads),null);
		Printer lastPrinter = printer;
		for(byte i = (byte)(nThreads - 1); i > 0; i--){
			printer = new Printer(i, printer);
			printer.start();
		}
		lastPrinter.setNext(printer);
		lastPrinter.start();
		printer.interrupt();		
	}
}
