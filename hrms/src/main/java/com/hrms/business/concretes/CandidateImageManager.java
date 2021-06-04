package com.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.business.abstracts.CandidateImageService;
import com.hrms.core.results.*;
import com.hrms.core.utilities.imageService.ImageService;
import com.hrms.dataAccess.abstracts.CandidateImageDao;
import com.hrms.entities.concretes.CandidateImage;

@Service
public class CandidateImageManager implements CandidateImageService {

    private CandidateImageDao candidateImageDao;
    private ImageService imageService;

    @Autowired
    public CandidateImageManager(CandidateImageDao candidateImageDao,ImageService imageService) {
        this.candidateImageDao = candidateImageDao;
        this.imageService = imageService;
    }

    @Override
    public Result add(CandidateImage candidateImage) {
        this.candidateImageDao.save(candidateImage);
        return new SuccessResult();
    }

    @Override
    public Result add(CandidateImage candidateImage, MultipartFile file) {
        @SuppressWarnings("unchecked")
		Map<String,String> result = (Map<String,String>)imageService.save(file).getData();
        String url = result.get("url");
        candidateImage.setUrl(url);
        candidateImage.setUploadedAt(LocalDate.now());
        return add(candidateImage);
    }

    @Override
    public DataResult<List<CandidateImage>> getAll() {
        return new SuccessDataResult<>(this.candidateImageDao.findAll());
    }

    @Override
    public DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateImageDao.getAllByCandidateId(candidateId));
    }
}