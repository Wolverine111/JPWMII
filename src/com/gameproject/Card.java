package com.gameproject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;


public class Card extends Parent {

    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    };

    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        final int value;
        private Rank(int value) {
            this.value = value;
        }
    };

    public final Suit suit;
    public final Rank rank;
    public final int value;
    
    public int wys=98;
    public int liczba=1;
    List<BufferedImage> images = new ArrayList();
    BufferedImage img = null;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

        Rectangle bg = new Rectangle(80, 100);
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setFill(Color.WHITE);

        Text text = new Text(toString());
        text.setWrappingWidth(70);

        getChildren().add(new StackPane(bg, text));
        
        
        
//        switch (suit){
//        
//            case CLUBS: wys=98; liczba=1; break;
//            case SPADES: wys=196; liczba=2; break;
//            case HEARTS: wys=294; liczba=3; break;
//            case DIAMONDS: wys=392; liczba=4; break;
//            
//        }
//        
//try {
//            img = ImageIO.read(Card.class.getResource("/resources/background.png"));
//        } catch (Exception ex) {
//            for (int i = 1; i < 4; i++) {
//
//            for (int j = 0; j < 12; j++) {
//                images.add(img.getSubimage(73 * j, 0, i*wys, i*wys));
//            }
//        }}
//
//        
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
        //return images.get(liczba*rank.value);
    }
}
