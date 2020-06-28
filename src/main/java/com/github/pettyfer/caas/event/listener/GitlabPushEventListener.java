package com.github.pettyfer.caas.event.listener;

import com.github.pettyfer.caas.event.GitlabPushEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
public class GitlabPushEventListener implements ApplicationListener<GitlabPushEvent> {
    @Override
    public void onApplicationEvent(GitlabPushEvent gitlabPushEvent) {
        System.out.println(gitlabPushEvent.getProjectName());
    }
}
