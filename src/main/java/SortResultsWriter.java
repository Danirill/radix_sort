import java.io.*;

public class SortResultsWriter {
    private static String filename = "output.csv";
    public void writeResult(int n, int iterations){
        FileWriter pw;
        String columnNamesList = "N;Iterations";
        File file = new File(filename);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                pw = new FileWriter(file, true);
                pw.append(columnNamesList);
            }
            pw = new FileWriter(file, true);
            String line = n + "," + iterations;
            pw.append(line).append("\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
