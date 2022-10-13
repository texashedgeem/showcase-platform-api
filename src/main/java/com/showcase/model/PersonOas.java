package com.showcase.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonOas {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("userName")
    @Valid
    @NotBlank(message = "The property 'userName' is mandatory.")
    private String userName;

    @JsonProperty("bankAccount")
    @Valid
    @NotBlank(message = "The property 'bankAccount' is mandatory.")
    private String bankAccount;

    @JsonProperty("status")
    private String status;

    @JsonProperty("createdAt")
    private Instant createdAt;
}
