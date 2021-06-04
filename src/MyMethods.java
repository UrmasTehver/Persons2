import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyMethods {
    private String filename;
    private ArrayList<Datas> filedata;

    public MyMethods() {
        this.filedata = new ArrayList<>();
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ArrayList<Datas> getFiledata() {
        return filedata;
    }

    public void readFromFile() {
        filedata = new ArrayList<>();
        File f = new File(filename);
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int x = 0;
            for(String line; (line = br.readLine()) != null;) {
                if(x > 0) {
                    String[] parts = line.split(";");
                    String birth = parts[3].split("-")[2] + "." + parts[3].split("-")[1] + "." + parts[3].split("-")[0];
                    String death;
                    if(parts.length == 8) { // Elav
                        death = "";
                        filedata.add(new Datas(parts[0], parts[1], parts[2], birth, death, parts[5], parts[6], parts[7]));
                    } else {
                        death = parts[4].split("-")[2] + "." + parts[4].split("-")[1] + "." + parts[4].split("-")[0];
                        filedata.add(new Datas(parts[0], parts[1], parts[2], birth, death, "", "", ""));
                    }
                }
                x++;
            }
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Faili lugemisega probleem!");
        }
    }

}
