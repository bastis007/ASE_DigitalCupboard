package com.springboot.digitalCupboard.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CupboardApplicationGUI {

    JFrame frame;

    public CupboardApplicationGUI() {
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
        retrieveButton.addActionListener(e -> {
            try {getCupboardData();}
            catch (IOException | InterruptedException ex) {ex.printStackTrace();}
        });
        JButton addButton = new JButton("Add Item");
        JButton deleteButton = new JButton("Delete Item");
        buttonPanel.add(retrieveButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        String data[][] = getTableData();
        String columns[] = getTableColumns();
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
    }

    private String[] getTableColumns() {
        String[] columns = {"ID", "Type", "Size", "Colour"};
        return columns;
    }

    private String[][] getTableData() {
        String[][] data = {{"tshirt1", "T-Shirt", "L", "Green"}, {"socks1", "Socks", "44-46", "Black"}};
        return data;
    }

    private String[][] getCupboardData() throws IOException, InterruptedException {
        String url = "http://localhost:8080/garment/";
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        String[][] data = new String[10][4];
        if (responseCode == HttpURLConnection.HTTP_OK) {
           BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }
            inputReader.close();
            String tableContent = response.toString();
            String[] table = tableContent.split("\"id\":");
            int l = 0;
            for (String s : table) {
                String[] tab = s.split(",\"_links\":");
                for (int j = 0; j < tab.length; j++) {
                    if (j % 2 != 0) {
                        tab[j] = null;
                    }
                    if (j + 1 == tab.length) {
                        tab[j] = null;
                    }
                }
                for (int j = 0; (j + 1) < tab.length; j++) {
                    if (tab[j] == null && j < tab.length) {
                        tab[j] = tab[j + 1];
                    }
                    //System.out.println(tab[j]);
                    if (tab[j] == null) {
                        tab[j] = tab[j - 1];
                    }
                    String[] t = tab[j].split(",");
                    for (int k = 0; k < t.length; k++) {
                        t[k] = t[k].replace("\"type\":", "");
                        t[k] = t[k].replace("\"size\":", "");
                        t[k] = t[k].replace("\"colour\":", "");
                        data[l][k] = t[k];
                        System.out.println(data[l][k]);

                        if (k == 3) {
                            l++;
                        }
                    }
                }
            }
        }
        return data;
    }
}
