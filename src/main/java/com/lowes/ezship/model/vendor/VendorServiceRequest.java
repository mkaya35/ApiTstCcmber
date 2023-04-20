/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc.
   ***************************************************************************/

package com.lowes.ezship.model.vendor;
import com.lowes.ezship.model.common.DestinationDetails;
import com.lowes.ezship.model.common.ShipmentDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorServiceRequest {

    private String vendorId;

    private String sourceSystemName;

    private String shipDate;

    private String deliveryByDate;

    private String shopKey;

    private String serviceLevel;

    private Boolean isTransferOrder;

    private String shipmentNumber;

    private String transferOrderNumber;

    private String purchaseOrderNumber;

    private String salesOrderNumber;

    private ShipmentDetails shipmentDetails;

    private DestinationDetails destinationDetails;

    private String fulfillmentMethod;

    private String originNodeType;

    private String originLocationId;

}
