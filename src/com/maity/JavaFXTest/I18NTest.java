package com.maity.JavaFXTest;

import java.util.Properties;

/*import com.maity.UI.JMFTest;
import com.maity.Utility.VedioUtils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;*/
import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.scene.control.*;  
import javafx.scene.layout.BorderPane;  
import javafx.stage.Stage;  
public class I18NTest extends Application {
	private Properties bundle;

	@Override
	/*/public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Let's Meet");
        primaryStage.getIcons().add(new Image(JMFTest.class.getResourceAsStream("Icon_VD.png")));
        this.bundle = VedioUtils.getPropertiseFromFile("I18N_DETAILS_bn.PROPERTIES");
        LoginGridPane login = new LoginGridPane(this.bundle);
        ////primaryStage.setFullScreen(true);
        
        Scene scene = new Scene(login, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
	}*/
	public void start(Stage primaryStage) throws Exception {  
        // TODO Auto-generated method stub  
        BorderPane root = new BorderPane();  
        Scene scene = new Scene(root,200,300);  
        MenuBar menubar = new MenuBar();  
        Menu FileMenu = new Menu("File");  
        MenuItem filemenu1=new MenuItem("new");  
        MenuItem filemenu2=new MenuItem("Save");  
        MenuItem filemenu3=new MenuItem("Exit");  
        Menu EditMenu=new Menu("Edit");  
        MenuItem EditMenu1=new MenuItem("Cut");  
        MenuItem EditMenu2=new MenuItem("Copy");  
        MenuItem EditMenu3=new MenuItem("Paste");  
        EditMenu.getItems().addAll(EditMenu1,EditMenu2,EditMenu3);  
        root.setTop(menubar);  
        FileMenu.getItems().addAll(filemenu1,filemenu2,filemenu3);  
        menubar.getMenus().addAll(FileMenu,EditMenu);  
        primaryStage.setScene(scene);  
        primaryStage.show();  
          
    }     
	public static void main(String args[]) {
		launch(args);
	}

}
