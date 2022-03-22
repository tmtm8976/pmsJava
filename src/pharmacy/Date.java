package pharmacy;

import org.json.simple.JSONObject;

public class Date {

	int month ;
	int year ;
	public Date(int month, int day, int year) {
		this.month = month;
		this.year = year;
	}
	
	
	public Date() {
	}
	
	
	public void loadDate(int date) 
    { 
		long temp=0;
		this.year=date%10000;
         this.month = date/10000 ;
    }
	
	public boolean isFartharDate(Date date)
	{
		//compare year
		if(this.year>date.year)
			return true ;
		else if(this.year<date.year)
			return false ;
		else {
			
			//compare month
			if(this.month>date.month)
				return true ;
			else {
				return false;
			}
		}
	}
	
	public void print()
	{
		System.out.println(this.month+"/"+this.year);
	}
	
	public int toInt()
	{
		return month*10000+year;
	}
}
