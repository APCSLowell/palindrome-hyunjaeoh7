import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
  
public boolean palindrome(String sWord)
{
  sWord = onlyLetters(noSpaces(noCapitals(sWord)));
  if(sWord == ""){
    return true;
  }
  int sick = 0;
  if(sWord.length() % 2 == 1){
    sick = 1;
  }
  
  String a = sWord.substring(0, (sWord.length()/2));
  String b = sWord.substring((sWord.length()/2)+sick, sWord.length());

  if(a.equals(reverse(b))){
    return true;
  }
  return false;
}
  
public String reverse(String sWord)
{
    String ok = "";
  for(int i = sWord.length()-1; i >= 0; i--){
    ok = ok + sWord.substring(i,i+1);
  }
  return ok;
}

public String noCapitals(String sWord){
  return sWord.toLowerCase();
}

public String noSpaces(String sWord){
  String sick = "";
  for(int i = 0; i < sWord.length(); i++){
    if(!(sWord.substring(i,i+1).equals(" "))){
      sick += sWord.substring(i,i+1);
    }
  }
  return sick;
}

public String onlyLetters(String sString){
  String sick = "";
  for(int i = 0; i < sString.length(); i++){
    if(Character.isLetter(sString.charAt(i))){
      sick += sString.charAt(i);
    }
  }
  return sick;
}
}
