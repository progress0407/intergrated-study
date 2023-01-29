package spring.token.interceptor.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.token.interceptor.test.TestUser;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JwtTokenUtilsTest {

    JwtTokenUtils jwtTokenUtils = new JwtTokenUtils(new CurrentDateTimeProvider());

    @DisplayName("토큰을 생성한다")
    @Test
    void t1() {
        String token = jwtTokenUtils.createToken(TestUser.ID);
        assertThat(token).isNotEmpty();
        assertThat(token).isNotEqualTo(TestUser.ID);
    }

    @DisplayName("생성한 토큰을 복원하면 원본 값과 같다")
    @Test
    void t2() {
        String token = jwtTokenUtils.createToken(TestUser.ID);
        String restoreValue = jwtTokenUtils.restorePayload(token);
        assertThat(restoreValue).isEqualTo(TestUser.ID);
    }

    @DisplayName("존재하지 않는 토큰을 복원 시도한다")
    @Test
    void t3() {
        String 존재하지_않는_토큰 = "난 존재하지 않는 토큰이야, 날 복원해낼 수 있을까";

        assertThatThrownBy(
                () -> jwtTokenUtils.restorePayload(존재하지_않는_토큰)
        ).isInstanceOf(MalformedJwtException.class);
    }

    @DisplayName("유효하지 않은(의도적으로 조작한) 토큰을 복원 시도한다")
    @Test
    void t4() {
        String token = jwtTokenUtils.createToken(TestUser.ID);

        String 의도적으로_조작한_토큰 = token + "something do this token";

        assertThatThrownBy(
                () -> jwtTokenUtils.restorePayload(의도적으로_조작한_토큰)
        ).isInstanceOf(SignatureException.class);
    }

    @DisplayName("유효시간이 지난 토큰은 접근이 불가능하다")
    @Test
    void t5() throws NoSuchFieldException {
        // given
        ManualDateTimeProvider manualDateTimeProvider = new ManualDateTimeProvider();
        JwtTokenUtils jwtTokenUtils = new JwtTokenUtils(manualDateTimeProvider);
        LocalDateTime pastDateTime = LocalDateTime.now().minusDays(1);
        manualDateTimeProvider.setDateTime(pastDateTime);

        String 유효기간이_지난_토큰 = jwtTokenUtils.createToken(TestUser.ID);

        // when & then
        assertThatThrownBy(
                () -> jwtTokenUtils.restorePayload(유효기간이_지난_토큰)
        ).isInstanceOf(ExpiredJwtException.class);
    }
}
