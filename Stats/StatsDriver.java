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
