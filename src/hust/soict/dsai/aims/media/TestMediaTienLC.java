
package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class TestMediaTienLC {
    public static void main(String[] args) {
              List<MediaTienLC> media = new ArrayList<>();
        
        DigitalVideoDiscTienLC dvd = new DigitalVideoDiscTienLC(4, "Lang vu dai ngay ay", "Drama", 5.0f, "Tran Van Thuy", 120);
    
        ArrayList<TrackTienLC> tracks = new ArrayList<>();
        tracks.add(new TrackTienLC("Beo dat may troi", 4));
        tracks.add(new TrackTienLC("Song Hong", 3));
        
        CompactDiscTienLC cd = new CompactDiscTienLC(5, "Nhac tru tinh Viet Nam", "Nhac dan gian", 4.0f, "Various Artists", tracks);
        
            List<String> authors = new ArrayList<>();
            authors.add("Nguyen Trong Hinh ; ");
            authors.add("Nguyen Tran Trung Quan");
            
            BookTienLC book = new BookTienLC(6, 
                "Mat Biec", 
                "Tinh cam", 
                6.5f, 
                authors);
        media.add(dvd);
        media.add(cd);
        media.add(book);
        for (MediaTienLC item : media) {
            System.out.println(item);
        }
    }
}
