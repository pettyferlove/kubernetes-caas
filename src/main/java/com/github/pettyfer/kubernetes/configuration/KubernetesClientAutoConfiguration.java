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
                .withMasterUrl("http://127.0.0.1:8001")
                .withOauthToken("eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJkZWZhdWx0LXRva2VuLWw2bWw5Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImRlZmF1bHQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI5NmU0YTFjNC03YTQzLTExZWEtOWM1Yi0wMDE1NWQwYTNjMDYiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06ZGVmYXVsdCJ9.0jIJHCrBf7XmipGIwb02agSomiUVAawKCfMjB1U1WoQ511Sf9RoY_K88GegGvl_GvF5m3eqLj-0iZ9x3bOfXDewe2s8zE3itCjp9LLerxzJcwpz_m1czLsa2osi0DCWVO3y6Cx2kR8mZba4vUPx1eC3CPR1WqkZ0Sgle0XFsyXitm8WFmWfNMXDXT8iRAW4zFI3nA573bB88CPupL-1Bs3tw60FFZNzEzUImlZHFCA7-M4Z5YH8qYf4JBETCGP0UZ3Yh2pjs2ZYkP5mUOwoGu-hr0AE0ZhSchpkErDzVO-MLroiZkVb_i6-iMPz8iB_XRCmgO3EiC_JZ0Sjz0YCFMw")
                .build();
        return new DefaultKubernetesClient(config);
    }


}
