package com.core.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDto {
    private String name;

    @Override
    public String toString() {
        return "CreateUserRequestDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
