package com.wellsfargo.pronounce.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.InputStream;

import com.wellsfargo.pronounce.core.service.ISpeechToTextService;

@CrossOrigin
@RestController
@RequestMapping("speech-to-text")
public class SpeechToTextController {

    @Autowired
    private ISpeechToTextService speechToTextService;

    @PostMapping
    public String acceptData(InputStream dataStream) throws Exception {
      return speechToTextService.speechToText(dataStream);
    }

}