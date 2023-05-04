package designpattern.singleton;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class AbstractSingletonTest {

    @Test
    void test() {
        AbstractSingleton loadedObjectEarlier = AbstractSingleton.newInstance();
        AbstractSingleton loadedObjectLater = AbstractSingleton.newInstance();

        assertAll(
                () -> assertThat(loadedObjectEarlier).isSameAs(loadedObjectLater),
                () -> assertThat(loadedObjectLater.createdNumberOfObjects()).isEqualTo(1),
                () -> assertThatThrownBy(() -> loadedObjectLater.introduceMe())
                        .isInstanceOf(RuntimeException.class)
        );
    }

}