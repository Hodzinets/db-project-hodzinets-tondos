package com.db.app.mapper;

import com.db.app.database.model.Territory;
import com.db.app.model.response.TerritoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TerritoryMapper {
    @Autowired
    RegionMapper regionMapper;

    public TerritoryResponse toTerritoryResponse(Territory territory) {
        return TerritoryResponse.builder()
                .id(territory.getId())
                .territoryDescription(territory.getTerritoryDescription())
                .region(regionMapper.toRegionResponse(territory.getRegion()))
                .build();
    }
}
