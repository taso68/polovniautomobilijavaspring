package com.taso.polovniautomobili.body;

import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/bodies")
@NoArgsConstructor
public class BodyController {
    @Autowired
    private BodyService bodyService;


    @GetMapping
    public ResponseEntity<List<Body>> allBodies(){
        return ResponseEntity.ok(bodyService.findAllBodies());
    }
    @GetMapping("/{bodyId}")
    public ResponseEntity<Body> bodyById(@PathVariable long bodyId) throws NotFoundException {
        return ResponseEntity.ok(bodyService.getBodyById(bodyId));
    }
    @PostMapping
    public ResponseEntity<Body> addBody(@RequestBody @Valid Body bodyResponse) throws AlreadyExistException {
        return ResponseEntity.ok(bodyService.addBody(bodyResponse));
    }
    @PutMapping("{bodyId}")
    public ResponseEntity<Body> updateBody(@PathVariable long bodyId,
                                           @RequestBody @NotNull @Valid Body bodyRequest) throws NotFoundException {
        return ResponseEntity.ok(bodyService.updateBody(bodyId, bodyRequest));
    }
}
