package assessment.expenseManager;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private final String groupId;
    private final String groupName;
    private final Set<String> members;

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = new HashSet<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public Set<String> getMembers() {
        return members;
    }

    public void addMember(String userId) {
        members.add(userId);
    }
}
