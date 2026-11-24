package com.example.multiplicationtable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import androidx.lifecycle.ViewModel;

public class MathViewModel extends ViewModel {
    private Model model;
    private MutableLiveData<Integer> num1 = new MutableLiveData<>();
    private  MutableLiveData<Integer> num2 = new MutableLiveData<>();
    private MutableLiveData<Boolean> answerCorrect = new MutableLiveData<>();
    public MathViewModel(){
        model = new Normal();
        generateQuestion();
    }


    public LiveData<Integer> getNum1(){
        return num1;
    }
    public LiveData<Integer> getNum2(){
        return num2;
    }
    public LiveData<Boolean> getAnswerCorrect(){
        return answerCorrect;
    }

    public void setGameType(GameType gameType){
        switch(gameType) {
            case Normal:
                model = new Normal();
                break;

            case UpTo20:
                model = new UpTo20();
                break;

            case Chellenge:
                model = new Challenge();
                break;
        }
        generateQuestion();
    }

    public void generateQuestion(){
        model.ranInt();

        num1.setValue(model.getNum1());
        num2.setValue(model.getNum2());

        answerCorrect.setValue(null);
    }

    public void checkAns(int ans){
        // ask model
        boolean isCorrect = model.checkAns(ans);

        answerCorrect.setValue(isCorrect);
    }
}
