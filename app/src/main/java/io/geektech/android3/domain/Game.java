package io.geektech.android3.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> cardContents) {
        for (int i = 0; i < cardContents.size(); i++) {
            cards.add(new Card<>(i + 1, false, false, cardContents.get(i)));
            cards.add(new Card<>((i + 1) * 2, false, false, cardContents.get(i)));
            Collections.shuffle(cards);
        }

    }

    public void cardClick(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            Log.d("FACEUP", card.getId() + "");
            checkPairs(card);
        }
    }

    private void checkPairs(Card<CardContent> card) {
        for (Card<CardContent> anotherCard : cards) {
            if (card.isFaceUp() && anotherCard.isFaceUp()) {
                if (card.equals(anotherCard) && card.getId() != anotherCard.getId()) {
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                } else if (!card.equals(anotherCard)){
                    card.setFaceUp(!card.isFaceUp());
                    anotherCard.setFaceUp(!anotherCard.isFaceUp());
                }
            }
        }
        remove();
    }

    private void remove() {
        List<Card<CardContent>> current = new ArrayList<>(cards);
        for (Card<CardContent> thisCard : cards) {
            if (thisCard.isMatched()) {
                current.remove(thisCard);
            }

        }
        cards.clear();
        cards.addAll(current);
    }
    public List<Card<CardContent>> getCards() {
        return cards;
    }

}
