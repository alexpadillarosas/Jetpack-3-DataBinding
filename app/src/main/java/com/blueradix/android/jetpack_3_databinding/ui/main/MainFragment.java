package com.blueradix.android.jetpack_3_databinding.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.blueradix.android.jetpack_3_databinding.R;
import com.blueradix.android.jetpack_3_databinding.databinding.MainFragmentBinding;
import com.google.android.material.textfield.TextInputEditText;

import static com.blueradix.android.jetpack_3_databinding.BR.myViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    //this class was automatically created by android studio, as soon as we declare the data element
    public MainFragmentBinding binding;

//    private TextInputEditText dollarInputEditText;
//    private TextView resultTextView;
//    private Button convertButton;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.main_fragment, container, false);
//        By using DataBinding, there is another way to use inflate the layout, for activities:
//        binging = DataBingingUtil.setContentView(this, R.layout.activity_main);
//        the following is for fragments:
        binding = DataBindingUtil.inflate( inflater, R.layout.main_fragment, container, false);
//      the binding object will only need to remain in memory for as long as  the fragment is present, to
//      do it, the binding object is declared as part of the fragment's lifecycle. See next line:
        binding.setLifecycleOwner(this);
//      it's mandatory to return the root view of the layout (as in the old code)
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

//        dollarInputEditText = getView().findViewById(R.id.dollarInputEditText);
//        resultTextView = getView().findViewById(R.id.resultTextView);
//        convertButton = getView().findViewById(R.id.convertButton);


//        final Observer<Float> resultObserver = new Observer<Float>() {
//            @Override
//            public void onChanged(Float result) {
//                resultTextView.setText(result.toString());
//            }
//        };

//        mViewModel.getResult().observe(this, resultObserver);
        /*
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!dollarInputEditText.getText().toString().isEmpty()){
                    mViewModel.setAmount( dollarInputEditText.getText().toString() );
//                    we don't need this as the observer will detect the result change and will set resultTextView's value from the viewModel
//                    resultTextView.setText(mViewModel.getResult().toString());
                }else {
                    resultTextView.setText("No Value");
                }
            }
        });
        */

//      We need to connect myViewModel (defined in main_fragment.xml) with the current ViewModel object
        binding.setVariable(myViewModel, mViewModel);
    }

}
