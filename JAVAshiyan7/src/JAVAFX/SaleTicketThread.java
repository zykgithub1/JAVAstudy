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
					System.out.println(name + "���������۵� " + tickets-- + " Ʊ");
				else  		break;			
			    try { 	Thread.sleep(300);	} 
catch (InterruptedException e) {	}
		}
	}

	public static void main(String[] args) {
		SaleTicketThread sale1 = new SaleTicketThread("����1");
		SaleTicketThread sale2 = new SaleTicketThread("����2");
		sale1.start();
		sale2.start();
	   }
}