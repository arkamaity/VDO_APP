package com.maity.JavaFXTest;

import java.util.Properties;

import com.maity.Utility.VedioUtils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginGridPane extends javafx.scene.layout.GridPane {
	private Properties bundle ;
	
	public LoginGridPane(Properties bundle){
		this.bundle = bundle;
		UpdateLoginGrid(this.bundle);
	}
	public void UpdateLoginGrid(Properties bundle){
		this.bundle = bundle;
		setAlignment(Pos.CENTER);
		setHgap(10);
		setVgap(10);
		setPadding(new Insets(25, 25, 25, 25));
		
		
		Text scenetitle = new Text(bundle.getProperty("label.Sign_in.welcomeMessage"));
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(scenetitle, 0, 0, 2, 1);
        
        Label userName = new Label(bundle.getProperty("label.Sign_in.userName"));
        add(userName, 0, 1);
        TextField userTextField = new TextField();
        add(userTextField, 1, 1);

        Label pw = new Label(bundle.getProperty("label.Sign_in.password"));
        add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        add(pwBox, 1, 2);

        Button btn = new Button(VedioUtils.getPropertyValue(bundle, "label.Sign_in.title"));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        add(hbBtn, 1, 4);

        Label lblBinding1 = new Label("Entered value is : ");
        Label lblBinding2 = new Label();
        
        add(lblBinding1,0,8);
        add(lblBinding2,1,8);
        lblBinding2.textProperty().bind(pwBox.textProperty());
        final Text actiontarget = new Text();
        add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                /*actiontarget.setText("Sign in button pressed");*/
                
            }
        });
	}

}
