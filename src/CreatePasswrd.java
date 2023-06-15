
import java.util.Random;

public class CreatePasswrd extends Phrase implements StrongPassword
        //CreatePasswrd inherits from the superclass Phrase and implement the 
        //StrongPassword interface. This is illustrated in the UML diagram and 
        //works fine
{
    private String  passwrd="",newPass = "",blanc=" ";
    private String symbols ="0123456789.!@#$%^&{}[]/?";
    private Phrase myPhrase;
    
    //build a strong passworgd from the phrase and the array of symbols
    @Override
    public String strongPasswrd(Phrase myPhrase)
    {
 
        for(int i=0; i<3; i++)
            {
                //getting the phrase from the Phrase class
                String ps = myPhrase.getPhrase();
                //choosing random characters from the phrase and symbols
                Random rand = new Random(); int index = rand. nextInt(24);
                Random rand2 = new Random(); int index1 = rand2. nextInt(ps.length()-1);
                
                //to void a blanc space into the password
                if( ps.charAt(index1)==blanc.charAt(0))
                    {
                        newPass += ps.charAt(index1-1);
                        newPass += symbols.charAt(index);
                    }
                //adding characters to the new password
                        newPass += ps.charAt(index1);
                        newPass += ps.charAt(index1+1);
                        newPass += symbols.charAt(index); 
                    }
                    
                   return newPass;
    
    }
}
 
