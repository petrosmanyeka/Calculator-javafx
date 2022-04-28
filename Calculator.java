import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;



public class Calculator extends Application {

    Button [] button  = {
     new Button("   0   "),
     new Button("   1   "),
     new Button("   2   "),
     new Button("   3   "),
     new Button("   4   "),
     new Button("   5   "),
     new Button("   6   "),
     new Button("   7   "),
     new Button("   8   "),
     new Button("   9   "),
     new Button("   +   "),
     new Button("   -   "),
     new Button("   /   "),
     new Button("   *   "),
     new Button("   =   "),
     new Button("   c   ")
    
    };

    

    String [] number = new String[100];
    String [] opertor = new String[99];

    int cnumber = 0;
    int coperator = 0;
    int isRestart = 0;
    String lastInserted = " ";


    TextField textField = new TextField();

    @Override
    public void start(Stage primaryStage){
       
        for(int i = 0 ; i < 100 ; i++){
            number[i] = "";
        }

        for(int y = 0 ; y < 99 ; y++){
            opertor[y] = " ";
        }

        for(int x = 0 ; x < button.length;x++){
            button[x].setMaxWidth(50);
            button[x].setMinHeight(50);
            
        }

        GridPane gridPane = new GridPane();
        gridPane.add(button[7] ,0 ,0);
        gridPane.add(button[8] ,1,0);
        gridPane.add(button[9], 2,0);
        gridPane.add(button[12],3,0);

        gridPane.add(button[4],0,1);
        gridPane.add(button[5],1,1);
        gridPane.add(button[6],2,1);
        gridPane.add(button[13],3,1);

        gridPane.add(button[1],0,2);
        gridPane.add(button[2],1,2);
        gridPane.add(button[3],2,2);
        gridPane.add(button[11],3,2);

        gridPane.add(button[0],0,3);
        gridPane.add(button[10],3,3);
        gridPane.add(button[14],2,3);
        gridPane.add(button[15],1,3);
        gridPane.setAlignment(Pos.CENTER);

      

        VBox vBox = new VBox();

        vBox.getChildren().addAll(textField,gridPane);
        
        button[15].setOnAction(e -> clear());
        button[14].setOnAction(e -> equal());

        button[0].setOnAction(e -> getValue(button[0].getText()));
        button[1].setOnAction(e -> getValue(button[1].getText()));
        button[2].setOnAction(e -> getValue(button[2].getText()));
        button[3].setOnAction(e -> getValue(button[3].getText()));
        button[4].setOnAction(e -> getValue(button[4].getText()));
        button[5].setOnAction(e -> getValue(button[5].getText()));
        button[6].setOnAction(e -> getValue(button[6].getText()));
        button[7].setOnAction(e -> getValue(button[7].getText()));
        button[8].setOnAction(e -> getValue(button[8].getText()));
        button[9].setOnAction(e -> getValue(button[9].getText()));
        button[10].setOnAction(e -> getValue(button[10].getText()));
        button[11].setOnAction(e -> getValue(button[11].getText()));
        button[12].setOnAction(e -> getValue(button[12].getText()));

        
        
        Scene scene = new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Caliculator");
        primaryStage.show();
    }
    private void clear(){
       textField.setText("  ");
       for(int i = 0 ; i < 100 ; i++){
        number[i] = " ";
    }

      for(int i = 0 ; i < 99 ; i++){
        opertor[i] = " " ;

        coperator = cnumber = 0;
    }
     }

    private void equal(){
       float num = 0;

       if (number[0].equals(" ")){
           number[0] = "0";
       }

       switch(opertor[0]){
           case "+ ":num = (float) Double.parseDouble(number[0]) + (float) Double.parseDouble(number[1]);break;
           case "* ":num = (float) Double.parseDouble(number[0]) * (float) Double.parseDouble(number[1]);break;
           case "- ":num = (float) Double.parseDouble(number[0]) - (float) Double.parseDouble(number[1]);break;
           case "/ ":num = (float) Double.parseDouble(number[0]) / (float) Double.parseDouble(number[1]);break;
       }

       for(int c = 0 ; c < cnumber ; c ++){
        if (number[0].equals(" ")){ 
            number[0] = "0";
        }
        switch(opertor[c]){
            case "/ ":num = (float) Double.parseDouble(number[c+1]);break;
            case " + ":num += (float) Double.parseDouble(number[c+1]);break;
            case " - ":num -= (float) Double.parseDouble(number[c+1]);break;
            case " * ":num *= (float) Double.parseDouble(number[c+1]);break;
            } }

            String pla2 = num + "";

            textField.setText(pla2);
            for(int i = 0 ; i < 100 ; i++){
                number[i] = " ";
            }
        
            for(int y = 0 ; y < 99 ; y++){
                opertor[y] = " " ;
        
                opertor = number = 0;
                isRestart = 1;
            }
           
    }

    private void getValue(String text){
        if(isRestart == 1){
            textField.setText(" ");
            isRestart = 0;

        }
        String pla = textField.getText(value);
        pla += text;

        //textField.setText(pla);

    if(text.equals("+")  ||text.equals("-") ||text.equals("*") ||text.equals("/") ){
    if(!lastInserted.equals("+") ||!lastInserted.equals("-")||!lastInserted.equals("*")||!lastInserted.equals("/")){
        opertor[coperator] = text;
        cnumber++;
        coperator++; 
        System.out.println("enter after additol");
        for(int t = 0; t < 99 ; t++){
            System.out.println(opertor[t] + " ");
        }
        System.out.println(" ");
    }
    else{
        pla = pla.substring(0,pla.length()-1);
    } 
    lastInserted = text;
    }
    else{
        number[cnumber] += text;
        lastInserted = text;
        System.out.println("enter after additol");
        for(int t = 0; t < 100 ; t++){
            System.out.println(opertor[t] + " ");
        }
        System.out.println(" ");

    }
    textField.setText(pla);
    }

    
    public static void main(String[] args) {
        Application.launch(args);
    }
}