package com.arthurbarbosa.jwt.backend.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface GenericDTO {

    Long getId();
}
