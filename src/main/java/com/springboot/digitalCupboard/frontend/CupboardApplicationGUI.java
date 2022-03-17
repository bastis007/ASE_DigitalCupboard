package com.springboot.digitalCupboard.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CupboardApplicationGUI {

    /*private GarmentRepository repository;

    @Autowired
    public CupboardApplicationGUI(GarmentRepository repository) {
        this.repository = repository;
    }*/

    JFrame frame;

    public CupboardApplicationGUI() throws IOException {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        frame = new JFrame();
        device.setFullScreenWindow(frame);
        frame.setTitle("Personal digital Cupboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton retrieveButton = new JButton("Get Cupboard");
        retrieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getCupboard();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JButton addButton = new JButton("Add Item");
        JButton deleteButton = new JButton("Delete Item");
        buttonPanel.add(retrieveButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        String data[][] = getTableData();
        String columns[] = getTableColumns();
        JTable table = new JTable(data, columns);
        table.setBounds(30, 40, 200, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
    }

    private String[] getTableColumns() {
        String[] columns = {"ID", "Type", "Size", "Colour"};
        return columns;
    }

    private String[][] getTableData() {
        /*GarmentService service = new GarmentService(repository);
        GarmentToRepresentationMapper toRepresentation = new GarmentToRepresentationMapper();
        RepresentationToGarmentMapper toGarment = new RepresentationToGarmentMapper();
        GarmentModelAssembler assembler = new GarmentModelAssembler();
        GarmentController controller = new GarmentController(service, toRepresentation, toGarment, assembler);
        controller.all();*/

        String[][] data = {{"tshirt1", "T-Shirt", "L", "Green"}, {"socks1", "Socks", "44-46", "Black"}};
        return data;
    }

    private void getCupboard() throws IOException {
        String url = "http://localhost:8080/garment/";
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        Integer responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }

            inputReader.close();

            System.out.println(response.toString());

        }
    }
}
