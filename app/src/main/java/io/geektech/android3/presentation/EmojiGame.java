package io.geektech.android3.presentation;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.geektech.android3.domain.Card;
import io.geektech.android3.domain.Game;

public class EmojiGame {

    private final Game<String> game;
    private final Context context;

    @SuppressLint("NewApi")
    public EmojiGame(Context context){
        this.context = context;
        game = new Game<String>(List.of("\uD83C\uDF83", "\uD83D\uDC7B", "\uD83D\uDC7F","\uD83E\uDD84","\uD83D\uDE0B","\uD83C\uDF4F"));
    }

    public void cardClick(Card<String> card){
        game.cardClick(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
