
package hust.soict.dsai.aims.media;

import java.time.Duration;
import java.util.Comparator;
import hust.soict.dsai.aims.exception.PlayerException;

public abstract class MediaTienLC implements Comparable<MediaTienLC> {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;    
    
    public static final Comparator<MediaTienLC> COMPARE_BY_TITLE_COST = new CompareByTitleCost();
    public static final Comparator<MediaTienLC> COMPARE_BY_COST_TITLE = new CompareByCostTitle();
    //Constructor
    
    public MediaTienLC(String title) {
        this.title = title;
		this.id = ++nbMedia;
    }
    public MediaTienLC(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    public MediaTienLC(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }
    
    public int getId(){
        return id;
    }   
    public String getTitle(){
        return title;
    }  
    public String getCategory(){
        return category;
    }
    public float getCost(){
        return cost;
    } 

    public void setTitle(String title){
        this.title = title;
    }
    
    // Check is title match
    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    public void play() {
        System.out.println("Playing media");
    }
    
    public String playGUI() throws PlayerException {
        return "Playing media";
    }
    
    public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaTienLC)) {
            return false;
        }
        return ((MediaTienLC)obj).getTitle() == this.getTitle();
    }
    
    @Override
    public String toString() {
        return "Media: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }
    
    // Answer for the second question
    @Override
    public int compareTo(MediaTienLC other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Double.compare(this.getCost(), other.getCost());
        }
    }
}
