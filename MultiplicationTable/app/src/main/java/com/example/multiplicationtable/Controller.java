package com.example.multiplicationtable;

public class Controller {
    Model model = new Normal();
    MainActivity view;
    public Controller(MainActivity activity){
        view = activity;
    }

    public void normal() {
        model = new Normal();
        model.ranInt();

        // new numbers
        view.displayNums(model.getNum1(), model.getNum2());
    }
    public void upTo20(){
        model = new UpTo20();
        model.ranInt();
        view.displayNums(model.getNum1(), model.getNum2());
    }
    public void challange(){
        model = new Challenge();
        model.ranInt();
        view.displayNums(model.getNum1(), model.getNum2());
    }
    public void checkAns(int ans){
        // ask model
        if(model.checkAns(ans)){
            model.ranInt();
            view.displayNums(model.getNum1(),model.getNum2());
            view.displayVictory();
        } else {
            view.displayFailure();
        }
        // if correct - generate new numbers, and display them
    }
}
