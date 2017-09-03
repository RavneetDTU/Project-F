package com.yhase.yhase.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.yhase.yhase.R;

public class UploadDesigns extends AppCompatActivity {

    public static final int PICK_IMAGE = 101;
    Button senddetils;
    EditText et_otherdetils;
    EditText et_colorTshirt;
    EditText et_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_designs);

        ImageView iv_design = (ImageView) findViewById(R.id.iv_design);

        et_size = (EditText) findViewById(R.id.et_size);

        et_colorTshirt = (EditText) findViewById(R.id.et_colorTShirt);

        et_otherdetils = (EditText) findViewById(R.id.et_Otherdetails);
        senddetils = (Button) findViewById(R.id.btn_Senddetails);

        iv_design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Image Using"), PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && data.getData() != null) {
            if (requestCode == PICK_IMAGE) {
                Uri uri = data.getData();
                Picasso.with(getApplicationContext()).load(uri).into((ImageView) findViewById(R.id.iv_design));

                senddetils.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(UploadDesigns.this, "Thankyou for Using Choosing Us...", Toast.LENGTH_SHORT).show();
                        et_colorTshirt.setText("");
                        et_otherdetils.setText("");
                        et_size.setText("");
                    }
                });

            }
        }
    }
}
