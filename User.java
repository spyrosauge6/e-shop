
abstract class User
{
    String email,name;
    
    public User(){
        email="";
        name="";
    }
    
    public User(String email,String name )
    {
       this.email = email;
       this.name = name;
    }
    
    //Getters
    
    String getEmail() {
        return email;
    }
    
    String getName() {
        return name;
    }
    
    //Setters
    
    void setEmail(String email) {
        this.email = email;
    }
    
    void setName(String name) {
        this.name=name;
    }
    public String getStats() {
        return "Username : " + getName() + "\n" + "Email : " + getEmail();
    }
    
    abstract int getBonus();
    
    abstract String getCategory();
    
    abstract void placeOrder(itemOrdered it1);
    
    abstract ShoppingCard getShoppingCard();
}
    

