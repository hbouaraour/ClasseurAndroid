package fr.hamtec.helloandroidprogrammatique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
    
    
        RelativeLayout layout = new RelativeLayout( this );
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT );
        layout.setLayoutParams( lp );
    
        TextView tx = new TextView( this );
        tx.setLayoutParams( new RelativeLayout.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT ) );
        tx.setText( "Hello mode programmatique" );
        
        layout.addView( tx );
        
        setContentView( layout );
    }
}