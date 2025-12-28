package ui;

import model.Complaint;
import util.FileUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ComplaintApp extends JFrame {

    private JTextField nameField;
    private JTextArea issueArea;
    private JTextArea displayArea;
    private static int complaintId = 1;

    public ComplaintApp() {
        setTitle("Complaint Management System");

        // 🔹 Bigger window
        setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 🔹 More spacing
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 🔹 Bigger font (GLOBAL)
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 18);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 18);
        Font textFont = new Font("Segoe UI", Font.PLAIN, 17);

        /* ---------- Row 1 : Name ---------- */
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        nameField = new JTextField();
        nameField.setFont(textFont);
        nameField.setPreferredSize(new Dimension(350, 35));
        gbc.gridx = 1;
        add(nameField, gbc);

        /* ---------- Row 2 : Complaint ---------- */
        JLabel complaintLabel = new JLabel("Complaint:");
        complaintLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(complaintLabel, gbc);

        issueArea = new JTextArea(3, 20);
        issueArea.setFont(textFont);
        JScrollPane issueScroll = new JScrollPane(issueArea);
        issueScroll.setPreferredSize(new Dimension(350, 80));
        gbc.gridx = 1;
        add(issueScroll, gbc);

        /* ---------- Row 3 : Submit Button ---------- */
        JButton submitBtn = new JButton("Submit Complaint");
        submitBtn.setFont(buttonFont);
        submitBtn.setPreferredSize(new Dimension(300, 40));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitBtn, gbc);

        /* ---------- Row 4 : View Button + Display ---------- */
        JButton viewBtn = new JButton("View Complaints");
        viewBtn.setFont(buttonFont);
        viewBtn.setPreferredSize(new Dimension(200, 40));

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        add(viewBtn, gbc);

        displayArea = new JTextArea();
        displayArea.setFont(textFont);
        displayArea.setEditable(false);
        JScrollPane displayScroll = new JScrollPane(displayArea);
        displayScroll.setPreferredSize(new Dimension(450, 200));

        gbc.gridx = 1;
        add(displayScroll, gbc);

        /* ---------- Row 5 : Resolve Button ---------- */
        JButton resolveBtn = new JButton("Resolve Complaint");
        resolveBtn.setFont(buttonFont);
        resolveBtn.setPreferredSize(new Dimension(300, 40));

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(resolveBtn, gbc);

        /* ---------- Actions ---------- */
        submitBtn.addActionListener(e -> submitComplaint());
        viewBtn.addActionListener(e -> viewComplaints());
        resolveBtn.addActionListener(e -> resolveComplaint());

        setLocationRelativeTo(null); // 🔹 Center window
        setVisible(true);
    }

    private void submitComplaint() {
        try {
            String name = nameField.getText();
            String issue = issueArea.getText();

            if (name.isEmpty() || issue.isEmpty()) {
                throw new Exception("Fields cannot be empty");
            }

            Complaint c = new Complaint(complaintId++, name, issue, "Pending");
            FileUtil.saveComplaint(c);

            JOptionPane.showMessageDialog(this, "Complaint Submitted Successfully");
            nameField.setText("");
            issueArea.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void viewComplaints() {
        try {
            List<Complaint> list = FileUtil.readComplaints();
            displayArea.setText("");

            for (Complaint c : list) {
                displayArea.append(
                        "ID: " + c.getId() +
                        " | Name: " + c.getName() +
                        " | Issue: " + c.getIssue() +
                        " | Status: " + c.getStatus() + "\n"
                );
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading complaints");
        }
    }

    private void resolveComplaint() {
        try {
            String idStr = JOptionPane.showInputDialog(this, "Enter Complaint ID:");
            int id = Integer.parseInt(idStr);

            FileUtil.updateStatus(id, "Resolved");
            JOptionPane.showMessageDialog(this, "Complaint Resolved");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Complaint ID");
        }
    }

    public static void main(String[] args) {
        new ComplaintApp();
    }
}
