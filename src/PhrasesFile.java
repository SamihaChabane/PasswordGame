/*
 PhraseFile class to store the phrases in a random access file
 */

import java.io.*;
public class PhrasesFile {
private final int recordSize = 3;     // Record length 
  
 private RandomAccessFile PhraseFile; // Random-Access file
 
//constructor   
   public PhrasesFile(String myFilename)throws FileNotFoundException
   {
      // Open the file for reading and writing.
      PhraseFile = new RandomAccessFile(myFilename, "rw");
   }
   
//write the phrase argument to the file at the curent position
   public void writePhrase(Phrase ph) throws IOException
   {      
     // Write the phrase to the file.
     PhraseFile.writeChars(ph.getPhrase());
   }
   
//read and return the record at the current file pointer position
   public Phrase readPhrases() throws FileNotFoundException, IOException
   {  
      // Read the phrase from the file.
      String storedPhrase = PhraseFile.readLine();
      // Create a Phrase object and initialize it 
      Phrase myphrase = new Phrase(storedPhrase);
      
      // Return the object.
      return myphrase;
   }

//return the starting byte number for a given record number 
   private long getByteNum(long recordNum)
   {
      return recordSize * recordNum;
   }
   
//move to the record indicated by the argument
   public void moveFilePointer(long recordNum) throws IOException
   {
      PhraseFile.seek(getByteNum(recordNum));
   }
   
 //calculate the number of records stored in the file
   public long getNumberOfRecords() throws IOException
   {
      return PhraseFile.length() / recordSize;
   }
    //close method closes the file.  
   public void close() throws IOException
   {
      PhraseFile.close();
   }  
}
