/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc.
   ***************************************************************************/

package com.lowes.ezship.model.common;

import com.lowes.ezship.model.vendor.VendorServiceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RateShipmentDetails {

    private Double shipmentWeight;
    private Double shipmentLength;
    private Double shipmentWidth;
    private Double shipmentHeight;
    private Double shipmentGirth;
    private Collection<ShipmentItemDetails> shipmentItemDetails;

}
