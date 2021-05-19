package io.geektech.android3.presentation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.geektech.android3.R;
import io.geektech.android3.domain.Card;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiVH> {

    private final EmojiGame emojiGame;
    private final OnCardClick onCardClick;
    private final Context context;

    public EmojiAdapter(OnCardClick onCardClick, EmojiGame emojiGame, Context context) {
        this.onCardClick = onCardClick;
        this.emojiGame = emojiGame;
        this.context = context;
    }

    @NonNull
    @Override
    public EmojiVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new EmojiVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiVH holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));

    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    class EmojiVH extends RecyclerView.ViewHolder {
        private final TextView cardTv;
        public EmojiVH(@NonNull View itemView) {
            super(itemView);
            cardTv = itemView.findViewById(R.id.card);

        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                cardTv.setText(card.getContent());
                cardTv.setBackgroundColor(Color.WHITE);
            } else {
                cardTv.setText("");
                cardTv.setBackgroundColor(context.getResources().getColor(R.color.green_1));
            }

            itemView.setOnClickListener(v -> {
                emojiGame.cardClick(card);
                onCardClick.cardClick(card);
                notifyDataSetChanged();
            });
        }
    }

    public interface OnCardClick{
        void cardClick(Card<String> card);
    }

}
