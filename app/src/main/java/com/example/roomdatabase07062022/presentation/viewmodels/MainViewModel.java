package com.example.roomdatabase07062022.presentation.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase07062022.data.local.entities.PriorityEntity;
import com.example.roomdatabase07062022.data.local.entities.ToDoEntity;
import com.example.roomdatabase07062022.data.local.entities.TodoAndPriorityEntity;
import com.example.roomdatabase07062022.data.repositories.TodoRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by pphat on 8/18/2022.
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<List<ToDoEntity>> todoListMutable = new MutableLiveData<>();
    private MutableLiveData<List<PriorityEntity>> priorityListMutable = new MutableLiveData<>();
    private MutableLiveData<List<TodoAndPriorityEntity>> todoAndPriorityMutable = new MutableLiveData<>();
    private MutableLiveData<String> message = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Disposable disposeTodo, disposePriority;
    private TodoRepository todoRepository;

    public MainViewModel(Context context) {
        todoRepository = new TodoRepository(context);
    }

    public LiveData<List<ToDoEntity>> getTodoListLiveData() {
        return todoListMutable;
    }

    public LiveData<List<PriorityEntity>> getPriorityEntityListLiveData() {
        return priorityListMutable;
    }

    public LiveData<List<TodoAndPriorityEntity>> getTodoAndPriorityLiveData() {
        return todoAndPriorityMutable;
    }

    public void queryTodoList() {
        disposeTodo = todoRepository
                .getToDoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(toDoEntities -> todoListMutable.setValue(toDoEntities));
        compositeDisposable.add(disposeTodo);
    }

    public void queryPriorityList() {
        disposePriority = todoRepository
                .getPriority()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(priorityEntities -> priorityListMutable.setValue(priorityEntities));
        compositeDisposable.add(disposePriority);
    }

    public void queryTodoAndPriority() {
        todoRepository
                .getTodoAndPriority()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(todoAndPriorityEntities -> todoAndPriorityMutable.setValue(todoAndPriorityEntities));

    }

    public void insertPriority(PriorityEntity priorityEntity) {
        todoRepository
                .insertPriority(priorityEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Long aLong) {
                        message.setValue("Insert Priority success");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        message.setValue("Insert Todo fail because " + e.getMessage());
                    }
                });
    }

    public void insertTodo(ToDoEntity toDoEntity) {
        todoRepository
                .insertTodo(toDoEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Long aLong) {
                        message.setValue("Insert Todo success");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        message.setValue("Insert Priority fail because " + e.getMessage());
                    }
                });
    }

    public void disposeData() {
        compositeDisposable.dispose();
    }
}
