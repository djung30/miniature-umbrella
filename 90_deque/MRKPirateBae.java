//A Dog's Dream: Abdullah Faruque, David Chen, Daniel Jung
//APCS pd08
//HW91: Deque the Halls
//2022-04-14r
//time spent: 0.5 hours

public class MRKPirateBae {
    
    public static void main(String[] args) {
        Dreamers<Integer> arrrg = new Dreamers<Integer>(); 
        
        for (int i = 0; i < 10; i++){
            arrrg.add(i);
        }
        System.out.println(arrrg.isEmpty());
        System.out.println(arrrg.peekFirst());
        System.out.println(arrrg.peekLast());
        arrrg.removeFirst();
        System.out.println(arrrg.peekFirst());
        arrrg.removeLast();
        System.out.println(arrrg.peekLast());

        while(!arrrg.isEmpty()){
            arrrg.remove();
        }
        System.out.println(arrrg.isEmpty());
      

    } 
    
}