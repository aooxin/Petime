package com.example.petime.ui.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

//    ViewModel是一个抽象类，其中只有一个方法onCleared()，当ViewModel不再被需要的时候，也就是与之相关的Activity都被销毁时，该方法会被系统调用，我们可以在这个方法里面执行一些资源释放的操作，以免内存泄漏。
    public SettingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is setting fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}