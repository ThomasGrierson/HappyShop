package ci553.happyshop.client.customer;

import ci553.happyshop.utility.AlertBase;
import ci553.happyshop.utility.UIStyle;
import ci553.happyshop.utility.WindowBounds;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerAlert extends AlertBase {

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
