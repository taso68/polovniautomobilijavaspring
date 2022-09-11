package com.taso.polovniautomobili.model;


import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import com.taso.polovniautomobili.model.entity.Model;
import com.taso.polovniautomobili.model.entity.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;
    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }


    @GetMapping
    public ResponseEntity<List<Model>> getAllModels(){
        return ResponseEntity.ok(modelService.getAllModels());
    }
    @PostMapping
    public ResponseEntity<Model> saveModel(@RequestBody @Valid RequestModel requestModel) throws AlreadyExistException, NotFoundException {
        return ResponseEntity.ok(modelService.saveModel(requestModel));
    }
    @DeleteMapping(path = "/{modelId}")
    public String deleteModel(@PathVariable Long modelId) throws NotFoundException {
        return modelService.deleteModel(modelId);
    }
}
