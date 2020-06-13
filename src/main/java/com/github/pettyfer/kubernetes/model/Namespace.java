package com.github.pettyfer.kubernetes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import lombok.*;

import javax.validation.constraints.NotNull;
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
@JsonPropertyOrder({"apiVersion", "kind", "metadata"})
public class Namespace implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String apiVersion = "v1";

    @NotNull
    private String kind = "Namespace";

    @NotNull
    private String name;

    private ObjectMeta metadata;



}
