package com.browser.myapp.max.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

//import android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText et1, et2;
        final TextView res;
        final Button test;
        Button reset,feed;
        reset=(Button)findViewById(R.id.reset);
        ImageButton fb, insta, in, twitter, snap;
        final Random num = new Random();
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        res=(TextView)findViewById(R.id.res);
        test=(Button)findViewById(R.id.test);
        fb=(ImageButton)findViewById(R.id.fb);
        insta=(ImageButton)findViewById(R.id.insta);
        in=(ImageButton)findViewById(R.id.in);
        twitter=(ImageButton)findViewById(R.id.twitter);
        snap=(ImageButton)findViewById(R.id.snap);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.main);
        feed=(Button)findViewById(R.id.feed);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard(v);
                return false;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("RESULT");
                et1.setText("");
                et2.setText("");
                hideKeyboard(v);
                Toast.makeText(MainActivity.this, "RESET successful!!", Toast.LENGTH_SHORT).show();
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                InputMethodManager inputManager = null;
                try {
                    inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    String temp1 = et1.getText().toString();
                    String temp2 = et2.getText().toString();
                    if (et1.length() == 0 || temp1.replace(" ", "").length() == 0) {
                        et1.setError("Enter your name!!");
                        Toast.makeText(MainActivity.this, "Enter your name!!", Toast.LENGTH_SHORT).show();
                        res.setText("RESULT");
                    } else if (et2.length() == 0 || temp2.replace(" ", "").length() == 0) {
                        et2.setError("Enter partner's name!!!");
                        Toast.makeText(MainActivity.this, "Enter partner's name!!!", Toast.LENGTH_SHORT).show();
                        res.setText("RESULT");
                    } else {

                        if ((et1.getText().toString().equalsIgnoreCase("SUMIT") && et2.getText().toString().equalsIgnoreCase("MISHTI"))
                                || (et2.getText().toString().equalsIgnoreCase("SUMIT") && et1.getText().toString().equalsIgnoreCase("MISHTI"))) {
                            res.setText("100 %");
                        } else {
                            String name1 = et1.getText().toString().toLowerCase();
                            String name2 = et2.getText().toString().toLowerCase();
                            String val = calculate(name1, name2);
                            String val2 = val.substring(val.length() - 3);
                            res.setText(val2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"ENTER NAMES !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "sumit749284@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback : Love Calculator");
                intent.setPackage("com.google.android.gm");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else
                    Toast.makeText(MainActivity.this, "No app to perform this operation !!", Toast.LENGTH_SHORT).show();
                //startActivity(Intent.createChooser(intent, ""));
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.fb.com/smaxiso"));
                startActivity(browserIntent);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/smaxiso"));
                startActivity(browserIntent);
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/sumit-kumar-65a52b151/"));
                startActivity(browserIntent);
            }
        });
        snap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.snapchat.com/add/sumitisalvin"));
                startActivity(browserIntent);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.twitter.com/smaxiso"));
                startActivity(browserIntent);
            }
        });
    }
    public void onBackPressed(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Confirm Exit??");
        alertDialogBuilder.setMessage("Are you sure want to exit the app?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Exit successfull !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancel successfull !", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }

    String calculate(String str1, String str2) {
        String shortString = countChars(str1, str2);
        String output = shortString;
        do {
            output = output + "\n";
            shortString = shortenNumber(shortString);
            if (shortString.length() == 2) {
                output = output + "\n";
            }
            output = output + shortString;
        } while (shortString.length() > 2);
        output = output + "%";

        return output;
    }

    String shortenNumber(String str) {
        String shortenString = "";
        if (str.length() >= 2) {
            int int1 = Integer.parseInt(String.valueOf(str.toCharArray()[0]));
            int int2 = Integer.parseInt(String.valueOf(str.toCharArray()[str.length() - 1]));
            shortenString = String.valueOf(int1 + int2) + shortenNumber(str.substring(1, str.length() - 1));
        } else {
            return str;
        }

        return shortenString;
    }

    String countChars(String str1, String str2) {
        String combinedString = str1 + "loves" + str2;

        String strAllChars = "";
        String strCount = "";
        for (char c1 : combinedString.toCharArray()) {
            if (strAllChars.indexOf(c1) < 0) {
                int count = 0;
                for (char c2 : combinedString.toCharArray()) {
                    if (c1 == c2) {
                        count = count + 1;
                    }
                }
                strAllChars = strAllChars + c1;
                strCount = strCount + String.valueOf(count);
            }
        }

        return strCount;
    }
    void hideKeyboard(View view)
    {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


}
