<<<<<<< HEAD
public class StatsDriver{ 
	public static int mean(int a, int b) {
		return((a+b)/2);
	}
	public static double mean(double a, double b) {
		return((a+b)/2); 
	}
	public static int max(int a, int b) {
		if (a>b){
			return(a);
		}
		else {
			return(b);
		}
	}
	public static double max(double a, double b) {

	}
	public int geoMean(int a, int b) {

	}
	public double geoMean(double a, double b) {

	}

	public static void main(String [] args) {

	}  
}
=======
public class StatsDriver {

    //main method for testing functionality
    public static void main(String[] args ) {
        System.out.println(Stats.mean(2,2));
        System.out.println(Stats.mean(4.5,1.5));
  
        System.out.println("------");
  
        System.out.println(Stats.max(5,20));
        System.out.println(Stats.max(5,5));
        System.out.println(Stats.max(1.5,1.5));
        System.out.println(Stats.max(1.5,21.5));
  
        System.out.println("------");
  
        System.out.println(Stats.max(1,2,3));
        System.out.println(Stats.max(3,2,1));
        System.out.println(Stats.max(1,3,2));
        System.out.println(Stats.max(1,1,2));
        System.out.println(Stats.max(2,2,2));
        System.out.println(Stats.max(1,2,2));
        
        System.out.println(Stats.max(1.5,3.0,2.2));
        System.out.println(Stats.max(2.0,1.0,1.0));
        
  
        System.out.println("------");
  
        System.out.println(Stats.geoMean(10,20));
        System.out.println(Stats.geoMean(10,10));
        System.out.println(Stats.geoMean(0,10));
        
        System.out.println("------");
  
        System.out.println(Stats.geoMean(10.0,20.0));
        System.out.println(Stats.geoMean(10.0,10.0));
        System.out.println(Stats.geoMean(0.0,10.0));
  
        System.out.println("------");
        
        System.out.println(Stats.geoMean(10, 10, 10));
  
        System.out.println("------");
  
        System.out.println(Stats.geoMean(10.0, 10.0, 10.0));
  
      }
}
>>>>>>> c7e5b435fa634a2be540e5dad73db6622795ce80
