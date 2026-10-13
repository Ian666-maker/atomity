package com.example.tenantcloudapi.workload;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkloadRepository extends JpaRepository<Workload, Long> {
    // 👉 根据租户 ID 查询对应的工作负载列表
    List<Workload> findByTenantId(String tenantId);
}