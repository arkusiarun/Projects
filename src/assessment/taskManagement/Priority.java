package assessment.taskManagement;

public enum Priority {
    P0 (1),
    P1(2),
    P2(3);

    int value;

    Priority(int value) {
        this.value = value;
    }

    //Priority -> P0(Highest) - P2(Lowest)
}
