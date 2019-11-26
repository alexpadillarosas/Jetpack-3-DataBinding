package com.blueradix.android.jetpack_3_databinding.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private static final Float usd_to_au_rate = 0.5F;
//    converting dollarText to LiveData
//    private String dollarText = "";
    public MutableLiveData<String> dollarValue = new MutableLiveData<>();
//    change the accessor from private to public for the result attribute
    public MutableLiveData<Float> result = new MutableLiveData<>();

    /*
    public void setAmount(String value){
        this.dollarText = value;
        result.setValue(Float.valueOf(dollarText)*usd_to_au_rate);
    }

    public MutableLiveData<Float> getResult(){
        return result;
    }
     */

    //adding the conversion method to the model
    public void convertValue(){
        if(dollarValue.getValue() != null && !dollarValue.getValue().isEmpty()){
            result.setValue(Float.valueOf(dollarValue.getValue()) * usd_to_au_rate);
        }else
            result.setValue(0F);
    }

}
