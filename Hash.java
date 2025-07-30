import java.util.*;
public class Hash {
    public static int asciiValues(String input)
    {
        int sum=0;
        System.out.println("ASCII value of characters:");
        //print ascii values of character
        for(int i=0;i<input.length();i++)
        {
          
            char ch=input.charAt(i);
            int value=(int)ch;

            System.out.println(ch+":"+value);
            sum+=value;
        }
        return sum;
    }

    public static int hash(int asciisum,int tableSize)
    {
        //calculate hash
      return asciisum%tableSize;

    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        //input string
         System.out.println("input string");
        String input=sc.nextLine();

        //input table size
        System.out.println("enter table size");
        int tableSize=sc.nextInt();
       
        //call ascii function
        int asciisum=asciiValues(input);

        //call hash function
        int hashValue=hash(asciisum,tableSize);
        System.out.println("hash value of "+input+" is "+hashValue);
    }
    
}
