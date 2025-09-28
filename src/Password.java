/*
Name: Samiha Chabane
Purpose: Final project final phase for a program that creates a pass word 
from selected phrase and special character. 
 */
//import needed tools
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Password extends Application {
 private double hackerScore = 0, yourscore = 0;   
  private String  passwrd="",newPass = "",blanc=" ";
    private String numbers ="0123456789";  
    Phrase phraseFromFile;  //to read phrases from the random access file
@Override
public void start(Stage primaryStage) throws Exception
{
//title of the scene
primaryStage.setTitle("Strong Password Samiha Chabane");
//create a GridPane to range the contents
GridPane mygridPane = new GridPane();
//set the padding and marging 
mygridPane.setPadding(new Insets(8));
mygridPane.setHgap(10);
mygridPane.setVgap(10);
//set the position and dimentions of the gridePane
mygridPane.setAlignment(Pos.TOP_LEFT);
//set my scene
Scene myScene = new Scene(mygridPane, 500, 400);

//create an array of 3 Phrase objects
Phrase[] myPhrases = new Phrase[3];
//store the phrases in the array
myPhrases[0] = new Phrase("Hello world my name is Java");
myPhrases[1] = new Phrase("It is fun to learn Java");
myPhrases[2] = new Phrase("Enjoy learning Java");
// Create a PhrasesFile object to store the remembered phrases on a random access file
      PhrasesFile myfile =new PhrasesFile("myphrases.dat");
      
      // Write the contents of the array to the file.
      for (int i = 0; i < myPhrases.length; i++)
      {
         myfile.writePhrase(myPhrases[i]);
         System.out.println("");
      }     
      // Close the file.
      myfile.close();
      
//comboBox to select a phrase
mygridPane.add(new Label("Select a phrase:"), 0, 0);
PhrasesFile file =new PhrasesFile("myphrases.dat");
//open the PhraseFilw object to read the stored phrases from it
 phraseFromFile = file.readPhrases();
 for (int i = 0; i <4; i++)
                {
                    //move through the account records
                    file.moveFilePointer(i);         
                    // Read the record at i location.
                    phraseFromFile = file.readPhrases();
                    // Display the record
                    System.out.println(phraseFromFile.getPhrase());        
                }  
ComboBox<String> phrase = new ComboBox<>();
        phrase.getItems().addAll("Hello world my name is Java","It is fun to learn Java",
                "Enjoy learning Java");     
//TextField phrase = new TextField();
mygridPane.add(phrase, 1, 0);
Phrase myPhrase = new Phrase();
//pass the entered phrase from the textfield to myPhrase object
myPhrase.setPhrase(phrase.getSelectionModel().getSelectedItem());
mygridPane.add(new Label("Length:"), 0, 2);

//create the button to calculate the length for the phrase
Button myButton = new Button(" Calculate length");
mygridPane.add(myButton, 1, 1);
GridPane.setHalignment(myButton, HPos.LEFT);
TextField resultLngt = new TextField();
mygridPane.add(resultLngt, 1, 2);

//hacker textfield and label
TextField hacker = new TextField();
mygridPane.add(new Label("Hacker score:"), 0, 3);
mygridPane.add(hacker,1,3);
//user's score textfield and label
TextField yourScore = new TextField();
mygridPane.add(new Label("Your score:"), 0, 4);
mygridPane.add(yourScore,1,4);

myButton.setOnAction(e -> {
//test the length of the phrase
double lngt = phrase.getSelectionModel().getSelectedItem().length();
if(lngt<15){
  hackerScore++;  
}else {
    yourscore++;
}
Double hack =hackerScore;
Double yrScr = yourscore;
Double total = lngt ;
//displaye the results
hacker.setText(hack.toString());
yourScore.setText(yrScr.toString());
resultLngt.setText(total.toString());

});
//comboBox for the symbols
ComboBox<String> myComboBox = new ComboBox<>();
        myComboBox.getItems().addAll(".","!","@","#","$","%",
                "^","&","{","[","/","?");
        mygridPane.add(new Label("Select a symbol: "), 0, 5);
        mygridPane.add(myComboBox, 1, 5);
//new CreatePasswrd object
CreatePasswrd myPassword = new CreatePasswrd();
Button psswrdButton = new Button("Get a strong password");
mygridPane.add(psswrdButton, 0, 6);
psswrdButton.setOnAction(e ->{
   for(int i=0; i<2; i++)
            {
                //getting the phrase from the Phrase class
                String ps = phrase.getSelectionModel().getSelectedItem();
                //choosing random characters from the phrase and numbers
                Random rand = new Random(); int index = rand. nextInt(10);
                Random rand2 = new Random(); int index1 = rand2. nextInt(ps.length()-1);
                
                //to void a blanc space into the password
                if( ps.charAt(index1)==blanc.charAt(0))
                    {
                        newPass += ps.charAt(index1+1);
                        newPass += numbers.charAt(index);
                    }else{
                //adding characters to the new password
                    newPass += ps.charAt(index1);
                    newPass += ps.charAt(index1+1);
                    //use the selscted symbol from the comboBox
                    newPass+= myComboBox.getSelectionModel().getSelectedItem();
                    newPass += numbers.charAt(index); 
                    }
            }
//textField for the new password 
TextField yourPasswrd = new TextField(); 
yourPasswrd.setText(newPass);
GridPane.setHalignment(psswrdButton, HPos.LEFT);
mygridPane.add(yourPasswrd, 1, 6);

//save the new password to a text file
FileWriter myFilewriter = null;
    try {
        myFilewriter = new FileWriter("StrongPassword.txt", true);
    } catch (IOException ex) {
        Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
    }
               PrintWriter myFile = new PrintWriter(myFilewriter);
               myFile.println(yourPasswrd.getText());// display the customers informations on the file
               myFile.close();
});

//create a list of CheckBoxes to select how to save the password 
Label miscLabel = new Label("Select how to save your password:");
mygridPane.add(miscLabel, 0, 7);
CheckBox SaveToFile = new CheckBox("Save it to a text file");
mygridPane.add(SaveToFile, 1, 7);
CheckBox CopyToApp = new CheckBox("Copy it to an online application use");
mygridPane.add(CopyToApp, 1, 8);
CheckBox WriteOnPaper = new CheckBox("Write it on a paper");
mygridPane.add(WriteOnPaper, 1, 9);

primaryStage.setScene(myScene);
primaryStage.show();
}

public static void main(String[] args) {
launch(args);
}
}

