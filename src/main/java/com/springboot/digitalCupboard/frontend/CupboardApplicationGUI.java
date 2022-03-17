package com.springboot.digitalCupboard.frontend;

import com.springboot.digitalCupboard.adapters.mappers.GarmentToRepresentationMapper;
import com.springboot.digitalCupboard.adapters.mappers.RepresentationToGarmentMapper;
import com.springboot.digitalCupboard.application.GarmentService;
import com.springboot.digitalCupboard.domain.Garment;
import com.springboot.digitalCupboard.domain.GarmentRepository;
import com.springboot.digitalCupboard.plugins.GarmentController;
import com.springboot.digitalCupboard.plugins.GarmentModelAssembler;
import com.springboot.digitalCupboard.plugins.GarmentRepositoryBridge;
import com.springboot.digitalCupboard.plugins.SpringDataGarmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.awt.*;

public class CupboardApplicationGUI {

    private GarmentRepository repository;
    @Autowired
    public CupboardApplicationGUI(GarmentRepository repository) {
        this.repository = repository;
    }

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
                JButton addButton = new JButton("Add Item");
                JButton deleteButton = new JButton("Delete Item");
                buttonPanel.add(retrieveButton);
                buttonPanel.add(addButton);
                buttonPanel.add(deleteButton);
            String data[][] =  getCupboard();
            String columns[] = getTableColumns();
            JTable table = new JTable(data, columns);
            table.setBounds(30,40,200,300);
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

    private String[][] getCupboard(){
        /*GarmentService service = new GarmentService(repository);
        GarmentToRepresentationMapper toRepresentation = new GarmentToRepresentationMapper();
        RepresentationToGarmentMapper toGarment = new RepresentationToGarmentMapper();
        GarmentModelAssembler assembler = new GarmentModelAssembler();
        GarmentController controller = new GarmentController(service, toRepresentation, toGarment, assembler);
        controller.all();*/
        String[][] data =  {{"tshirt1", "T-Shirt", "L", "Green"}, {"socks1", "Socks", "44-46", "Black"}};
        return data;
    }
}
