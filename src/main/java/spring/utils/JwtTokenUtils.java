package spring.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.util.Optional;

import static spring.utils.DateTimeUtils.convertDateFrom;

public final class JwtTokenUtils {

    private static final String secretKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIiLCJuYW1lIjoiSm9obiBEb2UiLCJpYXQiOjE1MTYyMzkwMjJ9.ih1aovtQShabQ7l0cINw4k1fagApg3qLWiB8Kt59Lno";
    private static final long expirationInterval = 10;

    private JwtTokenUtils() {
    }

    public static String createToken(String payload) {

        Claims claims = Jwts.claims().setSubject(payload);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expirationDateTime = now.plusSeconds(expirationInterval);

        String jwt = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(convertDateFrom(now))
                .setExpiration(convertDateFrom(expirationDateTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return jwt;
    }

    public static Optional<String> restorePayload(String token) {

        String payload = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        return Optional.of(payload);
    }

    /**
     * 토큰이 만료되었는지를 체크한다
     * true: 토큰 만료
     * false: 토큰 유효
     * @param token
     * @param expireDate
     * @return
     */
    private static boolean isTokenExpired(String token, LocalDateTime expireDate) {
        Jws<Claims> claims = restoreClaimsFrom(token);

        if (isTokenExpired(expireDate, claims)) {
            return true;
        }
        return false;
    }

    private static Jws<Claims> restoreClaimsFrom(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
    }

    private static boolean isTokenExpired(LocalDateTime expireDate, Jws<Claims> claims) {
        return claims.getBody().getExpiration().after(convertDateFrom(expireDate));
    }
}
