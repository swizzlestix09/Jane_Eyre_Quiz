package com.example.android.jane_eyre_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.util.Log;

// This is my final project
// a quiz about Jane Eyre by Charlotte Bronte
// She's a genius. #respect.
//
public class MainActivity extends AppCompatActivity {

    //boolean values for question four.
    //only two of four checkboxes are correct.

    boolean adeleFriend;
    boolean fairfaxFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    // this code is for the first question - @paramsarah
    //is the correct answer, giving you 1 point.

    private int firstQuest() {
        RadioButton sarahAnswer = findViewById( R.id.sarah );
        boolean checked = sarahAnswer.isChecked();
        int points = 0;
        switch (sarahAnswer.getId()) {
            case R.id.sarah:
                if (checked)
                    points += 1;
                break;
        }
        return points;
    }

    // this code is for the second question.
    // the false checkbox is correct, granting you an additional point.

    private int secondQuest() {
        int points = 0;
        RadioButton falseImput = findViewById( R.id.falseRadiobox );
        boolean checked = falseImput.isChecked();

        switch (falseImput.getId()) {
            case R.id.falseRadiobox:
                if (checked)
                    points += 1;
                break;
        }
        return points;
    }

    // this is code for the third question.
    // we're taking the user imput and converting it to
    // a string value, then using an if statement
    // to access if the answer is correct, granting you an additional point.

    private int thirdQuest() {
        EditText userImput = findViewById( R.id.answer_input );
        String userAnswer = userImput.getText().toString();
        int points = 0;
        if (userAnswer.equalsIgnoreCase( "Lowood" )) {
            points += 1;
        }
        return points;
    }

    // the fourth question - two checkboxes are correct.
    // both checkboxes are assigned values and used in an
    //if statement to verify that is both are selected
    // you will get an additional point.

    private int fourthQuest() {
        int points = 0;
        CheckBox adeleTrue = findViewById( R.id.adeleCheckbox );
        adeleFriend = adeleTrue.isChecked();

        CheckBox fairfaxTrue = findViewById( R.id.fairfaxCheckbox );
        fairfaxFriend = fairfaxTrue.isChecked();

        if ((adeleFriend && fairfaxFriend)) {
            points += 1;
        }
        return points;

    }

    //the fifth question confirms that if the celine radio
    //button is checked, you will get a point for that is
    // the correct answer.

    private int fifthQuest() {
        int points = 0;
        RadioButton celineAnswer = findViewById( R.id.celine );
        boolean checked = celineAnswer.isChecked();

        switch (celineAnswer.getId()) {
            case R.id.celine:
                if (checked)
                    points += 1;
                break;
        }
        return points;
    }

    //final tally is a function that is called when
    //the 'submit' button is pressed. this function
    //take an int variable and all the functions are called, results
    //are added together and once the final value is read it will
    //be read by the switch statement which has different toast commands
    //in correlation with how many points were scored.

    public void finalTally(View view) {
        int points = firstQuest() + secondQuest() + thirdQuest() + fourthQuest() + fifthQuest();
        String result = "  ";
        Log.v( "points ", "" + points );

        switch (points) {
            case 0:
            case 1:
            case 2:
                result = "Seems as though you are a novice in this subject. Read the book! You won't regret it! \n Correct: " + points;
                break;
            case 3:
            case 4:
                result = "I mean... you probably saw the movie or something, right? You got some of the questions right..\n Correct: " + points;
                break;
            case 5:
            case 6:
                result = "Look at you! You're a fan! The book is incredible, amiright? #teamjane \n Correct: " + points;
                break;
        }
        Toast.makeText( this, result, Toast.LENGTH_LONG ).show();

    }
}




