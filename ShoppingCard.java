//import java.util.ArrayList;
import java.util.*;

public class ShoppingCard
{
    
    private static ArrayList<itemOrdered> listOrder = new ArrayList<itemOrdered>();
    
    
    void addItemOrdered(itemOrdered itemOrd) {
      int flag = 0;
        if(itemOrd.getQuantity() <= itemOrd.getItem().getStock() ) { 
            
               for(int i=0;i<listOrder.size();i++) {
                   if( (itemOrd.getItem().getId() ) == (listOrder.get(i).getItem().getId()) )
                    {
                        flag = 1;
                        listOrder.get(i).getItem().setStock(listOrder.get(i).getItem().getStock() - itemOrd.getQuantity());
                        listOrder.get(i).setQuantity(listOrder.get(i).getQuantity() + itemOrd.getQuantity());
                        System.out.println("Succesfully added to your basket!\n\n");
                     }
                }
                
                if(flag==0) {
                    listOrder.add(itemOrd);
                    itemOrd.getItem().setStock(itemOrd.getItem().getStock() - itemOrd.getQuantity());
                    System.out.println("Succesfully added to your basket!\n\n");
                }
            
        }
        
        else {
            System.out.println("\nItem :  Not available in that quantity,we're sorry.\n");
            itemOrd = null; //diagrafi antikeimenou.
        }
        
       
    }
    
    void removeItemOrdered(itemOrdered itemOrd) {
        if(listOrder.contains(itemOrd)) {
            listOrder.remove(itemOrd);
            itemOrd.getItem().setStock(itemOrd.getItem().getStock() + itemOrd.getQuantity());
            itemOrd.setQuantity(0);
        }
        
        else {
            System.out.println("\nItem doesn't exist in your ShoppingCard!\n");
            itemOrd = null;
        }
    }
    
    itemOrdered viewOrderedItemByOrder(int num) {
        try{
        return listOrder.get(num-1);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("\nError!\n");
            System.exit(0);
            return null;
        }
    }
    
    void clearCart() {
        while(listOrder.size() != 0 ) {
            int i = listOrder.size() - 1 ;
            removeItemOrdered(listOrder.get(i));
            System.out.println("Deleting objects...");
        }
        System.out.println("Number of products in your basket : " + listOrder.size());
    }
    
    void checkout(Buyer b1) {
        
        int points=0;
        System.out.println("\nYour shopping Bag is  : \n ===================================================================");
        showCart();
        System.out.println("\nAre you sure you want to continue ? \n Press \"Y\" to continue, or press \"N\" to decline.");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if(answer.equals("Y") ){
           
            points = ((int) Math.floor(calculateNet())) / 10;
            b1.awardBonus(points);
            calculateCourierCost(b1);
            listOrder.clear();
        }
        else if(answer.equals("N") ){
            System.out.println("\nGoodBye!");
        }
        
        else 
            System.out.println("\nWrong input"); 
            
    }
    
    double calculateNet() {
        double sum = 0;
        for(int i=0;i<listOrder.size();i++ ) { 
                double timh = listOrder.get(i).getItem().getPrice();
                int kommatia = listOrder.get(i).getQuantity();
                sum = sum + (timh * kommatia);
                
                
               
               
            }
            System.out.println("\nSum : " + sum);
            return sum;
    }
    
    double calculateCourierCost(Buyer b1) {
        double sum = calculateNet();
        double courierCost=b1.getShipping();
        if(listOrder.size()>0) {
        
        courierCost = sum * 0.2;
        b1.setShipping(courierCost);
        if(b1.getShipping()<3) {
            if(listOrder.size()!=0)
            System.out.println("\nCourier cost can't be less than 3 Euros,we're sorry.");
            else
            System.out.println("\nEmpty Basket");
        }
        else {
           if(b1.getCategory().equals("Bronze")) {
            System.out.println("\nCourier Cost is : " + courierCost + " Euros,you have no discount.");
        }
        
        if(b1.getCategory().equals("Silver")) {
            b1.setShipping(courierCost * 0.5);
            courierCost = b1.getShipping();
             System.out.println("\nCourier Cost is : " + b1.getShipping() + " Euros,you have 50% discount!");
        }
        
        if(b1.getCategory().equals("Gold")) {
             b1.setShipping(0);
             courierCost = b1.getShipping();
             System.out.println("\nCourier Cost is : " + b1.getShipping() + " Euros,you have 100% discount!");
        }
        }
    }
   
        return courierCost;
    }
    
   void changeItemOrderedQuantity(Eshop es1,itemOrdered itemOrd, int newQuantity) {
        for(int i=0;i<listOrder.size();i++) {
            if(listOrder.get(i).getItem().getId() == itemOrd.getItem().getId() ) {
                listOrder.get(i).getItem().setStock(listOrder.get(i).getItem().getStock() + listOrder.get(i).getQuantity());
                
                listOrder.get(i).setQuantity(newQuantity);
                
                es1.updateItemStock(listOrder.get(i).getItem(),listOrder.get(i).getItem().getStock() - newQuantity);
            }
        }
    }

    void showCart() {
        if(listOrder.size() ==0 ) 
            System.out.println("\nYour basket is empty!");
        else
            {System.out.println("\nNumber of products in your basket : " + listOrder.size());
        for(int i=0;i<listOrder.size();i++) {
            System.out.println((i+1) + ")" +listOrder.get(i));
            }
        }
    }
    
    public ShoppingCard()
    {
       
    }

    
}
