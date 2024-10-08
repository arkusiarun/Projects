package assessment.inMemoryFileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystem {
    File root = new File();

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        File node = root.search(path);
        if (node == null) {
            return result;
        }
        if (node.isFile) {
            result.add(node.name);
        } else {
            result.addAll(node.getFiles().keySet());
        }
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        root.insert(path, false, "");
    }

    public void addContentToFile(String filePath, String content) {
        File node = root.insert(filePath, true, content);
        node.setContent(node.getContent() + content);
    }

    public String readContentFromFile(String filePath) {
        File node = root.search(filePath);
        if (node != null && node.isFile) {
            return node.getContent();
        }
        return "";
    }
}
