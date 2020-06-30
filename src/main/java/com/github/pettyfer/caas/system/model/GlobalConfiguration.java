package com.github.pettyfer.caas.system.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GlobalConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gitlabHomePath;

    private String dockerHost;

    private String workspace;

    private String dockerRegistryPath;

    private String dockerRegistryProject;

    private String dockerRegistryUsername;

    private String dockerRegistryPassword;

    private String mavenHome;

}
