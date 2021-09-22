package finki.emt.videomanagement.domain.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import finki.emt.videomanagement.domain.exceptions.StorageFileNotFoundException;
import finki.emt.videomanagement.domain.models.VideoId;
import finki.emt.videomanagement.domain.service.StorageProperties;
import finki.emt.videomanagement.domain.service.StorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class StorageServiceImpl implements StorageService {
    private final Path rootLocation;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public String store(MultipartFile file, String name) throws IOException {
        try {

            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(VideoId.randomId(VideoId.class).getId()+"."+ FilenameUtils.getExtension(file.getOriginalFilename())))
                    .normalize().toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
                return destinationFile.toString();
            }
        } finally {

        }

    }


    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }


    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
