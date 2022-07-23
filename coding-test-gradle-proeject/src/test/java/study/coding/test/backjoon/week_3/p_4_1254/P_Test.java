package study.coding.test.backjoon.week_3.p_4_1254;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class P_Test {

    private P p = new P();

    @Test
    void t1() {
        assertThat(p.solve("abab")).isEqualTo("5");
    }

    @Test
    void t2() {
        assertThat(p.solve("abacaba")).isEqualTo("7");
    }

    @Test
    void t3() {
        assertThat(p.solve("qwerty")).isEqualTo("11");
    }

    @Test
    void t4() {
        assertThat(p.solve("abdfhdyrbdbsdfghjkllkjhgfds")).isEqualTo("38");
    }
}