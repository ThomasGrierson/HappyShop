package ci553.happyshop.utility;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AlertBase {

    protected static int WIDTH = UIStyle.AlertSimulatorWinWidth;
    protected static int HEIGHT = UIStyle.AlertSimulatorWinHeight;

    protected Stage window; //window for AlertSimulator
    protected Scene scene; // Scene for AlertSimulator
    private  Label laErrorMsg;// Label to display error messages
    protected TextArea taErrorMsg;

    protected abstract void createWindow();

    protected void createScene() {
        Label laTitle = new Label("\u26A0 Action cannot be completed"); // for emoji ⚠️
        laTitle.setStyle(UIStyle.alertTitleLabelStyle); //red

        taErrorMsg = new TextArea();
        taErrorMsg.setEditable(false);
        taErrorMsg.setWrapText(true);// text wraps if long
        taErrorMsg.setStyle(UIStyle.alertContentTextAreaStyle);

        VBox vbLaTaMsg = new VBox(3, laTitle, taErrorMsg);
        vbLaTaMsg.setAlignment(Pos.CENTER_LEFT); // Wrap two labels in a VBox to align it left

        Button btnOk = new Button("Ok");
        btnOk.setStyle(UIStyle.alertBtnStyle);
        HBox hbBtnOk = new HBox(btnOk);
        hbBtnOk.setAlignment(Pos.CENTER); //aligned to right
        btnOk.setOnAction(e -> {
            window.close();
        });

        VBox vb = new VBox(2,vbLaTaMsg, hbBtnOk);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle(UIStyle.rootStyleGray);
        scene = new Scene(vb, WIDTH,HEIGHT);
    }

    // Show error message in the alert window
    public  void showErrorMsg(String errorMsg) {
        if (window ==null ||!window.isShowing() ) {
            createWindow(); // create window if not exists
        }

        //laErrorMsg.setText(errorMsg); // Update the error message
        taErrorMsg.setText(errorMsg); // Update the error message
        window.toFront(); // Bring the window to the front if it's already open
    }

    /**
     * Closes the alert window.
     *
     * The purpose of this method is to provide a way to close the alert window from outside the AlertSimulator class,
     * when it is no longer needed (e.g., after canceling or submitting an action while the alert window is still showing
     * from a previous error).
     */

    public  void closeAlertSimulatorWindow() {
        if (window != null && window.isShowing()) {
            window.close();
        }
    }
}
