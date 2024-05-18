package com.etiyacrm.customerservice.core.business.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageInfo {
    private int page = 0;
    private int size = 10;
}