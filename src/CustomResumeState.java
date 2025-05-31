import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CustomResumeState {
    private static final Map<String, List<Object>> selectedItems = new LinkedHashMap<>();

    public static void setSelected(String category, List<Object> items) {
        selectedItems.put(category, new ArrayList<>(items));
    }

    public static Map<String, List<Object>> getSelectedItems() {
        return selectedItems;
    }

    public static void clear() {
        selectedItems.clear();
    }


    public static void exportToFile(String filename, Resume resume) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CUSTOM RESUME OUTPUT ===\n\n");

        sb.append("GENERAL INFO:\n");
        sb.append(resume.getGeneralInfo() != null ? resume.getGeneralInfo() + "\n\n" : "Not Provided\n\n");

        sb.append("EDUCATION:\n");
        if (!resume.getEducationList().isEmpty()) {
            for (var edu : resume.getEducationList()) sb.append("• ").append(edu).append("\n");
        } else {
            sb.append("  None listed.\n");
        }
        sb.append("\n");

        for (Map.Entry<String, List<Object>> entry : selectedItems.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                sb.append(entry.getKey().toUpperCase()).append(":\n");
                for (Object o : entry.getValue()) {
                    sb.append("• ").append(o.toString()).append("\n");
                }
                sb.append("\n");
            }
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
