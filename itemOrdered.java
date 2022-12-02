
public class itemOrdered
{
    
    private Item item;
    private int quantity;

   
    public itemOrdered(Item item,int quantity)
    {
       this.item = item;
       this.quantity = quantity;
    }
    
    int getQuantity() {
        return quantity;
    }
    
    Item getItem() {
        return item;
    }
    
    void setQuantity(int y) {
        quantity = y;
    }

    public String toString() {
        return "Item's name : " + item.getName() + "\n Quantity : " + getQuantity();
    }
}
