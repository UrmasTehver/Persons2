import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class App {
    private MyMethods mm;
    private String[] columnNames = {"Eesnimi", "Perenimi", "Sugu", "Sünniaeg", "Surmaaeg", "Asula", "Tüüp", "Maakond"};
    private JTable table;
    private JFrame frame;
    private JPanel pnlBottom;

    public App() {
        mm = new MyMethods();
        createGui();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }

    private void createGui() {
        frame = new JFrame("Persons 2");
        frame.setPreferredSize(new Dimension(500,300));

        JPanel pnlTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnOpen = new JButton("Ava fail");
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed();
            }
        });
        pnlTop.add(btnOpen);

        pnlBottom = new JPanel(new BorderLayout());
        pnlBottom.setPreferredSize(new Dimension(400, 200));

        JPanel container = new JPanel(new BorderLayout());
        container.add(pnlTop, BorderLayout.NORTH);
        container.add(pnlBottom, BorderLayout.CENTER);

        frame.add(container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buttonPressed() {
        JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
        int result = fc.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            mm.setFilename(f.getAbsolutePath());
            mm.readFromFile();
            ArrayList<Datas> filedata = mm.getFiledata();
            if(filedata.size() > 0) {
                String[][] data = new String[mm.getFiledata().size()][8];
                for(int i = 0; i < mm.getFiledata().size(); i++) {
                    data[i][0] = mm.getFiledata().get(i).getFirstname(); // Eesnimi
                    data[i][1] = mm.getFiledata().get(i).getLastname(); // Perenimi
                    data[i][2] = mm.getFiledata().get(i).getGender(); // Sugu
                    data[i][3] = mm.getFiledata().get(i).getBirth(); // Sünniaeg
                    data[i][4] = mm.getFiledata().get(i).getDeath(); // Surmaaeg
                    data[i][5] = mm.getFiledata().get(i).getPlace(); // Asula
                    data[i][6] = mm.getFiledata().get(i).getType(); // Tüüp
                    data[i][7] = mm.getFiledata().get(i).getCounty(); // Maakond
                }
                table = new JTable(data, columnNames);
                table.setFillsViewportHeight(true);
                pnlBottom.add(new JScrollPane(table));
                frame.pack();
                pnlBottom.setVisible(true);
            }
        }
    }
}
