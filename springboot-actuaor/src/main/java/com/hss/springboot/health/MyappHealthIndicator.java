package com.hss.springboot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyappHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //自定义检查方法
       return Health.down().withDetail("msg","原地爆炸").build();
//        return Health.up().build();
    }
}
