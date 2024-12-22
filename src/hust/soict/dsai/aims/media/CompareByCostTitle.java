
package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class CompareByCostTitle implements Comparator<MediaTienLC> {
    @Override
    public int compare(MediaTienLC m1, MediaTienLC m2) {
        // So sánh theo chi phí (chi phí cao hơn ưu tiên trước)
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        
        // Nếu chi phí giống nhau, so sánh theo tiêu đề
        if (costComparison == 0) {
            return m1.getTitle().compareTo(m2.getTitle());  // So sánh theo tiêu đề (theo thứ tự chữ cái)
        }
        
        return costComparison;  // Nếu chi phí khác nhau, sắp xếp theo chi phí
    }
}
