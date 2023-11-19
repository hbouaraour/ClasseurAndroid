package fr.hamtec.startactivityforresultdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView txtView1;
    private Button btn_1;
    private static final String TAG = "TEST";
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        txtView1 = findViewById( R.id.textView1 );
        btn_1 = findViewById( R.id.button1 );
        Log.d( TAG, "onCreate: Entrée" );
        btn_1.setOnClickListener( arg0 -> {
            Log.d( TAG, "onCreate: btn_1.setOnClickListener entrée" );
            Intent intent = new Intent( MainActivity.this, SecondActivity.class );
            startActivityForResult( intent, 2 );    // Activity is started with requestCode 2
            Log.i( TAG, "onCreate: après startActivityForResult" );
        } );
    }
    
    @Override
    protected void onResume( ) {
        super.onResume( );
        Log.i( TAG, "onResume: " );
    }
    
    //? Méthode de rappel pour obtenir le message d'une autre activité
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
        
        Log.d( TAG, "onActivityResult: requestCode = " + requestCode + " resultCode = " + resultCode );
        //! version-1
//        super.onActivityResult( requestCode, resultCode, data );
        //? vérifier si le code de la demande est le même que celui qui est transmis ici, c'est-à-dire 2
//        if ( requestCode == 2 ) {
//            String message = data.getStringExtra( "MESSAGE" );
//            txtView1.setText( message );
//        }
        //! version-2
        if ( requestCode == 2 ){
            
            if ( resultCode == RESULT_OK ){
                String message = data.getStringExtra( "MESSAGE" );
                txtView1.setText( message );
            }
            
        }else {
            super.onActivityResult( requestCode, resultCode, data );
        }
    }
    
}