package com.ayo4u.assessment.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

import com.ayo4u.assessment.service.convertor.utility.Convertor;

@Service
@Slf4j
public class WeightService implements Convertor {

    @Override
    public double convertToMetric(final double fromValue) {
        return Precision.round(fromValue / 2.205, 2);
    }

    @Override
    public double convertToImperial(final double fromValue) {
        return Precision.round(fromValue * 2.205, 2);
    }
}
