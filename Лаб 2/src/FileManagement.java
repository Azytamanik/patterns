import java.io.*;
import java.util.List;

public class FileManagement {
    public static void writer(File file, List<Worker> workers) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            for (Worker worker : workers) {
                objOut.writeObject(worker);
            }

            objOut.close();

        } catch (FileNotFoundException e) {
            System.out.println("File hasn't found");
        } catch (IOException e) {
            System.out.println("File writing error");
        }
    }

    public static void reader(File file, List<Worker> workers){
        int i = 0;
        ObjectInputStream objIn;

        try {
            FileInputStream fileIn = new FileInputStream(file);
            objIn = new ObjectInputStream(fileIn);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));

                while (bufferedReader.ready()) {
                    Worker worker = (Worker) objIn.readObject();
                    if (worker == null) {
                        break;
                    }
                    workers.add(i++, worker);
                }
                objIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("File hasn't found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class hasn't found");
        } catch (IOException e) {
            System.out.println("File reading error");
        }
    }
}
