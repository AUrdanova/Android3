package io.geektech.android3.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import io.geektech.android3.R;
import io.geektech.android3.domain.Card;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.OnCardClick {
    private RecyclerView recyclerView;
    private EmojiAdapter emojiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.cards);
        emojiAdapter = new EmojiAdapter(this, new EmojiGame(this), this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(emojiAdapter);
    }

    @Override
    public void cardClick(Card<String> card) {
        emojiAdapter.notifyDataSetChanged();
    }
}