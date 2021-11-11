public class GrokStatic {
    public static int classField;
    public int instanceField;
    public static void classMethod(int x) {
        classField = 13;
        instanceField = 17; // this
        classMethod(19);
        instanceMethod(41); // this
    }
    public void instanceMethod(int y) {
        classField = 29;
        instanceField = 31;
        classMethod(37); // THIS TECHNICALLY BECAUSE IT INVOKES AN ERROR
        instanceMethod(41);
    }
}
