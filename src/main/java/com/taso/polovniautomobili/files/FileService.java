package com.taso.polovniautomobili.files;

import com.taso.polovniautomobili.exceptions.custom.BadRequestException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import com.taso.polovniautomobili.users.User;
import com.taso.polovniautomobili.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    private final FileRepository fileRepository;
    private final UserService userService;

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    public FileService(FileRepository fileRepository,@Lazy UserService userService) {
        this.fileRepository = fileRepository;
        this.userService = userService;
    }

    public File saveFile(MultipartFile multipartFile, Long ads_id, Long usr_id) throws IOException, NotFoundException {
        if(ads_id == null && usr_id == null)
            throw new BadRequestException("Image must have reference to entity");
        if(ads_id != null && usr_id != null)
            throw new BadRequestException("Image must have only one reference to entity");
        User user = new User();
        if(usr_id != null){
            user = userService.getUserById(usr_id);
        }

        File f = new File(
                multipartFile.getOriginalFilename(),
                multipartFile.getBytes(),
                multipartFile.getSize(),
                multipartFile.getContentType(),
                ads_id,
                user
        );

        return fileRepository.save(f);
    }

    public File getFileById(Long filId) throws NotFoundException {
        Optional<File> byId = fileRepository.findById(filId);
        System.out.println(byId);
        if(byId.isEmpty()) throw new NotFoundException("File with id: "+filId+" not found");
        return byId.get();
    }

    public String getImageUrlById(Long filId) throws NotFoundException {
        Optional<File> byId = fileRepository.findById(filId);
        if(byId.isEmpty()) throw new NotFoundException("File with id: "+filId+" not found");
        return "http://localhost:8082/files/"+String.valueOf(byId.get().getId());

    }

    public List<String> urlsForAds(Long id){
        List<Long> ids = fileRepository.findAllIdsAds(id);
        List<String> urls = new ArrayList<>();
        for(int i = 0; i < ids.size(); i++){
            urls.add("http://localhost:"+serverPort+"/files/" + String.valueOf(id));
        }
        return urls;
    }

}
