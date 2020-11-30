package com.hzp.storage.mapper;

import com.hzp.storage.entity.Storage;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageMapper {

    int decreaseStorage(Storage storage);
}
