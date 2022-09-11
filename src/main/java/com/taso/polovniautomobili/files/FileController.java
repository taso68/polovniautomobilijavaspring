package com.taso.polovniautomobili.files;

import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<File> saveFile(@RequestParam("file") MultipartFile multipartFile,
                                         @Nullable @RequestParam(value = "ads_id", required = false) Long ads_id,
                                         @Nullable @RequestParam(value = "usr_id", required = false) Long usr_id) throws IOException, NotFoundException {
        return ResponseEntity.ok(fileService.saveFile(multipartFile, ads_id, usr_id));
    }
    @GetMapping(value = "/{filId}")
    public ResponseEntity<byte[]> getFileByid(@PathVariable Long filId) throws NotFoundException {
        File file = fileService.getFileById(filId);
        byte[] image = file.getData();
        System.out.println(file);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .body(image);
    }
}