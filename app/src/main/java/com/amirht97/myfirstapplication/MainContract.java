package com.amirht97.myfirstapplication;

import com.amirht97.myfirstapplication.model.AllTodoDetails;

public interface MainContract {
    interface View{
        void showTodo(AllTodoDetails todoDetails);
    }
    interface Presenter{
        void onAttach(View view);
        void onDetach();
        void getObserver();
    }
}
