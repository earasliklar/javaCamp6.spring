package com.hrms.core.utilities.imageService.cloudinary;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.core.results.DataResult;
import com.hrms.core.results.ErrorDataResult;
import com.hrms.core.results.SuccessDataResult;
import com.hrms.core.utilities.imageService.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public class CloudinaryImageManager implements ImageService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryImageManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public DataResult<Map> save(MultipartFile file) {
        try {
            @SuppressWarnings("unchecked")
			Map<String, String> uploadResult = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            ;
            return new SuccessDataResult<Map>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }
}