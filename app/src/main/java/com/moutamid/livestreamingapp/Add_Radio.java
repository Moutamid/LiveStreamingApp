package com.moutamid.livestreamingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class Add_Radio extends AppCompatActivity {

    EditText radio_name , radio_link ,radio_id;
    Button radio_btn_add;
    ImageView raido_img;

    private static final int IMAGE_REQUEST = 1;
    Uri uri;
    ProgressDialog pd;
    String imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_radio);

        pd = new ProgressDialog(this);
        pd.setTitle("Wait...");
        pd.setMessage("Test Uploading...");

        radio_name = findViewById(R.id.radio_name);
        radio_id = findViewById(R.id.radio_id);
        radio_link = findViewById(R.id.radio_link);
        raido_img = findViewById(R.id.radio_img_add);
        radio_btn_add = findViewById(R.id.radio_btn_add);

        raido_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImage();
            }
        });

        // 3rd btn for submit all data using firebase
        radio_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
            }
        });
    }

    private void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            uri = data.getData();
            raido_img.setImageURI(uri);
        }
        else {
            Toast.makeText(this, "No Image is Selected", Toast.LENGTH_SHORT).show();
        }
    }

    public void uploadImage(){
        pd.show();
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Radio_Images").child(uri.getLastPathSegment());
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uriImage = uriTask.getResult();
                imageURL = uriImage.toString();
                uploadTest();
            }
        });
    }

    private void uploadTest(){
        pd.show();
        String id = radio_id.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Radio").child(id);
        HashMap<String, String> hashMap = new HashMap<>();
        String name = radio_name.getText().toString();
        String link = radio_link.getText().toString();

        hashMap.put("name", name);
        hashMap.put("link", link);
        hashMap.put("image1", imageURL);

        reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    pd.dismiss();
                    Toast.makeText(Add_Radio.this, "Test Uploaded", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Add_Radio.this, "Failed to Upload..." , Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        });
    }
}