package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.security.auth.callback.Callback;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class QueryRentController implements Initializable {

    @FXML
    private Button btn_find;

    @FXML
    private Label label_pid;

    @FXML
    private Label label_rent;

    @FXML
    private Label label_size;

    @FXML
    private TextField txt_cheapest;

    @FXML
    private TableColumn<?, ?> locationColumn;

    @FXML
    private TableColumn<?, ?> monthlyRentColumn;

    @FXML
    private TableColumn<?, ?> propertyIdColumn;

    @FXML
    private TableView<CombinedData> propertyTable;

    @FXML
    private TableColumn<?, ?> sizeColumn;
    
    Connection conn = null;
    ResultSet resultSet = null;
    PreparedStatement pst = null;

    @FXML
    void FindHouse(ActionEvent event) {
    	String location = txt_cheapest.getText();
    	conn = mysqlconnect.getConnection();

        try{
            String query = "SELECT p.pId, p.pSize, r.montlyRent " +
                           "FROM property p " +
                           "JOIN Rent r ON p.pId = r.pID " +
                           "WHERE p.pLocation= ?";
            pst= conn.prepareStatement(query);
            pst.setString(1, location);

            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                String propertyId = resultSet.getString("pID");
                int size = resultSet.getInt("pSize");
                double monthlyRate = resultSet.getDouble("montlyRent");

                label_pid.setText(String.valueOf(propertyId));
                label_size.setText(String.valueOf(size));
                label_rent.setText(String.valueOf(monthlyRate));
            } else {
            	label_pid.setText("Property not found");
            	label_size.setText("");
                label_rent.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
  
    
  
    
   /* private void enterTable(){
		Connection conn = mysqlconnect.getConnection();
		try {
			 String query = "SELECT p.pId , p.pLocation, p.pSize, r.montlyRent " +
	                    "FROM property p " +
	                    "JOIN rent r ON p.pId = r.pID " +
	                    "ORDER BY r.montlyRent ASC";
			PreparedStatement statement = conn.prepareStatement(query);
		    ResultSet resultSet = statement.executeQuery();
           
            
            //In the rs.getString() method, you need to specify the column name in workBench or the column index from which you want to retrieve the data.
            
		    ObservableList<property> propertyList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String propertyId = resultSet.getString("pId");
                String propertyLocation = resultSet.getString("pLocation");
                String size = resultSet.getString("pSize");
                int monthlyRent = resultSet.getInt("montlyRent");

               property property = new property(propertyId, propertyLocation,size,monthlyRent);
                propertyList.add(property);
            }

            propertyTable.setItems(propertyList); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
    } */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up the table columns
        propertyIdColumn.setCellValueFactory(new PropertyValueFactory<>("propertyId"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("propertyLocation"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("propertySize"));
        monthlyRentColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyRent"));

        // Retrieve data from the SQL view
        List<CombinedData> data = fetchDataFromView();

        // Populate the table list with the retrieved data
        propertyTable.getItems().addAll(data);
    }

    private List<CombinedData> fetchDataFromView() {
        List<CombinedData> data = new ArrayList<>();

        try {
            conn = mysqlconnect.getConnection();
            String query = "SELECT p.pId, p.pLocation, p.pSize, r.montlyRent " +
                    "FROM property p " +
                    "JOIN Rent r ON p.pId = r.pID " +
                    "ORDER BY r.montlyRent ASC";
     System.out.println(query); // Print the query for debugging purposes
     pst = conn.prepareStatement(query);
     resultSet = pst.executeQuery();


            // Process the query result
            while (resultSet.next()) {
                String propertyId = resultSet.getString("pId");
                String propertyLocation = resultSet.getString("pLocation");
                String propertySize = resultSet.getString("pSize");
                int monthlyRent = resultSet.getInt("montlyRent");

                // Create an instance of CombinedData and add it to the list
                CombinedData combinedData = new CombinedData(propertyId, propertyLocation, propertySize, monthlyRent);
                data.add(combinedData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }



  





	/*@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 propertyIdColumn.setCellValueFactory(new PropertyValueFactory<>("pid"));
		    locationColumn.setCellValueFactory(new PropertyValueFactory<>("pLocation"));
		    sizeColumn.setCellValueFactory(new PropertyValueFactory<>("pSize"));
		    monthlyRentColumn.setCellValueFactory(new PropertyValueFactory<>("montlyrent"));
		   

		   
		    enterTable();
	}*/

}
