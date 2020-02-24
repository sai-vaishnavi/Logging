package com.client.LoggingEpamTask;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class App 
{
	public static final Logger  LOGGER=LogManager.getLogger(App.class);
    public static void main( String[] args ) 
    {
     	Scanner sc=new Scanner(System.in);
    	LOGGER.info("Enter profit to calculate simple Interest");
    	int profit=sc.nextInt();
    	LOGGER.info("Enter rate to calculate simple Interest");
    	int rate=sc.nextInt();
    	LOGGER.info("Enter term to calculate simple Interest");
    	int term=sc.nextInt();
    	LOGGER.info("Enter materialStandard  \n1.standard materials \n2. above Standard materials\n3. high standard materials\n4. high standard and fully automated home\n to calculate house construction cost\n ");
    	
    	int materialStandard=sc.nextInt();
    	LOGGER.info("Enter totalarea for calculation of construction of house");
    	int totalarea=sc.nextInt();
    	BusinessApp b=new BusinessApp();
         int simpleInterest=b.SimpleInterest(profit,rate,term);
    	LOGGER.info("\nSimple Interest is\n"+simpleInterest);
    	int  coumpoundinterest=b.CoumpoundInterest(profit, rate, term);
    	LOGGER.info("Coumpound Interest is\n"+coumpoundinterest);
    	int housecost=b.houseConstructionRate(materialStandard,totalarea);
    	LOGGER.info("Total house cost is\n"+housecost);    	
    }
}
class BusinessApp
{
	public static final Logger  LOGGER=LogManager.getLogger(App.class);
   public int SimpleInterest(int profit,int rate,int term)
   {
	 LOGGER.debug("Simple Interest calculation Method invoked");
	   return profit*rate*term;
	
   }
   public int CoumpoundInterest(int profit,int rate,int term)
   {
	   LOGGER.debug("Coumpound Interest calculation method invoked");
	   int x=rate+1;
	   int power=(int)Math.pow(x, term);
	   return (profit*power)-profit;
   }
   public int houseConstructionRate(int materialstandard,int totalarea)
   {
	   LOGGER.debug("House construction cost calculation method invoked");
	   int result=0;
   switch(materialstandard) {
   case 1:
         
        result=(int)1200*totalarea;
      break;
   case 2:
	        result=(int)1500*totalarea;
      break;
      
   case 3:
	        result=(int)1800*totalarea;
      break;
   case 4:
	         result= (int)2500*totalarea;
      break;
     }
   return result;
  }
}
