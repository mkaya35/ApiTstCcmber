/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc.
   ***************************************************************************/

package com.lowes.ezship.model.geography;
import com.lowes.ezship.model.common.DestinationDetails;
import com.lowes.ezship.model.common.EligibleCarrierService;
import com.lowes.ezship.model.common.OriginDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeographyRequest {

    private String shipmentNumber;
    private String transferOrderNumber;
    private String purchaseOrderNumber;
    private String salesOrderNumber;
    private String fulfillmentMethod;
    private String shopKey;
    private String shipDate;
    private DestinationDetails destinationDetails;
    private OriginDetails originDetails;
    private Collection<EligibleCarrierService> carrierCodeServices;

}
