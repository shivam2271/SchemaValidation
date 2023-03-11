package com.shivam.schemaValidation.validator;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.shivam.schemaValidation.model.JsonSchema;
import lombok.extern.slf4j.Slf4j;
import org.openapi4j.core.exception.EncodeException;
import org.openapi4j.core.exception.ResolutionException;
import org.openapi4j.core.validation.ValidationException;
import org.openapi4j.parser.OpenApi3Parser;
import org.openapi4j.parser.model.v3.OpenApi3;
import org.openapi4j.parser.model.v3.Schema;
import org.openapi4j.schema.validator.ValidationContext;
import org.openapi4j.schema.validator.ValidationData;
import org.openapi4j.schema.validator.v3.SchemaValidator;
import org.springframework.stereotype.Component;

import java.io.DataInput;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class SchemaValidatorClass {


    public String SchemaValidatorClass(JsonSchema jsonSchema) throws IOException, ResolutionException, ValidationException, EncodeException {
        URL specUrl= new URL("file:src/main/resources/schema.yaml");
        String schemaName ="jsonSchema";
        OpenApi3 api= new OpenApi3Parser().parse(specUrl,true);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(jsonSchema);
 JsonNode contentNode= mapper.readTree(json);
        Schema s= api.getComponents().getSchema(schemaName);
        JsonNode schemaNode= s.toNode();
        SchemaValidator schemaValidator= new SchemaValidator(new ValidationContext<>(api.getContext()),null, schemaNode);
        ValidationData<Void> validationData= new ValidationData<>();
        schemaValidator.validate(contentNode,validationData);
        if(validationData.isValid()){
            System.out.println("Schema is Valid"+validationData.results().toString());

            return "ok";
        }
        else{
            System.out.println(validationData.results().toString());
            throw new ValidationException(validationData.results().toString(), validationData.results());         }
    }
}
