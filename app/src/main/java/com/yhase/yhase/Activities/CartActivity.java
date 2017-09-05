package com.yhase.yhase.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.yhase.yhase.R;

public class CartActivity extends AppCompatActivity {

    ImageView userpic,addmoney,edit;
    public static final int PICK_IMAGE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        userpic = (ImageView) findViewById(R.id.iv_cart_userimage);
        addmoney = (ImageView) findViewById(R.id.iv_addmoney);
        edit = (ImageView) findViewById(R.id.iv_cart_edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Image Using"), PICK_IMAGE);
            }
        });

        addmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CartActivity.this, "Add Amount In Your Wallet", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            if (requestCode == PICK_IMAGE) {
                Uri uri = data.getData();
                Picasso.with(getApplicationContext()).load(uri).into((ImageView) findViewById(R.id.iv_cart_userimage));

            }
        }
    }
}
