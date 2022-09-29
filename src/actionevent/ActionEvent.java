package actionevent;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author guillermogallegogonzalez
 * @version 1.0
 * Contacto: guillermojulian.gallegogonzalez@gmail.com
 */


public class ActionEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Declaración de variables
        
        Text interes = new Text("Anual interest Rate:");
        Text years= new Text("Number of Years:");
        Text amount = new Text("Loan Amount:");
        Text payment = new Text("Monthly Payment:");
        Text totalPayment = new Text("Total Payment:");
        
        TextField interesField = new TextField();
        TextField yearsField = new TextField();
        TextField amountField = new TextField();
        TextField paymentField = new TextField();
        TextField totalPaymentField = new TextField();
        
        Button btnCalculate = new Button("Calculate");
        
        //Evento al hacer click sobre el botón
        btnCalculate.setOnAction((javafx.event.ActionEvent event) -> {
            paymentField.setText(String.format("$%.2f",calculoMensual(interesField,yearsField,amountField)));
            totalPaymentField.setText(String.format("$%.2f",calculoTotal(interesField,yearsField,amountField)));
        });
        
        //Evento al pulsar enter sobre el botón
        btnCalculate.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                paymentField.setText(String.format("$%.2f",calculoMensual(interesField,yearsField,amountField)));
                totalPaymentField.setText(String.format("$%.2f",calculoTotal(interesField,yearsField,amountField)));
            }
        });
        
        //Encuadre de la interfaz gráfica
        
        GridPane grid;
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(interes, 1, 0);
        grid.add(years, 1, 1);
        grid.add(amount, 1, 2);
        grid.add(payment, 1, 3);
        grid.add(totalPayment, 1, 4);
        grid.add(interesField, 2, 0);
        grid.add(yearsField, 2, 1);
        grid.add(amountField, 2, 2);
        grid.add(paymentField, 2, 3);
        grid.add(totalPaymentField, 2, 4);
        grid.add(btnCalculate, 2, 5);
        
        
        //Escena
        Scene scene;        
        scene = new Scene(grid);
        primaryStage.setTitle("AnonymousHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Funciones
    
    public double calculoMensual(TextField interesField,TextField yearsField, TextField amountField){
        Double interesNumber = Double.valueOf(interesField.getText()),yearsNumber = Double.valueOf(yearsField.getText()),amountNumber = Double.valueOf(amountField.getText());
        Double interes , calculoInteres;
        interes = interesNumber/(100*12);
        calculoInteres=amountNumber * interes / (1- (Math.pow(1 / (1 + interes), yearsNumber * 12)));
        return calculoInteres;
    }
    
    public double calculoTotal(TextField interesField,TextField yearsField, TextField amountField){
        Double interesNumber = Double.valueOf(interesField.getText()),yearsNumber = Double.valueOf(yearsField.getText()),amountNumber = Double.valueOf(amountField.getText());
        Double interes , calculoInteres;
        interes = interesNumber/(100*12);
        calculoInteres=amountNumber * interes / (1- (Math.pow(1 / (1 + interes), yearsNumber * 12)));
        return calculoInteres*12*yearsNumber;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
