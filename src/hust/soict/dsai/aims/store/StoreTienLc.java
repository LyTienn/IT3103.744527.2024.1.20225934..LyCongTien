
package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.MediaTienLC;
import java.util.ArrayList;

public class StoreTienLc {
	
    private ArrayList<MediaTienLC> itemsInStore = new ArrayList<MediaTienLC>();
    
    public ArrayList<MediaTienLC> getItemsInStore() { 
        return itemsInStore; 
    }

 // Add and remove media from the store
    public void addMedia(MediaTienLC media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media " + media.getTitle() + " is already in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        }
    }
    public void removeMedia(MediaTienLC media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is not in the store!");
        }
    }
    
 // Print the store
    public void print() {
        if (itemsInStore.size() == 0) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("********************STORE INVENTORY********************");
            for (MediaTienLC media : itemsInStore) {
                System.out.println(media);
            }
            System.out.println("********************************************************");
        }
    }

    public MediaTienLC search(String title) {
		for (MediaTienLC media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
}
