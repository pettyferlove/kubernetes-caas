package com.github.pettyfer.kubernetes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.fabric8.kubernetes.api.model.NamespaceSpec;
import io.fabric8.kubernetes.api.model.NamespaceStatus;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NamespaceDetailView implements Serializable {

    private String apiVersion;

    private ObjectMeta metadata;

    private NamespaceSpec spec;

    private NamespaceStatus status;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
