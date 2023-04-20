/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc.
   ***************************************************************************/

package com.lowes.ezship.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentRespDetails {
    private Double shipmentWeight;
    private Double shipmentLength;
    private Double shipmentWidth;
    private Double shipmentHeight;

    // Below JsonProperty is to overwrite the attribute name in the response to match with contract. Do not remove it.
    @JsonProperty("shipmentItemDetails")
    private Collection<ShipmentRespItemDetails> shipmentRespItemDetails;
}
