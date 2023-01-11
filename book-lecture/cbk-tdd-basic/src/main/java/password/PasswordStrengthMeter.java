package password;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String input) {

        if (input == null || input.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int meetsCount = getMeetsCount(input);

        if (meetsCount == 3) {
            return PasswordStrength.STRONG;
        }

        if (meetsCount == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.WEAK;
    }

    private int getMeetsCount(String input) {
        int meetsCount = 0;

        if (meetsContainingUppercaseCriteria(input)) {
            meetsCount++;
        }

        if (input.length() >= 8) {
            meetsCount++;
        }

        if (meetsContainingNumberCriteria(input)) {
            meetsCount++;
        }
        return meetsCount;
    }

    private boolean meetsContainingUppercaseCriteria(String input) {
        boolean containsUpperCase = false;
        for (char ch : input.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                containsUpperCase = true;
                break;
            }
        }
        return containsUpperCase;
    }

    private boolean meetsContainingNumberCriteria(String input) {
        boolean containsNumber = false;
        for (char ch : input.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                containsNumber = true;
                break;
            }
        }
        return containsNumber;
    }
}
