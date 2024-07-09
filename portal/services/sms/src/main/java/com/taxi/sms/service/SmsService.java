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

/**
 * Service for sending SMS messages using a specified SMS gateway.
 * This class extends AbstractSmsService and uses OkHttpClient to send HTTP requests to the SMS API.
 *
 * @see AbstractSmsService
 */
@Service
public class SmsService extends AbstractSmsService {

    /**
     * The OkHttpClient used for making HTTP requests.
     */
    private final OkHttpClient client;

    /**
     * The URL of the SMS API endpoint.
     */
    private final String apiUrl;

    /**
     * The API key used for authentication with the SMS API.
     */
    private final String apiKey;

    /**
     * Constructs a new SmsService with the specified API URL and API key.
     *
     * @param apiUrl the URL of the SMS API endpoint
     * @param apiKey the API key used for authentication with the SMS API
     */
    public SmsService(
            @Value("${sms.api.url}") String apiUrl,
            @Value("${sms.api.key}") String apiKey) {
        super(apiUrl, apiKey);
        this.client = new OkHttpClient();
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    /**
     * Sends an SMS message based on the provided SMS request DTO.
     *
     * @param smsRequest the SMS request DTO containing the message details
     * @return a string containing the result of the SMS send operation
     * @throws IOException if an I/O error occurs during the SMS send operation
     */
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
