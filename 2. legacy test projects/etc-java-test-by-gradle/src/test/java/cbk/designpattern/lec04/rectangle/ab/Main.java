package cbk.designpattern.lec04.rectangle.ab;

import org.junit.jupiter.api.Test;

class Main {

    @Test
    void test() {

        직사각형Class 사각형 = new 직사각형Class(4, 4);

        사각형.set가로(7);

        System.out.println("사각형 = " + 사각형);

    }

    @Test
    void test2() {

        직사각형Class 사각형 = new 정사각형Class(4, 4);

        사각형.set가로(7);

        System.out.println("사각형 = " + 사각형);

    }
}
