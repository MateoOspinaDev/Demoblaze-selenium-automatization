package org.mateo.automatizacione2eselenium.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private final String username;
    private final String passwork;
}
