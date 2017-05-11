//*******************************************************************
// Dear CompileJava users,
//
// CompileJava has been operating since 2013 completely free. If you
// find this site useful, or would otherwise like to contribute, then
// please consider a donation (link in 'More Info' tab) to support
// development of the new CompileJava website (stay tuned!).
//
// Most sincerely, Z.
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    OtherClass myObject = new OtherClass("Hello World!");
    
    String result= myObject.Truncate("123456789012345678901234567890",20);
    
  }
}

// you can add other public classes to this editor in any order
public class OtherClass
{
  private String message;
  private boolean answer = false;
  public OtherClass(String input)
  {
    message = "Why, " + input + " Isn't this something?";
  }
  public String toString()
  {
    return message;
  }
  
  public String Truncate(String log, int size)
  {
     
     int strlength= log.length();
     int reqlength= size;
     String sub_string="... (truncated) ...";
     int sublen=sub_string.length();
     
    if(strlength<=reqlength)
    {
      log="No change required";
      
       System.out.println(sub_string+ ": "+sublen+": "+log  );
      
    }else if(strlength>reqlength){
      
      String Newstr=log+sub_string;
      
      int newstrlen=Newstr.length();
      
      int quo= (newstrlen-reqlength);
      	  quo=quo-sublen;
          quo=quo-1/2;
       System.out.println(quo);
   
      System.out.println(log.replace(log.substring(2,strlength-2),sub_string)) ;
      
      log=log.replace(log.substring((quo),strlength-(quo)),sub_string);
      
      System.out.println(log.length()) ;
      
     
    }
    
      return log;
  }
}