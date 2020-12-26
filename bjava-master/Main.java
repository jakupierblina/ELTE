
package workspace;

import java.lang.Exception;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import Registration.*;

public class Main 
{
	static Scanner scanner = new Scanner(System.in);
	
	//static Beings bg = null;
	//static Kid kd =  null;
	//static OomplaLoompa op = null;
	//static OomplaLoompaSong os = null;
	//static Product pd =null;
	
	public static void main(String[] args) throws Exception
	{
		Solution tmp = new Solution();
		
		int chose = 0;
		
			do{
			
				System.out.println("Select from the list: "
					+"\n 1- Register golden ticket "
					+"\n 2- List all prize tickets "
					+"\n 3- List raffled tickets "
					+"\n 4- Create a new OompaLoompa Song "
					+"\n 5 - Register Beings "
					+"\n 6 - Register products" 
					+ "\n 7 - Ruffle ticket "
					+"\n 8 - Register sale "
					+"\n 9 - List winners \n " );
				
				chose = scanner.nextInt();
				
				switch(chose)
				{
					case 1:
						System.out.print("Ticket code: ");
						String putCode = scanner.nextLine();
						tmp.registerPrizeTicket(putCode);
						break;
						
					case 2:
						tmp.listTickets();
						break;
					case 3:
						tmp.listRaffledTickets();
						break;
					case 4:
						tmp.createSong();
						break;
					case 5:
						tmp.registerBeings();
						break;
					case 6:
						tmp.registerProducts();
						break;
					case 7:
						tmp.ruffleTicket();
						break;
					case 8:
						tmp.registerSale();
						break;
					case 9:
					   tmp.listWinners();
					   break;
					
					default:
						System.out.println("Wrong number");
				}
			}while(chose!=0); 
		} 	
	}

	