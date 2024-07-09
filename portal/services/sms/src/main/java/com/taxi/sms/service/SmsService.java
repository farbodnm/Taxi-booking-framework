package com.taxi.sms.service;

import com.taxi.framework.sms.dto.SmsRequestDTO;
import com.google.gson.Gson;
import com.taxi.framework.sms.service.AbstractSmsService;
import okhttp3.OkHttpClient;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SmsService extends AbstractSmsService {
    private final String apiKey;
    private final String url;

    public SmsService(@Value("${sms.api.key}") String apiKey, @Value("${sms.api.url}") String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    @Override
    protected OkHttpClient createHttpClient() {
        return new OkHttpClient().newBuilder().build();  // Factory Method for OkHttpClient
    }

    @Override
    protected Request createRequest(SmsRequestDTO smsRequestDTO) {
        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = new SmsRequestBodyBuilder()  // Using Builder Pattern
                .withMobile(smsRequestDTO.getMobile())  // Adding mobile to builder
                .withTemplateId(smsRequestDTO.getTemplateId())  // Adding templateId to builder
                .withParameters(smsRequestDTO.getParameters())  // Adding parameters to builder
                .build();  // Building JSON body

        RequestBody body = RequestBody.create(mediaType, jsonBody);
        return new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "text/plain")
                .addHeader("x-api-key", apiKey)
                .build();
    }

    @Override
    protected String executeRequest(OkHttpClient client, Request request) throws IOException {
        try (Response response = client.newCall(request).execute()) {
            return response.body() != null ? response.body().string() : null;
        }
    }

    // Builder Pattern: Inner static class for building JSON request body
    private static class SmsRequestBodyBuilder {
        private String mobile;
        private String templateId;
        private List<SmsRequestDTO.Parameter> parameters;

        public SmsRequestBodyBuilder withMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public SmsRequestBodyBuilder withTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public SmsRequestBodyBuilder withParameters(List<SmsRequestDTO.Parameter> parameters) {
            this.parameters = parameters;
            return this;
        }

        public String build() {
            StringBuilder parametersJson = new StringBuilder("[");
            for (SmsRequestDTO.Parameter parameter : parameters) {
                parametersJson.append("{")
                        .append("\"name\":\"").append(parameter.getName()).append("\",")
                        .append("\"value\":\"").append(parameter.getValue()).append("\"},");
            }
            if (parametersJson.length() > 1) {
                parametersJson.setLength(parametersJson.length() - 1); // Remove trailing comma
            }
            parametersJson.append("]");

            return "{\n" +
                    "\"mobile\":\"" + mobile + "\",\n" +
                    "\"templateId\":\"" + templateId + "\",\n" +
                    "\"parameters\":" + parametersJson.toString() + "\n" +
                    "}";
        }
    }
}
