package javafinal;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafinal.Javafinal.f;
import static javafinal.Javafinal.flag;
import static javafinal.Javafinal.str3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

/**
 *
 * @author test
 */
public class FXMLDocumentController implements Initializable {

    public static Socket socket;
    public File file;
    public FileInputStream fis;
    public BufferedInputStream bis;
    public static ObjectOutputStream os;
    public static ObjectInputStream is;

    private Desktop desktop = Desktop.getDesktop();
    @FXML
    ImageView img1 = new ImageView();
    @FXML
    private Button login = new Button();

    @FXML
    private Button upto = new Button();
    @FXML
    private Button photo = new Button();
    @FXML
    private Button caccount = new Button();
    @FXML
    private Button logout = new Button();
    @FXML
    private Button wantblood = new Button();
    @FXML
    private Button help = new Button();
    @FXML
    private Button help2 = new Button();
    @FXML
    private Button backblood = new Button();
    @FXML
    private Button backaccount = new Button();
    @FXML
    private Button setnow = new Button();
    @FXML
    private Button ab = new Button();
    @FXML
    private Button ab2 = new Button();
    @FXML
    private Button ex = new Button();
    @FXML
    private Button backabout = new Button();
    @FXML
    private Button backhelp = new Button();
    @FXML
    private Label fail = new Label();
    @FXML
    private Label lname = new Label();
    @FXML
    private Label lage = new Label();
    @FXML
    private Label lgroup = new Label();
    @FXML
    private Label ladd = new Label();
    @FXML
    private Label lemail = new Label();
    @FXML
    private Label ldate = new Label();
    @FXML
    private Label lphone = new Label();
    @FXML
    private TextField txtD = new TextField();
    @FXML
    private PasswordField passD = new PasswordField();
    @FXML
    private Button up = new Button();
    @FXML
    private Button backup = new Button();
    @FXML
    private Button wantblood2 = new Button();
    @FXML
    private Button search = new Button();
    @FXML
    private Button login2 = new Button();
    @FXML
    private Button help3 = new Button();
    @FXML
    private Button aboutw = new Button();
    @FXML
    private Button reset = new Button();
    @FXML
    private Button submit = new Button();
    @FXML
    private TextField wname = new TextField();
    @FXML
    private TextField wemail = new TextField();
    @FXML
    private TextField waddress = new TextField();
    @FXML
    private TextField wgroup = new TextField();
    @FXML
    private TextField wphone = new TextField();
    @FXML
    private Label labelwant = new Label();

    @FXML
    private void helping(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == help) {
            //get reference to the button's stage         
            stage = (Stage) help.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("Help.fxml"));
        } else {
            stage = (Stage) backhelp.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void helping2(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == help2) {
            //get reference to the button's stage         
            stage = (Stage) help2.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("Help.fxml"));
        } else {
            stage = (Stage) backhelp.getScene().getWindow();
            if (flag) {
                root = FXMLLoader.load(getClass().getResource("login.fxml"));
            } else {
                root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            }
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void upload(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            f = file;
            System.out.println(f.getName());
            String s = f.toURI().toString();
            System.out.println(s);
            Image image = new Image(s);

            img1.setImage(image);

            // openFile(file);
        }
        final GridPane inputGridPane = new GridPane();

    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            ;
        }
    }

    @FXML
    private void about(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == ab) {
            //get reference to the button's stage         
            stage = (Stage) ab.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("about.fxml"));
        } else {
            stage = (Stage) backabout.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField sbox = new TextField();
    @FXML
    private TextField sbox2 = new TextField();
    @FXML
    private Button backsearch = new Button();
    @FXML
    private Button searchagain = new Button();
    public static boolean flag2 = false;
    public static String searchresult;

    @FXML
    private void searching(ActionEvent event) throws IOException, ClassNotFoundException {
        str3 = sbox.getText();
        str3.trim();
        Stage stage;
        Parent root;
        if (event.getSource() == search & str3 != null) {
             os.writeObject("Searching " + str3);
          
            searchresult = (String) is.readObject();
            flag2=true;
            //  System.out.println(flag2);
            root = FXMLLoader.load(getClass().getResource("Search_result.fxml"));
           
           
            stage = (Stage) search.getScene().getWindow();

        } else {
            stage = (Stage) backsearch.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("wantblood.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    String str4;

    @FXML
    private void search_again(ActionEvent event) throws IOException, ClassNotFoundException {
        str4 = sbox2.getText();
        str4.trim();
        os.writeObject("Searching " + str4);
        searchresult = (String) is.readObject();
      
        String part[] = searchresult.split("&");
        searchresult = "";
        for (int i = 0; i < part.length; i++) {
            searchresult += ("\n") + part[i];
        }
        System.out.println(searchresult);
       labelsearch.setText(searchresult);
    }

    @FXML
    private void updating(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == upto) {
            //get reference to the button's stage         
            stage = (Stage) upto.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        //create a new scene with root and set the stage

    }

    @FXML
    private void about2(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == ab2) {
            //get reference to the button's stage         
            stage = (Stage) ab2.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("about.fxml"));
        } else {
            stage = (Stage) backabout.getScene().getWindow();
            if (flag) {
                root = FXMLLoader.load(getClass().getResource("login.fxml"));
            } else {
                root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            }

        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static String str1, str2;
    public static data d;

    @FXML
    private void log_in(ActionEvent event) throws IOException, ClassNotFoundException {

        str1 = txtD.getText();
        str2 = passD.getText();
        str1.trim();
        str2.trim();
        System.out.println(str1);
        System.out.println(str2);
        Stage stage;
        Parent root;
        String pass;
        boolean flag1 = false;

        if (event.getSource() == login) {
            os.writeObject("searchuser " + str1);
            String q = (String) is.readObject();
            if (q.compareToIgnoreCase(str2) == 0) {
                flag1 = true;
            } else {

                fail.setText("Wrong user name or password");

                txtD.clear();
                passD.clear();
            }
        }
        if (flag1) {

            flag = true;
            os.writeObject("searchdata " + str1);
            String q = (String) is.readObject();
            String[] part = q.split(" ");

            int l = q.length();
            String p = new String();
            for (int i = 0; i < part.length - 6; i++) {
                p = p + part[i] + " ";
            }

            d = new data(p, part[part.length - 6], part[part.length - 5], part[part.length - 4], part[part.length - 3], part[part.length - 1], part[part.length - 2]);

            stage = (Stage) login.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        }
    }

    @FXML
    private final WebView webview = new WebView();
    @FXML
    Button cnow = new Button();

    @FXML
    private void create_account(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == caccount) {
            //get reference to the button's stage         
            stage = (Stage) caccount.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("Create_account.fxml"));

        } else {
            stage = (Stage) backaccount.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void want_blood2(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == wantblood2) {
            //get reference to the button's stage         
            stage = (Stage) wantblood2.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("wantblood.fxml"));
        } else {
            stage = (Stage) backblood.getScene().getWindow();
            if (flag) {
                root = FXMLLoader.load(getClass().getResource("login.fxml"));
            } else {
                root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            }
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == up) {
            //get reference to the button's stage         
            stage = (Stage) up.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("update.fxml"));
        } else {
            stage = (Stage) backup.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void log_out(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == logout) {
            flag = false;
            stage = (Stage) logout.getScene().getWindow();

            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        //create a new scene with root and set the stage

    }

    @FXML
    private void want_blood(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == wantblood) {
            //get reference to the button's stage         
            stage = (Stage) caccount.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("wantblood.fxml"));
        } else {
            stage = (Stage) backblood.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void log_in2(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == login2) {
            //get reference to the button's stage         
            stage = (Stage) login2.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        } else {
            stage = (Stage) login.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void helping3(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == help3) {
            //get reference to the button's stage         
            stage = (Stage) help3.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("Help.fxml"));
        } else {
            stage = (Stage) backhelp.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void about3(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == aboutw) {
            //get reference to the button's stage         
            stage = (Stage) aboutw.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("about.fxml"));
        } else {
            stage = (Stage) backabout.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void submiting(ActionEvent event) {
        String s1, s2, s3, s4, s5;

        s1 = wname.getText();
        s2 = wgroup.getText();
        s3 = waddress.getText();
        s4 = wemail.getText();
        s5 = wphone.getText();
        if (s1.length() == 0 || s2.length() == 0 || s3.length() == 0 || s4.length() == 0 || s5.length() == 0) {

            labelwant.setText("Please Fill All Data!");
        } else {
            labelwant.setText("The information is Stored!");
        }

    }

    @FXML
    private void reseting(ActionEvent event) {

        wname.clear();
        wgroup.clear();
        waddress.clear();
        wemail.clear();
        wphone.clear();
        labelwant.setText("");
        labelwant.setText("Reseted");

    }

    @FXML
    private void exitnow(ActionEvent event) {
        System.exit(1);
    }
    @FXML
    private TextField c3 = new TextField();

    @FXML
    private TextField c4 = new TextField();

    @FXML
    private PasswordField p1 = new PasswordField();

    @FXML
    private TextField c5 = new TextField();

    @FXML
    private TextField c6 = new TextField();

    @FXML
    private TextField c7 = new TextField();

    @FXML
    private TextField c8 = new TextField();

    @FXML
    private Button create1 = new Button();

    @FXML
    private TextField c1 = new TextField();

    @FXML
    private TextField c2 = new TextField();
    @FXML
    Label lbl2 = new Label();

    @FXML
    void createa(ActionEvent event) throws IOException, ClassNotFoundException {
        String s1, s2, s3, s4, s5, s6, s7, s8, s9;
        s1 = c1.getText();
        s2 = p1.getText();
        s3 = c2.getText();
        s4 = c3.getText();
        s5 = c4.getText();
        s6 = c5.getText();
        s7 = c6.getText();
        s8 = c7.getText();
        s9 = c8.getText();
        if (s1.length() == 0 | s2.length() == 0 | s3.length() == 0 | s4.length() == 0 | s5.length() == 0 | s6.length() == 0 | s7.length() == 0 | s8.length() == 0 | s9.length() == 0) {
            lbl2.setText("Fill all data");
        }
        s3 = s3.replace(" ", "#");
        os.writeObject((String) ("update " + s1 + "$" + s2 + "$" + s3 + "$" + s4 + "$" + s5 + "$" + s6 + "$" + s7 + "$" + s8 + "$" + s9));
        System.out.println(is.readObject());
    }
   @FXML
   Label labelsearch=new Label();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (flag2) {
            //System.out.println(searchresult);
            String part[] = searchresult.split("&");
            searchresult = "";
            for (String part1 : part) {
                searchresult += ("\n") + part1;
            }
            System.out.println(searchresult);
          
            labelsearch.setText(searchresult);
            flag2 = false;
        }
        if (flag) {
            lname.setText(d.name());

            lage.setText(d.age());
            ldate.setText(d.date());
            lgroup.setText(d.getblood());
            lphone.setText(d.phone());
            lemail.setText(d.email());
            ladd.setText(d.address());
        }

        try {
            socket = new Socket("localhost", 12345);
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            System.out.println("Error");
        }

    }

}
