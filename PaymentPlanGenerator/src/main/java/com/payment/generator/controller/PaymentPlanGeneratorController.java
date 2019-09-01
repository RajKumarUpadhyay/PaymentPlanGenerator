package com.payment.generator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payment.generator.model.Request;
import com.payment.generator.model.Response;
import com.payment.generator.service.PaymentPlanGeneratorService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "payment-plan-generate")
public class PaymentPlanGeneratorController {

    @Autowired
    private PaymentPlanGeneratorService paymentPlanGeneratorService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    @ApiOperation(value = "This method accept parameters as in RequestBody")
    public List<Response> generatePaymentPlan(@RequestBody final Request request) {
        return paymentPlanGeneratorService.generatePaymentPlan(request);
    }
}