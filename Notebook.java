
public class Notebook extends Item
{
    private int sections;
    
    public Notebook(String name,double price,String description,int stock,int id,int sections)
    {
      super(name,price,description,stock,id);
      this.sections=sections;
    }
    
    String getDetails() {
        return " Sections : " + sections;
    }

    public String getItemClass() {
        return "Notebook";
    }
}
