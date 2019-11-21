package com.example.myfirstgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView consoleText;
    private Button attackButton, defendButton;
    Player player = new Player("Danny", 100, 25);
    Enemy enemy = new Enemy("Stranger", 100, 20);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consoleText = findViewById(R.id.consoleText);
        attackButton = findViewById(R.id.attacButton);
        defendButton = findViewById(R.id.defendButton);
        startGame();
    }
    private void startGame(){
        consoleText.append("Игра началась.\n" + player.getName() + " vs " + enemy.getName() + "\n");
    }
    public void onClickAttack(View view) {
        if (player.getHealth() > 0 && enemy.getHealth() > 0) {
            player.attack(consoleText, enemy);
            enemy.chooseAction(consoleText, player);
        } else if (player.getHealth() <= 0 && enemy.getHealth() > 0) {
            consoleText.append("Ты проиграл!\n");
            attackButton.setEnabled(false);
            defendButton.setEnabled(false);
        } else {
            consoleText.append("Ты выиграл!");
            attackButton.setEnabled(false);
            defendButton.setEnabled(false);
        }
    }
    public void onClickDefend(View view){
        if (player.getHealth() > 0 && enemy.getHealth() > 0) {
            player.defend(consoleText);
            enemy.chooseAction(consoleText, player);
        }
        else if (player.getHealth() <= 0 && enemy.getHealth() > 0){
            consoleText.append("Ты проиграл!\n");
            attackButton.setEnabled(false);
            defendButton.setEnabled(false);
        }
        else {
            consoleText.append("Ты выиграл!");
            attackButton.setEnabled(false);
            defendButton.setEnabled(false);
        }
    }
}
