package assessment.taskManagement;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {

    private Map<String, Board> boards;

    public TaskManager() {
        this.boards = new HashMap<>();
    }

    public void createBoard(String boardId, String name, boolean isPrivate) {
        Board board = new Board(boardId, name, isPrivate);
        boards.put(boardId, board);
        System.out.println("Board Created : " + board);
    }

    public void deleteBoard(String boardId) {
        boards.remove(boardId);
    }

    public Board getBoard(String boardId) {
        return boards.get(boardId);
    }

    public void printAllBoards() {
        for(Board board: boards.values()) {
            System.out.println(board);
        }
    }

    public void moveCard(String sourceBoardId, String destBoardId, String destStoryId, String cardId, String userId) {
        Board sourceBoard = boards.get(sourceBoardId);
        Board destBoard = boards.get(destBoardId);
        System.out.println("Source Board :-" +sourceBoard.isPrivate());
        System.out.println("Destination Board :-" +destBoard.isPrivate());
        if(destBoard.isPrivate()) {
            if(destBoard.getTeamMembers().stream().anyMatch(user -> user.getUserId().equals(userId))) {
                moveCard(sourceBoard, destBoard, cardId, destStoryId);
                System.out.println("Card :" + cardId + " Moved");
            } else{
                System.out.println("User not authorised to move card");
            }
        } else {
            moveCard(sourceBoard, destBoard, cardId, destStoryId);
            System.out.println("Card :" + cardId + " Moved");
        }
    }

    private void moveCard(Board sourceBoard, Board destBoard, String cardId, String destStoryId) {
        Card sourceCard = null;
        for(Story story : sourceBoard.getStory()) {
            for(Card card: story.getCards()) {
                if(card.getCardId().equals(cardId)) {
                    sourceCard = card;
                }
            }
            if(sourceCard != null) {
                story.removeCard(sourceCard.getCardId());
            }
            else {
                System.out.println("Card not found in source story");
            }
        }

        for(Story story: destBoard.getStory()) {
            if(story.getStoryId().equals(destStoryId)) {
                story.addCard(sourceCard);
            }
        }
    }

    public void moveCardWithinStory(String boardId, String sourceStoryId, String destStoryId, String cardId) {
        Board board = boards.get(boardId);
        Story destStory = null;
        Story sourceStory = null;
        Card refCard = null;
        for(Story story:  board.getStory()) {
            if(story.getStoryId().equals(sourceStoryId)) {
                sourceStory = story;
            }
            if(story.getStoryId().equals(destStoryId)) {
                destStory = story;
            }
            for(Card card: story.getCards()) {
                if(card.getCardId().equals(cardId)) {
                    refCard = card;
                }
            }
        }

        destStory.addCard(refCard);
        sourceStory.removeCard(refCard.getCardId());
    }

}
