package assessment.taskManagement;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private String boardId;
    private String name;
    private boolean isPrivate;
    private List<User> teamMembers;
    private List<Story> stories;

    public Board(String boardId, String name, boolean isPrivate) {
        this.boardId = boardId;
        this.name = name;
        this.isPrivate = isPrivate;
        this.teamMembers = new ArrayList<>();
        this.stories = new ArrayList<>();
    }

    public String getBoardId() {
        return boardId;
    }

    public String getName() {
        return name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public List<Story> getStory() {
        return stories;
    }

    public void addTeamMember(User user) {
        teamMembers.add(user);
        System.out.println(user.getName() + " Added to Board :" +this.name);
    }

    public void removeTeamMember(String userId) {
        teamMembers.removeIf(user -> user.getUserId().equals(userId));
        Board currentBoard = this;
        for(Story story: currentBoard.getStory()) {
            for(Card card: story.getCards()) {
                if(card.getUserAssigned().getUserId().equals(userId)) {
                    card.userUnassigned();
                }
            }
        }
    }

    public void addStory(Story story) {
        stories.add(story);
        System.out.println(story.getName() + " story added to Board : " + this.name);
    }

    @Override
    public String toString() {
        return "Board {" +
                ", boardId='" + boardId + ", name='" + name  + ", Private=" + isPrivate + "\n" +
                ", teamMembers=" + teamMembers + "\n" +
                ", stories=" + stories + "\n" +
                '}';
    }
}
