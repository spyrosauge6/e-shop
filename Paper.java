
public class Paper extends Item
{
    private int pages,weight;
    
    public Paper(String name,double price,String description,int stock,int id,int pages,int weight)
    {
        super(name,price,description,stock,id);
        this.pages=pages;
        this.weight = weight;
        
    }
    
    String getDetails() {
        return " Pages : " + pages + " Weight : " + weight;
    }
    
    public String getItemClass() {
        return "Paper";
    }
}
