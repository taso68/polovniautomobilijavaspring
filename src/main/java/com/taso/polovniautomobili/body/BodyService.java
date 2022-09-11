package com.taso.polovniautomobili.body;

import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyService {

    @Autowired
    private final BodyRepositrory bodyRepositrory;

    public BodyService(BodyRepositrory bodyRepositrory) {
        this.bodyRepositrory = bodyRepositrory;
    }

    public List<Body> findAllBodies() {
        return bodyRepositrory.findAllByOrderByName();
    }
    public Body getBodyById(long bodyId) throws NotFoundException {
        Optional<Body> bodyById = bodyRepositrory.findById(bodyId);
        if(bodyById.isEmpty()) throw new NotFoundException("Body with id: "+ bodyId +" not found");
        return bodyById.get();

    }

    public Body addBody(@NotNull Body bodyResponse) throws AlreadyExistException {
        Optional<Body> byName = bodyRepositrory.findByName(bodyResponse.getName());
        if(byName.isPresent())
            throw new AlreadyExistException("Body with name "+ bodyResponse.getName() + " already exist");
        return bodyRepositrory.save(bodyResponse);
    }


    public Body updateBody(long bodyId, Body bodyRequest) throws NotFoundException {
        Optional<Body> bodyById = bodyRepositrory.findById(bodyId);
        if (bodyById.isEmpty())
            throw new NotFoundException("Body with id: "+ bodyId + " already exist");
        Body body = bodyById.get();
        body.setName(bodyRequest.getName());

        return bodyRepositrory.save(body);
    }
}
