
package investments_final;

public class consoleTest {
    public static void main(String [] args)
    {
        
      int current_age=23;
    int reitrement_age=60;
    int monthly_cont=5000;
    double interest=0.07;

    int years=reitrement_age - current_age;

    int x=0;
    int yearlyInt=0;
    int total=0;
    int yearlyInvst=0;
    int more=12345678;
	do{
		x++;
        yearlyInvst=monthly_cont*12;
        yearlyInt=(int) ((yearlyInvst+total)*interest);
        total=total+yearlyInt+yearlyInvst;
        
        System.out.println(yearlyInvst+"\n"+x+" "+total+"\n");
        

        //cout<<yearlyInt<<"\n"<<x<<" "<<total<<"\n";

	}
	while(years>x);
        
        /*int x=0;
        do{
           x++; 
           System.out.println(x);
        }
        while(x<10);*/
   
    }
    
}
