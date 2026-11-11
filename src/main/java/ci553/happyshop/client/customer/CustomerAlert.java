package ci553.happyshop.client.customer;

import ci553.happyshop.client.warehouse.AlertSimulator;
import ci553.happyshop.utility.UIStyle;
import ci553.happyshop.utility.WindowBounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerAlert extends AlertSimulator {

    public CustomerView customerView;

    @Override
    protected void createWindow() {
        if (scene == null) {
            createScene();  //create scene if not exists
        }

        window = new Stage();
        window.initModality(Modality.NONE); //Optional: explicitly set as non-blocking, though this is the default
        window.initStyle(StageStyle.UNDECORATED); // No title bar
        //window.setTitle("\uD83C\uDFEC input error message"); // for icon 🏬
        window.setScene(scene);

        //get bounds of warehouse window which triggers the alertSimulator
        // so that we can put the alertSimulator on top of it and at a suitable position
        WindowBounds bounds = customerView.getWindowBounds();
        window.setX(bounds.x + bounds.width-10);
        window.setY(bounds.y + UIStyle.HistoryWinHeight+30);
        window.show();
    }
}
