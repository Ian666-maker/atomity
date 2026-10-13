package com.example.tenantcloudapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "mySecretKeyForTenantCloudApiProjectSecurityJwtToken2026SecureKeyEnsure32Bytes";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    // 👉 改造：支持生成带 tenantId 的 Token
    public String generateToken(String username, String tenantId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("tenantId", tenantId);
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 10)) // 10小时过期
                .signWith(key)
                .compact();
    }

    // 从 Token 中解析用户名
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // 👉 新增：从 Token 中提取 tenantId
    public String extractTenantId(String token) {
        return extractAllClaims(token).get("tenantId", String.class);
    }

    // 验证 Token 是否有效
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}