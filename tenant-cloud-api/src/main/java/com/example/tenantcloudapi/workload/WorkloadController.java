package com.example.tenantcloudapi.workload;

import com.example.tenantcloudapi.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workloads")
public class WorkloadController {

    private final WorkloadRepository workloadRepository;
    private final JwtUtil jwtUtil;

    public WorkloadController(WorkloadRepository workloadRepository, JwtUtil jwtUtil) {
        this.workloadRepository = workloadRepository;
        this.jwtUtil = jwtUtil;
    }

    // 辅助方法：从 Authorization 请求头中提取 tenantId，如果没有则返回默认租户 "tenant-1"
    private String getTenantIdFromHeader(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String token = authHeader.substring(7);
                String tenantId = jwtUtil.extractTenantId(token);
                if (tenantId != null) {
                    return tenantId;
                }
            } catch (Exception e) {
                // Token 解析失败时降级
            }
        }
        // 👉 浏览器直接访问或未带 Token 时，默认使用 "tenant-1"
        return "tenant-1";
    }

    // 1. 查询当前租户的 workloads
    @GetMapping
    public List<Workload> getAllWorkloads(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        String tenantId = getTenantIdFromHeader(authHeader);
        return workloadRepository.findByTenantId(tenantId);
    }

    // 2. 创建 workload，自动绑定当前租户
    @PostMapping
    public Workload createWorkload(
            @RequestHeader(value = "Authorization", required = false) String authHeader,
            @RequestBody Workload workload) {
        String tenantId = getTenantIdFromHeader(authHeader);

        workload.setTenantId(tenantId);
        return workloadRepository.save(workload);
    }
}