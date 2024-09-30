package practise.inMemoryFileSystem;

import java.util.HashMap;
import java.util.Map;

public class File {

    String name;
    boolean isFile;
    String content;
    Map<String, File> files;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public void setFiles(Map<String, File> files) {
        this.files = files;
    }

    public File() {
        isFile = false;
        content = new String();
        files = new HashMap<>();
    }

    File insert(String path, boolean isFile, String content) {
        File node = this;
        String parts[] = path.split("/");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (!node.getFiles().containsKey(part)) {
                node.getFiles().put(part, new File());
            }
            node = node.getFiles().get(part);
        }
        if (isFile) {
            node.setFile(true);
            node.setName(parts[parts.length - 1]);
            node.setContent(content);
        }
        return node;
    }

    File search(String path) {
        File node = this;
        String[] parts = path.split("/");
        for (int i = 1; i < parts.length; ++i) {
            String part = parts[i];
            if (!node.getFiles().containsKey(part)) {
                return null;
            }
            node = node.getFiles().get(part);
        }
        return node;
    }
}