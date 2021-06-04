package com.hrms.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.core.utilities.imageService.ImageService;
import com.hrms.core.utilities.imageService.cloudinary.CloudinaryImageManager;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }


    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "mediaapijava",
                "api_key", "366157844667416",
                "api_secret", "yi5qOcdFqVYQgGGQFBnovBJ_f_s"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}