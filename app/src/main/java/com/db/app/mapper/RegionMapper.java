package com.db.app.mapper;

import com.db.app.database.model.Region;
import com.db.app.model.response.RegionResponse;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {
    public RegionResponse toRegionResponse(Region region) {
        return RegionResponse.builder()
                .id(region.getId())
                .regionDescription(region.getRegionDescription())
                .build();
    }
}
