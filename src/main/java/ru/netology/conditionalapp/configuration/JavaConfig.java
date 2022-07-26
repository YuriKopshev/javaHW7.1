package ru.netology.conditionalapp.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.conditionalapp.DevProfile;
import ru.netology.conditionalapp.ProductionProfile;
import ru.netology.conditionalapp.SystemProfile;

@Configuration
public class JavaConfig {
    @ConditionalOnProperty(name ="netology.profile.dev",havingValue = "true",matchIfMissing = true)
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }
    @ConditionalOnProperty(name ="netology.profile.dev",havingValue = "false")
    @Bean
    public SystemProfile productionProfile() {
        return new ProductionProfile();
    }

}
