package com.stengg.service;

import com.stengg.model.Asset;

import java.util.List;
import java.util.Optional;

public interface IAssetService {

    List<Asset> getAllAssets();

    List<Asset> getAllAssets2();

    Asset getAsset(Long id);

    Asset createAsset(Asset asset);

    void deleteAsset(Long id);

    void updateAsset(Asset asset);

    long countAsset();

}
