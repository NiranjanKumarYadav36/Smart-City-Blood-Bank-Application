/** * Sample Skeleton for '8_user sign up.fxml' Controller Class */package mini.mini;import javafx.animation.Timeline;import javafx.event.ActionEvent;import javafx.fxml.FXML;import javafx.fxml.FXMLLoader;import javafx.fxml.Initializable;import javafx.scene.Node;import javafx.scene.Scene;import javafx.scene.control.*;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.layout.AnchorPane;import javafx.stage.FileChooser;import javafx.stage.Stage;import javafx.util.StringConverter;import java.io.*;import java.net.URL;import java.sql.*;import java.time.LocalDate;import java.time.format.DateTimeFormatter;import java.util.ResourceBundle;import org.mindrot.jbcrypt.BCrypt;public class userSignupController implements Initializable {    @FXML // ResourceBundle that was given to the FXMLLoader    private ResourceBundle resources;    @FXML // URL location of the FXML file that was given to the FXMLLoader    private URL location;    @FXML // fx:id="addresstext"    private TextArea addresstext; // Value injected by FXMLLoader    @FXML // fx:id="anchorpanescreen"    private AnchorPane anchorpanescreen; // Value injected by FXMLLoader    @FXML // fx:id="bloodguardianslabel"    private Label bloodguardianslabel; // Value injected by FXMLLoader    @FXML // fx:id="button_back"    private Button button_back; // Value injected by FXMLLoader    @FXML // fx:id="confirmtext"    private TextField confirmtext; // Value injected by FXMLLoader    @FXML // fx:id="contactnumbertext"    private TextField contactnumbertext; // Value injected by FXMLLoader    @FXML // fx:id="emailidtext"    private TextField emailidtext; // Value injected by FXMLLoader    @FXML // fx:id="emailidtext1"    private TextField emailidtext1; // Value injected by FXMLLoader    @FXML // fx:id="fullbackgimage"    private ImageView fullbackgimage; // Value injected by FXMLLoader    @FXML // fx:id="passwordtext"    private TextField passwordtext; // Value injected by FXMLLoader    @FXML // fx:id="profiletext"    private Label profiletext; // Value injected by FXMLLoader    @FXML // fx:id="registerduser"    private Label registerduser; // Value injected by FXMLLoader    @FXML // fx:id="signupbutton"    private Button signupbutton; // Value injected by FXMLLoader    @FXML // fx:id="REPORTFILES"    private Button REPORTFILES; // Value injected by FXMLLoader    @FXML // fx:id="bloodchoice"    private ChoiceBox<String> bloodchoice; // Value injected by FXMLLoader    @FXML // fx:id="date"    private DatePicker date; // Value injected by FXMLLoader    private Stage stage;    private Scene scene;    Timeline timeline;    Label warning;    @FXML    private Label nameLabel;    @FXML    private Label emailLabel;    @FXML    private Label passwordLabel;    @FXML    private Label phoneLabel;    @FXML        // This method is called by the FXMLLoader when initialization is complete    void initialize() {        assert addresstext != null : "fx:id=\"addresstext\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert anchorpanescreen != null : "fx:id=\"anchorpanescreen\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert bloodguardianslabel != null : "fx:id=\"bloodguardianslabel\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert button_back != null : "fx:id=\"button_back\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert confirmtext != null : "fx:id=\"confirmtext\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert contactnumbertext != null : "fx:id=\"contactnumbertext\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert emailidtext != null : "fx:id=\"emailidtext\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert emailidtext1 != null : "fx:id=\"emailidtext1\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert fullbackgimage != null : "fx:id=\"fullbackgimage\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert passwordtext != null : "fx:id=\"passwordtext\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert profiletext != null : "fx:id=\"profiletext\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert registerduser != null : "fx:id=\"registerduser\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert signupbutton != null : "fx:id=\"signupbutton\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert addresstext != null : "fx:id=\"addresstext\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert date != null : "fx:id=\"date\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert bloodchoice != null : "fx:id=\"bloodchoice\" was not injected: check your FXML file '8_user sign up.fxml'.";        assert REPORTFILES != null : "fx:id=\"REPORTFILES\" was not injected: check your FXML file '8_user sign up.fxml'.";    }    @Override    public void initialize(URL location, ResourceBundle resources) {        File backFile = new File("im/background.png");        Image backImage = new Image(backFile.toURI().toString());        fullbackgimage.setImage(backImage);        bloodchoice.getItems().addAll("A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-");        bloodchoice.setConverter(new StringConverter<String>() {            @Override            public String toString(String s) {                return (s == null) ? "select blood group" : s;            }            @Override            public String fromString(String s) {                return null;            }        });    }    @FXML    void filesetOnAction(ActionEvent event){        FileChooser fileChooser = new FileChooser();        File file = fileChooser.showOpenDialog(REPORTFILES.getScene().getWindow());        String filename = file.getAbsolutePath();        REPORTFILES.setText(filename);    }    private boolean isValidPhoneNumber(String phoneNumber) {        // You can modify this regular expression based on your expected phone number format.        String regex = "^[0-9]{10}$"; // Assumes a 10-digit phone number format        return phoneNumber.matches(regex);    }    private boolean isDateValid(LocalDate selectedDate) {        LocalDate currentDate = LocalDate.now();        return !selectedDate.isAfter(currentDate);    }    public void signupOnAction(ActionEvent actionEventevent) throws SQLException, FileNotFoundException {        nameLabel.setText(""); // Clear previous name warning        emailLabel.setText(""); // Clear previous email warning        String name = emailidtext1.getText();        String email = emailidtext.getText();        String address = addresstext.getText();        String report = REPORTFILES.getText();        String password = passwordtext.getText();        if (name.isEmpty() && email.isEmpty() && address.isEmpty()  && password.isEmpty()) {            Alert alert = new Alert(Alert.AlertType.WARNING);            alert.setContentText("Please provide all the details above asked ");            alert.show();        }        if (passwordtext.getText().equals(confirmtext.getText())) {            LocalDate selectedDate = date.getValue();            if (isDateValid(selectedDate)) {                String phoneNumber = contactnumbertext.getText();                if (isValidPhoneNumber(phoneNumber)) {                    if (!name.isEmpty() && !email.isEmpty() && !address.isEmpty()  && !password.isEmpty()) {                        registeruser();                    }                        if (name.isEmpty()) {                            Alert alert = new Alert(Alert.AlertType.WARNING);                            alert.setContentText("Please fill in your name ");                            alert.show();                        }                        if (email.isEmpty()) {                            Alert alert = new Alert(Alert.AlertType.WARNING);                            alert.setContentText("Please fill in your email ");                            alert.show();                        }                        if (address.isEmpty()) {                            Alert alert = new Alert(Alert.AlertType.WARNING);                            alert.setContentText("Please fill in your address ");                            alert.show();                        }                        if (report.isEmpty()) {                            Alert alert = new Alert(Alert.AlertType.WARNING);                            alert.setContentText("Please add  your medical report ");                            alert.show();                        }                        if (password.isEmpty()) {                            Alert alert = new Alert(Alert.AlertType.WARNING);                            alert.setContentText("Please create password for your account ");                            alert.show();                        }                } else {                    Alert alert = new Alert(Alert.AlertType.WARNING);                    alert.setContentText("Please enter a valid phone number (10 digits).");                    alert.show();                }            } else {                Alert alert = new Alert(Alert.AlertType.WARNING);                alert.setContentText("Please select a date before or equal to today's date.");                alert.show();            }        } else {            registerduser.setText("Password does not match!");        }    }    public void registeruser() throws SQLException, FileNotFoundException {        LocalDate localDate = date.getValue();        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");        String dob = localDate.format(dateTimeFormatter);        DatabaseConnection connectNow = new DatabaseConnection();        Connection connectDB = connectNow.getConnection();        PreparedStatement psinsert1 = null;        PreparedStatement pscheck1 = null;        ResultSet resultSet1 = null;        PreparedStatement psinsert2 = null;        PreparedStatement pscheck2 = null;        ResultSet resultSet2 = null;        String name = emailidtext1.getText();        String password = passwordtext.getText();        String email_id = emailidtext.getText();        String bloodgroup = bloodchoice.getValue();        String phone_number = contactnumbertext.getText();        String address = addresstext.getText();        InputStream report = new FileInputStream(REPORTFILES.getText());        try {            pscheck1 = connectDB.prepareStatement("select * from users where email_id= ?");            pscheck1.setString(1, email_id);            resultSet1 = pscheck1.executeQuery();            pscheck2 = connectDB.prepareStatement("select * from users where phone_number= ?");            pscheck2.setString(1, password);            resultSet2 = pscheck2.executeQuery();            if (resultSet1.isBeforeFirst()) {                System.out.println("User Already Exists...");                Alert alert1 = new Alert(Alert.AlertType.ERROR);                alert1.setContentText("YOU CANNOT USE THIS EMAILID.");                alert1.show();                if (resultSet2.isBeforeFirst()) {                    System.out.println("Password Already Exists...");                    Alert alert2 = new Alert(Alert.AlertType.ERROR);                    alert2.setContentText("YOU CANNOT USE THIS CONTACT NUMBER.");                    alert2.show();                }            } else {                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());                // Store the hashed password in the database                String insertFields = "insert into users (name, dob, bloodgroup, email_id, password, phone_number, address, report) values (?, ?, ?, ?, ?, ?, ?, ?)";                PreparedStatement preparedStatement = connectDB.prepareStatement(insertFields);                preparedStatement.setString(1, name);                preparedStatement.setString(2, dob);                preparedStatement.setString(3, bloodgroup);                preparedStatement.setString(4, email_id);                preparedStatement.setString(5, hashedPassword); // Store the hashed password                preparedStatement.setString(6, phone_number);                preparedStatement.setString(7, address);                preparedStatement.setBlob(8, report);                preparedStatement.executeUpdate();                registerduser.setText("You have registered successfully!");            }        }catch(Exception e){                e.printStackTrace();                e.getCause();            }    }    @FXML    void backTologinOnAction(ActionEvent event) {        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("2_coomon_login_page.fxml"));        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        try {            scene = new Scene(fxmlLoader.load());        } catch (IOException e) {            throw new RuntimeException(e);        }        stage.setScene(scene);        stage.show();        stage.setTitle("Login");    }}