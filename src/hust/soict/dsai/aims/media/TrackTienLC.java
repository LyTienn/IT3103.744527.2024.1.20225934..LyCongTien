
package hust.soict.dsai.aims.media;

import java.time.Duration;
import hust.soict.dsai.aims.exception.PlayerException;

public class TrackTienLC implements PlayableTienLC {
    private String title;
    private int length;
    
    //Constructor
    public TrackTienLC(String title, int length){
        this.title = title;
        this.length = length;
    }
    @Override
    public void play(){
        System.out.println("Playing track: " + this.title);
        System.out.println("Track length: " + this.length);
    }
    
    public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing track: " + this.getTitle() + "\n" + 
                "Track length: " + formatDuration(this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }   
    }
    
    public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }
    
    public String getTitle(){
        return title;
    }
    public int getLength(){
        return length;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof TrackTienLC)) {
            return false;
        }
        return ((TrackTienLC)obj).getTitle() == this.getTitle() && ((TrackTienLC)obj).getLength() == this.getLength();
    }
}
