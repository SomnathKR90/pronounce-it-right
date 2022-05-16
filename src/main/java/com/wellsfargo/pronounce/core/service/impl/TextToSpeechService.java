package com.wellsfargo.pronounce.core.service.impl;

import java.util.Locale;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import com.wellsfargo.pronounce.core.service.ITextToSpeechService;

@Service
public class TextToSpeechService implements ITextToSpeechService {

  final String uri = "https://eastus.api.cognitive.microsoft.com/sts/v1.0/issueToken";
  
  final String speechUri = "https://eastus.tts.speech.microsoft.com/cognitiveservices/v1";

    @Override
    public Object getVoiceOutput(String inputText) {
        
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        // TODO - Add it as a property and use it
        headers.add("Ocp-Apim-Subscription-Key", "fa51b3880f7f420186edf5028e01603c");
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        String token = restTemplate.exchange(uri,HttpMethod.POST,entity,String.class).getBody();


        HttpHeaders headersForSpeech=new HttpHeaders();
        headersForSpeech.setBearerAuth(token);
        headersForSpeech.add("Content-Type", "application/ssml+xml");
        headersForSpeech.add("X-Microsoft-OutputFormat", "audio-16khz-32kbitrate-mono-mp3");
        HttpEntity<String> entityForSpeech=new HttpEntity<String>("<speak version='1.0' xml:lang='en-US'><voice xml:lang='en-US' xml:gender='Male' name='en-US-ChristopherNeural'>" + inputText + "</voice></speak>", headersForSpeech);
        
        return restTemplate.exchange(speechUri,HttpMethod.POST,entityForSpeech,String.class);
    }
    
    @Override
    public String getAccessToken() {
        
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.add("Ocp-Apim-Subscription-Key", "fa51b3880f7f420186edf5028e01603c");
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        return restTemplate.exchange(uri,HttpMethod.POST,entity,String.class).getBody();
      }  
        

}