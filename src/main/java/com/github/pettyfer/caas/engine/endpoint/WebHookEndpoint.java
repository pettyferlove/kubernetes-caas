package com.github.pettyfer.caas.engine.endpoint;

import com.github.pettyfer.caas.engine.event.publisher.GitlabPushEventPublisher;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author admin
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/hooks")
public class WebHookEndpoint {

    private final GitlabPushEventPublisher publisher;

    public WebHookEndpoint(GitlabPushEventPublisher publisher) {
        this.publisher = publisher;
    }

    @SneakyThrows
    @RequestMapping("gitlab/{projectName}")
    public HttpEntity<String> gitlab(HttpServletRequest request, @PathVariable String projectName) {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String body = sb.toString();
        System.out.println(body);
        System.out.println(request.getHeader("X-Gitlab-Event"));
        publisher.push(projectName);
        return new HttpEntity<String>("success");
    }

}
