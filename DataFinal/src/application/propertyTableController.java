package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.awt.Container;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class propertyTableController implements Initializable {
	@FXML
	private TableView<property> prop_table;
	@FXML
	private Button HOME_BTN;
	@FXML
	private Button AddProparty;
	@FXML
	private Button logOut_btn;
	@FXML
	private AnchorPane home;
	@FXML
	private Label totalH;
	@FXML
	private Label KEYH;
	@FXML
	private Label AgeH;
	@FXML
	private AnchorPane AddButton;
	@FXML
	private TableColumn<property,String> p_ID_COL;
	@FXML
	private TableColumn<property,String> Ptype_COL;
	@FXML
	private TableColumn<property,String> Plocation_COL;
	@FXML
	private TableColumn<property,String> Psize_COL;
	@FXML
	private TableColumn<property,String> T_ID_COL;
	
	@FXML
	private TextField Search;
	@FXML
	private TextField p_id;
	@FXML
	private TextField Plocation;
	@FXML
	private TextField Psize;
	@FXML
	private Button updatebtn;
	@FXML
	private Button clearbtn;
	@FXML
	private Button ADDbtn;
	@FXML
	private Button deletebtn;
	@FXML
	private ComboBox<String> P_TYPE;
	
	//VARIABLE DECLARED
	private Parent root;
	ObservableList <property> listM;
	ObservableList <property> dataList;
	int index = -1;
	 Connection conn = null;
	 ResultSet rs = null;
	 PreparedStatement pst = null;
	

	// Event Listener on Button[#HOME_BTN].onAction
	@FXML
	public void HOME_BTN(ActionEvent event) throws IOException
	{
		
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("Main2.fxml"));
		 Parent root = loader.load();
		    
		    // Set the root as the new scene
		    this.root = root;
		    
		    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    Scene scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
		
	}
	
	
	// Event Listener on Button[#logOut_btn].onAction
	@FXML
	public void logout(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
	    Parent root = loader.load();
	    
	    // Set the root as the new scene
	    this.root = root;
	    
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}
	
	
	// Event Listener on Button[#updatebtn].onAction
	@FXML
	public void updatebtn(ActionEvent event) 
	{
        try {
            conn = mysqlconnect.getConnection();
            String value2 = P_TYPE.getPromptText();
            String value3 = Plocation.getText();
            String value4 = Psize.getText();
            String value1 = p_id.getText();
        
            String sql = "UPDATE Property SET pid = '" + value1 + "', ptype = '" + value2 + "', pLocation = '" + value3 + "', pSize = '" +
            	    value4 ;

            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            updateTable();
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
	}
	
	
	// Event Listener on Button[#clearbtn].onAction
	@FXML
	public void clearbtn(ActionEvent event)
	{
	    P_TYPE.setValue(null);
	    P_TYPE.getEditor().clear();
	    p_id.clear();
		Plocation.clear();
		Psize.clear();
		
	}
	
	
	// Event Listener on Button[#ADDbtn].onAction
	@FXML
	public void ADDbtn(ActionEvent event) 
	{
		conn = mysqlconnect.getConnection();
		String sql = "insert into property (pid,ptype,pLocation,pSize)values(?,?,?,?) ";
		
		try {
			//The index passed as the first argument corresponds to the position of the question mark in the SQL query.
			pst= conn.prepareStatement(sql);
			pst.setString(2,P_TYPE.getPromptText());
			pst.setString(3,Plocation.getText());
			pst.setString(4,Psize.getText());
			pst.setString(1,p_id.getText());
			pst.executeUpdate();  //pst.executeUpdate() method is called to execute the SQL statement to insert a new row into your MySQL database table based on the values you provided.
			

	        // Refresh the TableView after adding the user
	       // listM = mysqlconnect.getDataproperty();     
	        listM= getDataproperty();                ////getDataproperty() method retrieves the updated data from the database.
	        prop_table.setItems(listM);
			
			JOptionPane.showMessageDialog(null, "Users Add succes");
			
		} catch (Exception e) {
			
			 JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	// Event Listener on Button[#deletebtn].onAction
	@FXML
	public void deletebtn(ActionEvent event)
	{
		   conn = mysqlconnect.getConnection();
		    String sql = "delete from property where pid = ?";
		        try {
		            pst = conn.prepareStatement(sql);
		            pst.setString(1, p_id.getText());
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Delete");
		            updateTable();
		        } catch (Exception e) {
		            JOptionPane.showMessageDialog(null, e);
		        }
		
	}
	
	
	//this function to make update for the tables when we called it on other functions
	public void updateTable() 
	{

		p_ID_COL.setCellValueFactory(new PropertyValueFactory<property,String>("pid"));
		Ptype_COL.setCellValueFactory(new PropertyValueFactory<property,String>("ptype"));
		Plocation_COL.setCellValueFactory(new PropertyValueFactory<property,String>("pLocation"));
		Psize_COL.setCellValueFactory(new PropertyValueFactory<property,String>("pSize"));
		T_ID_COL.setCellValueFactory(new PropertyValueFactory<property,String>("Tid")); 
      //Note that the strings inside PropertyValueFactory are case-sensitive and must match the property names exactly as they are defined in the property class.
        
          listM = getDataproperty();
          prop_table.setItems(listM);
		
	}
	
	
	public static ObservableList<property> getDataproperty(){
		Connection conn = mysqlconnect.getConnection();
		ObservableList<property> list = FXCollections.observableArrayList();  //This list will store the retrieved data
		try {
			PreparedStatement ps =  conn.prepareStatement("select * from property");  //Prepares a SQL statement using a PreparedStatement object
            ResultSet rs = ps.executeQuery();      // Executes the SQL statement using executeQuery(), which returns a ResultSet containing the retrieved data.
            
            //In the rs.getString() method, you need to specify the column name in workBench or the column index from which you want to retrieve the data.
            
            while(rs.next()){
                list.add(new property(rs.getString("pid"), rs.getString("ptype"), rs.getString("pLocation"), rs.getString("pSize"),  rs.getString("Tid")));
           //extracts the values for each column of a row.
            }
           
			
		 } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (conn != null) {
		                conn.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		return list;
		
	}
	
	@FXML
	public void SearchB(ActionEvent event)
	{
		
		p_ID_COL.setCellValueFactory(new PropertyValueFactory<property,String>("pid"));
		Ptype_COL.setCellValueFactory(new PropertyValueFactory<property,String>("ptype"));
		Plocation_COL.setCellValueFactory(new PropertyValueFactory<property,String>("pLocation"));
		Psize_COL.setCellValueFactory(new PropertyValueFactory<property,String>("pSize"));
		T_ID_COL.setCellValueFactory(new PropertyValueFactory<property,String>("Tid"));
        
        dataList = getDataproperty();
        prop_table.setItems(dataList);
        FilteredList<property> filteredData = new FilteredList<>(dataList, b -> true);  
        Search.textProperty().addListener((observable, oldValue, newValue) -> {
     filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getPid().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (person.getPtype().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }else if (person.getPLocation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }
    else if (person.getPSize().toLowerCase().indexOf(lowerCaseFilter) != -1)
         return true;// Filter matches email
    else if (person.getTid().toLowerCase().indexOf(lowerCaseFilter) != -1)
        return true;// Filter matches email
              
         else  
          return false; // Does not match.
   });
  });  
  SortedList<property> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(prop_table.comparatorProperty());  
  prop_table.setItems(sortedData);      
    }
	
	   @FXML
	    void getSelected (MouseEvent event){
	    index = prop_table.getSelectionModel().getSelectedIndex();
	    if (index <= -1){
	    
	        return;
	    }
	    p_id.setText(p_ID_COL.getCellData(index).toString());
	    P_TYPE.setPromptText(Ptype_COL.getCellData(index).toString());
	    Plocation.setText(Plocation_COL.getCellData(index).toString());
	    Psize.setText(Psize_COL.getCellData(index).toString());
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		P_TYPE.setItems(FXCollections.observableArrayList("Apartment", "Company", "House", "Shop"));
		    updateTable();
	}
	   
 
	   
}