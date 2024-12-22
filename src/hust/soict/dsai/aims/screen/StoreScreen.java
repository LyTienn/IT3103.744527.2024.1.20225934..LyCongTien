
package hust.soict.dsai.aims.screen;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import hust.soict.dsai.aims.store.StoreTienLc;
import hust.soict.dsai.aims.cart.CartTienLC;
import hust.soict.dsai.aims.media.*;

public class StoreScreen extends JFrame {
    private static StoreTienLc store = new StoreTienLc();
    private static CartTienLC cart = new CartTienLC();
    public static void initSetup(){
        DigitalVideoDiscTienLC dvd1 = new DigitalVideoDiscTienLC("The Lion King", "Animation", 
                                                    "Roger Aller", 87, 19.95f);
                                                          
        DigitalVideoDiscTienLC dvd2 = new DigitalVideoDiscTienLC("Star War", "Science Fiction",  
                                                    "George Lucas",87, 24.95f); 
        DigitalVideoDiscTienLC dvd3 = new DigitalVideoDiscTienLC("Aladdin", "Animation", null,  
                                                    0, 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        BookTienLC book = new BookTienLC("The Valley of Fear", "Detective", 20.00f);
        BookTienLC book1 = new BookTienLC("A Living Remedy: A Memoir", "Biography", 202.00f);
        BookTienLC book2 = new BookTienLC("On the Origin of Time: Stephen Hawking's Final Theory", 
                            "Science", 120.00f);
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);
        
        CompactDiscTienLC cd1 = new CompactDiscTienLC("Quang Hung", "Music","Master D", 1500.98f);
        TrackTienLC track1CD1 = new TrackTienLC("Thuy Trieu(remix)", 161);
        TrackTienLC track2CD1 = new TrackTienLC("Troi em lai", 403);
        TrackTienLC track3CD1 = new TrackTienLC("Tinh dau qua chen", 300);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);
        
        CompactDiscTienLC cd2 = new CompactDiscTienLC("BTS Album", "Music","BTS", 2000.22f);
        TrackTienLC track1CD2 = new TrackTienLC("Boy with luv", 180+34);
        TrackTienLC track2CD2 = new TrackTienLC("IDOL", 180+30);
        TrackTienLC track3CD2 = new TrackTienLC("Boy in luv", 60*2+39);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);

        CompactDiscTienLC cd3 = new CompactDiscTienLC("99%", "Music","MCK", 1000.98f);
        TrackTienLC track1CD3 = new TrackTienLC("Chim sau", 4*60+5);
        TrackTienLC track2CD3 = new TrackTienLC("00", 0);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
    }
    public static void main(String[] args) {
        initSetup();
	new StoreScreen(store);
	}
    
    public StoreScreen(StoreTienLc store){
        StoreScreen.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);
        setVisible(true);
        setTitle("Ly Cong Tien_5934_Store");
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem smAddBook = new JMenuItem("Add Book");
        JMenuItem smAddCD = new JMenuItem("Add CD");
        JMenuItem smAddDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(smAddBook);
        smUpdateStore.add(smAddCD);
        smUpdateStore.add(smAddDVD);
        
        smAddBook.addActionListener(new btnMenuListener());
        smAddCD.addActionListener(new btnMenuListener());
        smAddDVD.addActionListener(new btnMenuListener());
        
        menu.add(smUpdateStore);
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        JMenuItem viewCartMenu = new JMenuItem("View cart");
        menu.add(viewStoreMenu);
        menu.add(viewCartMenu);
        viewStoreMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new StoreScreen(store);
            }
        });
        viewCartMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new CartScreen(cart);
            }
        });
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    private class btnMenuListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Add Book")){
                new AddBookToStoreScreen(store);
            } 
            else if(command.equals("Add CD")){
                new AddCompactDiscToStoreScreen(store);
            } 
            else if(command.equals("Add DVD")){
                new AddDigitalVideoDiscToStoreScreen(store);
            } 
	}
    }
    
    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
    
        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));
        cartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });
        
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        
        ArrayList<MediaTienLC> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        
        return center;
    }
}
