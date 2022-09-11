package com.taso.polovniautomobili.mark;

import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarkController {

    private final MarkService markService;
    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }


    @GetMapping
    public ResponseEntity<List<Mark>> allMarks(){
        return ResponseEntity.ok(markService.findAll());
    }

    @GetMapping(path = "/{markId}")
    public ResponseEntity<Mark> findMarkById(@PathVariable Long markId) throws NotFoundException {
        return ResponseEntity.ok(markService.findMarkById(markId));
    }

    @PostMapping
    public ResponseEntity<Mark> saveMark(@RequestBody @Valid Mark mark) throws AlreadyExistException {
        return ResponseEntity.ok(markService.saveMark(mark));
    }
    @PutMapping(path = "/{markId}")
    public ResponseEntity<Mark> updateMark(@PathVariable Long markId, @RequestBody @NotNull Mark mark) throws NotFoundException, AlreadyExistException {
        return ResponseEntity.ok(markService.updateMark(markId,mark));
    }
    @DeleteMapping(path = "/{markId}")
    public ResponseEntity<String> deleteMark(@PathVariable Long markId) throws NotFoundException {
        return ResponseEntity.ok(markService.deleteMark(markId));
    }

}
