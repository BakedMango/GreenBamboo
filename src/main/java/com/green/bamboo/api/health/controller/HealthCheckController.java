package com.green.bamboo.api.health.controller;

import com.green.bamboo.api.health.dto.HealthCheckResponseDto;
import com.green.bamboo.global.util.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HealthCheckController {

    private final Environment environment;

    @GetMapping("/health")
    public ResponseEntity<ApiUtils.ApiResult<HealthCheckResponseDto>> healthCheck() {
        HealthCheckResponseDto healthCheckResponseDto = HealthCheckResponseDto.builder()
                .health("ok")
                .activeProfile(Arrays.asList(environment.getActiveProfiles()))
                .build();
        return ResponseEntity.ok(ApiUtils.success(healthCheckResponseDto));
    }
}