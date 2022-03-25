/***
 * class ListTester
 * ...for putting your LList through its paces
 *
 * Assumes local List.java (interface),
 * overriding List interface from standard Java library
 **/

public class ListTester<T> {
  public static void main(String[] args) {

    LList david = new LList();
    LList<String> daniel = new LList<String>();
    LList<Integer> abdullah = new LList<Integer>();

    david.add("david");
    david.add(1);
    david.add(false);

    daniel.add("daniel");
    daniel.add("sheesh");
    daniel.add("pog");

    abdullah.add(1);
    abdullah.add(2);
    abdullah.add(3);

    System.out.println("Generic LList: " + david);
    david.add(2, "lmsd");
    System.out.println(david);
    david.remove(2);
    System.out.println(david);
    
    System.out.println("String LList: " + daniel);
    daniel.add(2, "lmsd");
    System.out.println(daniel);
    daniel.remove(2);
    System.out.println(daniel);

    System.out.println("Integer LList: " + abdullah);
    abdullah.add(2, 4);
    System.out.println(abdullah);
    abdullah.remove(2);
    System.out.println(abdullah);
    

  }// end main()

}// end class
