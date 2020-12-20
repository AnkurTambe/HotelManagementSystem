import java.util.Scanner;
import java.util.ArrayList;

public class project
{
    public static void main(String[] args)
    {

        try
        {           
            Scanner sc = new Scanner(System.in);
            int ch,ch2;
            char wish;
            x:  //label
            do{                    //1-10->LuxDouRoo1 11-30->DelDouRoo2 31-40->LuxSinRoo3 41-60->DelSinRoo4
                System.out.println("\nEnter your choice :\n1.Room Details\n2.Room Availability \n3.Book Room\n4.Order Food\n5.Checkout\n6.Exit\n");
                ch = sc.nextInt();
                switch(ch){
                    case 1: System.out.println("\nChoose Room Type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                            ch2 = sc.nextInt();
                            Hotel.features(ch2);
                        break;
                    case 2:System.out.println("\nChoose Room Type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                            ch2 = sc.nextInt();
                            Hotel.availability(ch2);
                        break;
                    case 3:System.out.println("\nChoose Room Type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                            ch2 = sc.nextInt();
                            Hotel.bookroom(ch2);                     
                        break;
                    case 4:
                        System.out.print("Room Number -");
                            ch2 = sc.nextInt();
                            if(ch2>60)
                                System.out.println("Room Doesn't Exist");
                            else if(ch2>40)
                                Hotel.order(ch2-40-1,4);
                            else if(ch2>30)
                                Hotel.order(ch2-30-1,3);
                            else if(ch2>10)
                                Hotel.order(ch2-10-1,2);
                            else if(ch2>0)
                                Hotel.order(ch2-0-1,1);
                            else
                                System.out.println("Room Doesn't Exist");
                            break;
                    case 5:                 
                        System.out.print("Room Number -");
                            ch2 = sc.nextInt();
                            if(ch2>60)
                                System.out.println("Room Doesn't Exist");
                            else if(ch2>40)
                                Hotel.deallocate(ch2-40-1,4);
                            else if(ch2>30)
                                Hotel.deallocate(ch2-30-1,3);
                            else if(ch2>10)
                                Hotel.deallocate(ch2-10-1,2);
                            else if(ch2>0)
                                Hotel.deallocate(ch2-0-1,1);
                            else
                                System.out.println("Room Doesn't Exist");
                            break;
                    case 6:break x;     //labelled break terminates the outermost loop
                } 

                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0); 
                    if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                    {
                        System.out.println("Invalid Option");
                        System.out.println("\nContinue : (y/n)");
                        wish=sc.next().charAt(0); 
                    }                    
            }while(wish=='y'||wish=='Y');    
            
        }        
            catch(Exception e)
            {
                System.out.println("Not a valid input");
            }
    }
}

class Food      //food services
{
    int itemno;
    int quantity;   
    float price;
    
    Food(int itemno,int quantity)
    {
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*50;
                break;
            case 2:price=quantity*60;
                break;
            case 3:price=quantity*70;
                break;
            case 4:price=quantity*30;
                break;
        }
    }
}

class Singleroom 
{
    String name;
    String contact;
    String gender;   
    ArrayList<Food> food =new ArrayList<>();

   
    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
}

class Doubleroom extends Singleroom
{ 
    String name2;
    String contact2;
    String gender2;  
    
    Doubleroom()
    {
        this.name="";
        this.name2="";
    }
    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
}

class NotAvailable extends Exception
{
    @Override
    public String toString()
    {
        return "Not Available !";
    }
}

class AllRooms
{
    Doubleroom LuDo[]=new Doubleroom[10]; //Luxury Doubleroom
    Doubleroom DeDo[]=new Doubleroom[20]; //Deluxe Doubleroom
    Singleroom LuSi[]=new Singleroom[10]; //Luxury Singleroom
    Singleroom DeSi[]=new Singleroom[20]; //Deluxe Singleroom
}

class Hotel
{
    static AllRooms HO=new AllRooms();
    static Scanner sc = new Scanner(System.in);

    static void CustDetails(int i,int rn)       //inputing customer details
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nEnter Customer Name: ");
        name = sc.next();
        System.out.print("Enter Contact Number: ");
        contact=sc.next();
        System.out.print("Enter Gender: ");
        gender = sc.next();
        if(i<3)
        {
        System.out.print("Enter Second Customer Name: ");
        name2 = sc.next();
        System.out.print("Enter Contact Number: ");
        contact2=sc.next();
        System.out.print("Enter Gender: ");
        gender2 = sc.next();
        }      
        
          switch (i) {
            case 1:HO.LuDo[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:HO.DeDo[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:HO.LuSi[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:HO.DeSi[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println("Wrong Option");
                break;
        }
    }
    
    static void bookroom(int i)     //booking room
    {
        int j;
        int rn;
        System.out.println("\nChoose Room Number From : ");
        switch (i) {
            case 1:
                for(j=0;j<HO.LuDo.length;j++)
                {
                    if(HO.LuDo[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter Room Number: ");
                try{
                rn=sc.nextInt();
                rn--;
                if(HO.LuDo[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 2:
                 for(j=0;j<HO.DeDo.length;j++)
                {
                    if(HO.DeDo[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter Room Number: ");
                try{
                rn=sc.nextInt();
                rn=rn-11;
                if(HO.DeDo[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 3:
                  for(j=0;j<HO.LuSi.length;j++)
                {
                    if(HO.LuSi[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter Room Number: ");
                try{
                rn=sc.nextInt();
                rn=rn-31;
                if(HO.LuSi[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
            case 4:
                  for(j=0;j<HO.DeSi.length;j++)
                {
                    if(HO.DeSi[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter Room Number: ");
                try{
                rn=sc.nextInt();
                rn=rn-41;
                if(HO.DeSi[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                   System.out.println("Invalid Option");
                    return;
                }
                break;
            default:
                System.out.println("Enter Valid Option");
                break;
        }
        System.out.println("Room Booked");
    }
    
    static void features(int i)     //displaying room features
    {
        switch (i) {
            case 1:System.out.println("Number of Double Beds : 1\nAC : Yes\nFree Breakfast : Yes\nCharge / Day:4000 ");
                break;
            case 2:System.out.println("Number of Double Beds : 1\nAC : No\nFree Breakfast : Yes\nCharge / Day:3000  ");
                break;
            case 3:System.out.println("Number of Single Beds : 1\nAC : Yes\nFree Breakfast : Yes\nCharge / Day:2200  ");
                break;
            case 4:System.out.println("Number of Single Beds : 1\nAC : No\nFree Breakfast : Yes\nCharge / Day:1200 ");
                break;
            default:
                System.out.println("Enter Valid Option");
                break;
        }
    }
    
    static void availability(int i)     //displaying room availability
    {
      int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<HO.LuDo.length;j++)
                {
                    if(HO.LuDo[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<HO.DeDo.length;j++)
                {
                    if(HO.DeDo[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<HO.LuSi.length;j++)
                {
                    if(HO.LuSi[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<HO.DeSi.length;j++)
                {
                    if(HO.DeSi[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter Valid Option");
                break;
        }
        System.out.println("Number of Rooms Available : "+count);
    }
    
    static void bill(int rn,int rtype)      //bill calculation
    {
        double amount=0;
        String list[]={"VadaPav","BhelPuri","PavBhaji","Lassi"}; //menu
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
               
        switch(rtype)
        {
            case 1:
                amount+=4000;
                    System.out.println("\nRoom Charge - "+4000);
                    System.out.println("\n===============");
                    System.out.println("Food Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:HO.LuDo[rn].food)      
                    /*enhanced for loop 
                    for (Food obb = 0; obb < HOLuDO[rn].food.length; obb++) {
                        System.out.println(HOLuDO[rn].food[obb]);
                    }*/
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";    //proper formating
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    
                break;
            case 2:amount+=3000;
                    System.out.println("Room Charge - "+3000);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:HO.DeDo[rn].food)      //enhanced for loop 
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";    //proper formating
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 3:amount+=2200;
                    System.out.println("Room Charge - "+2200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:HO.LuSi[rn].food)      //enhanced for loop 
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";    //proper formating
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 4:amount+=1200;
                    System.out.println("Room Charge - "+1200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:HO.DeSi[rn].food)      //enhanced for loop 
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%-10s%n";    //proper formating
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            default:
                System.out.println("Not Valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }
    
    static void deallocate(int rn,int rtype)        //checkout with biil payment
    {
        int j;
        char w;
        switch (rtype) {
            case 1:               
                if(HO.LuDo[rn]!=null)
                    System.out.println("Room Used By "+HO.LuDo[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do U Want To CheckOut ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    HO.LuDo[rn]=null;
                    System.out.println("Deallocated Succesfully");
                }
                
                break;
            case 2:
                if(HO.DeDo[rn]!=null)
                    System.out.println("Room Used By "+HO.DeDo[rn].name);                
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do U Want To CheckOut ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    HO.DeDo[rn]=null;
                    System.out.println("Deallocated Succesfully");
                }
                 
                break;
            case 3:
                if(HO.LuSi[rn]!=null)
                    System.out.println("Room Used By "+HO.LuSi[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do U Want To CheckOut ?(y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    HO.LuSi[rn]=null;
                    System.out.println("Deallocated Succesfully");
                }
                
                break;
            case 4:
                if(HO.DeSi[rn]!=null)
                    System.out.println("Room Used By "+HO.DeSi[rn].name);                
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do U Want To CheckOut ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    HO.DeSi[rn]=null;
                    System.out.println("Deallocated Succesfully");
                }
                break;
            default:
                System.out.println("\nEnter Valid Option : ");
                break;
        }
    }
    
    static void order(int rn,int rtype)     //food ordering
    {
        int i,q;
        char wish;
         try{                   //menu with price
             System.out.println("\n==========\n   Menu:  \n==========\n\n1.VadaPav\tRs.50\n2.BhelPuri\tRs.60\n3.PavBhaji\tRs.70\n4.Lassi\tRs.30\n");
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity- ");
            q=sc.nextInt();
           
              switch(rtype){
            case 1: HO.LuDo[rn].food.add(new Food(i,q));  //adding in the food  arraylist
                break;
            case 2: HO.DeDo[rn].food.add(new Food(i,q));  //adding in the food  arraylist
                break;
            case 3: HO.LuSi[rn].food.add(new Food(i,q));  //adding in the food  arraylist
                break;
            case 4: HO.DeSi[rn].food.add(new Food(i,q));  //adding in the food  arraylist
                break;                                                 
        }
              System.out.println("Do U Want To Order Anything Else ? (y/n)");
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y');  
        }
         catch(NullPointerException e)
            {
                System.out.println("\nRoom Not Booked");
            }
         catch(Exception e)
         {
             System.out.println("Cannot Be Done");
         }
    }
}
