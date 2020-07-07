package com.example.override_fivemonthn.Main;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;

import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.override_fivemonthn.App;

import com.example.override_fivemonthn.data.BoredApiClient;
import com.example.override_fivemonthn.R;
import com.example.override_fivemonthn.data.SharedPr;
import com.example.override_fivemonthn.model.BoredAction;
import com.example.override_fivemonthn.presentation.intro.IntroActivity;
import com.google.gson.internal.$Gson$Preconditions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;
import java.util.List;

import me.bendik.simplerangeview.SimpleRangeView;

public class MainActivity extends AppCompatActivity  implements  AdapterView.OnItemSelectedListener {

    Spinner spinner;
    TextView textCategory;
    String valueOfSpinner;
    TextView exploreThe;
    static TextView priceTextAcc;
    public   TextView textPrice;
 Button update;
   public static SimpleRangeView  priceR,accibilR;
  public static TextView accibilText;
    ProgressBar progressBar;

    ImageView person1,person2,person3,person4;
     ImageView vectorHeartred,vectorbegin;



       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      person1=findViewById(R.id.percon1);
      person2=findViewById(R.id.percon2);
      person3=findViewById(R.id.percon3);
      person4=findViewById(R.id.percon4);
vectorbegin=findViewById(R.id.vector_stro);
vectorHeartred=findViewById(R.id.vectorHeart);
     update=findViewById(R.id.update);

      priceTextAcc=findViewById(R.id.PriceTextAcc);
        priceR=findViewById(R.id.PriceRangeBar);
      accibilR=findViewById(R.id.accibilityRangeBar);
       accibilText=findViewById(R.id.accibilText);
    textPrice=findViewById(R.id.textPrice);
        exploreThe=findViewById(R.id.explore_the);
        textCategory=findViewById(R.id.textViewCategory);
         spinner=findViewById(R.id.Change);
         progressBar=findViewById(R.id.progress_bar);

         spinner();



         update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 App.boredApiClient.getAction(valueOfSpinner, null, null, null, null,
                         null, null, null, new BoredApiClient.BoredActionCallback() {

                             @Override
                             public void onSuccess(BoredAction boredAction) {


                               

                                     method(boredAction);




                             }

                             @Override
                             public void onFailure(Exception exception) {


                                 if (exception==null){




                                 }



                             }


                         });

             }
         });














        boolean isShow = SharedPr.getInstance(this).isShown();
        if (!isShow) {
            startActivity(new Intent(this, IntroActivity.class));
            finish();
            return;
        }
      }







    public void TonextTo(View view) {


        App.boredApiClient.getAction(valueOfSpinner, null, null, null, null,
                null, null, null, new BoredApiClient.BoredActionCallback() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onSuccess(BoredAction boredAction) {
                        exploreThe.setText( boredAction.getActivity());
                          textPrice.setText(MessageFormat.format("{0}",boredAction.getPrice().toString()));
                          progressBar.setProgress((int)(boredAction.getAccessibility()*90),true);
                        Participants(boredAction );
                        method(boredAction);
                        begin(boredAction);
                    }

                    @Override
                    public void onFailure(Exception exception) {


                        if (exception==null){

                            Toast.makeText(MainActivity.this,"данных нету",Toast.LENGTH_LONG).show();


                        }



                    }


                });

    }
    private void spinner() {

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.types,R.layout.support_simple_spinner_dropdown_item);//CharSequense Parent String
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {   //
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    textCategory.setText(valueOfSpinner);
                    valueOfSpinner = spinner.getSelectedItem().toString();



                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString().trim();
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void begin(BoredAction a){
        if (a!= null) {

vectorbegin.setVisibility(View.INVISIBLE);
vectorHeartred.setVisibility(View.VISIBLE);


        }}

    public void Participants(BoredAction a) {

        if (a.getParticipents() == null) {

            person1.setVisibility(View.INVISIBLE);
            person2.setVisibility(View.VISIBLE);
            person3.setVisibility(View.INVISIBLE);
            person4.setVisibility(View.VISIBLE);


        } else {

            Toast.makeText(this,"Все на работе",Toast.LENGTH_LONG).show();

        }


    }

   public  static <T>   void method(BoredAction boredAction){


      accibilR.setOnChangeRangeListener (new SimpleRangeView.OnChangeRangeListener() {
           @Override
           public void onRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i, int i1) {

               accibilText.setText(String.valueOf(boredAction.getAccessibility()+i1));





                 simpleRangeView.getActiveFocusThumbAlpha();

           }
       });
       accibilR.setOnTrackRangeListener(new SimpleRangeView.OnTrackRangeListener() {
           @Override
           public void onStartRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i) {
               accibilText.setText(String.valueOf(boredAction.getAccessibility()));
               accibilText.setText(String.valueOf(i));


           }

           @Override
           public void onEndRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i) {
               accibilText.setText(String.valueOf(boredAction.getAccessibility()));
               accibilText.setText(String.valueOf(i));

           }
       });
       accibilR.setOnRangeLabelsListener(new SimpleRangeView.OnRangeLabelsListener() {
           @Nullable
           @Override
           public String getLabelTextForPosition(@NotNull SimpleRangeView simpleRangeView, int i, @NotNull SimpleRangeView.State state) {


               return String.valueOf(boredAction.getAccessibility()+i);


           }


       });



       priceR.setOnChangeRangeListener(new  SimpleRangeView.OnChangeRangeListener()  {
           @Override
           public void onRangeChanged(@NotNull SimpleRangeView simpleRangeView,  int i, int i2) {

               priceTextAcc.setText(String.valueOf(boredAction.getAccessibility()));





           }
       });
       priceR.setOnTrackRangeListener(new SimpleRangeView.OnTrackRangeListener() {
           @Override
           public void onStartRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i) {
               priceTextAcc.setText(String.valueOf(boredAction.getAccessibility()));



           }

           @Override
           public void onEndRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i) {
               priceTextAcc.setText(String.valueOf(boredAction.getAccessibility()));


           }
       });
       priceR.setOnRangeLabelsListener(new SimpleRangeView.OnRangeLabelsListener() {
           @Nullable
           @Override
           public String getLabelTextForPosition(@NotNull SimpleRangeView simpleRangeView, int i, @NotNull SimpleRangeView.State state) {



               return String.valueOf(boredAction.getAccessibility());

           }}); }





}

