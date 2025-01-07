package net.BuildUi.userservice.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.BuildUi.userservice.entity.UserInfo;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfo> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public UserInfo deserialize(String s, byte[] bytes) {
        UserInfo user = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            user = objectMapper.readValue(bytes , UserInfo.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public UserInfo deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public UserInfo deserialize(String topic, Headers headers, ByteBuffer data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
