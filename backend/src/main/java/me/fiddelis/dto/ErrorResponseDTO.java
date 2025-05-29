package me.fiddelis.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ErrorResponseDTO {
    public String message;
    public int code;

    public ErrorResponseDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
