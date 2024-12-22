
package hust.soict.dsai.aims.media;
import java.util.*;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDiscTienLC extends MediaTienLC implements PlayableTienLC {
    private String artist;
    private List<TrackTienLC> tracks = new ArrayList<TrackTienLC>();
    
    //Constructor of CompactDisc
    public CompactDiscTienLC(String title) {
        super(title);
    }
    public CompactDiscTienLC(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
    @Override
    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        for(TrackTienLC song : tracks){
            song.play();
        }
    }
    //Getter (only artist)
    public String getArtist(){
        return artist;
    }
    public void addTrack(TrackTienLC track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to CD: " + this.getTitle());
        } else {
            System.out.println("Track already exists in CD.");
        }
    }

    public void removeTrack(TrackTienLC track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track: " +track.getTitle() + " has been removed from CD: " + this.getTitle());
        } else {
            System.out.println("Track does not exist in CD.");
        }
    }
    //total track sum
    
    public int getLength(){
    	int totalLength = 0;
        for (TrackTienLC track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;    }
    @Override
    public String toString() {
        return this.getId() + " - CD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() +
                " - Length: " + this.getLength() + " seconds" + 
                " - Cost: " + this.getCost() + "$";
    }
    
    public String playGUI() throws PlayerException {
        if(this.getLength() > 0) {
            String output =  "Playing CD: " + this.getTitle() + "\n" + 
                            "CD length: " + formatDuration(this.getLength()) + "\n"+ "\n";
            for (TrackTienLC track : tracks) {
                try {
                    output += track.playGUI() + "\n";
                } catch (PlayerException e) {
                    output += track.getTitle() + "\n" + e.getMessage();
                }
            }
            return output;
            } else {
                throw new PlayerException("ERROR: CD length is non-positive!");
            }
    }
}
