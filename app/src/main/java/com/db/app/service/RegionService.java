package com.db.app.service;

import com.db.app.model.response.RegionResponse;

import java.util.List;

public interface RegionService {
    List<RegionResponse> getAll();
}
