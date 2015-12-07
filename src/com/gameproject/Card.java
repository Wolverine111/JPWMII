package com.gameproject;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    public JPanel panel;

    public int wys = 98;
    public int liczba = 1;
    List<BufferedImage> images = new ArrayList();
    BufferedImage img = null;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    
    public void paintComponent(Graphics graph) {
    
        Graphics2D graph2 = (Graphics2D) graph;

        AffineTransform at = new AffineTransform();
        AffineTransform t = graph2.getTransform();
        
        graph2.drawImage(images.get(1), 350, 350, null);
 
        
    }

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

        switch (suit) {

            case CLUBS:
                wys = 100;
                liczba = 1;
                break;
            case SPADES:
                wys = 200;
                liczba = 2;
                break;
            case HEARTS:
                wys = 300;
                liczba = 3;
                break;
            case DIAMONDS:
                wys = 400;
                liczba = 4;
                break;

        }
//        
        try {
            img = ImageIO.read(Card.class.getResource("/res/images/deck.png"));
            for (int i = 1; i < 4; i++) {

                for (int j = 0; j < 12; j++) {
                    images.add(img.getSubimage(70 * j, i * wys, 70, 100));
                }

            }
        } catch (Exception ex) {

        }
 
        
        //JPanel karta = new JPanel();
        //BufferedImage obr = images.get(1);
        
        try {
            ImageIcon image = new ImageIcon(images.get(1));
            JLabel label = new JLabel("", image, JLabel.CENTER);
            panel = new JPanel(new BorderLayout());
            panel.add( label, BorderLayout.CENTER );
        } catch (Exception e) {
        }

        
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
        //return images.get(liczba*rank.value);
    }
}
