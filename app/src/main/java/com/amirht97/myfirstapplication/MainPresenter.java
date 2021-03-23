package com.amirht97.myfirstapplication;

import android.util.Log;

import com.amirht97.myfirstapplication.api.apiClient;
import com.amirht97.myfirstapplication.api.apiInterface;
import com.amirht97.myfirstapplication.model.AllTodoDetails;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainPresenter implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";

    private MainContract.View view;

    @Override
    public void onAttach(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view=null;
    }

    @Override
    public void getObserver() {
        getObservable().subscribeWith(getObserverTodo());
    }

    public Observable<AllTodoDetails> getObservable(){
        return apiClient.getRetrofit().create(apiInterface.class)
                .getAllTodo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<AllTodoDetails> getObserverTodo(){
        return new DisposableObserver<AllTodoDetails>() {

            @Override
            public void onNext(@NonNull AllTodoDetails movieResponse) {
                Log.d(TAG,"OnNext : "+movieResponse.getResults());
                view.showTodo(movieResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }

}
