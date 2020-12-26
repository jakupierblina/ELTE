
package workspace;
/* 
	- Register sale
	This item shall ask for the user code and the product barcode
	(you can make it as simple as 123), then it randomly take one product 
	from that barcode and adds it to the kids products list and removes it from the 
	general list of products.

	- Ruffle tickets
	Given a number of tickets to be ruffled, it creates the GoldenTickets 
	(giving a random code and the current date) and ruffles it on the list of products.

	The system asks how many GoldenTickets should be created and then ruffles 
	the Golden Tickets into the list of products.

	- List winners
	This goes through all the registered kids and check if they have bought
	any product with GoldenTicket in it, if that's the case, it prints out the 
	name of the kid

*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import Registration.*;
import Song.*;
import Ticket.*;

public class Solution {

    static Scanner input = new Scanner(System.in);
    
	private static ArrayList<Product> products = new ArrayList<>();
	private static ArrayList<Kid> kid = new ArrayList<>() ;
	private static ArrayList<GoldenTicket> prizeTicket = new ArrayList<>();
	private static ArrayList<OomplaLoompa> Oompa = new ArrayList<>() ;

    public Solution() { }
	
	
	/* Register for Beigns,Products and Golden ticket*/
	public void registerPrizeTicket(String Code)
	{
		prizeTicket.add(new GoldenTicket(Code,new Date()));
	}
	
	
	public void registerBeings()
	{		
		
		System.out.println("Press 0 for OompaLoompa and 1 for kid");
		int keypress = input.nextInt();
		
		if (keypress == 1)
		{
			String name, code, birthday, placeOfBirth;
			System.out.println("Please give: name, code, birthday and place of birth");
			name = input.next();
			code = input.next();
			birthday = input.next();
			placeOfBirth = input.next();
			
			Kid myKid = new Kid(name, code, birthday, placeOfBirth);
			kid.add(myKid);
			return;
		}
		if (keypress == 0) 
		{
			String name, code, favoriteFood;
			int height;
			
			System.out.println("Please give: name, code, height and favorite food ");
			name = inp.next();
			code = inp.next();
			height = inp.nextInt();
			favoriteFood = inp.next();
			OompaLoompa op = new OompaLoompa(name, code, height, favoriteFood);
			Oompa.add(op);
			return;
		}
		
	}
	
	
	public void registerProducts()
	{
		System.out.println("Product's description: ");
        String description = input.next();
		
        System.out.println("Write it's barcode: ");
        long barcode = input.nextInt();
		
        System.out.println("Write the serial number: ");
        String snum = input.next();

        System.out.println("Press 1 for GoldenTicket, press 2 without GoldenTicket ");
        int code = input.nextInt();
		
        if (code == 1) 
		{
            System.out.println("Ticket's code: ");
            String ticketCode = input.next();
			
            int id = 0;
            for (int i = 0; i < prizeTicket.size(); i++) 
			{
                if (prizeTicket.get(i).getCode().equals(ticketCode)) 
				{
                    id = i;
                }
            }
            try
			{
                Product product = new Product(description, barcode, snum, tickets.get(id));
                products.add(product);
                System.out.println("Your product is registered successfully!");
            }
			catch (Exception ex) 
			{
                System.out.println("Exception handle!");
            }
        }

        if (code == 2) 
		{
            Product product = new Product(description, barcode, snum, null);

            try 
			{
                products.add(product);
                System.out.println("Your product is registered successfully!");
            }
			catch (Exception ex) 
			{
                System.out.println("Exception handle!");
            }
        }
	}
	
	public static void registerSale() 
	{
        System.out.println("code: ");
        int code = scanner.nextInt();
		
        System.out.println("barcode: ");
        long barcode = scanner.nextInt();

        ArrayList<Product> tmpProducts = new ArrayList<>();
		
        //randomly take one product from that barcode
        for (int i = 0; i < products.size(); i++) 
		{
            if (products.get(i).getBarcode() == barcode) 
			{
                tmpProducts.add(products.get(i));
            }
        }

        Random rnd = new Random();
		
        int k = rnd.nextInt(tmpProducts.size());
		Product product = tmpProducts.get(k);

     
        for (int i = 0; i < products.size(); i++) 
		{
            if (products.get(i).getBarcode() == barcode) 
			{
                products.remove(products.get(i));
            }
        }
    }
	
	public static void ruffleTicket() 
	{
		
        System.out.println("How many GoldenTickets you want to be ruffled: ");
		
        int nr = scanner.nextInt();

        if (nr >= prizeTicket.size()) 
		{
            for (int i = 0; i <= (nr - prizeTicket.size()); ++i) 
			{
                prizeTicket.add(new GoldenTicket());
            }
        }

        Random rnd = new Random();
		
        int a= 0, b= 0;
		
        if (products.size() > 0) 
		{
            for (int i = 0; i < nr; i++) 
			{
                a = rnd.nextInt(products.size());
                b = rnd.nextInt(prizeTicket.size() - 1);
				
                GoldenTicket t = prizeTicket.get(b);
                products.get(a).prizeTicket(t);
            }
            listProduct();
        } else 
		{
            System.out.println("There is no product!");
        }
    }
	
	
	public Product sell(long productBarCode)
	{
		for(Product j : products){
					
					if(j.getBarCode()== productBarCode){
						
						products.remove(j);
						
						return j;
						
					}
		}
					
		return null;
		
	}
	
	
    public static void createSong() 
	{
        System.out.println("Write the number of the lines:");
		
        int nr = scanner.nextInt();
		
        OompaLoompaSong song = new OompaLoompaSong(nr);
        song.singRandomly();
    }

	
	
	public void listPrizeTicket()
	{
		System.out.println("List of the Golden Tickets");
		if(prizeTicket.size()!=0)
		{
			for(GoldenTicket g : prizeTicket )
			{
				System.out.println(g);
			}
		}
		else
		{
			System.out.println("There is no Golden Ticket");
		}
	}
	
	public void listBeings()
	{
		System.out.println("Kids ");
        for (int i = 0; i < kid.size(); i++) {
            System.out.println(kid.get(i).getClass() + "\n " + kid.get(i));
        }
		
		System.out.println("OompaLoompas: ");
        for (int i = 0; i < beingsOompa.size(); i++) {
            System.out.println(beingsOompa.get(i).getClass() + "\n " + beingsOompa.get(i));
        }
        System.out.println();

	}
	
	
	public void listRaffledTickets()
	{
		System.out.println("List of the raffled tickets");	
		
		for(Product k : products)
		{
			if(k.isGolden())
			{
				
				System.out.println(k.getPrizeTicket());
			}
		}
	}
	
	public void listProduct()
	{
		System.out.println("List of the products");
		if(products.size()!= 0)
		{
			for(Product i : products )
			{
				System.out.println(i);
			}
			
		}
		else
		{
			System.out.println("There is no product");
		}
	}
	
	

	public void winnerkids()
	{
		System.out.println("List the kids with GoldenTicket");
		for(Beings k : beings)
		{
			if(k instanceof Kid) 
			{
				if(((Kid)k).hasGoldenTicket())
				{
					System.out.println((Kid)k);
				}
			}
		}
	}
	
	

}