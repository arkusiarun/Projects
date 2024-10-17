package assessment.taskManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Story {

    private String storyId;
    private String name;
    private List<Card> cards;

    public Story(String storyId, String name) {
        this.storyId = storyId;
        this.name = name;
        this.cards = new ArrayList<>();
        System.out.println("Story : " + name + " Created with Id: " + storyId);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        cards.sort(Comparator.comparingInt(card-> card.getPriority().value));
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
        System.out.println(card.getName() + " Card Added to Story :" + this.getName());
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void removeCard(String cardId) {
        Card ref = null;
        for(Card existingCard: cards) {
            if(existingCard.getCardId().equals(cardId)) {
                ref = existingCard;
            }
        }
        if(ref!=null) {
            cards.remove(ref);
        }
        //cards.removeIf(card -> cardId.equals(cardId));
    }

    @Override
    public String toString() {
        return "Story : {" +
                "storyId='" + storyId + " name='" + name  + "\n" +
                ", cards=" + cards + "\n" +
                '}';
    }
}
