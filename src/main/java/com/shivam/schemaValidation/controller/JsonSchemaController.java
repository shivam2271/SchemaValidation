package com.shivam.schemaValidation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shivam.schemaValidation.model.JsonSchema;
import com.shivam.schemaValidation.service.JsonSchemaServiceImpl;
import com.shivam.schemaValidation.validator.SchemaValidatorClass;
import org.openapi4j.core.exception.EncodeException;
import org.openapi4j.core.exception.ResolutionException;
import org.openapi4j.core.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/api")
public class JsonSchemaController {
    @Autowired
    private JsonSchemaServiceImpl jsonSchemaService;
    @Autowired
    private SchemaValidatorClass schemaValidatorClass;
//   public JsonSchemaLJsonSchema= JsonSchema.builder().testAddress("Porsa").testAge("6").testName("shiva").build();
    @PostMapping("/v1/kp")
    public String getJsonSchemaName(@RequestBody JsonSchema jsonSchema) throws ResolutionException, IOException, ValidationException, EncodeException {
        schemaValidatorClass.SchemaValidatorClass(jsonSchema);
        return jsonSchemaService.getSchemaName(jsonSchema);
    }
}
