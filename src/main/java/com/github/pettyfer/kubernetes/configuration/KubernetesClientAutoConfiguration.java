package com.github.pettyfer.kubernetes.configuration;

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

    @Bean
    @SneakyThrows
    KubernetesClient coreV1Api() {
        Config config = new ConfigBuilder()
                .withMasterUrl("http://192.168.13.57:8001")
                .withOauthToken("eyJhbGciOiJSUzI1NiIsImtpZCI6ImcyczVkdENyVThhaGhyeGpaX0RIaDJOM1U5WVh6TVh5Y0hqRXRGZ2RWZ1UifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLXI1bGw3Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI4Nzg5YjE0Zi00ZDI5LTRiMWEtYjdjNy0xZWUzYWU5NmY0MjUiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06YWRtaW4tdXNlciJ9.IXcoYQLOB7tl4_HqohAOS0WYdp3lxFwsvg8rWDcjTjnMpS0nkx-T5zOlJP5My4vkSJg7_M3bGRE1tKJfDuqRHAnrldoqlNznhoYoefpLGap18d_5fmB7dtttWsTVqq9N5OXtfrNJGs8PNO3cEGiF3wqRIQVvP62tF2HrtaDa8qqMtrHfU9c7nYpm8MzOngVbc0II-0seNWgri5lguvn1pUHadoMHqzEOAuTFbyrGU5inV575UWL2J1j0cbXViQZAWPIoItosfmQH4s5eIT43IkC0N1B8SXAnWLYWqoJR2MbxXKUiPZ7QP73eFddIp7_TTxnbrXXRnJqAJlD5kt1zEg")
                .build();
        return new DefaultKubernetesClient(config);
    }


}
