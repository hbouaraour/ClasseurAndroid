package fr.hamtec.startactivityforresultdemo;

import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    Button button1;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        textView1=(TextView)findViewById(R.id.textView1);
        button1=(Button)findViewById(R.id.button1);
        
        button1.setOnClickListener( v -> {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivityForResult(intent, 2);// Activity is started with requestCode 2
        });
    }
    
    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data ) {
        super.onActivityResult( requestCode, resultCode, data );
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            textView1.setText(message);
            
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        return super.onCreateOptionsMenu( menu );
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}