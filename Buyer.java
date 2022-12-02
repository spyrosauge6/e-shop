import java.util.*;

public class Buyer extends User
{
    private int bonus=0;
    private double shipping=0; //metaforika
    private String categor = "Bronze";
    
    
    enum BuyerCategory 
    {
        Bronze, Silver, Gold
    }
    private BuyerCategory Category;
    private ShoppingCard sc1 = new ShoppingCard();
    
    
    public Buyer(String email,String name)
    {
        super(email,name);   
    }
    
    ShoppingCard getShoppingCard() {
        return sc1;
    }
    
   
    void awardBonus(int bon) {
        setBonus(bonus+bon);
        System.out.println("Current Bonus Points : " +getBonus());
        setBuyerCategory();
    }
    
    void placeOrder(itemOrdered it1) {
        sc1.addItemOrdered(it1);
    }
    
    void setBuyerCategory() {
            
        if(bonus>=0 && bonus<100) {
              Category = BuyerCategory.Bronze; 
        }
        else if(bonus>=100 && bonus<200) {
            Category = BuyerCategory.Silver;
        }
        else {
            Category = BuyerCategory.Gold;
        }
    }

    int getBonus() {
        return bonus;
    }
    
    String getCategory() {
        setBuyerCategory();
        String cat="";
        if(Category == BuyerCategory.Bronze) {
            cat = "Bronze";
        }
        
        if(Category == BuyerCategory.Silver) {
            cat = "Silver";

        }
        
        if(Category == BuyerCategory.Gold) {
             cat = "Gold";
        }
        
        return cat;
    }
    
     void setShipping(double y) {
        shipping = y;
    }
    
    double getShipping() {
        return shipping;
    }
    
    void setBonus(int y) {
        bonus = y;
    }
    
    public String toString() {
        return getStats() + "\nCurrent bonus : " + getBonus() + "\nCategory : " + getCategory() + "\n";
    }
    
}
