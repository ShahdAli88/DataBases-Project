package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BillQueryController implements Initializable{
    @FXML
    private TextField Accruedpayment;
    @FXML
    private Button HOME_BTN;
    @FXML
    private Button LogOut_BTN1;
    @FXML
    private TextField Payment_Method;
    @FXML
    private TextField PropartyID;
    @FXML
    private TextField TaxesB;
    @FXML
    private TextField Tenanant_ID;
    @FXML
    private TextField date;
    @FXML
    private TextField search_B;
    
    @FXML
    private Button Displaybtn;
    private Parent root;

    // Add a method to fetch and populate the data
    @FXML
    void searchB(ActionEvent event) {
        String tenantId = search_B.getText();
        fetchDataAndPopulateFields(tenantId);
    }

    // Method to fetch data and populate the fields
    private void fetchDataAndPopulateFields(String tenantId) {
        // Execute the SQL query and populate the fields
        try (Connection conn = mysqlconnect.getConnection();
             PreparedStatement pst = conn.prepareStatement(
            		 "SELECT t.Tid, t.Accruedpayments, p.pId, r.Tax, c.dueDate, c.paymentMehode " +
                             "FROM Tenant t " +
                             "JOIN Property p ON t.Tid = p.Tid " +
                             "JOIN Rent r ON p.pId = r.pID " +
                             "JOIN Contract c ON p.pId = c.pID " +
                             "WHERE t.Tid = ?")) {
            pst.setString(1, tenantId);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                Tenanant_ID.setText(resultSet.getString("Tid"));
                Accruedpayment.setText(resultSet.getString("Accruedpayments"));
                PropartyID.setText(resultSet.getString("pId"));
                TaxesB.setText(resultSet.getString("Tax"));
                date.setText(resultSet.getString("dueDate"));
                Payment_Method.setText(resultSet.getString("paymentMehode"));
            } else {
                // Tenant ID not found, clear the fields
                Tenanant_ID.clear();
                Accruedpayment.clear();
                PropartyID.clear();
                TaxesB.clear();
                date.clear();
                Payment_Method.clear();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	   @FXML
	    void HOME_BTN(ActionEvent event) throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main2.fxml"));
			 Parent root = loader.load();
			    
			    // Set the root as the new scene
			    this.root = root;
			    
			    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			    Scene scene = new Scene(root);
			    stage.setScene(scene);
			    stage.show();

	    }

	    @FXML
	    void logOutBtn(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
		    Parent root = loader.load();
		    
		    // Set the root as the new scene
		    this.root = root;
		    
		    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    Scene scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();

	    }

    // Other event handler methods...
}




