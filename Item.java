
abstract class Item 
{
    private String name,description;
    private double price;
    private int stock,id;
    
    public Item() 
    {
       name="";
       price = 0;
       description = "";
       stock = 0;
       id = 0;
    }
    
    public Item(String name,double price,String description,int stock,int id)
    {
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.id=id;
        
    }
    
    //Getters
    
    String getName() {
        return name;
    }
    
    double getPrice() {
        return price;
    }
    
    String getDescription() {
        return description;
    }
    
    int getStock(){
        return stock;
    }
    
    int getId() {
        return id;
    }
    
    //Setters
    
    void setName(String name) {
        this.name=name;
    }
    
    void setPrice(double price) {
        this.price=price;
    }
    
    void setDescription(String description) {
        this.description=description;
    }
    
    void setStock(int stock) {
        this.stock=stock;
    }
    
    void setId(int id) {
        this.id=id;
    }
    
     String getBasicInfo() {
        return "Name : " + name + ", Price : " +price + ", Description : " + description + ", Stock : " + stock + ", ID : " + id;
    }
    
    abstract String getDetails() ;
    
    public String toString() {
        return getBasicInfo() + getDetails();
        
    }
    
    abstract String getItemClass() ;
        
    

}
