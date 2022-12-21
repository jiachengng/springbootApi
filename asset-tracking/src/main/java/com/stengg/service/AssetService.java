package com.stengg.service;

import com.stengg.model.Asset;
import com.stengg.repository.AssetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService implements IAssetService {

    @Autowired
    private AssetRepository repository;

    @Override
    public List<Asset> getAllAssets() {

        var assets = (List<Asset>) repository.findAll();

        return assets;
    }
    @Override
    public List<Asset> getAllAssets2(){ 
        // List<Asset> assets = new ArrayList<>(); 
        // repository.findAll().forEach(assets::add); 
        return (List<Asset>)repository.findAll();
        // return assets; 
    }

    @Override
    public Asset getAsset(Long id) {
        Optional<Asset> optional = repository.findById(id);
        Asset asset = optional.get();
        return asset;
    }
    @Override
    public Asset createAsset(Asset asset) {
        return repository.save(asset);
    }
    @Override
    public void deleteAsset(Long id) {
        repository.deleteById(id);
        
    }
    @Override
    public void updateAsset(Asset asset) {
        repository.save(asset);
    }
    @Override
    public long countAsset() {
        return repository.count();
    }

    // public List<Asset> getAsset(final String assetIdString) {
        
    //     var assets = (List<Asset>) repository.findAllById(assetIdString);
    // }
}
