package pharmacy;

import java.util.Scanner;

import org.json.simple.JSONObject;

public class Node 
{
	int medicineID ;
	int quantity;
	String medicineName;
	String place;
	double Price;
	String Type ;
	String Manufacture;
    Date expireDate = new Date();
	Node next;
	
	
	public Node() {
	}


	public Node(int medicineID, int quantity, String medicineName, String place, double price, String type,
			String manufacture, int expireDate) {
		
		this.medicineID = medicineID;
		this.quantity = quantity;
		this.medicineName = medicineName;
		this.place = place;
		Price = price;
		Type = type;
		Manufacture = manufacture;
		this.expireDate.loadDate(expireDate);;
	}

	
	//load data from json file to node
	public void loadNode(JSONObject medic) 
    {
		

		//Get medic object within list
	        JSONObject medicObject = (JSONObject) medic.get("medic");
	         
	        this.medicineID = (int)(long) medicObject.get("medicineID");  
	         
	        this.quantity = (int)(long) medicObject.get("quantity");  
	         
	        this.medicineName = (String) medicObject.get("medicineName");  
	        
	        this.place = (String) medicObject.get("place");
	        
	        this.Price = (double) medicObject.get("Price");  
	        
	        this.Type = (String) medicObject.get("Type");  
	         
	        this.Manufacture = (String) medicObject.get("Manufacture");  
	        
	        int date = (int)(long) medicObject.get("expireDate");
	        this.expireDate.loadDate(date);
	        
    }
	
	
	//print node data
	public void printNode()
	{
		System.out.print("Id: "+this.medicineID+"  ");
		
		System.out.print("Quantity: "+quantity+"  ");
		
		System.out.print("Name: "+medicineName+"  ");
		
		System.out.print("Place: "+place+"  ");
		
		System.out.print("Price: "+Price+"  ");
		
		System.out.print("Type: "+Type+"  ");
		
		System.out.print("Manufacture: "+Manufacture+"  ");
		
		System.out.print("Expire Date: ");
		this.expireDate.print();
		
	}
	
	
	//load node by Scanner
	public void loadNode() 
    {
		Scanner s = new Scanner(System.in);
		
        System.out.print("Id: ");
        medicineID = s.nextInt();
        
		System.out.print("  "+"Quantity: ");
		quantity =s.nextInt();
		
		System.out.print("  "+"Name: ");
		medicineName= s.next();
		
		System.out.print("  "+"Place: ");
		place = s.next();
		
		System.out.print("  "+"Price: ");
		Price = s.nextInt();
		
		System.out.print("  "+"Type: ");
		Type = s.next();
		
		System.out.print("  "+"Manufacture: ");
		Manufacture = s.next();
		
		System.out.println("  "+"Expire Date: ");
		int date = s.nextInt();
		this.expireDate.loadDate(date);

    }
	
	//transfer data to another node
	public void transfereData(Node node)
	{
		node.medicineID = medicineID;
		node.quantity = quantity;
		node.medicineName = medicineName;
		node.place = place;
		node.Price = Price;
		node.Type = Type;
		node.Manufacture = Manufacture;
		node.expireDate = expireDate;
	}
	
	
	public JSONObject nodeToJsonObj()
	{
		 JSONObject medDetail = new JSONObject();
	        medDetail.put("Type", this.Type);
	      medDetail.put("quantity", this.quantity);
	      medDetail.put("Price", this.Price);
	      medDetail.put("medicineID", this.medicineID);
	      medDetail.put("expireDate", this.expireDate.toInt());
	      medDetail.put("place", this.place);
	      medDetail.put("Manufacture", this.Manufacture);
	      medDetail.put("medicineName", this.medicineName);
	        JSONObject employeeObject2 = new JSONObject(); 
	        employeeObject2.put("medic", medDetail);
	        
	        return employeeObject2 ;
	}
	
	
}