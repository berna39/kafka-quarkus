package com.terminator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {
    // All POJOs of this class will be serialiezed automatically using the avro schema
    private String title;
    private String synopsis;
    private int views;
}
