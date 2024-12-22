
package hust.soict.dsai.aims.media;

import java.util.*;

public class BookTienLC extends MediaTienLC {
   
    private List<String> authors = new ArrayList<String>();   
    
    public BookTienLC(String title) {
        super(title);
    }
    public BookTienLC(String title, String category) {
        super(title, category);
    }
    public BookTienLC(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public void addAuthorTienLC(String authorName){
        if(authors.contains(authorName)){
            System.out.println("Author is already in the list.");
        }
        else{
            authors.add(authorName);
            System.out.println("added new Author successfully.");
        }
    }
    public void removeAuthorTienLC(String authorName){
        if(!authors.contains(authorName)){
            System.out.println("Not found the author.");
        }
        else{
            authors.remove(authorName);
            System.out.println("Deleted Author successfully.");
        }
    }
   
    @Override
    public String toString() {
        return this.getId() + " - Book: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }
}
