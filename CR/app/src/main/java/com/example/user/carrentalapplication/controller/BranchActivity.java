package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.carrentalapplication.R;

import static android.view.View.*;

public class BranchActivity extends Activity implements OnClickListener  {



    private Button getBranch;

    private void findViews(){
        getBranch =(Button)findViewById(R.id.getBranch_btn);

        getBranch.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if(v==getBranch){
            GetBranch();
        }
    }

    private void GetBranch() {
        Intent intent = new Intent(this,GetBranchesActivity.class);
        startActivity(intent);
    }


}
