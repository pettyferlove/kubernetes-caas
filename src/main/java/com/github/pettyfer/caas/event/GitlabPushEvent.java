package com.github.pettyfer.caas.event;

/**
 * @author admin
 */
public class GitlabPushEvent extends PushEvent {

    private static final long serialVersionUID = 1L;

    private String projectName;

    public GitlabPushEvent(Object source, String message, String projectName) {
        super(source, message);
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
