package com.example.fanshopV2.controllers.StripeController;

import com.example.fanshopV2.entitys.stripeEntitys.Request;
import com.example.fanshopV2.entitys.stripeEntitys.Response;
import com.example.fanshopV2.repositories.stripeRepo.RequestRepo;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentIntentController {

    @Autowired
    private RequestRepo requestRepo;

    @PostMapping("/create-payment-intent")
    public Response createPaymentIntent(@RequestBody Request request)
            throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(request.getAmount() * 100L)
                        .putMetadata("productName",
                                request.getProductName())
                        .setCurrency("usd")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams
                                        .AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();
        PaymentIntent intent = PaymentIntent.create(params);

        requestRepo.save(request);

        return new Response(intent.getId(),
                intent.getClientSecret());
    }

}