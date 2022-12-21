package com.stengg.controller;

import com.stengg.model.Asset;
import com.stengg.repository.AssetRepository;
import com.stengg.service.IAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private IAssetService assetService;

    @GetMapping("/getAllAssets")
    public String findAssets(Model model) {

        var assets = (List<Asset>) assetService.getAllAssets2();

        model.addAttribute("assets", assets);

        return "showAssets";
    }

    @GetMapping("/getAllAssets2") 
    public ResponseEntity<Object> getAllAssets(){ 
      return new ResponseEntity<>(assetService.getAllAssets2(), HttpStatus.OK);
    }

    @GetMapping("/getAsset/{id}") 
    public ResponseEntity<Object> getAsset(@PathVariable("id") long id){ 
      Asset asset = assetService.getAsset(id);
      return new ResponseEntity<>(asset, HttpStatus.OK);
    }

    @PostMapping("/createAsset")
    public ResponseEntity<Object> createAsset(@RequestBody Asset asset){ 
      asset = assetService.createAsset(asset);
      return new ResponseEntity<>("Asset is created successfully with id = " + asset.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAsset/{id}")
    public ResponseEntity<Object> deleteAsset(@PathVariable("id") long id){ 
      assetService.deleteAsset(id);
      return new ResponseEntity<>("Asset is deleted successfully with id = " + id, HttpStatus.OK);
    }

    @PutMapping("/updateAsset/{id}")
    public ResponseEntity<Object> updateAsset(@PathVariable("id") long id, @RequestBody Asset asset){ 
      asset.setId(id);
      assetService.updateAsset(asset);
      return new ResponseEntity<>("Asset is updated successfully", HttpStatus.OK);
    }

    @GetMapping("/getCount") 
    public ResponseEntity<Object> getCount(){ 
      return new ResponseEntity<>("Total number of asset(s): " + assetService.countAsset(), HttpStatus.OK);
    }

    // @GetMapping("/getAssetById")
    // public String findAssetsById(Model model) {
    //     long id = 1;
    //     var assets = (Optional<Asset>) assetService.findById(id);

    //     model.addAttribute("assets", assets);

    //     return "showAssets";
    // }
    
}
