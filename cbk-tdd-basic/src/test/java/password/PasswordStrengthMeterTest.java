package password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PasswordStrengthMeterTest {

    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expectedStrength) {
        PasswordStrength result = meter.meter(password);
        Assertions.assertEquals(expectedStrength, result);
    }

    @Test
    @DisplayName("공백을 입력하면 INVALID를 리턴한다")
    void input_empty_string_then_invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    @DisplayName("null을 입력하면 INVALID를 리턴한다")
    void input_null_then_invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A123456789", "123A@!4567"})
    @DisplayName("모든 조건을 충족하는 경우 강함을 리턴한다")
    void meetsAllCriteria_Then_Strong(String password) {
        assertStrength(password, PasswordStrength.STRONG);
    }

    @Test
    @DisplayName("길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("A@12345", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_Number_Then_Normal() {
        assertStrength("ABCDEFGH@", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void meetsOtherCriteria_except_for_Upper_Case_Then_Normal() {
        assertStrength("1234abcd!", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("8글자 이상인 조건만 충족하는 경우")
    void meetsOnlyCriteria_for_Length_then_Weak() {
        assertStrength("abcdefghi", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("숫자 포함 조건만 충족하는경우")
    void meetsOnlyCriteria_for_Number_then_Weak() {
        assertStrength("1234", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("대문자 포함 조건만 충족하는경우")
    void meetsOnlyCriteria_for_Uppercase_then_Weak() {
        assertStrength("ABCD", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("아무 조건도 충족하지 않은 경우")
    void meetsNoCriteria_then_Weak() {
        assertStrength("abcd", PasswordStrength.WEAK);
    }
}
