package com.example.myintents;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String imageIndex = bundle.getString("ImageIndex");
            setImage(imageIndex);
        }
    }

    private void setImage(String index) {
        ImageView imageView = (ImageView)findViewById(R.id.imageViewFood);

        switch (index) {
            case "1" :
                imageView.setImageResource(R.drawable.burger);
                break;

            case "2" :
                imageView.setImageResource(R.drawable.pizza);
                break;

            case "3" :
                imageView.setImageResource(R.drawable.spaghetti);
                break;

            case "4" :
                imageView.setImageResource(R.drawable.fc);
                break;

            default :
                imageView.setImageResource(R.drawable.burger);
        }
    }
}