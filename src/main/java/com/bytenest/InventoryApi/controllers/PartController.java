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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PartController {

    @Autowired
    PartRepository partRepository;


    @PostMapping("/parts")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid PartRecordDto partRecordDto) {
        try {
            var partModel = new PartModel();
            BeanUtils.copyProperties(partRecordDto, partModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(partRepository.save(partModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar a peça: " + e.getMessage());
        }
    }



    @GetMapping("/parts")
    public ResponseEntity<List<PartModel>> getAllParts(){
        List<PartModel> partsList = partRepository.findAll();
        if(!partsList.isEmpty()){
            for(PartModel p: partsList){
                UUID id = p.getIdPart();
                p.add(linkTo(methodOn(PartController.class).getOnePart(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(partsList);
    }


    @GetMapping("/parts/{id}")
    public ResponseEntity<Object> getOnePart(@PathVariable(value = "id")UUID id){
        Optional<PartModel> part0 = partRepository.findById(id);

        part0.get().add(linkTo(methodOn(PartController.class).getAllParts()).withRel("Parts list"));
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
