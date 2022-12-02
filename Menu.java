import java.awt.*;
import java.util.*;
import java.io.*;
public class Menu  {
    public static Owner owner = new Owner("drtmisk1@gmail.com", "DrtMisk"); //orizw owner
    public static Eshop es1 = new Eshop("Eshop Naousa", owner); //orizw eshop tou owner
    boolean exit = false;
    private  Scanner sc1  = new Scanner(System.in);
    public Menu() {
     
     
    }
    
   
    public void printWelcome() 
    {
       
       System.out.println("+-----------------------------------------+\n"+
       "|                                         |\n"+
       "|         Welcome to our Eshop!           |\n"+
       "|                                         |\n"+
       "|            Eshop CEID!!                 |\n"+
       "+-----------------------------------------+\n");
    }
    
    public String enterEmail() {
       System.out.println("Enter your email : ");
       String EnteredEmail = sc1.nextLine();
       return EnteredEmail;
       
    }
    
    public void register(String newEmail) {
        System.out.println("This email doesn't belong to any registered account.\n Would you like to register ? Type \"Y\" for Yes or \"N\" for No ");      
        int answer = getAnswer();
        if(answer ==1 ) {
           Scanner sc2 = new Scanner(System.in);
           System.out.println("Give a username");
           String username = sc2.nextLine();
           Buyer newBuyer = new Buyer(newEmail,username);
           es1.addBuyer(newBuyer);
           System.out.println("You are now registered with these information : \n");
           System.out.println(newBuyer);
           System.out.println("Redirecting you to main page...\n\n");
           BuyerMenuRun(newEmail);
        }
        else if(answer == 0) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }
    
    
    public int emailType(String email) {
    int userType = -1;

    label :while( userType != 0 || userType != 1 || userType != 2) {
       
       if(email.equals("drtmisk1@gmail.com") ) {    
        userType = 0;
        break label;
        
    }
       else if(es1.buyerExists(email)) {
        userType = 1;  
        break label;
        }
        
        else {
            userType = 2;
            break label;
        }
    }
       
       return userType;
    }
    
    public void printBuyerMenu() {
        System.out.println("What would you like to do ? \n 1->Browse Store \n 2->View Cart \n 3->Checkout \n 4->Back \n 5->Log out \n 6->Exit Program \n\n");  
    }
    
    public void printOwnerMenu() {
        System.out.println("What would you like to do? \n 1->Browse Store \n 2->Check Status \n 3->Back \n 4->Log Out \n 5->Exit Program\n\n ");     
    }
    
    public void OwnerMenuRun() {
        printWelcome();
        while(!exit) {
        printOwnerMenu();
        int choice = getOwnerChoice();
        OwnerAction(choice);
        }
    }
    
    public void BuyerMenuRun(String email) {
        printWelcome();
        while(!exit) {
            printBuyerMenu();
            int choice = getChoice();
            BuyerAction(choice,email);
        }
    }
    
    public int getOwnerChoice() {
        int choice = -1;
        while(choice < 1 || choice > 5) {
            try{
                System.out.print("\nEnter your choice :  ");
                choice = sc1.nextInt();
            }
            
            catch(InputMismatchException e) {
                System.out.println("\nError,wrong input!!!");
                System.exit(0);
            }
        }
        return choice;
    }
    
    public int getChoice() {
        int choice = -1;
        while(choice<1 || choice >6) {
            try{
                System.out.print("\nEnter your choice :  ");
                choice = sc1.nextInt();
            }
            
            catch(InputMismatchException e) {
                System.out.println("\nError,wrong input!!!");
                System.exit(0);
                
            }
        }
        return choice;
    }
    
    public int BuyerCase2Choice(){
        int choice = -1;
        while(choice < 1 || choice > 5) {
            try{
                System.out.print("\nEnter your choice :  ");
                choice = sc1.nextInt();
            }
            
            catch(InputMismatchException e) {
                System.out.println("\nError,wrong input!!!");
                System.exit(0);
            }
        }
        return choice;
    }
    
    public int BuyerCaseChoice(){
        int choice = -1;
        while(choice < 1 || choice > 4) {
            try{
                System.out.print("\nEnter your choice :  ");
                choice = sc1.nextInt();
            }
            
            catch(InputMismatchException e) {
                System.out.println("\nError,wrong input!!!");
                System.exit(0);
            }
        }
        return choice;
    }
    
    public void BuyerCase2Action(int choice,String email) {
        switch (choice) {
            case 1 :
                System.out.println("Which item do you want to delete?");
                int answer1 = sc1.nextInt();
                System.out.println("\nYou have selected to delete this item \n ===================== \n" + es1.getBuyerByEmail(email).getShoppingCard().viewOrderedItemByOrder(answer1).getItem());
                es1.getBuyerByEmail(email).getShoppingCard().removeItemOrdered(es1.getBuyerByEmail(email).getShoppingCard().viewOrderedItemByOrder(answer1));
                break;
                
            case 2:
                System.out.println("Which item do you want to modify its quantity? (Select based on your basket numbers!)");
                answer1 = sc1.nextInt();
                System.out.println("Enter the new quantity :");
                int newquantity = sc1.nextInt();
                es1.getBuyerByEmail(email).getShoppingCard().changeItemOrderedQuantity(es1,es1.getBuyerByEmail(email).getShoppingCard().viewOrderedItemByOrder(answer1),newquantity);
                break;
                
            case 3:
                es1.getBuyerByEmail(email).getShoppingCard().clearCart();
                break;
                
            case 4:
                es1.getBuyerByEmail(email).getShoppingCard().checkout(es1.getBuyerByEmail(email));
                break;
            case 5:
                BuyerMenuRun(email);
        }
    }
     
    public void BuyerAction(int choice,String email) {
        switch (choice) {
            case 1:
                es1.showCategories();
                int option1 = BuyerCaseChoice();
                es1.showProductsInCategory(option1);
                System.out.println("Which item do you want to select :");
                Scanner sc3 = new Scanner(System.in);
                try{
                int option2 = sc3.nextInt();
                BuyerItemList(option1,option2,email);
            }
            catch(InputMismatchException e) {
                System.out.println("Error,wrong input!!");
                System.exit(0);
            }
                
                break;
            
            case 2:
                es1.getBuyerByEmail(email).getShoppingCard().showCart();
                System.out.println("Press : \n 1)To delete an item \n 2)To modify item's quantity \n 3)To clear your basket \n 4)To checkout \n 5)Back to menu");
                int choice2 = BuyerCase2Choice();
                BuyerCase2Action(choice2,email);
                
                break;
                
            case 3:
                es1.getBuyerByEmail(email).getShoppingCard().checkout(es1.getBuyerByEmail(email));
                
                break;
                
            case 4:
                BuyerMenuRun(email);    
            
            case 5:
                System.out.println("You have succesfully logged out!");
                printWelcome();
                System.out.println("Would you like to log in again?");
                int answer = getAnswer();
                if(answer == 1) {
                System.out.println("Enter your email : ");
                Scanner sc2 = new Scanner(System.in);
                String reEnterEmail = sc2.nextLine();
                checkIfEmailExists(reEnterEmail);
               }
               else
                System.exit(0);
               
               break;
            
            case 6:
            System.out.println("\nThank you for visiting our eshop,goodbye!");
            exit = true;
        }
    }
    
    public void OwnerAction(int choice) {
        switch(choice) {
            case 1:
                System.out.println("Eshop Miskos");
                es1.viewItemList();
                System.out.println("Which item do you want to select ?");
                try{
                int option2 = sc1.nextInt();    
                System.out.println("You have selected this item \n =================== \n " + es1.getItemListByOrder(option2));
                System.out.println("Would you like to change this item's stock value ?\n Type \"Y\" for Yes or \"N\" for No ");
                if(getAnswer() == 1 ) {
                System.out.println("Give the new stock for this item : ");
                int newstock = sc1.nextInt();
                es1.updateItemStock(es1.getItemListByOrder(option2),newstock);
            }
            else {
            System.out.println("We're going back to the menu!");
            OwnerMenuRun();
        }
        }
                catch(InputMismatchException e) {
                System.out.println("Wrong input!!");
                System.exit(0);
            }
        
        
        
                break;
                
            case 2:
                es1.viewBuyerList();
                break; 
                
            case 3:
                OwnerMenuRun();
                break;
                
            case 4:
                System.out.println("You have succesfully logged out!");
                printWelcome();
                System.out.println("Would you like to log in again?");
                int answer = getAnswer();
                if(answer == 1) {
                System.out.println("Enter your email : ");
                Scanner sc2 = new Scanner(System.in);
                String reEnterEmail = sc2.nextLine();
                checkIfEmailExists(reEnterEmail);
               }
               else
                System.exit(0);
               
               break;
                
            case 5:
            System.out.println("\nGoodbye sir!");
            exit = true;
                
        }
    }
    
    public void BuyerItemList(int catChoice,int itemChoice,String email) {
        Scanner sc2 = new Scanner(System.in);
        switch(catChoice) {
            case 1:
            System.out.println("You have selected this item \n =================== \n " + es1.getPenByOrder(itemChoice));
            System.out.println("Are you sure you want to continue?\n Type \"Y\" for Yes or \"N\" for No ");
            //String answer1 = sc1.nextLine();
            if(getAnswer() == 1) {
            System.out.println("Enter quantity : ");
            
            try{
            int quantity1 = sc2.nextInt();
            itemOrdered it1 = new itemOrdered(es1.getPenByOrder(itemChoice),quantity1);
            es1.getBuyerByEmail(email).placeOrder(it1);}
            catch(NumberFormatException e) {
                System.out.println("Wrong input!");
            }
            
            }
            
            else if(getAnswer() == 0 ) {
                System.out.println("Order canceled");
                System.exit(0);
                
            }
            break;
            
            case 2:
            System.out.println("You have selected this item \n =================== \n " + es1.getPencilByOrder(itemChoice));
            System.out.println("Are you sure you want to continue?\n Type \"Y\" for Yes or \"N\" for No ");
            //answer1 = sc1.nextLine();
            if(getAnswer() == 1) {
            System.out.println("Enter quantity : ");
            try{
            int quantity1 = sc2.nextInt();
            itemOrdered it1 = new itemOrdered(es1.getPencilByOrder(itemChoice),quantity1);
            es1.getBuyerByEmail(email).placeOrder(it1);}
            catch(NumberFormatException e) {
                System.out.println("Wrong input!");
            }
            
            }
            
            else if(getAnswer() == 0 ) {
                System.out.println("Order canceled");
                System.exit(0);
                
            }
            
            break;
            
            
            case 3:
            System.out.println("You have selected this item \n =================== \n " + es1.getNotebookbyOrder(itemChoice));
            System.out.println("Are you sure you want to continue?\n Type \"Y\" for Yes or \"N\" for No ");
            //answer1 = sc1.nextLine();
            if(getAnswer() == 1) {
            System.out.println("Enter quantity : ");
            try{
            int quantity1 = sc2.nextInt();
            itemOrdered it1 = new itemOrdered(es1.getNotebookbyOrder(itemChoice),quantity1);
            es1.getBuyerByEmail(email).placeOrder(it1);}
            catch(NumberFormatException e) {
                System.out.println("Wrong input!");
            }
            }
            else if(getAnswer() == 0 ) {
                System.out.println("Order canceled");
                System.exit(0);
                
            }
            
            break;
            
            case 4:
            System.out.println("You have selected this item \n =================== \n " + es1.getPaperByOrder(itemChoice));
            System.out.println("Are you sure you want to continue?\n Type \"Y\" for Yes or \"N\" for No ");
            //answer1 = sc1.nextLine();
            if(getAnswer() == 1) {
            System.out.println("Enter quantity : ");
            try{
            int quantity1 = sc2.nextInt();
            itemOrdered it1 = new itemOrdered(es1.getPaperByOrder(itemChoice),quantity1);
            es1.getBuyerByEmail(email).placeOrder(it1);}
            catch(NumberFormatException e) {
                System.out.println("Wrong input!");
            }
            
            }
            
            else if(getAnswer() == 0 ) {
                System.out.println("Order canceled");
                System.exit(0);
                
            }
            
            break;
            
        }
    }
    
    public int getAnswer() {
        int bool = -1;
        Scanner sc2 = new Scanner(System.in);
        
        while(bool != 0 || bool != 1){
        String answer=sc2.nextLine();
        
        if(answer.equals("Y") ) {
            bool = 1;
            break;
        }
        else if(answer.equals("N") ) {
            bool = 0;
            break;
        }
        else {
            System.out.println("Wrong entry,please try again!");
            
        }
        
        }
       
        return bool;
    }
    
    public void checkIfEmailExists(String email) {
 
       if(emailType(email) == 1 )  {  //exw orisei 1 ws buyer, 0 ws Owner
          System.out.println("\n\nWelcome " + es1.getBuyerByEmail(email).getName());
          System.out.println("\nYour stats are \n ================================== \n" + es1.getBuyerByEmail(email));
          BuyerMenuRun(email); 
       }
       
       else if(emailType(email) == 0 ) {
          System.out.println("\n\nWelcome Mr Miskos! ( Owner of the eshop!) ");
          OwnerMenuRun(); 
        }
       else {
           register(email);
        }
    }

     public static void main(String args[]) {
       
       
       Pen p1 = new Pen("Stylo Big", 2 , "Ena aplo Stylo" , 100 , 193841, "Black", 21); 
       Pen p2 = new Pen("Stylo Pilot", 5 , "Poiotiko Stylo" , 94 , 193211, "Blue", 12); 
       Pen p3 = new Pen("Stylo Pilot(Small Ekdosh)", 2.3 , "Poiotiko Stylo se mikrh ekdosh" , 94 , 193211, "Blue", 12);
       Pencil pe1 = new Pencil("Molyvi xwris svhstra", 0.5 , "Aplo molyvi" , 200 , 123341, 6.7 , Pencil.type.H); 
       Pencil pe2 = new Pencil("Molyvi me svhstra", 1 , "Aplo molyvi + Svhstra" , 30 , 123111, 6.7 , Pencil.type.HB);
       Pencil pe3 = new Pencil("Mhxaniko Molyvi", 3 , "Mhxaniko molyvi me dwro mytes" , 55 , 123641, 6.7 , Pencil.type.B);
       Notebook n1 = new Notebook("Shape",3,"Kalo shmeiwmatario",100,1067429,3);
       Notebook n2 = new Notebook("Skag",5,"Epwnymh marka me sklhro xarti",100,1061215,3);
       Notebook n3 = new Notebook("Note",5.6,"Tetradio me xarti filiko pros to perivallon",100,1061435,3);
       Paper pa1 = new Paper("Paketo 100 kolles A4",5,"100 kolles a4",1000,987341,100,2);
       Paper pa2 = new Paper("Paketo 100 kolles A3",7,"100 kolles a3",350,987990,100,4);
       Paper pa3 = new Paper("Paketo 100 kolles A5",10,"100 kolles a5",97,987123,100,5);
       Buyer b1 = new Buyer("drtmisk7@gmail.com","Miskos7");
       Buyer b2 = new Buyer("augerinoscr7@gmail.com", "spyrosauge"); 
       Buyer b3 = new Buyer("Alexchrys99@gmail.com", "AlexChrys");
       es1.addBuyer(b1);
       es1.addBuyer(b2);
       es1.addBuyer(b3);
       es1.addItem(p1);
       es1.addItem(p2);
       es1.addItem(p3);
       es1.addItem(pe1);
       es1.addItem(pe2);
       es1.addItem(pe3);
       es1.addItem(n1);
       es1.addItem(n2);
       es1.addItem(n3);
       es1.addItem(pa1);
       es1.addItem(pa2);
       es1.addItem(pa3);
       Menu m1 = new Menu();
       m1.printWelcome();
       String emailExists = m1.enterEmail();
       m1.checkIfEmailExists(emailExists);
       
       
        
        
            
    
    
  }
    
}


       
           
     



