/* ***************************************************************************
    Copyright (C) Lowe's Companies, Inc.  All rights reserved.
    This file is for internal use only at Lowe's Companies, Inc.
   ***************************************************************************/

package com.lowes.ezship.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentItemDetails {
    private Integer itemSeqNbr;
    private Integer itemQty;
    private String itemId;
    private String itemIdType;
    private Double itemWeight;
    private Double itemLength;
    private Double itemWidth;
    private Double itemHeight;
    private Collection<ItemAttributes> itemAttributes;


}
