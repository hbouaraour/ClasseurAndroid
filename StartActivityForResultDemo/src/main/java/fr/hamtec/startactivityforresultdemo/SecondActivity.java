package fr.hamtec.startactivityforresultdemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText editText1;
    private Button btn_1;
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.second_main );
        
        editText1 = findViewById( R.id.editText1 );
        btn_1 = findViewById( R.id.button1 );
        
        btn_1.setOnClickListener( arg0 -> {
            String message = String.valueOf( editText1.getText( ) );
            //String message = editText1.getText( ).toString( );
            Intent intent = new Intent( );
            intent.putExtra( "MESSAGE", message );
            setResult( RESULT_OK, intent );
            //setResult( 2, intent );
            finish( );  //finishing activity
        } );
    }
}