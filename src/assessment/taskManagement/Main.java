package assessment.taskManagement;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Integer userSeq = 101;
        Integer boardSeq = 101;
        Integer storySeq = 201;
        Integer cardSeq = 301;


        User user1 = new User(String.valueOf(userSeq++),"Scott", "scott@g.in");
        User user2 = new User(String.valueOf(userSeq++),"Brett", "brett@g.in");
        User user3 = new User(String.valueOf(userSeq++),"Tina", "tina@g.in");
        User user4 = new User(String.valueOf(userSeq++),"Chan", "chan@g.in");
        User user5 = new User(String.valueOf(userSeq++),"Thor", "thor@g.in");

        manager.createBoard(String.valueOf(boardSeq++), "OrdersProjectBoard", false);
        manager.createBoard(String.valueOf(boardSeq++), "SupplyProjectBoard", true);
        manager.createBoard(String.valueOf(boardSeq++), "AndroidProjectBoard", false);

        Board orderProject = manager.getBoard("101");
        Board supplyProject = manager.getBoard("102");
        Board androidProject = manager.getBoard("103");

        orderProject.addTeamMember(user1);
        orderProject.addTeamMember(user2);
        supplyProject.addTeamMember(user3);
        supplyProject.addTeamMember(user4);
        androidProject.addTeamMember(user5);

        Story story1 = new Story(String.valueOf(storySeq++), "OrderProjectStory1" );
        Story story2 = new Story(String.valueOf(storySeq++), "OrderProjectStory2" );
        Story story3 = new Story(String.valueOf(storySeq++), "OrderProjectStory3" );
        Story story4 = new Story(String.valueOf(storySeq++), "SupplyProjectStory1" );
        Story story5 = new Story(String.valueOf(storySeq++), "AndroidProjectStory1" );
        Story story6 = new Story(String.valueOf(storySeq++), "AndroidProjectStory2" );

        orderProject.addStory(story1);
        orderProject.addStory(story2);
        orderProject.addStory(story3);
        supplyProject.addStory(story4);
        androidProject.addStory(story5);
        androidProject.addStory(story6);

        Card card1 = new Card(String.valueOf(cardSeq++), "OrderProjectCard1", Priority.P0);
        Card card2 = new Card(String.valueOf(cardSeq++), "OrderProjectCard2", Priority.P1);
        Card card3 = new Card(String.valueOf(cardSeq++), "SupplyProjectCard1", Priority.P1);
        Card card4 = new Card(String.valueOf(cardSeq++), "SupplyProjectCard2", Priority.P2);
        Card card5 = new Card(String.valueOf(cardSeq++), "SupplyProjectCard3", Priority.P0);
        Card card6 = new Card(String.valueOf(cardSeq++), "AndroidProjectCard3", Priority.P0);

        story1.addCard(card1);
        story2.addCard(card2);
        story4.addCard(card3);
        story4.addCard(card4);
        story4.addCard(card5);
        story5.addCard(card6);

        card1.userAssigned(user1);
        card2.userAssigned(user2);
        card3.userAssigned(user3);
        card4.userAssigned(user4);
        card5.userAssigned(user3);
        card6.userAssigned(user5);

        System.out.println("");
        System.out.println("Printing Current Board Stats");
        manager.printAllBoards();

        System.out.println("");
        System.out.println("Cards in Story:- "+story4.getCards());

        story4.removeCard("304");

        System.out.println("");
        System.out.println("Cards in Story after removal:- "+story4.getCards());

        orderProject.removeTeamMember(user1.getUserId());

        System.out.println("");
        System.out.println("Board After Team Member Removal");
        manager.printAllBoards();


        manager.moveCard("101","103", "206", "301", "101");

        System.out.println("After Card moving across board");

        manager.printAllBoards();

        //manager.moveCard("102","103", "202", "302", "101");

        manager.moveCardWithinStory("103", "205", "206", "306");

        System.out.println("After Card moving within story");

        manager.printAllBoards();

    }
}