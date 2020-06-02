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
                .withOauthToken("eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJkZWZhdWx0LXRva2VuLXo3Y2I0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImRlZmF1bHQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiI5ZDEzOTVmYi1hM2UxLTExZWEtYmFiMy0wMDE1NWQzMzE2MDUiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZS1zeXN0ZW06ZGVmYXVsdCJ9.dQHfg6Ut_skquRYGfgLRu2PtoK4Z5K18iTLDm7IiLcw9kjfTRJwNyvFQt2ffpubPEqQViiH4Ny6gD980N-z9jOc-kMQ_mdlxsDzpI3zkHRfi82ZYY18KKfH58-j0wo0kFiZheI0uHKUga7avnWKhoIoqj-U8ZL69db_DQj0AAN8uh-F-Cs6yy93sWDV6DB8LYBoNgL6s8PQ5BFt8pebVZZpNSNcFSwtN_niOAROKbeKV6F2WsLNGwBboCZSog9bNTEvQb5T-kxZrTFmaP0YgO10BILnvWdihSFGHSFkh9tbGQB35XvaLpNR_KYxGoLLkKNe9ID42kHaWzzryZiZAww")
                .build();
        return new DefaultKubernetesClient(config);
    }


}
