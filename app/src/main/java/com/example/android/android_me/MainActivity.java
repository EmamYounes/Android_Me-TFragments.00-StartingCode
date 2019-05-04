package com.example.android.android_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.ui.AndroidMeActivity;
import com.example.android.android_me.ui.MyCustomFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.onItemClick {

    int headIndex, bodyIndex, legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageClick(int postion) {
        int bodyPartNumber = postion / 12;
        int lastIndex = postion - 12 * bodyPartNumber;
        switch (bodyPartNumber) {
            case 0:
                headIndex = lastIndex;
                break;
            case 1:
                bodyIndex = lastIndex;
                break;
            case 2:
                legIndex = lastIndex;
                break;
            default:
                break;
        }
        Bundle bundle=new Bundle();
        bundle.putInt("headIndex",headIndex);
        bundle.putInt("bodyIndex",bodyIndex);
        bundle.putInt("legIndex",legIndex);
        final Intent intent=new Intent(this, AndroidMeActivity.class);
       intent.putExtras(bundle);
        Button nextButton= (Button) findViewById(R.id.next_btn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Toast.makeText(getApplicationContext(), "Postion Clicked is" + postion, Toast.LENGTH_LONG).show();
    }

}
