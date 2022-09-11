package com.taso.polovniautomobili.users;

import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import com.taso.polovniautomobili.files.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final FileService fileService;
    @Autowired
    public UserService(UserRepository userRepository, FileService fileService) {
        this.userRepository = userRepository;
        this.fileService = fileService;
    }
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }
    public User getUserById(Long userId) throws NotFoundException {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty())
            throw new NotFoundException("User with id: " + userId + " not found");
        User u = byId.get();
        loadImageUrls(u);
        return u;
    }
    public void loadImageUrls(User user){
        System.out.println("Creating urls....");
        List<String> urls = new ArrayList<>();
        user.getPhotos().forEach(file ->
                        urls.add(fileService.getImageUrlByFile(file))
        );
        user.setUserPhotos(urls);
    }
}
