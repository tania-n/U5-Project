public class Fraction{ 
    private int numerator; 
    private int denominator; 
    
    public Fraction(int n, int d){ 
        numerator = n; 
        denominator = d; 
    } 
    
    public int getNumerator(){ 
        return numerator; 
    } 
    
    public void setNumerator(){ 
        numerator = numerator; 
    } 
    
    public int getDenominator(){ 
        return denominator; 
    } 
    
    public void setDenominator(){ 
        denominator = denominator; 
    } 
    
    public Fraction add(Fraction f){ 
        int fN = 0; 
        int fD = 0; 
        // checks if both denominators are the same
        if(this.denominator == f.denominator){ 
            // adds the numerators together
            fN = f.numerator + this.numerator; 
            fD = this.denominator; 
        } 
        else if(this.denominator != f.denominator){
            // checks if the second denominator is a factor of the first denominator 
            if(this.denominator % f.denominator == 0){ 
                int d = this.denominator / f.denominator; 
                fN = this.numerator + (f.numerator * d); 
                fD = this.denominator; 
            } 
            // checks if the first denominator is a factor of the second denominator 
            else if(f.denominator % this.denominator == 0){ 
                int d = f.denominator / this.denominator; 
                fN = f.numerator + (this.numerator * d); 
                fD = f.denominator; 
            }
            else{    
                // if none of the other if statements are true, finds a common denominator for the fraction
                fD = this.denominator * f.denominator; 
                fN = (this.numerator * f.denominator) + (f.numerator * this.denominator); 
            }  
        } 
        return new Fraction(fN, fD); 
    } 
    
    public Fraction subtract(Fraction f){ 
        int fN = 0; 
        int fD = 0; 
        // check if both denominators are the same 
        if(this.denominator == f.denominator){ 
            fN = this.numerator - f.numerator; 
            fD = this.denominator; 
        } 
        else if(this.denominator != f.denominator){
            // checks if the second denominator is a factor of the first denominator
            if(this.denominator % f.denominator == 0){ 
                int d = this.denominator / f.denominator; 
                fN = this.numerator - (f.numerator * d); 
                fD = this.denominator; 
            } 
            // checks if the first denominator is a factor of the second denominator
            else if(f.denominator % this.denominator == 0){ 
                int d = f.denominator / this.denominator; 
                fN = this.numerator - (f.numerator * d); 
                fD = f.denominator; 
            }
            else{    
                // if none of the other if statements are true, finds a common denominator for the fraction
                fN = (this.numerator * f.denominator) - (f.numerator * this.denominator); 
                fD = this.denominator * f.denominator;
            }  
        } 
        return new Fraction(fN, fD); 
    } 
    
    public Fraction multiply(Fraction f){ 
        // multiplies the numerators 
        int fN = this.numerator * f.numerator; 
        // multiplies the denominators 
        int fD = this.denominator * f.denominator;
        return new Fraction(fN, fD); 
    } 
    
    public Fraction divide(Fraction f){ 
        // multiples the first numerator to the second denominator 
        int fN = this.numerator * f.denominator; 
        // multiples the first denominator to the second numerator 
        int fD = this.denominator * f.numerator;
        return new Fraction(fN, fD); 
    }
    
    public Fraction simplify(Fraction f){ 
        int highest = 0; 
        int divide = 0; 
        numerator = f.numerator; 
        denominator = f.denominator; 
        // checks if the numerator is greater than the denominator 
        if(f.numerator > f.denominator){ 
            highest = f.numerator; 
        } 
        // checks if the denominator is greater 
        else if(f.numerator < f.denominator){ 
            highest = f.denominator; 
        } 
        else{ 
            highest = f.numerator; 
        }
        // goes through each number until its greater than or equal to "highest"  
        for(int i = 1; i <= highest; i++){ 
            // checks if the number is a factor of the numerator and the denominator 
            if(f.numerator % i == 0 && f.denominator % i == 0){ 
                // saves that number, then divides the numerator and denominator by it 
                divide = i; 
                numerator = f.numerator / divide; 
                denominator = f.denominator / divide;
            } 
        } 
        return new Fraction(numerator, denominator); 
    }
    
    public String toString(){ 
        // creates a new object in order to use the simplify method 
        Fraction f = new Fraction(numerator, denominator); 
        f.simplify(f); 
        // saves the numerator and denominator 
        numerator = f.numerator; 
        denominator = f.denominator; 
        return numerator + "/" + denominator; 
    }
    
}
