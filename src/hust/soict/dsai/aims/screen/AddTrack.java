package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.media.CompactDiscTienLC;
import hust.soict.dsai.aims.screen.controller.AddTrackScreenController;

public class AddTrack extends JFrame {
	private static CompactDiscTienLC CD;
	
	public static void main(String[] args) {
		new AddTrack(CD);
	}
	
	public AddTrack(CompactDiscTienLC CD) {
		super();
		AddTrack.CD = CD;
		
		JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Tracks");
        this.setSize(638, 300);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/view/addTracks.fxml"));//hust/soict/dsai/aims/screen/view/addTracks.fxml
                    
                    AddTrackScreenController controller = new AddTrackScreenController(CD);
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
