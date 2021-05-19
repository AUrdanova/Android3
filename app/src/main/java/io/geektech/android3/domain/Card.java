package io.geektech.android3.domain;


import java.util.Objects;

public class Card<CardContent> {
    private int id;
    private boolean isMatched;
    private boolean isFaceUp;
    private CardContent content;

    public Card(int id, boolean isMatched, boolean isFaceUp, CardContent content) {
        this.id = id;
        this.isMatched = isMatched;
        this.isFaceUp = isFaceUp;
        this.content = content;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public CardContent getContent() {
        return content;
    }

    public void setContent(CardContent content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return Objects.equals(content, card.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}



