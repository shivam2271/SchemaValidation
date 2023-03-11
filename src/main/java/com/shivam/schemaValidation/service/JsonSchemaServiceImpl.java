package com.shivam.schemaValidation.service;

import com.shivam.schemaValidation.model.JsonSchema;
import org.springframework.stereotype.Service;

@Service

public class JsonSchemaServiceImpl implements JsonSchemaService {

    @Override
    public String getSchemaName(JsonSchema jsonSchema) {
        return jsonSchema.getTestName();
    }
}
