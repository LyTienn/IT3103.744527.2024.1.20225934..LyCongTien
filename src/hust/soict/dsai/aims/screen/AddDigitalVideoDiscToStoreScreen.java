package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.store.StoreTienLc;
import hust.soict.dsai.aims.screen.controller.AddDVDScreenController;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
	private static StoreTienLc store;
	
	public static void main(String[] args) {
		new AddDigitalVideoDiscToStoreScreen(store);
	}
	public AddDigitalVideoDiscToStoreScreen(StoreTienLc store) {
		super();
		AddDigitalVideoDiscToStoreScreen.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add DVD");
        this.setSize(1024, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/view/addDVD.fxml"));//hust/soict/dsai/aims/screen/view/addDVD.fxml
                    
                    AddDVDScreenController controller = new AddDVDScreenController(store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
