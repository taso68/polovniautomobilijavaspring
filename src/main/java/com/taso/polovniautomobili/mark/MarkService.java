package com.taso.polovniautomobili.mark;

import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    private final MarkRepository markRepository;
    @Autowired
    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public Mark saveMark(Mark mark) throws AlreadyExistException {
        if(markRepository.findByName(mark.getName()).isPresent())
            throw new AlreadyExistException("Mark with name: "+mark.getName()+" already exist");
        Mark savedMark = markRepository.save(mark);
        return savedMark;
    }

    public List<Mark> findAll() {
        List<Mark> all = markRepository.findAllByOrderByName();
        return all;
    }

    public Mark findMarkById(Long markId) throws NotFoundException {
        return markRepository.findById(markId).orElseThrow(
                () -> new NotFoundException("Mark with id:" +markId+" not found")
        );
    }

    public Mark updateMark(Long markId, Mark mark) throws NotFoundException, AlreadyExistException {
        Optional<Mark> byId = markRepository.findById(markId);
        if(byId.isEmpty())
            throw new NotFoundException("Mark with id:" +markId+" not found");
        if(markRepository.getByName(mark.getName()).isPresent())
            throw new AlreadyExistException("Mark with name: "+mark.getName()+" already exist");
        Mark updatedMark = byId.get();
        if(mark.getName() != null) updatedMark.setName(mark.getName());
        return markRepository.save(updatedMark);
    }

    public String deleteMark(Long markId) throws NotFoundException {
        Optional<Mark> byId = markRepository.findById(markId);
        if(byId.isEmpty())
            throw new NotFoundException("Mark with id: " +markId+" not found");
        markRepository.delete(byId.get());
        return "Mark with " + byId.get().getName() + " is successfully deleted";
    }
}
