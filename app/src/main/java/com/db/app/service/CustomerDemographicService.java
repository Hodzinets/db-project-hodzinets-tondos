package com.db.app.service;

import com.db.app.model.response.CustomerDemographicResponse;

import java.util.List;

public interface CustomerDemographicService {
    List<CustomerDemographicResponse> getAll();
}
