package com.erbipin.dfs.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSubscriptionRequest {
    @JsonProperty("package_name")
    private String packageName;
    @JsonProperty("size_in_mb")
    private double sizeProvided;
    @JsonProperty("coverage_time")
    private int timeSpan;
    @JsonProperty("bandwidth_provided")
    private double bandwidthProvided;
}
