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

@Service
public class SmsService extends AbstractSmsService {
    private final OkHttpClient client;
    private final String apiKey;
    private final String url;

    public SmsService(@Value("${sms.api.key}") String apiKey, @Value("${sms.api.url}") String url) {
        this.client = new OkHttpClient().newBuilder().build();
        this.apiKey = apiKey;
        this.url = url;
    }

    @Override
    protected String convertToJson(SmsRequestDTO smsRequestDTO) {
        StringBuilder parametersJson = new StringBuilder("[");
        for (SmsRequestDTO.Parameter parameter : smsRequestDTO.getParameters()) {
            parametersJson.append("{")
                    .append("\"name\":\"").append(parameter.getName()).append("\",")
                    .append("\"value\":\"").append(parameter.getValue()).append("\"},");
        }
        if (parametersJson.length() > 1) {
            parametersJson.setLength(parametersJson.length() - 1); // Remove trailing comma
        }
        parametersJson.append("]");

        return "{\n" +
                "\"mobile\":\"" + smsRequestDTO.getMobile() + "\",\n" +
                "\"templateId\":\"" + smsRequestDTO.getTemplateId() + "\",\n" +
                "\"parameters\":" + parametersJson.toString() + "\n" +
                "}";
    }

    @Override
    protected String sendHttpRequest(String jsonBody) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonBody);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "text/plain")
                .addHeader("x-api-key", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body() != null ? response.body().string() : null;
        }
    }

    @Override
    protected String processResponse(String response) {
        return response;
    }
}
