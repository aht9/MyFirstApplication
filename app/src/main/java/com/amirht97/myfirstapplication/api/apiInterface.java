package com.amirht97.myfirstapplication.api;

import com.amirht97.myfirstapplication.model.AllTodoDetails;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface apiInterface {
    @GET("/test-api.php")
    Observable<AllTodoDetails> getAllTodo();
}
