package com.programesi.api.models.dto;

public class ErrorDTO {
    /**
     * código de erro do cupom (status code http)
     */
    private int code;
    /**
     * mensagem de erro
     */
    private String message;

    public ErrorDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
