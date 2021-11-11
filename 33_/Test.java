/***
 * Jason Zhou, Daniel Jung, Russell Goychayev (Team Dunkin' Ducks) Duckies: Tiggy, Ralph, 
 * APCS
 * HW33: Retrench, Regroup
 * 2021-11-11
 * time spent: 1.25 hrs
 */

public class Test {
    public static void q10() {
        int s, w, t, h;
        w = 1; t = -4; h = 4; s = -2;
        if ( t > h) {
            s = t;
        }
        else if (h > w) {
            s = h;
        }
        if ( h > t ) {
            s += 1;
        }
        else {
            s = 100;
        }
        System.out.println(s);
    }
    public static void q11() {
        double x = 5;
        double y = 2;
        int m = (int) (x + y + x / y - x * y - x / (10*y));
        System.out.println(m);
    }
    public static void q12() {
        int x = 89;
        byte y = 89;
        short z = 89;
        long a = 89;
        double b = 89;
        //no error so all right
    }
    public static void q14() { 
        
        double ans = (double)(25/4);
        System.out.println(ans);
        double ans2 = 25/(double)4.0;
        System.out.println(ans2);
        double ans3 = (double)25/4;
        System.out.println(ans3);
        double ans4 = 25/4.0;
        System.out.println(ans4);
        double ans5 = 25.0/4;
        System.out.println(ans5);
    }
    
    public static void q15() {
        System.out.println((int)(Math.random() * 5) + 10); // returns 0
        
    }
    public static void q16() {
        System.out.println("1" + new String("2") + 3);
    }
    public static void q17() {
        String drop = new String("e");
        String dead = new String("e");
        String fred = new String("e");
        System.out.println(drop == dead);
        System.out.println(drop == fred);
        System.out.println(drop.equals(dead));
        System.out.println(drop.equals(fred));
    }
    public static void q18() {
        int x = 160;
        //byte x1 = 160; error here
        short x2 = 160;
        long x3 = 160;
        double x4 = 160;
    }
    public static void q19() {
        int x = 123; int y = 0;
        while(x > 0) {
            y *= 10;
            y += x % 10;
            x /= 10; 
        }
        System.out.println(y);
    }

    public static void q21() {
        int p = 3;
        int q = 1;
        int sum = 0;
        while (p <= 10) {
            sum += p % q;
            p+=1;
            q+=1;
        }
        System.out.println(sum);
    }

    public static void q22(int x, int y) {
        int m = x; int i = 1;
        while (m % y != 0) {
            m = i * x;
            i += 1;
        }
        System.out.println(m);
    }

    public static void twist(String[] w) {
        String temp = w[0].substring(0, 1);
        w[0] = w[1].substring(0,1) + w[0].substring(1);
        w[1] = temp + w[1].substring(1);
    }
    public static void q23() {
        String[] words = {"How", "Neat"};
        twist(words);
        System.out.println(words[0] + " " + words[1]);
    }
    public static void q24() {
        int n = 253;
        for (int i =0; i<50; i++) {
            n = (n+3)/2;
        }
        System.out.println(n);
    }
    public static void main(String[] args) {
        

        q22(12, 9);
    }
    
}
