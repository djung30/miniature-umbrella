/***
 * Daniel Jung (Dunking Ducks: Roster: Jason Zhou, Daniel Jung, Tiggy, Ralph)
 * APCS
 * HW23: What Does Equality Look Like? (Created Coin.java)
 * 2021 - 10 - 24
 * Time spent: In class time + 10 minutes outside class
 * 
 * Disco: N/A
 * QCC: N/A
 ***/

public class Coin {

    //attributes aka instance vars
    private double value;
    private double bias = 0.5;
    private String upFace = "Heads";
    private String name;
    private int flipCtr, headsCtr, tailsCtr;

    


    /***
     *  Coin() -- default constuctor
     *  precond: Default a penny?
     *  postcond: "penny" with upFace "Heads" 
     ***/
    public Coin() {
        name = "penny";
        value = 0.01;
        upFace = "Heads";
    }


    /***
        Coin(String) -- overloaded constructor
        precond: input is one of
        "penny",
        "nickel",
        "dime",
        "quarter",
        "half dollar",
        "dollar"
        postcond: coin s with value of s
    ***/
    public Coin( String s ) {
        name = s;
        assignValue(s);
    }


    /***
        Coin(String,String) --
        precond: given above and the face
        postcond: set face to nowFace set coin type and coin value to s
    ***/
    public Coin( String s, String nowFace ) {
        name = s;
        upFace = nowFace;
        assignValue(s);
    }

  
    // Accessors...
    // ----------------------------
    public String getUpFace() {
        return upFace;
    }

    public int getFlipCtr() {
        return flipCtr;
    }

    public double getValue() {
        return value;
    }

    public int getHeadsCtr() {
        return headsCtr;
    }

    public int getTailsCtr() {
        return tailsCtr;
    }
    // ----------------------------
    

    /***
     * assignValue() -- set a Coin's monetary value based on its name
     * precond:  input String is a valid coin name ("penny", "nickel", etc.)
     * postcond: instvar value gets appropriate value
     * Returns value assigned.
     ***/
  
    private double assignValue( String s ) {
        
      
        if (s == "penny") {
          value = 0.01;
        } else if (s == "nickel") {
          value = 0.05;
        } else if (s == "dime") {
          value = 0.1;
        } else if (s == "quarter") {
          value = 0.25;
        } else if (s == "half dollar") {
          value = 0.5;
        } else {
          value = 1;
        }
        return value;
    }



    /***
        reset() -- initialize a Coin
        precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
        postcond: Coin's attribs reset to starting vals
    ***/
    
    public void reset( String s, double d ) {
        upFace = s;
        assignValue(s);
        bias = d;
        headsCtr = 0;
        tailsCtr = 0;
        flipCtr = 0;
    }
    

    /***
     * String flip() -- simulates a Coin flip
     * precond:  bias is a double on interval [0.0,1.0]
     * (1.0 indicates always heads, 0.0 always tails)
     * postcond: upFace updated to reflect result of flip.
     * flipCtr incremented by 1.
     * Either headsCtr or tailsCtr incremented by 1, as approp.
     * Returns "heads" or "tails"
     ***/
    public String flip() {
        if (Math.random() <= bias) {
            flipCtr++;
            headsCtr++;
            upFace = "Heads";
            return upFace;
        } else {
            flipCtr++;
            tailsCtr++;
            upFace = "Tails";
            return upFace;
        }
    }	


    /***
     * boolean equals(Coin) -- checks to see if 2 coins have same face up
     * precond: other is not null
     * postcond: Returns true if both coins showing heads
     * or both showing tails. False otherwise.
     ***/
    public boolean equals( Coin other ) {
        return (this.upFace.equals(other.getUpFace()));
    }


    /***
     * String toString() -- overrides toString() provided by Java
     * precond: n/a
     * postcond: Return String comprised of name and current face
     ***/
    public String toString() {
        return name + " -- " + upFace;
    }          

}//end class
