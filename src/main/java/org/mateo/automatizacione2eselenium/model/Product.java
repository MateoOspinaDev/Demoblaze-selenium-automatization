package org.mateo.automatizacione2eselenium.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private final String category;
    private final String name;
}