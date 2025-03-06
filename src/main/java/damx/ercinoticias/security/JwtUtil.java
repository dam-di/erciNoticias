package damx.ercinoticias.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class JwtUtil {

    // Clave secreta (debe coincidir con la usada en Python y estar en base64)
    //private static final String SECRET_KEY = "OGU2ZDAwOTliYTcxNjQzMzc4NzdmN2ZjMzA2MmY3MWE4ZGVmMmYwOThiYWQzMDU0MjgxODRmZDlkNDUzMjAyZjc2NWU3YjUxYzMxMzliOTczYjE1ZGZlMWQxYzY3NTIwZjRiYjE2OWZiNmQ2ZWZmNjkxYTcxOWE1YWQ1NDY5ZGI=";

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String extractUsername(String token) {
        return getClaims(token).getSubject(); // Extrae el usuario
    }

    // Extraer un dato específico (por ejemplo, "sub" o "rol")
    public <T> T extraerDato(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(getClaims(token));
    }

    // Extraer el rol del token
    public String extractRol(String token) {
        return extraerDato(token, claims -> claims.get("rol", String.class));
    }

    public boolean validateToken(String token) {
        try {
            return getClaims(token) != null;
        } catch (Exception e) {
            return false; // Token inválido
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
