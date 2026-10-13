package com.example.tenantcloudapi.workload;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String region;
    private String cloudProvider; // 例如 AWS, Azure 等
    private String tenantId;      // 👉 新增：多租户隔离字段

    // Getters 和 Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getCloudProvider() { return cloudProvider; }
    public void setCloudProvider(String cloudProvider) { this.cloudProvider = cloudProvider; }

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
}