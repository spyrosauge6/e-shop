
public class Pencil extends Item
{   
    private double tipSize;
    public enum type {
        H,B,HB;
    }
    public type penciltype;
    
    public Pencil(String name,double price,String description,int stock,int id,double tipSize,type penciltype)
    { 
       super(name,price,description,stock,id);
       this.tipSize = tipSize;
       this.penciltype = penciltype;
       
    }
    
    String getDetails() {
        return " TipSize : " + tipSize + " Type : " + penciltype;
    }
    
    public String getItemClass() {
        return "Pencil";
    }
    
}
