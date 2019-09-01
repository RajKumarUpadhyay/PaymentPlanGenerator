package com.payment.generator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payment.generator.model.Request;
import com.payment.generator.model.Response;
import com.payment.generator.utils.PaymentUtils;

@Service
public class PaymentPlanGeneratorService {

    public List<Response> generatePaymentPlan(final Request request) {
        request.validate();
        final List<PaymentUtils> paymentPerMonthList = generatePaymentPlanList(request);
        return generateResponseList(paymentPerMonthList);
    }

    private List<PaymentUtils> generatePaymentPlanList(final Request request) {

        final List<PaymentUtils> paymentPerMonthList = new ArrayList<>();
        paymentPerMonthList.add(firstMonth(request));
        paymentPerMonthList.addAll(remainingMonths(request, paymentPerMonthList.get(0)));
        return paymentPerMonthList;
    }

    private List<PaymentUtils> remainingMonths(final Request request, PaymentUtils previousPaymentPerMonth) {

        final List<PaymentUtils> paymentPerMonthList = new ArrayList<>();

        for (int counter = 1; counter < request.getDuration(); counter++) {
            previousPaymentPerMonth = new PaymentUtils(request, previousPaymentPerMonth, counter);
            paymentPerMonthList.add(previousPaymentPerMonth);
        }

        return paymentPerMonthList;
    }

    private PaymentUtils firstMonth(final Request request) {
        return new PaymentUtils(request);
    }

    private List<Response> generateResponseList(final List<PaymentUtils> paymentPerMonthList) {

        final List<Response> responseList = new ArrayList<>();

        for (final PaymentUtils paymentPerMonth : paymentPerMonthList) {
            final Response response = new Response(paymentPerMonth);
            responseList.add(response);
        }

        return responseList;
    }
}
