
package hust.soict.dsai.aims.cart;

import javax.naming.LimitExceededException;
import java.util.*;
import hust.soict.dsai.aims.media.MediaTienLC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CartTienLC {
	
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<MediaTienLC> itemsOrdered = FXCollections.observableArrayList();
    public ObservableList<MediaTienLC> getItemsOrdered() {
		return itemsOrdered;
	}
    
    public int qtyOrdered = 0;
  
    public String addMedia(MediaTienLC media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        } else if (itemsOrdered.contains(media)) {
            return(media.getTitle() + " is already in the cart!");
        } else {
            qtyOrdered +=1;
            itemsOrdered.add(media);
            return (media.getTitle() + " has been added!");
        }
    }
    public void removeMedia(MediaTienLC media) {
        if (itemsOrdered.size() == 0) {
            System.out.println("Nothing to remove!");
        } else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart.");
                qtyOrdered -=1;
            } else {
                System.out.println("Media not found in cart!");
            }
        }
    }
    
 // Search to remove
    public MediaTienLC searchToRemove(String title) {
		for (MediaTienLC media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
    
 // Search by title, category, price (max cost/ min-max cost) and ID
    public void searchByTitle(String keyword) {
        boolean matchFound = false;
        for (MediaTienLC media : itemsOrdered) {
            if (media.isMatch(keyword)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no media were found with \"" + keyword + "\" in the title!");
        }
    }
    
    public void searchByCategory(String category) {
        boolean found = false;
        for (MediaTienLC media : itemsOrdered) {
            if (media.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no media matching the \"" + category + "\" category were found!");
        }
    }
    
    public void searchByPrice(float maxCost) {
        boolean matchFound = false;
        for (MediaTienLC media : itemsOrdered) {
            if (media.getCost() <= maxCost) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no media were found that match the maximum cost provided!");
        }
    }
    
    public void searchByPrice(float minCost, float maxCost) {
        boolean matchFound = false;
        for (MediaTienLC media : itemsOrdered) {
            if (media.getCost() >= minCost && media.getCost() <= maxCost) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no media were found that match the cost range between your specified minimum and maximum!");
        }
    }
    
    public void searchByID(int id) {
        boolean found = false;
        for (MediaTienLC media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no media were found that match the ID provided!");
        }
    }
    
    //update total cost
    public float totalCostTienLC(){
        float sum = 0.00f;
        for(MediaTienLC media : itemsOrdered){
            sum += media.getCost();
        }
        return Math.round(sum * 100.0f) / 100.0f;
    }
    
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (MediaTienLC media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.println("Total items: " + qtyOrdered);
        System.out.println("Total cost: " + totalCostTienLC());
        System.out.println("***************************************************");
    }

    public void empty() {
        if (itemsOrdered.size() == 0) {
            System.out.println("Nothing to remove!");
        } else {
            qtyOrdered = 0;
            itemsOrdered.clear();
            System.out.println("Order created.");
            System.out.println("Now your current cart will be empty!");
            System.out.println();
        }
    }
    
    public String placeOrder() {
        if (itemsOrdered.size() == 0) {
            return "Your cart is empty!";
        } else {
            qtyOrdered = 0;
            itemsOrdered.clear();
            return "Order created!\n" + "Now your cart will be empty!";
        }
    }

 // Sort media in cart
    public void sortMediaByTitle() {
        Collections.sort((List<MediaTienLC>)itemsOrdered, MediaTienLC.COMPARE_BY_TITLE_COST);
        Iterator<MediaTienLC> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((MediaTienLC)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<MediaTienLC>)itemsOrdered, MediaTienLC.COMPARE_BY_COST_TITLE);
        Iterator<MediaTienLC> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((MediaTienLC)iterator.next()).toString());
        }
    }
}
