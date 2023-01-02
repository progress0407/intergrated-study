package skeleton.code.spring.error.handle.bean;

import org.springframework.stereotype.Component;

public class ChildProd extends Parent {

    @Override
    public void print() {
        System.out.println("ChildProd.print");
    }
}
