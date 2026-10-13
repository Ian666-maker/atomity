package com.example.tenantcloudapi.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public static class AuthRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        if (authentication.isAuthenticated()) {
            // 💡 模拟多租户逻辑：根据不同用户分配不同的 tenantId
            // 比如 admin 分配到 "tenant-1"
            String tenantId = "tenant-1";
            if ("otherUser".equals(request.getUsername())) {
                tenantId = "tenant-2";
            }

            // 生成携带 tenantId 的 Token
            return jwtUtil.generateToken(request.getUsername(), tenantId);
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
}