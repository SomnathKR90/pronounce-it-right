package com.wellsfargo.pronounce.core.service.impl;

import java.util.Locale;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.multipart.MultipartFile;    
import org.springframework.util.MultiValueMap;   
import org.springframework.util.LinkedMultiValueMap; 
import org.springframework.http.MediaType;  
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import java.io.InputStream;

import com.wellsfargo.pronounce.core.service.ISpeechToTextService;

@Service
public class SpeechToTextService implements ISpeechToTextService {

  final String uri = "https://eastus.stt.speech.microsoft.com/speech/recognition/conversation/cognitiveservices/v1?language=en-US&format=simple";
  
  public String speechToText(InputStream dataStream) {
  
  RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.add("Ocp-Apim-Subscription-Key", "fa51b3880f7f420186edf5028e01603c");
        HttpEntity<InputStream> requestEntity = new HttpEntity<>(dataStream, headers);
        return restTemplate.exchange(uri,HttpMethod.POST,requestEntity,String.class).getBody();
        
  }
 

}