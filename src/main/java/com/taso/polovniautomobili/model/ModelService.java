package com.taso.polovniautomobili.model;

import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import com.taso.polovniautomobili.mark.MarkService;
import com.taso.polovniautomobili.model.entity.Model;
import com.taso.polovniautomobili.model.entity.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    private final MarkService markService;
    @Autowired
    public ModelService(ModelRepository modelRepository,@Lazy MarkService markService) {
        this.modelRepository = modelRepository;
        this.markService = markService;
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model saveModel(RequestModel requestModel) throws AlreadyExistException, NotFoundException {
        if(modelRepository.findByName(requestModel.getName()).isPresent())
            throw new AlreadyExistException("Model with name: " + requestModel.getName() + " already exist");
        Model model = new Model(requestModel.getName(), markService.findMarkById(requestModel.getMarkId()));
        return modelRepository.save(model);

    }

    public String deleteModel(Long modelId) throws NotFoundException {
        Optional<Model> model = modelRepository.findById(modelId);
        modelRepository.delete(model.orElseThrow(() ->
                new NotFoundException("Model with id: "+modelId+" not found")));
        return "Model with id: "+modelId+" deleted";
    }
}
