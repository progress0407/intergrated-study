package password;

public class PasswordStrengthMeter {

    public PasswordStrength examine(String input) {

        if (input == null || input.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        boolean containsUpperCase = meetsContainingUppercaseCriteria(input);
        boolean lengthEnough = input.length() >= 8;
        boolean containsNumber = meetsContainingNumberCriteria(input);

        if (lengthEnough && !containsNumber && !containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough && containsNumber && !containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough && !containsNumber && containsUpperCase) {
            return PasswordStrength.WEAK;
        }

        if (!containsUpperCase) {
            return PasswordStrength.NORMAL;
        }

        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }

        if (!containsNumber) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
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
