package com.amirht97.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.amirht97.myfirstapplication.adapter.RcTodoListAdapter;
import com.amirht97.myfirstapplication.model.AllTodoDetails;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    MainContract.Presenter mainPresenter = new MainPresenter();

    RecyclerView.Adapter adapter;

    @BindView(R.id.rc_Show_Todo)
    RecyclerView recyclerView;

    @BindView(R.id.txt_title)
    TextView txt_title;


    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        txt_title.setText("My Api Application");

        mainPresenter.onAttach(this);
        initRecyclerView_ShowTodo();
        mainPresenter.getObserver();

    }

    private void initRecyclerView_ShowTodo() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void showTodo(AllTodoDetails todoDetails) {
        adapter = new RcTodoListAdapter(MainActivity.this, todoDetails.getResults());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDetach();
    }
}