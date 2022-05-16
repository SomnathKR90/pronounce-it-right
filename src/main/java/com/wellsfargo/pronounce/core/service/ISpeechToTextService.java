package com.wellsfargo.pronounce.core.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;

public interface ISpeechToTextService {
  
  public String speechToText(InputStream dataStream); 

}