package com.github.pettyfer.kubernetes.event.publisher;

import com.github.pettyfer.kubernetes.event.GitlabPushEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
public class GitlabPushEventPublisher {

    private final ApplicationContext context;

    public GitlabPushEventPublisher(ApplicationContext context) {
        this.context = context;
    }

    public void push(String projectName){
        context.publishEvent(new GitlabPushEvent(this, "push project", projectName));
    }

}
