package pharmacy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Pharmacy {

	 Node first;
	
	//load data to the pharmacy system
	public void loadData(String filePath) 
	{

		 JSONParser jsonParser = new JSONParser();
	     
		  JSONArray midicList = new JSONArray();
	       try (FileReader reader = new FileReader(filePath))
	       {
	           //Read JSON file
	           Object obj = jsonParser.parse(reader);

	         midicList = (JSONArray) obj;
	            
	       } catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       } catch (ParseException e) {
	           e.printStackTrace();
	       }
	       Node node =new Node();
	      	for(int i =0 ; i <midicList.size() ;i++ )
	      	{
	      		Node temp =new Node();
	      		temp.loadNode((JSONObject)midicList.get(i));
	      		node.next = temp ;
	      		
	      		if(first==null)
	      		{
	      			first = new Node();
	      			first=node.next;
	      			node.next.next = first.next ;
	      		}
	      	    node=node.next;
	      	}
	}
	
	//print all data
	public void printAll()
	{
		Node temp = first ;
		while(temp!=null)
		{
			temp.printNode();
			temp = temp.next;
		}
	}
	
	//print medicine data
	public void printMedicineData(String medicineName)
	{
		Node temp = searchByName(medicineName) ;
		if(temp!=null)
		  temp.printNode();
		System.out.println("loop?");
	}
	
	
	//add new medicine
	public void addNewMedicine()
	{
		Node temp = new Node() ;
		temp.next = first ;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=new Node();
		temp.next.loadNode();
	}
	
	
	//update medicine
	public void update(Node medicine)
	{
		if(medicine.medicineID==first.medicineID)
		{
			medicine.next= first.next;
			first=medicine;
		}
		else
		{
			Node temp = first ;
			while(temp.next!=null)
			{
				if(medicine.medicineID==temp.next.medicineID) {
					medicine.next = temp.next.next;
					temp.next = medicine ;
					break;
				}
					
				temp=temp.next;
			}
		}
		
	}
	
	
	//delete medicine
		public void delete(Node medicine)
		{
			if(medicine.medicineName.equals(first.medicineName))
			{
				first= first.next;
			}
			else
			{
				Node temp = first ;
				while(temp.next!=null)
				{
					if(temp.next.medicineName.equals(medicine.medicineName)) {
						temp.next = temp.next.next;
						break;
					}
						
					temp=temp.next;
				}
			}
		}
		
		
		//Sort by price.
		public void sortByPrice(boolean order)
		{
			Pharmacy sorted = new Pharmacy();
			
			
				if(order) {
					while(this.first!=null)
					{
						Node temp = first ;
						Node max = new Node();
						 first.transfereData(max);
						
						while(temp!=null)
						{
							if(max.Price<=temp.Price)
							{
								temp.transfereData(max);;
							}
							temp=temp.next;
						}
						
					    sorted.add(max);
					    delete(max);
					}
				    this.first=sorted.first;
				}else
				{
					while(this.first!=null)
					{
						Node temp = first ;
						Node min = new Node();
						 first.transfereData(min);
						
						while(temp!=null)
						{
							if(min.Price>=temp.Price)
							{
								temp.transfereData(min);;
							}
							temp=temp.next;
						}
						
					    sorted.add(min);
					    delete(min);
					}
				    this.first=sorted.first;
				}
			
		}
		
		
		//Sort by Quanitiy.
			public void sortByQuanitiy(boolean order)
			{
				Pharmacy sorted = new Pharmacy();
				
				
					if(order) {
						while(this.first!=null)
						{
							Node temp = first ;
							Node max = new Node();
							 first.transfereData(max);
							
							while(temp!=null)
							{
								if(max.quantity<temp.quantity)
								{
									temp.transfereData(max);;
								}
								temp=temp.next;
							}
							
						    sorted.add(max);
						    delete(max);
						}
					    this.first=sorted.first;
					}else
					{
						while(this.first!=null)
						{
							Node temp = first ;
							Node min = new Node();
							 first.transfereData(min);
							
							while(temp!=null)
							{
								if(min.quantity>temp.quantity)
								{
									temp.transfereData(min);;
								}
								temp=temp.next;
							}
							
						    sorted.add(min);
						    delete(min);
						}
					    this.first=sorted.first;
					}
				
			}
		
		
			
		//sort by date
			public void sortByDate(boolean order)
			{
				Pharmacy sorted = new Pharmacy();
				
				
					if(order) {
						while(this.first!=null)
						{
							Node temp = first ;
							Node max = new Node();
							 first.transfereData(max);
							
							while(temp!=null)
							{
								if(max.expireDate.isFartharDate(temp.expireDate))
								{
									temp.transfereData(max);;
								}
								temp=temp.next;
							}
							
						    sorted.add(max);
						    delete(max);
						}
					    this.first=sorted.first;
					}else
					{
						while(this.first!=null)
						{
							Node temp = first ;
							Node min = new Node();
							 first.transfereData(min);
							
							while(temp!=null)
							{
								if(!min.expireDate.isFartharDate(temp.expireDate))
								{
									temp.transfereData(min);;
								}
								temp=temp.next;
							}
							
						    sorted.add(min);
						    delete(min);
						}
					    this.first=sorted.first;
					}
				
			}
		
	//search by name
	public Node searchByName(String name) 
	{
		Node temp = new Node() ;
		temp.next = first ;
		while(temp.next!=null)
		{
			if(temp.next.medicineName.equals(name))
				return temp.next ;
			temp=temp.next;
		}
		return null ;
	}
	
	//add
	public boolean add(Node node)
	{
		boolean retval= false ;
		Node temp;
		
		if(node!=null)
		{
			if(first==null) 
			{
				first=node;
			}
			else
			{
				temp=first;
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				temp.next =node ;
			}
			retval =  true;
		}
		return retval ;
	}
	
	//sell medicine 
	public double SellMedicine(String name,int quantity) {
		Node med=searchByName(name);
		if (med!=null)
		{
			med.quantity-=quantity;
			return quantity*med.Price;
			
		}
		return  0;
	}
	
	//save
	@SuppressWarnings("unchecked")
	public void save() {
		Node temp =  first;
		JSONArray medicList = new JSONArray()  ;
		while(temp!=null)
		{
			medicList.add(temp.nodeToJsonObj());
			temp=temp.next;
			
			
		}
		 //Write JSON file
        try (FileWriter file = new FileWriter("Pharma.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(medicList.toJSONString()); 
            file.flush();
 
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	//expire at date
	public Pharmacy expireAtDate(Date date){
		
		Pharmacy expired = new Pharmacy();
		Pharmacy copy = new Pharmacy();
		
		this.makeCopy(copy);
		
		copy.sortByDate(true);
		Node temp = copy.first;
		
		while(temp!=null)
		{
			if(temp.expireDate.isFartharDate(date))
				return expired;
			Node data = new Node();
			temp.transfereData(data);
			expired.add(data);
			
			temp=temp.next;
		}
		return expired;
		
	}
	
	//make a copy
	public void makeCopy(Pharmacy copy) {
		Node temp = first;
		while(temp!=null)
		{
			Node copyTemp = new Node();
			temp.transfereData(copyTemp);
			copy.add(copyTemp);
			temp=temp.next;
		}
	}
	}

