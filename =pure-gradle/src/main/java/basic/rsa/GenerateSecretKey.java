package basic.rsa;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

public class GenerateSecretKey {

    public static void main(String[] args) {
            SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            String secretString = Encoders.BASE64.encode(secretKey.getEncoded());
            System.out.println("secretString: " + secretString);
    }
}
