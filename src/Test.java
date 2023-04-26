import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(otherClass.Goodbye);
    }
}


class myClass {
    String Howdy = "Hello There!";
    static MyOtherClass otherClass;

    MyClass {
        otherClass = new MyOtherClass();
    }
}

class MyOtherClass {
    static public String Goodbye = "So Long!";

    MyOtherClass() {
    }
}
