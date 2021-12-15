/*
package com.example.moneytransferserviceproject.model.operations;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class OperationSerializer extends StdSerializer<Operation> {

    public OperationSerializer(){
        this(null);
    }

    public OperationSerializer(Class<Operation> t) {
        super(t);
    }



    @Override
    public void serialize(Operation operation,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("operationId", operation.getOperationId());
        jsonGenerator.writeEndObject();

    }
}
*/
