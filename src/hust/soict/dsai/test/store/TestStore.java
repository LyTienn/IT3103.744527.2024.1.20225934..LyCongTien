
package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDiscTienLC;
import hust.soict.dsai.aims.store.StoreTienLc;
public class TestStore {
    public static void main(String[] args) {
        StoreTienLc store = new StoreTienLc();
        DigitalVideoDiscTienLC dvd1 = new DigitalVideoDiscTienLC("Tom and Jerry", "Cartoon", "Gene Deitch", 20, 120);
        DigitalVideoDiscTienLC dvd2 = new DigitalVideoDiscTienLC("The Lion king", "anime", "Roger Allers", 15, 87);
        DigitalVideoDiscTienLC dvd3 = new DigitalVideoDiscTienLC("Toy Story", "anime",  "John Lasseter", 17, 150);
        
        store.addMediaTienLC(dvd1);
        store.addMediaTienLC(dvd2);
        store.addMediaTienLC(dvd3);
         
        System.out.println(store.toString());
        
        store.removeMediaTienLC(dvd1);
        store.removeMediaTienLC(dvd2);
        
        System.out.println(store.toString());
    }
}



