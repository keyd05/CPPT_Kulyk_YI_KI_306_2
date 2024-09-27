package KI.Kulyk.Lab6;

public class Driver {
    public static void main(String[] args) {
        MyDictionary<Integer, String> dict = new MyDictionary<>();
        dict.add(24, "3");
        dict.add(22, "2");
        dict.add(26, "1AAA");
        System.out.println(dict.getMax());
    }
}
