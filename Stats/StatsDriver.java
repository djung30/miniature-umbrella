public class StatsDriver{ 
  public static void main(String[] args){
    Stats test = new Stats();
    System.out.println();
    test.mean(1,2);
    test.mean(1.1,1.2);
    test.max(1,2);
    test.max(1.1,2.2);
    test.geoMean(1,2);
    
  }
}
