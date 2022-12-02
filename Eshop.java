import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Eshop 
{
    private String name;
    private Owner owner;
    private ArrayList<Item> itemsList = new ArrayList<Item>();
    private ArrayList<Buyer> buyersList = new ArrayList<Buyer>(); 
    private ArrayList<Item> PenList = new ArrayList<Item>();
    private ArrayList<Item> NotebookList = new ArrayList<Item>();
    private ArrayList<Item> PencilList = new ArrayList<Item>();
    private ArrayList<Item> PaperList = new ArrayList<Item>();
    private ArrayList<String> ClassList = new ArrayList<String>();
    
    

    public Eshop() {
    
    }
    
    public Eshop(String name,Owner owner) 
    {
        this.name=name;
        this.owner=owner;
    }
    
    boolean buyerExists(String email) {
        boolean exists = false;
        
        for(int i=0;i<buyersList.size();i++) {
            if(buyersList.get(i).getEmail().equals(email)) 
                exists = true;
        }
        
        return exists;
    }
    
    Buyer getBuyerByEmail(String email) {
        int c = -1;
        try{
        for(int i=0;i<buyersList.size();i++) {
            if(buyersList.get(i).getEmail().equals(email)) 
                c=i;
        }
    }
    catch(IndexOutOfBoundsException e ) {
        System.out.println("\nBuyer not found in list!");
    }
    return buyersList.get(c);
    }
    
    Owner getOwner() {
        return owner;
    }
    
    void addItem(Item item) {
        if(!itemsList.contains(item) )
            itemsList.add(item);
        else System.out.println("\nItem already exists!");
        
        if(item.getItemClass().equals("Pen")) 
            PenList.add(item);
        
        if(item.getItemClass().equals("Notebook")) 
            NotebookList.add(item);
            
        if(item.getItemClass().equals("Pencil")) 
            PencilList.add(item);
        
        if(item.getItemClass().equals("Paper")) 
            PaperList.add(item);    
    }
    
    Item getPenByOrder(int order) {
        try{
        return PenList.get(order-1);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("\nError,program crashed!");
            System.exit(0);
            return null;
        }
    }
    
    Item getNotebookbyOrder(int order) {
        try{
        return NotebookList.get(order-1);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("\nError,program crashed!");
            System.exit(0);
            return null;
        }
    }
    
    Item getPencilByOrder(int order) {
        try{
        return PencilList.get(order-1);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("\nError,program crashed!");
            System.exit(0);
            return null;
        }
    }
    
    Item getPaperByOrder(int order) {
        try{
        return PaperList.get(order-1);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("\nError,program crashed!");
            System.exit(0);
            return null;
        }
    }
    
    Item getItemById(int id) {
        int c=-1;
        
        for(int i=0;i<itemsList.size();i++) {
            if(id==(itemsList.get(i).getId())) {
                c=i;
                break;
            }
           
        }
         return itemsList.get(c);
        }
        
    
    
    
    void removeItem(Item item) {
        if(itemsList.contains(item) )
            itemsList.remove(item);
        else System.out.println("\nItem does not exist!");
      
    }
    
    
    
    void addBuyer(Buyer buyer)  {
        
        if(!buyersList.contains(buyer) ) {
            buyersList.add(buyer);
        
            }
        else{
            System.out.println("\nBuyer already exists!");
        }
            

        }


    void removeBuyer(User buyer) {
         if(buyersList.contains(buyer) )
            buyersList.remove(buyer);
        else System.out.println("\nBuyer does not exist!");
    }
    
    void updateItemStock(Item item,int newStock) {
        item.setStock(newStock);
    }
    
    void showCategories() {
        for(int i=0;i<itemsList.size();i++) {
            if(!ClassList.contains(itemsList.get(i).getItemClass())) 
                ClassList.add(itemsList.get(i).getItemClass());
        }
        
        for(int i=0;i<ClassList.size();i++) {
            System.out.println((i+1) + ")" + ClassList.get(i));
        }
    }
    
    void showProductsInCategory(int Class) {
        switch(Class) {
            case 1 : 
                for(int i=0;i<PenList.size();i++) {
                    System.out.println(i+1 + ")" + PenList.get(i));  
                }
            break;   
            case 2 : 
                for(int i=0;i<NotebookList.size();i++) {
                    System.out.println(i+1 + ")" + PencilList.get(i));  
                }
            break;     
            case 3 : 
                for(int i=0;i<PencilList.size();i++) {
                    System.out.println(i+1 + ")" + NotebookList.get(i));  
                }  
            break;    
            case 4 : 
                for(int i=0;i<PaperList.size();i++) {
                    System.out.println(i+1 + ")" + PaperList.get(i));  
                }
            break;
        }
    }
    
    void showProduct(Item item) {
        System.out.println(item);
    }
    
    void checkStatus() {
        for(int i=0;i<buyersList.size();i++) {
            System.out.print( "\n ==================== \n Buyer name : " + buyersList.get(i).getName() + "\n ==================== \n Points : ");
            System.out.println(buyersList.get(i).getBonus() + "\n ==================== \n Category : " +  buyersList.get(i).getCategory()+"\n");
        }
    }
    
    void viewItemList() {
        for(int i=0;i<itemsList.size();i++) {
            System.out.println((i+1) + ")" + itemsList.get(i));
        }
        
    }
    
    Item getItemListByOrder(int ord) {
        return itemsList.get(ord-1);
        
    }
    
    void viewBuyerList() {
        for(int i=0;i<buyersList.size();i++) {
            System.out.println(buyersList.get(i));
        }
        
    }
    
    

    
}
