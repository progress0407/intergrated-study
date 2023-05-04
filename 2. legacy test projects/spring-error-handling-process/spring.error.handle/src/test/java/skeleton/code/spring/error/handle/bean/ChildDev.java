package skeleton.code.spring.error.handle.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
public class ChildDev extends Parent {

    @Override
    public void print() {
        System.out.println("ChildDev.print");
    }
}
