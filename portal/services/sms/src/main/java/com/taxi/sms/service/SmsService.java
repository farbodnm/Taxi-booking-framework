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
public class SmsService extends AbstractSmsService<SmsRequestDTO, String> {
    private final OkHttpClient client;
    private final String apiUrl;
    private final String apiKey;

    public SmsService(
            @Value("${sms.api.url}") String apiUrl,
            @Value("${sms.api.key}") String apiKey) {
        super(apiUrl, apiKey);
        this.client = new OkHttpClient();
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    @Override
    public String sendSms(SmsRequestDTO smsRequest) throws IOException {
        Gson gson = new Gson();
        String requestBodyJson = gson.toJson(smsRequest);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(requestBodyJson, mediaType);

        Request request = new Request.Builder()
                .url(apiUrl)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "text/plain")
                .addHeader("x-api-key", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
