/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc.
   ***************************************************************************/

package com.lowes.ezship.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarrierServiceCharge {
    private String carrierCode;
    private String carrierService;
    private double baseRate;
    private double assessorialFees;
    private double estFreightCost;
}
