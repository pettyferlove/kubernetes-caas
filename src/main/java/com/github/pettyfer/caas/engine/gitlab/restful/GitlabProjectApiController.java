package com.github.pettyfer.caas.engine.gitlab.restful;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/gitlab/project")
@Api(value = "Gitlab Project Api", tags = {"Gitlab Project Api"})
public class GitlabProjectApiController {

}
