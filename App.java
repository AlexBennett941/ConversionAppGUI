import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;



public class App extends Application {
  
    // launch the application
    public void start(Stage stage)
    {
            //set scene and panel
            stage.setTitle("Conversion App");
            Label label = new Label("Imperial to Metric");
            Pane pane = new Pane(label);
            Scene scene = new Scene(pane, 400, 300);

            //adding buttons
            Button ft_to_meter = new Button("Feet to Meter");
            ft_to_meter.relocate(30, 200);
            pane.getChildren().add(ft_to_meter);
            
            Button meter_to_feet = new Button("Meter to Feet");
            meter_to_feet.relocate(30, 250);
            pane.getChildren().add(meter_to_feet);

            Button lb_to_kg = new Button("Pound to Kilogram");
            lb_to_kg.relocate(200, 200);
            pane.getChildren().add(lb_to_kg);


            Button kg_to_lb = new Button("Kilogram to Pound");
            kg_to_lb.relocate(200, 250);
            pane.getChildren().add(kg_to_lb);
            
            //adding text fields
            Label converter = new Label("Unit to convert");
            TextField textField = new TextField();
            converter.relocate(50, 25);
            textField.relocate(50, 50);
            pane.getChildren().addAll(converter, textField);

            //event feet
            EventHandler<ActionEvent> feetConversion = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                    double feet = Double.parseDouble(textField.getText());
                    String convertedNum = feetToMeter(feet);;
                    textField.clear();
                    textField.appendText(convertedNum + " meters.");
                }
            };

            //conversion for meters

            EventHandler<ActionEvent> meterConversion = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                    double meter = Double.parseDouble(textField.getText());
                    String convertedNum = meterToFeet(meter);
                    textField.clear();
                    textField.appendText(convertedNum + " feet.");
                }
            };
            //event for lb
            EventHandler<ActionEvent> poundConversion = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                    double pound = Double.parseDouble(textField.getText());
                    String convertedNum = lbToKilogram(pound);
                    textField.clear();
                    textField.appendText(convertedNum + " kilograms.");
                }
            };
            //event for kg
            EventHandler<ActionEvent> kilogramConversion = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                    double kilogram = Double.parseDouble(textField.getText());
                    String convertedNum = kilogramToLb(kilogram);
                    textField.clear();
                    textField.appendText(convertedNum + " pounds.");
                }
            };

            //actions
            kg_to_lb.setOnAction(kilogramConversion);
            lb_to_kg.setOnAction(poundConversion);
            ft_to_meter.setOnAction(feetConversion);
            meter_to_feet.setOnAction(meterConversion);

            //dont touch this
            stage.setScene(scene);
            stage.show();
        }
        
        public String feetToMeter(double feet){
            double newMeter = feet * 0.304;
            String finalMeter = ""; 
            finalMeter = String.valueOf(newMeter);
            return finalMeter;
        }

        public String lbToKilogram(double lb){
            double newKilogram = lb * 0.454;
            String finalKilogram = ""; 
            finalKilogram = String.valueOf(newKilogram);
            return finalKilogram;
        }

        public String meterToFeet(double meter){
            double newFoot = meter * 3.28;
            String finalFoot = ""; 
            finalFoot = String.valueOf(newFoot);
            return finalFoot;
        }

        public String kilogramToLb(double kilogram){
            double newLb = kilogram * 2.2;
            String finalLb = ""; 
            finalLb = String.valueOf(newLb);
            return finalLb;
        }

    public static void main(String args[])
    {
        launch(args);
    }
}