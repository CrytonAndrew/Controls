import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 implements ActionListener {

    private JFrame frame = new JFrame();
    private JTextField productIDField = new JTextField();
    private JTextField productNameField = new JTextField();
    private JTextField productPriceField = new JTextField();
    private JTextArea productFileArea = new JTextArea();
    private JButton submitButton = new JButton("Submit");
    private JButton searchButton =  new JButton("Search");
    private ArrayList<String> productsArray = new ArrayList<>();


    private Question3() {


        //Read From File of the products

        try {
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                productsArray.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] tempsArray = productsArray.toArray(new String[0]);

        String products = null;
        for (String s : tempsArray) {
            System.out.println(s);
            productFileArea.append(s + "\n");
        }

        //Product ID Lable and Text Field
        JLabel label1 = new JLabel("Product ID:");
        label1.setBounds(50, 40, 100, 50);

        productIDField.setBounds(150, 40, 200, 50);

        //Product Name
        JLabel label2 = new JLabel("Product Name:");
        label2.setBounds(50, 100, 120, 50);

        productNameField.setBounds(150, 120, 200, 50);


        // Product Price
        JLabel label3 = new JLabel("Product Price:");
        label3.setBounds(50, 200, 100, 50);

        productPriceField.setBounds(150, 200, 200, 50);


        //Buttons setup
        submitButton.setBounds(50, 270, 300, 50);

        searchButton.setBounds(400, 270, 250, 50);


        //Print File on text area


        productFileArea.setBounds(400, 50, 250, 220);

        frame.add(productIDField);
        frame.add(label1);
        frame.add(productNameField);
        frame.add(label2);
        frame.add(productPriceField);
        frame.add(label3);
        frame.add(productFileArea);
        frame.add(submitButton);
        frame.add(searchButton);

        frame.setSize(700, 450);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton && !productIDField.getText().isEmpty() && !productNameField.getText().isEmpty() || !productPriceField.getText().isEmpty()) {
            String price = productPriceField.getText();
            String id = productIDField.getText();
            String name = productNameField.getText();

            try {
                BufferedWriter myWriter = new BufferedWriter(new FileWriter("products.txt", true));
                myWriter.append(' ');
                myWriter.append("ID: " + id + "\n NAME: "+  name + "\n PRICE: " + price);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException er) {
                System.out.println("An error occurred.");
                er.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Question3();
    }


}
