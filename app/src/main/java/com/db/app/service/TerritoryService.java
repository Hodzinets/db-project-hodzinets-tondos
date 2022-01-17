package com.db.app.service;

import com.db.app.model.response.TerritoryResponse;

import java.util.List;

public interface TerritoryService {
    List<TerritoryResponse> getAll();
}
