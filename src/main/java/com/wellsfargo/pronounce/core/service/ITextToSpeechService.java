package com.wellsfargo.pronounce.core.service;

public interface ITextToSpeechService {

    Object getVoiceOutput(String inputText);
    
    String getAccessToken();

}