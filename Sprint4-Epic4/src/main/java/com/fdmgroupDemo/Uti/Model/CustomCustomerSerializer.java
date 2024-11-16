package com.fdmgroupDemo.Uti.Model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import com.fdmgroupDemo.model.Account;
import com.fdmgroupDemo.model.Customer;

public class CustomCustomerSerializer extends JsonSerializer<Customer> {
    @Override
    public void serialize(Customer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("type", value.getClass().getSimpleName().toLowerCase());
        gen.writeNumberField("customerId", value.getCustomerId());
        gen.writeStringField("name", value.getName());
        gen.writeObjectField("address", value.getAddress());
        gen.writeArrayFieldStart("accounts");
        for (Account account : value.getAccounts()) {
            serializers.defaultSerializeValue(account, gen);
        }
        gen.writeEndArray();
        gen.writeEndObject();
    }
}