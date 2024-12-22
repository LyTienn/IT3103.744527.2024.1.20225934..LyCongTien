
package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class CompareByTitleCost implements Comparator<MediaTienLC> {
    @Override
    public int compare(MediaTienLC m1, MediaTienLC m2) {
        // So sánh theo tiêu đề
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        
        // Nếu tiêu đề giống nhau, so sánh theo chi phí (chi phí cao hơn ưu tiên trước)
        if (titleComparison == 0) {
            return Float.compare(m2.getCost(), m1.getCost());  // So sánh theo chi phí giảm dần
        }
        
        return titleComparison;  // Nếu tiêu đề khác nhau, sắp xếp theo tiêu đề
    }
}
