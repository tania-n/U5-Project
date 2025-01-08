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
        if(this.denominator == f.denominator){ 
            fN = f.numerator + this.numerator; 
            fD = this.denominator; 
        } 
        else if(this.denominator != f.denominator){
            if(this.denominator % f.denominator == 0){ 
                int d = this.denominator / f.denominator; 
                fN = this.numerator + (f.numerator * d); 
                fD = this.denominator; 
            } 
            else if(f.denominator % this.denominator == 0){ 
                int d = f.denominator / this.denominator; 
                fN = f.numerator + (this.numerator * d); 
                fD = f.denominator; 
            }
            else{    
                fD = this.denominator * f.denominator; 
                fN = (this.numerator * f.denominator) + (f.numerator * this.denominator); 
            }  
        } 
        return new Fraction(fN, fD); 
    } 
    
    public Fraction subtract(Fraction f){ 
        int fN = 0; 
        int fD = 0; 
        if(this.denominator == f.denominator){ 
            fN = this.numerator - f.numerator; 
            fD = this.denominator; 
        } 
        else if(this.denominator != f.denominator){
            if(this.denominator % f.denominator == 0){ 
                int d = this.denominator / f.denominator; 
                fN = this.numerator - (f.numerator * d); 
                fD = this.denominator; 
            } 
            else if(f.denominator % this.denominator == 0){ 
                int d = f.denominator / this.denominator; 
                fN = this.numerator - (f.numerator * d); 
                fD = f.denominator; 
            }
            else{    
                fN = (this.numerator * f.denominator) - (f.numerator * this.denominator); 
                fD = this.denominator * f.denominator;
            }  
        } 
        return new Fraction(fN, fD); 
    } 
    
    public Fraction multiply(Fraction f){ 
        int fN = this.numerator * f.numerator; 
        int fD = this.denominator * f.denominator;
        return new Fraction(fN, fD); 
    } 
    
    public Fraction divide(Fraction f){ 
        int fN = this.numerator * f.denominator; 
        int fD = this.denominator * f.numerator;
        return new Fraction(fN, fD); 
    }
    
    public Fraction simplify(Fraction f){ 
        int highest = 0; 
        int divide = 0; 
        numerator = f.numerator; 
        denominator = f.denominator; 
        if(f.numerator > f.denominator){ 
            highest = f.numerator; 
        } 
        else if(f.numerator < f.denominator){ 
            highest = f.denominator; 
        } 
        else{ 
            highest = f.numerator; 
        }
        for(int i = 1; i <= highest; i++){ 
            if(f.numerator % i == 0 && f.denominator % i == 0){ 
                divide = i; 
                numerator = f.numerator / divide; 
                denominator = f.denominator / divide;
            } 
        } 
        return new Fraction(numerator, denominator); 
    }
    
    public String toString(){ 
        Fraction f = new Fraction(numerator, denominator); 
        f.simplify(f); 
        numerator = f.numerator; 
        denominator = f.denominator; 
        return numerator + "/" + denominator; 
    }
    
}