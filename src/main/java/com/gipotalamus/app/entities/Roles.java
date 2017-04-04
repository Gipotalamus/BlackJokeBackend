package com.gipotalamus.app.entities;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by gipotalamus on 02.03.17.
 */
public enum Roles {
    ROLE_USER("[ROLE_USER]"),
    ROLE_ADMIN("[ROLE_ADMIN]"),
    anonymous("[anonymous]");

    private String jsonValue;

    private Roles(final String json) {
        this.jsonValue = json;
    }

    @JsonValue
    public String jsonValue() {
        return this.jsonValue;
    }
}
