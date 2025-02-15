package com.bytenest.InventoryApi.controllers;

import com.bytenest.InventoryApi.models.dtos.PartRecordDto;
import com.bytenest.InventoryApi.models.entities.PartModel;
import com.bytenest.InventoryApi.repositories.PartRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class PartController {

    @Autowired
    PartRepository partRepository;


    @PostMapping("/parts")
    public ResponseEntity<PartModel> saveProduct(@RequestBody @Valid PartRecordDto partRecordDto){
        var partModel = new PartModel();
        BeanUtils.copyProperties(partRecordDto, partModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(partRepository.save(partModel));
    }


    @GetMapping("/parts")
    public ResponseEntity<List<PartModel>> getAllParts(){
        return ResponseEntity.status(HttpStatus.OK).body(partRepository.findAll());
    }


    @GetMapping("/parts/{id}")
    public ResponseEntity<Object> getOnePart(@PathVariable(value = "id")UUID id){
        Optional<PartModel> part0 = partRepository.findById(id);
        return part0.<ResponseEntity<Object>>
                map(partModel -> ResponseEntity.status(HttpStatus.OK).body(partModel))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Part not found"));

    }


    @GetMapping("/codeSku/{codeSku}")
    public ResponseEntity<Object> getOnePartByCodeSku(@PathVariable(value = "codeSku")String codeSku){
        Optional<PartModel> part0 = partRepository.findByCodeSku(codeSku);
        return part0.<ResponseEntity<Object>>
                map(partModel -> ResponseEntity.status(HttpStatus.OK).body(partModel))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Part not found"));

    }


    @PutMapping("/parts/{id}")
    public ResponseEntity<Object> updatePart(@PathVariable(value = "id")UUID id,
                                             @RequestBody @Valid PartRecordDto partRecordDto){
        Optional<PartModel> part0 = partRepository.findById(id);
        if(part0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Part not found");
        }
        var partModel = part0.get();
        BeanUtils.copyProperties(partRecordDto, partModel);
        return ResponseEntity.status(HttpStatus.OK).body(partRepository.save(partModel));
    }


    @DeleteMapping("/parts/{id}")
    public ResponseEntity<Object> deletePart(@PathVariable(value = "id")UUID id){
        Optional<PartModel> part0 = partRepository.findById(id);
        if(part0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Part not found");
        }
        partRepository.delete(part0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Part deleted successfully");
    }

}
