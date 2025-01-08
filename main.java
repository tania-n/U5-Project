import java.util.Scanner; 

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); 
    boolean cont = true; 
    
    System.out.println("Type h for help or q to quit");
    
    // keeps the code running until cont is false 
    while(cont == true){ 
        System.out.println("Enter a fraction operation: "); 
        String answer = input.nextLine(); 
        
        // if user enters q, the code ends
        if(answer.toLowerCase().equals("q")){ 
            cont = false; 
            System.out.println("Fraction calculator closed.");
        }
        else if(answer.toLowerCase().equals("h")){ 
            System.out.println("Fractions have parenthesis and no space: (m/n)"); 
            System.out.println("Operations are +, -, *, /, entered with no space."); 
            System.out.println("You can simplify by typing: simplify(m/n)"); 
        } 
        else{ 
            // checks if "simplify" is in the users response 
            if(answer.substring(0, 8).toLowerCase().equals("simplify")){ 
                // if it is, it gets the numerator and denominator from the response
                int index1 = answer.indexOf("("); 
                String sub1 = answer.substring(index1 + 1); 
                int index2 = sub1.indexOf("/"); 
                // takes the number thats between ( and / and makes it the numerator 
                int num1 = Integer.valueOf(sub1.substring(0, index2)); 
                // takes the number that between / and ) and makes it the denominator 
                int d1 = Integer.valueOf(sub1.substring(index2 + 1, sub1.length() - 1)); 
                // creates a new object for the fraction 
                Fraction f = new Fraction(num1, d1); 
                System.out.println(f.simplify(f)); 
            } 
            else{ 
                // loops through each character in the users response 
                for(int i = 0; i < answer.length() - 2; i++){ 
                    int index1 = answer.indexOf(")");
                    // saves the first fraction
                    String sub1 = answer.substring(0, index1 + 1); 
                    int index2 = sub1.indexOf("/"); 
                    // takes the number thats between ( and / and makes it the numerator 
                    int num1 = Integer.valueOf(sub1.substring(1, index2)); 
                    // takes the number thats between / and ) and makes it the denominator 
                    int d1 = Integer.valueOf(sub1.substring(index2 + 1, sub1.length() - 1));
                    // repeats the same steps for the second fraction  
                    String sub2 = answer.substring(index1 + 2); 
                    int index3 = sub2.indexOf("/"); 
                    int num2 = Integer.valueOf(sub2.substring(1, index3)); 
                    int d2 = Integer.valueOf(sub2.substring(index3 + 1, sub2.length() - 1)); 
        
                    // creates two new objects for the two fractions 
                    Fraction f = new Fraction(num1, d1);
                    Fraction g = new Fraction(num2, d2); 
                    
                    // substring1 saves a character 
                    // and substring2 saves the character that comes after it 
                    String substring1 = answer.substring(i, i + 1); 
                    String substring2 = answer.substring(i + 1, i + 2); 
                    // when going through each character, checks if substring1 is ) 
                    // and if substring2 is + in order to get the correct operation 
                    if(substring1.equals(")") && substring2.equals("+")){ 
                        System.out.println(f.add(g)); 
                    } 
                    // repeats the steps for each operation 
                    else if(substring1.equals(")") && substring2.equals("-")){ 
                        System.out.println(f.subtract(g)); 
                    } 
                    else if(substring1.equals(")") && substring2.equals("/")){ 
                        System.out.println(f.divide(g)); 
                    } 
                    else if(substring1.equals(")") && substring2.equals("*")){ 
                        System.out.println(f.multiply(g)); 
                    } 
                }
            }
        } 
      } 
   }
} 


