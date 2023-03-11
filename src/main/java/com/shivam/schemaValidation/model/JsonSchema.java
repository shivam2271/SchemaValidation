package com.shivam.schemaValidation.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class JsonSchema {
    public String testName;
    public String testAge;
    public String testAddress;

}
