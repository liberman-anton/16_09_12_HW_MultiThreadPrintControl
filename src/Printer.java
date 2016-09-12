
public class Printer extends Thread {
	private byte id;
	private static int portion;
	private static int nPortion;
	private Printer next;
	@Override
	public void run(){
		for (int j = 0; j < nPortion; j++) {
			try {
				sleep(1000);
				
			} catch (InterruptedException e) {
				for (int i = 0; i < portion; i++)
					System.out.print(id);
				System.out.println();
				if(id == PrinterController.nThreads) System.out.println("---");
				next.interrupt();
			} 
		}
	}
	public Printer(byte id, Printer next) {
		super();
		this.id = id;
		this.next = next;
	}
	public static void setPortion(int portion) {
		Printer.portion = portion;
	}
	public static void setnPortion(int nPortion) {
		Printer.nPortion = nPortion;
	}
	public void setNext(Printer next) {
		this.next = next;
	}
}
