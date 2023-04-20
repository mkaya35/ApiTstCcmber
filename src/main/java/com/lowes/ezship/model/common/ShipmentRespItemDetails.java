package com.lowes.ezship.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentRespItemDetails {
    private int itemSeqNbr;
    private int itemQty;
    private String itemId;
    private String itemIdType;

}
