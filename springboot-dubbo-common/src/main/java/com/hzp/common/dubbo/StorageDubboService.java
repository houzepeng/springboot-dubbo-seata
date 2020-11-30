package com.hzp.common.dubbo;

import com.hzp.common.dto.StorageDTO;

public interface StorageDubboService {

    int decreaseStorage(StorageDTO storage);
}
