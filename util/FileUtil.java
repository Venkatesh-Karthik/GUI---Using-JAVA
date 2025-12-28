package util;

import model.Complaint;
import java.io.*;
import java.util.*;

public class FileUtil {

    private static final String FILE_NAME = "complaints.txt";

    public static void saveComplaint(Complaint c) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(c.toString() + "\n");
        fw.close();
    }

    public static List<Complaint> readComplaints() throws IOException {
        List<Complaint> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return list;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Complaint(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    data[3]
            ));
        }
        br.close();
        return list;
    }

    public static void updateStatus(int id, String newStatus) throws IOException {
        List<Complaint> list = readComplaints();
        FileWriter fw = new FileWriter(FILE_NAME);

        for (Complaint c : list) {
            if (c.getId() == id) {
                c.setStatus(newStatus);
            }
            fw.write(c.toString() + "\n");
        }
        fw.close();
    }
}
