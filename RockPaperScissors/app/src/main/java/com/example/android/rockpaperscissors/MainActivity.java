package com.example.android.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * Declaring Variables
     */
    Button buttonRock, buttonPaper, buttonScissors;
    TextView scoreTextView;
    ImageView computerChoiceIV, humanChoiceIV;
    int humanScore = 0, computerScore = 0;
    String outputMessage = "";

    /**
     * The onCreate method has action listeners for buttons
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRock = (Button) findViewById(R.id.Rock);
        buttonPaper = (Button) findViewById(R.id.Paper);
        buttonScissors = (Button) findViewById(R.id.Scissors);

        computerChoiceIV = (ImageView) findViewById(R.id.computerPicture);
        humanChoiceIV = (ImageView) findViewById(R.id.humanPicture);

        scoreTextView = (TextView) findViewById(R.id.scoreTextView);

        buttonRock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                humanChoiceIV.setImageResource(R.drawable.rock);
                outputMessage = gamePlay("rock");
                Toast.makeText(MainActivity.this, outputMessage, Toast.LENGTH_SHORT).show();
                printScore();
            }
        });

        buttonPaper.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                humanChoiceIV.setImageResource(R.drawable.paper);
                outputMessage = gamePlay("paper");
                Toast.makeText(MainActivity.this, outputMessage, Toast.LENGTH_SHORT).show();
                printScore();
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                humanChoiceIV.setImageResource(R.drawable.scissors);
                outputMessage = gamePlay("scissors");
                Toast.makeText(MainActivity.this, outputMessage, Toast.LENGTH_SHORT).show();
                printScore();
            }
        });
    }

    /**
     * This method handles gamePlay
     * @param humanChoice
     * @return
     */
    public String gamePlay(String humanChoice) {
        String computerChoice = "";
        Random r = new Random();
        int rand = r.nextInt(3) + 1;  //r.nextInt(3) -> { 0,1,2 } +1  -> {1,2,3}
        String winningStatement = "";
        switch (rand) {
            case 1:
                computerChoice = "rock";
                computerChoiceIV.setImageResource(R.drawable.rock);
                break;
            case 2:
                computerChoice = "paper";
                computerChoiceIV.setImageResource(R.drawable.paper);
                break;
            case 3:
                computerChoice = "scissors";
                computerChoiceIV.setImageResource(R.drawable.scissors);
                break;
        }

        if (computerChoice == humanChoice) {
            winningStatement = "Draw. Nobody wins!";
        } else if (humanChoice == "rock" && computerChoice == "paper") {
            computerScore++;
            winningStatement = "Paper covers rock";
        } else if (humanChoice == "rock" && computerChoice == "scissors") {
            humanScore++;
            winningStatement = "Rock crushes scissors!";
        } else if (humanChoice == "paper" && computerChoice == "rock") {
            humanScore++;
            winningStatement = "Paper covers rock";
        } else if (humanChoice == "paper" && computerChoice == "scissors") {
            computerScore++;
            winningStatement = "Scissors cuts through paper!";
        } else if (humanChoice == "scissors" && computerChoice == "rock") {
            computerScore++;
            winningStatement = "Rock crushes scissors!";
        } else if (humanChoice == "scissors" && computerChoice == "paper") {
            humanScore++;
            winningStatement = "Scissors cuts through paper!";
        }

        return winningStatement;
    }

    /**
     * This method prints the score
     */
    public void printScore(){
        scoreTextView.setText("Human: "+Integer.toString(humanScore)+" Computer:"+Integer.toString(computerScore));
    }
}
