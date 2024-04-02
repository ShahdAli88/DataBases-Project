package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainSceneController {

	private Stage stage ;
	private Scene scene ;
	private Parent root ;
	// Event Listener on Button.onAction
	
	@FXML
	private Button BOOK;
	@FXML
	public void chooseField(ActionEvent event) throws IOException {
		
		Parent root =FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene  = new Scene (root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	


	private void setSceneDimensions() {
	    Stage stage = (Stage) root.getScene().getWindow();
	    double width = stage.getWidth();
	    double height = stage.getHeight();

	    root.prefWidth(width);
	    root.prefHeight(height);
	}

	

	@FXML
	public void BookNow(ActionEvent event) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    // Adjust the scene dimensions
	    setSceneDimensions();
	   
	}
	
	@FXML
	public void EmpTable(ActionEvent event) throws IOException
	{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("EmpTable.fxml"));
		    Parent root = loader.load();
		    
		    // Set the root as the new scene
		    this.root = root;
		    
		    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    Scene scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();

		    // Adjust the scene dimensions
		    setSceneDimensions();
	}
	@FXML
	public void ContractTable(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ContractTable.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    // Adjust the scene dimensions
	    setSceneDimensions();
	}
	
	@FXML
	public void RentTable(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RentTable.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    // Adjust the scene dimensions
	    setSceneDimensions();
	}
	@FXML
	
	public void PropartyTable(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("propartyTable.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    // Adjust the scene dimensions
	    setSceneDimensions();
	}
	
	@FXML
	public void Bill(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Bill.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    // Adjust the scene dimensions
	    setSceneDimensions();
	}
	
	@FXML
	public void TenantTable(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TenantTable.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    // Adjust the scene dimensions
	    setSceneDimensions();
	}
	
	@FXML
	public void SponserTable(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SponsorTable.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();

	    // Adjust the scene dimensions
	    setSceneDimensions();
	}
	
	
	
}

