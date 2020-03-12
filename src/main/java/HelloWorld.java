import javax.faces.bean.ManagedBean;
import java.io.Serializable;


public class HelloWorld implements Serializable {
    String message = "Зосимов Кирилл (P3202)";

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}