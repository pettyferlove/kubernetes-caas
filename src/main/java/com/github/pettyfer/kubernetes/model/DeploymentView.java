package com.github.pettyfer.kubernetes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * @author Petty
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentView implements Serializable {
    private static final long serialVersionUID = 936073914758626898L;

    private String name;

    private String namespace;

    private String groupStatus;

    private String creationTimestamp;

    private String imagesName;

}
