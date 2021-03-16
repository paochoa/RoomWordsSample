package com.example.roomwordssample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

//nunca pasar contexto a instancias de ViewModel
//No almacenar instancias de Activity, Fragment o View o su contexto en un ViewModel

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    //esta variable sercirá para cachear la lista de palabras
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void deleteWord(Word word) {
        mRepository.deleteWord(word);
    }
}
