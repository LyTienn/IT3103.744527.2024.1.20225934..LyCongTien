package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.CartTienLC;
import hust.soict.dsai.aims.media.DigitalVideoDiscTienLC;
public class TestCart {
    public static void main(String[] args) {
        CartTienLC anOrder = new CartTienLC();
        DigitalVideoDiscTienLC dvd1 = new DigitalVideoDiscTienLC("One Piece", "Anime", "Oda", 148, 29.5f);

        anOrder.addDigitalVideoDiscTienLC(dvd1);
        DigitalVideoDiscTienLC dvd2 = new DigitalVideoDiscTienLC("Songoku", "Action", "Toriyama", 136, 19.0f);
        anOrder.addDigitalVideoDiscTienLC(dvd2);
        DigitalVideoDiscTienLC dvd3 = new DigitalVideoDiscTienLC("Naruto", "Anime", "Kishimoto", 169, 24.5f);
        anOrder.addDigitalVideoDiscTienLC(dvd3);

        anOrder.print();

        //Test search by ID method
        anOrder.searchById(2);
        anOrder.searchById(3);

        //Test search by Title method
        anOrder.searchByTitle("One Piece");
        anOrder.searchByTitle("Songoku");
    }
}