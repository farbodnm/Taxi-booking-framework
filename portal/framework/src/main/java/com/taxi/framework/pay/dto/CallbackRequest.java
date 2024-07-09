package com.taxi.framework.pay.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CallbackRequest {
    // Define the fields for callback request
    private String transactionId;
    private String status;



}
