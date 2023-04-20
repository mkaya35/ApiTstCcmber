/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc.
   ***************************************************************************/

package com.lowes.ezship.model.vendor;

import com.lowes.ezship.model.common.Address;
import com.lowes.ezship.model.common.EligibleCarrierService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorServiceResponse {
    private Address vendorAddress;

    private Address originAddress;

    private Collection<EligibleCarrierService> carrierCodeServices;

    private Double shipmentGirth;
}
