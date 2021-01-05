package JAVAFX;
public class SaleTicketThread extends Thread {
	private String name;
	private  int tickets = 50;
	private   String lock="";	

	public SaleTicketThread(String name) { 	this.name = name;	}

	@Override
	public void run() {
		while (true) {		
				if (tickets > 0)
					System.out.println(name + "：正在销售第 " + tickets-- + " 票");
				else  		break;			
			    try { 	Thread.sleep(300);	} 
catch (InterruptedException e) {	}
		}
	}

	public static void main(String[] args) {
		SaleTicketThread sale1 = new SaleTicketThread("窗口1");
		SaleTicketThread sale2 = new SaleTicketThread("窗口2");
		sale1.start();
		sale2.start();
	   }
}