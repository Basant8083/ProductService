package General;

public class JavaPassByValue {
    int x;
    public void f1(JavaPassByValue obj){
        obj.x = 10;

        System.out.println(x);
    }

    public static void main(String[] args) {
        JavaPassByValue obj = new JavaPassByValue();
        obj.f1(obj);
    }

}
