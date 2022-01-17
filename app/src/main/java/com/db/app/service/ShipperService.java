package com.db.app.service;

import com.db.app.model.response.ShipperResponse;

import java.util.List;

public interface ShipperService {
    List<ShipperResponse> getAll();
}
