package com.github.pettyfer.kubernetes.configuration;

import com.github.pettyfer.kubernetes.properties.KubernetesClientProperties;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Kubernetes Client实例自动化配置
 *
 * @author Petty
 */
@Configuration
@ConditionalOnWebApplication
public class KubernetesClientAutoConfiguration {

    private final KubernetesClientProperties properties;

    public KubernetesClientAutoConfiguration(KubernetesClientProperties properties) {
        this.properties = properties;
    }

    @Bean
    @SneakyThrows
    KubernetesClient coreV1Api() {
        Config config = new ConfigBuilder()
                .withMasterUrl(properties.getMasterUrl())
                .withOauthToken(properties.getToken())
                .build();
        return new DefaultKubernetesClient(config);
    }


}
