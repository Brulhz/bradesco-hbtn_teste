package src;

public class Pessoa {

    public static boolean emailValid(String email) {
        if (email == null) {
            return false;
        }

        if (!email.contains("@")) {
            return false;
        }

        if (email.length() > 50) {
            return false;
        }

        return true;
    }
}