
public class Owner extends User
{
    private boolean isAdmin = true;
    
    public Owner(String email,String name)
    {
        super(email,name);
        isAdmin=true;
    }
    
    int getBonus() {
        return 0;
    }
    
    String getCategory() {
        return "";
    }
    
    void placeOrder(itemOrdered it1) {
    }
    
    ShoppingCard getShoppingCard()
    {
        return null;
    }
}
