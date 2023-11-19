package fr.hamtec.onsavedinstancestatedemo;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private RadioGroup radioGroup;
    private RadioButton rbTrue, rbFalse;
    private Spinner spinner;
    private String string;
    private boolean aBoolean;
    private int anInt;
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        editText = findViewById( R.id.edit_text );
        radioGroup = findViewById( R.id.radio_group );
        rbTrue = findViewById( R.id.rb_true );
        rbFalse = findViewById( R.id.rb_false );
        spinner = findViewById( R.id.spinner );
        
        ArrayList < String > arrayList = new ArrayList <>( );
        arrayList.add( "Select Position" );
        arrayList.add( "1" );
        arrayList.add( "2" );
        arrayList.add( "3" );
        
        spinner.setAdapter( new ArrayAdapter <>( getApplicationContext( ), android.R.layout.simple_spinner_dropdown_item, arrayList ) );
        
        //! Lorsqu'un objet de ce type est attaché à un objet modifiable, ses méthodes sont appelées lorsque le texte est modifié.
        editText.addTextChangedListener( new TextWatcher( ) {
            //- Cette méthode est appelée pour vous notifier que, dans un délai de s, les caractères de comptage commençant par start sont sur le point
            //- d'être remplacés par un nouveau texte de longueur after.
            @Override
            public void beforeTextChanged( CharSequence s, int start, int count, int after ) {
            }
            
            //- Cette méthode est appelée pour vous notifier que, dans s, les caractères de comptage commençant par start viennent de remplacer l'ancien
            //- texte qui avait la longueur avant.
            @Override
            public void onTextChanged( CharSequence s, int start, int before, int count ) {
                // get string value
                string = String.valueOf( s );
            }
            
            //- Cette méthode est appelée pour vous notifier que, quelque part dans s, le texte a été modifié.
            @Override
            public void afterTextChanged( Editable s ) {
            }
            
        } );
        
        //! Définition d'une interface pour un rappel à invoquer lorsque l'état coché d'un bouton composé est modifié.
        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener( ) {
            //- Appelé lorsque l'état coché d'un bouton composé a changé.
            @Override
            public void onCheckedChanged( RadioGroup group, int checkedId ) {
                // get boolean value
                aBoolean = checkedId == R.id.rb_true;
            }
        } );
        
        //! Définition de l'interface pour un rappel à invoquer lorsqu'un élément de cette vue a été sélectionné.
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener( ) {
            //- Méthode de rappel à invoquer lorsqu'un élément de cette vue a été sélectionné.
            @Override
            public void onItemSelected( AdapterView < ? > parent, View view, int position, long id ) {
                // get int value
                anInt = position;
            }
            //- Méthode de rappel à invoquer lorsque la sélection disparaît de cette vue.
            @Override
            public void onNothingSelected( AdapterView < ? > parent ) {
            }
        } );
        
    }
    
    //! Appelé pour récupérer l'état de l'instance d'une activité avant qu'elle ne soit tuée, afin que l'état puisse
    //! être restauré dans onCreate(Bundle) ou onRestoreInstanceState(Bundle) (le Bundle rempli par cette méthode sera
    //! transmis à ces deux méthodes).
    @Override
    protected void onSaveInstanceState( @NonNull Bundle outState ) {
        // put string value
        outState.putString( "string_value", string );
        // put boolean value
        outState.putBoolean( "boolean_value", aBoolean );
        // Put int value
        outState.putInt( "int_value", anInt );
        super.onSaveInstanceState( outState );
    }
    
    //! Cette méthode est appelée après onStart() lorsque l'activité est réinitialisée à partir d'un état précédemment
    //! sauvegardé, donné ici dans savedInstanceState. La plupart des implémentations utiliseront simplement onCreate(Bundle)
    //! pour restaurer leur état, mais il est parfois pratique de le faire ici après que toute l'initialisation a été faite
    //! ou pour permettre aux sous-classes de décider d'utiliser votre implémentation par défaut. L'implémentation par défaut
    //! de cette méthode effectue une restauration de tout état de vue qui avait été précédemment gelé par onSaveInstanceState(Bundle).
    @Override
    protected void onRestoreInstanceState( @NonNull Bundle savedInstanceState ) {
        // get values from saved state
        string = savedInstanceState.getString( "string_value" );
        aBoolean = savedInstanceState.getBoolean( "boolean_value" );
        anInt = savedInstanceState.getInt( "int_value" );
        // display toast
        Toast.makeText( getApplicationContext( ), string + " - " + aBoolean + " - " + anInt, Toast.LENGTH_SHORT ).show( );
        super.onRestoreInstanceState( savedInstanceState );
    }
}