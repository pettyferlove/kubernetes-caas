package com.github.pettyfer.kubernetes.service;

import io.fabric8.kubernetes.api.model.apps.Deployment;

import java.util.List;

/**
 * @author Petty
 */
public interface DeploymentService {

    List<Deployment> list();

}
