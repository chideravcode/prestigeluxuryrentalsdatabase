/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package prestigerentalscrudtest;

import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Chidera
 */
public class FXMLController implements Initializable {
    
    @FXML
    private BorderPane mainlayout;
    @FXML
    private Button buttonbranches;
    @FXML
    private Button buttoncars;
    @FXML
    private Button buttoncustomers;
    @FXML
    private Button buttonemployees;
    @FXML
    private Button buttoninsurancepolicies;
    @FXML
    private Button buttonrentals;
    @FXML
    private Button buttonabout;
    @FXML
    private VBox verticalnavbar;
    @FXML
    private ImageView prestigeluxuryrentalslogo;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       
        /*if(event.getSource() == buttoninsert){
            System.out.println("You clicked insert!");
            insertCarToTable();
        } else if(event.getSource() == buttonupdate){
            System.out.println("You clicked update!");
            updateCarToTable();
        } else if(event.getSource() == buttondelete){
            System.out.println("You clicked delete!");
            deleteCarToTable();
        }*/
        
        if (event.getSource() == buttoncars){
            System.out.println("You clicked cars");
            AnchorPane view = FXMLLoader.load(getClass().getResource("CARFXML.fxml"));
            mainlayout.setCenter(view);
        } else if(event.getSource() == buttonbranches){
            System.out.println("You clicked branches");
            AnchorPane view = FXMLLoader.load(getClass().getResource("BRANCHFXML.fxml"));
            mainlayout.setCenter(view);
        } else if(event.getSource() == buttoncustomers){
            System.out.println("You clicked customers");
            AnchorPane view = FXMLLoader.load(getClass().getResource("CUSTOMERFXML.fxml"));
            mainlayout.setCenter(view);
        } else if(event.getSource() == buttonemployees){
            System.out.println("You clicked employees");
            AnchorPane view = FXMLLoader.load(getClass().getResource("EMPLOYEEFXML.fxml"));
            mainlayout.setCenter(view);
        } else if(event.getSource() == buttoninsurancepolicies){
            System.out.println("You clicked insurancepolicies");
            AnchorPane view = FXMLLoader.load(getClass().getResource("IPFXML.fxml"));
            mainlayout.setCenter(view);
        } else if(event.getSource() == buttonrentals){
            System.out.println("You clicked rentals");
            AnchorPane view = FXMLLoader.load(getClass().getResource("RENTALFXML.fxml"));
            mainlayout.setCenter(view);
        } else if(event.getSource() == buttonabout){
            System.out.println("You clicked about");
            AnchorPane view = FXMLLoader.load(getClass().getResource("ABOUTFXML.fxml"));
            mainlayout.setCenter(view);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //showCars();
    }
    
    public Connection getConnection(){
        Connection connection;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");
            return connection;
        } catch(Exception exception){
            System.out.println("An error has occurred!" + exception.getMessage());
            return null;
        }
    }
    
    /*public ObservableList<Car> getCarList(){
        ObservableList<Car> carList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM car";
        Statement statement;
        ResultSet resultset;
        
        try{
            statement = connection.createStatement();
            resultset = statement.executeQuery(query);
            Car car;
            
            // Create new car object from car details in the database.
            while(resultset.next()){
                car = new Car(resultset.getString("vin"), 
                        resultset.getString("make"), 
                        resultset.getString("model"),
                        resultset.getInt("year"),
                        resultset.getString("type"));
                carList.add(car);
            }
            
        } catch(Exception exception){
            exception.printStackTrace();
        }
        
        return carList;
    }
    
    // Display car objects in table.
    public void showCars(){
        ObservableList<Car> list = getCarList();
        
        columnvin.setCellValueFactory(new PropertyValueFactory<Car, String> ("vin"));
        columnmake.setCellValueFactory(new PropertyValueFactory<Car, String> ("make"));
        columnmodel.setCellValueFactory(new PropertyValueFactory<Car, String> ("model"));
        columnyear.setCellValueFactory(new PropertyValueFactory<Car, Integer> ("year"));
        columntype.setCellValueFactory(new PropertyValueFactory<Car, String> ("type"));
        
        tableviewcars.setItems(list);
    }
    
    private void insertCarToTable(){
        String query = "INSERT INTO car VALUES(" + "'" + 
                textfieldcarvin.getText() + "', '" +
                textfieldcarmake.getText() + "', '" +
                textfieldcarmodel.getText() + "', " +
                textfieldcaryear.getText() + ", '" +
                textfieldcartype.getText() + "')";
        executeQuery(query);
        showCars();
    }
    
    private void updateCarToTable(){
        String query = "UPDATE car SET make = '" + textfieldcarmake.getText()
                + "', model = '" + textfieldcarmodel.getText()
                + "', year = " + textfieldcaryear.getText()
                + ", type = '" + textfieldcartype.getText() + "' WHERE vin = '" + textfieldcarvin.getText() + "'";
        executeQuery(query);
        showCars();
    }
    
    private void deleteCarToTable(){
        String query = "DELETE FROM car WHERE vin = '" + textfieldcarvin.getText() + "'";
        executeQuery(query);
        showCars();
    }
    
    private void executeQuery(String query){
        Connection connection = getConnection();
        Statement statement;
        
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch(Exception exception){
            exception.printStackTrace();
        }
    }*/
}
