package pharmacy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
	public static void main(String[]args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("enter file path: ");
		String path = s.next();
		
		Pharmacy p = new Pharmacy();	
		p.loadData(path);
		
		startSystem(p);
		
		
	}
	
	public static void startSystem(Pharmacy p) {
		System.out.println("choose the method: ");
		System.out.println("1.print all.");
		System.out.println("2.print medecine ");
		System.out.println("3.add new medecine. ");
		System.out.println("4.update ");
		System.out.println("5.delete. ");
		System.out.println("6.sort by price. ");
		System.out.println("7.sort by Quantity. ");
		System.out.println("8.sort by Expiredate. ");
		System.out.println("9.expired medecine on. ");
		System.out.println("10.sell ");
		System.out.println("11.save. ");
		System.out.println("12.exit. ");
		
		 Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		
		switch(x){
		case 1:
			p.printAll();
			finish(p);
			break;
		case 2:
			System.out.println("Enter the medicine Name:");
			String name=s.next();
			p.printMedicineData(name);
			finish(p);
			break;
		case 3:
			p.addNewMedicine();
			finish(p);
			break;
		case 4:
			System.out.println("Enter the Id of the medicine you want to update\nthen the new data:");
			Node med = new Node();
			med.loadNode();
			p.update(med);
			finish(p);
			break;
		case 5:
			System.out.println("Enter the name of the medicine you want to delete:");
		    name = s.next();
			p.delete(p.searchByName(name));
			finish(p);
			break;
		case 6:
			System.out.println("1 for low to high\n2 for high to low");
			int choice = s.nextInt();
			p.sortByPrice(choice==2);
			finish(p);
			break;
		case 7:
			System.out.println("1 for low to high\n2 for high to low");
			choice = s.nextInt();
			p.sortByQuanitiy(choice==2);
			finish(p);
			break;
		case 8:
			System.out.println("1 for new to old\n2 for old to new");
			choice = s.nextInt();
			p.sortByDate(choice==2);
			finish(p);
			break;	
		case 9:
			System.out.println("Enter date:");
			int date = s.nextInt();
			Date d = new Date();
			d.loadDate(date);
			p.expireAtDate(d).printAll();
			finish(p);
			break;	
		case 10:
			System.out.println("Name:");
			name = s.next();
			System.out.println("Quantity:");
			int quantity = s.nextInt();
			System.out.println("Price: "+p.SellMedicine(name, quantity));
			finish(p);
			break;		
		case 11:
			p.save();
			System.out.println("Saved.");
			finish(p);
			break;		
		case 12:
			p.save();
			System.out.println("Saved.");
			break;		
			
		
		}
		
		}
			
		
		public static void finish(Pharmacy p) {
			Scanner s = new Scanner(System.in);
			System.out.println("enter 1 to return to menu or 2 to save and exit:");
			int z = s.nextInt();
			input(1 , 2 , z ,p);
			switch(z){
			   case 1:
				   startSystem(p);
				   break;
			   case 2:
				   p.save();
				   System.out.println("saved.");
				   break;
			
		}
	}
		
		public static void input(int start , int finish , int input ,Pharmacy p)
		{
			if(!(input>=start&&input<=finish))
			{
				System.out.println("wrong input. try again!");
				startSystem(p);
			}
		}
		
		
}
