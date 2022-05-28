package spring.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.test.TestUserConstant;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class JwtTokenUtilsTest {

    @DisplayName("토큰을 생성한다")
    @Test
    void t1() {
        String token = JwtTokenUtils.createToken(TestUserConstant.ID);
        assertThat(token).isNotEmpty();
        assertThat(token).isNotEqualTo(TestUserConstant.ID);
    }

    @DisplayName("생성한 토큰을 복원하면 원본 값과 같다")
    @Test
    void t2() {
        String token = JwtTokenUtils.createToken(TestUserConstant.ID);
        String restoreValue = JwtTokenUtils.restorePayload(token).get();
        assertThat(restoreValue).isEqualTo(TestUserConstant.ID);
    }
}