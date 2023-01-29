package clonecoding.toby.supertypetoken;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static clonecoding.toby.supertypetoken.TypeReference.CONSTRUCT_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TypeReferenceTest {

    @Test
    void t1() {
        assertThatThrownBy(TypeReference::new)
                .isInstanceOf(RuntimeException.class)
                .hasMessage(CONSTRUCT_EXCEPTION_MESSAGE);
    }

    @Test
    void t2() {
        TypeReference<String> typeReference = new TypeReference<>(){};
        assertThat(typeReference).isNotNull();
    }

}