package com.taxi.framework.sms.service;

import com.taxi.framework.sms.dto.ParameterDto;
import com.taxi.framework.sms.dto.SmsRequestDto;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SmsService {

    private static final String API_URL = "https://api.sms.ir/v1/send/verify";
    private static final String API_KEY = "YOURAPIKEY";

    public void sendSms(SmsRequestDto smsRequestDto) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        StringBuilder parametersJson = new StringBuilder("[");
        for (ParameterDto param : smsRequestDto.getParameters()) {
            parametersJson.append(String.format("{\"name\":\"%s\",\"value\":\"%s\"},", param.getName(), param.getValue()));
        }
        if (parametersJson.length() > 1) {
            parametersJson.deleteCharAt(parametersJson.length() - 1); // Remove last comma
        }
        parametersJson.append("]");

        String jsonBody = String.format("{\n  \"mobile\": \"%s\",\n  \"templateId\": %d,\n  \"parameters\": %s\n}",
                smsRequestDto.getMobile(), smsRequestDto.getTemplateId(), parametersJson);

        RequestBody body = RequestBody.create(mediaType, jsonBody);

        Request request = new Request.Builder()
                .url(API_URL)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "text/plain")
                .addHeader("x-api-key", API_KEY)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
