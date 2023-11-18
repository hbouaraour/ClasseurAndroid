package fr.hamtec.startactivityforresultdemo;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText editText1;
    Button button1;
    
    @Override
    public void onCreate( @Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState ) {
        super.onCreate( savedInstanceState, persistentState );
        
        editText1 = findViewById( R.id.editText1 );
        button1 = findViewById( R.id.button1 );
        
        button1.setOnClickListener( v -> {
            String message=editText1.getText().toString();
            Intent intent=new Intent();
            intent.putExtra("MESSAGE",message);
            
            setResult(2,intent);
            
            finish();//finishing activity
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        return super.onCreateOptionsMenu( menu );
        
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }
}
