package com.db.app.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TerritoryResponse {
    private Long id;
    private String territoryDescription;
    private RegionResponse region;
}
