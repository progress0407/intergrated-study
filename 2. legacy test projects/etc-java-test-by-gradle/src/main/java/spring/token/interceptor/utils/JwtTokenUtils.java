package spring.token.interceptor.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

import static spring.token.interceptor.utils.DateTimeUtils.convertDateFrom;

@AllArgsConstructor
public final class JwtTokenUtils {

    private final String SECRET_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIiLCJuYW1lIjoiSm9obiBEb2UiLCJpYXQiOjE1MTYyMzkwMjJ9.ih1aovtQShabQ7l0cINw4k1fagApg3qLWiB8Kt59Lno";
    private final long EXPIRATION_INTERVAL = 10;
    private final DateTimeProvider dateTimeProvider;

    public String createToken(String payload) {

        Claims claims = Jwts.claims().setSubject(payload);
        LocalDateTime issuedDateTime = dateTimeProvider.get();
        LocalDateTime expirationDateTime = issuedDateTime.plusSeconds(EXPIRATION_INTERVAL);

        String jwt = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(convertDateFrom(issuedDateTime))
                .setExpiration(convertDateFrom(expirationDateTime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return jwt;
    }

    public String restorePayload(String token) {

        String payload = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        return payload;
    }

    /**
     * 토큰이 만료되었는지를 체크한다
     * true: 토큰 만료
     * false: 토큰 유효
     * @param token
     * @param expireDate
     * @return
     */
    private boolean isTokenExpired(String token, LocalDateTime expireDate) {
        Jws<Claims> claims = restoreClaimsFrom(token);

        if (isTokenExpired(expireDate, claims)) {
            return true;
        }
        return false;
    }

    private Jws<Claims> restoreClaimsFrom(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }

    private boolean isTokenExpired(LocalDateTime expireDate, Jws<Claims> claims) {
        return claims.getBody().getExpiration().after(convertDateFrom(expireDate));
    }
}
