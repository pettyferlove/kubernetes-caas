package com.github.pettyfer.caas.event.publisher;

import com.github.pettyfer.caas.event.GitlabPushEvent;
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
