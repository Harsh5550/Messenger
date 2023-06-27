package com.example.chatapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;

import com.example.chatapp.databinding.ActivityInfoBinding;
import com.example.chatapp.databinding.ActivityUserBinding;
import com.example.chatapp.databinding.ActivityUserInfoBinding;
import com.example.chatapp.utilities.Constants;
import com.example.chatapp.utilities.PreferenceManager;

public class UserInfoActivity extends BaseActivity{
    ActivityUserInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadUserDetails();
        setListener();
    }
    private void setListener(){
        binding.imageBack.setOnClickListener(v-> onBackPressed());
    }
    private void loadUserDetails(){
        Intent intent=getIntent();
        Bundle extra=intent.getExtras();
        binding.textName.setText(extra.getString("name"));
        binding.textNumber.setText(extra.getString("number"));
        byte [] bytes= Base64.decode(extra.getString("image"), Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        binding.profileImage.setImageBitmap(bitmap);
    }
}
