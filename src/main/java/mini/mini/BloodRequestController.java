public void display2() throws SQLException {

    // Establishing a database connection
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    // SQL query to retrieve data from the database
    String refreshQuery = "SELECT patient_table.patient_id, patient_table.action, patient_table.request_date, users.name, users.dob, users.email_id, users.phone_number, users.address, users.bloodgroup, users.report " +
            "FROM users " +
            "INNER JOIN patient_table ON users.user_id = patient_table.user_id " +
            "WHERE action != 'Request is in Progress......'";

    try {
        // Creating a statement to execute the query
        Statement statement = connectDB.createStatement();
        ResultSet queryOutput = statement.executeQuery(refreshQuery);

        // Looping through the result set
        while (queryOutput.next()) {
            // Extracting data from each row
            int userId = queryOutput.getInt("patient_id");
            String query_Name = queryOutput.getString("name");
            String queryBlood_group = queryOutput.getString("bloodgroup");
            String query_Dob = queryOutput.getString("dob");
            LocalDate dob = LocalDate.parse(query_Dob);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
            String formatted_Dob = dob.format(formatter);
            String query_Dob1 = queryOutput.getString("request_date");
            LocalDate request_date = LocalDate.parse(query_Dob1);
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyy");
            String formatted_Dob1 = request_date.format(formatter1);
            String queryContactno = queryOutput.getString("phone_number");
            String queryEmail = queryOutput.getString("email_id");
            String queryAddress = queryOutput.getString("address");
            byte[] pdfData = queryOutput.getBytes("report");
            String queryAction = queryOutput.getString("action");

            // Creating AdminPatientHistory objects and adding them to a list
            AdminPatientHistoryObservableList.add(new AdminPatientHistory(userId, query_Name, formatted_Dob, queryBlood_group, queryContactno, queryEmail, queryAddress, pdfData, queryAction, formatted_Dob1));
        }

        // Setting cell value factories for table columns
        tablecolumnname.setCellValueFactory(new PropertyValueFactory<>("name"));
        tablecolumnage.setCellValueFactory(new PropertyValueFactory<>("bloodgroup"));
        tablecolumnbloodgroup.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tablecolumncontactno.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        tablecolumncontactno1.setCellValueFactory(new PropertyValueFactory<>("email_id"));
        tablecolumncontactno2.setCellValueFactory(new PropertyValueFactory<>("address"));
        tablecolumncontactno3.setCellValueFactory(new PropertyValueFactory<>("report"));
        buttonColumn.setCellValueFactory(new PropertyValueFactory<>("action"));
        buttonColumn1.setCellValueFactory(new PropertyValueFactory<>("request_date"));
        tableview.setItems(AdminPatientHistoryObservableList);

        // Filtering the data based on user input
        FilteredList<AdminPatientHistory> filteredData = new FilteredList<>(AdminPatientHistoryObservableList, b -> true);
        searching.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(adminPatientHistory -> {
                if (newValue == null || newValue.trim().isEmpty()) {
                    return true; // No filter, show all items
                }
                // Filtering logic based on various fields
                String lowerCaseKeyword = newValue.toLowerCase();
                return adminPatientHistory.getName().toLowerCase().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getBloodgroup().toLowerCase().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getDob().toString().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getAction().toLowerCase().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getAddress().toLowerCase().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getEmail_id().toLowerCase().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getPhone_number().toLowerCase().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getReport().toString().contains(lowerCaseKeyword) ||
                        adminPatientHistory.getRequest_date().toString().contains(lowerCaseKeyword);
            });
        });

        // Sorting the filtered data
        SortedList<AdminPatientHistory> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);

    } catch (SQLException e) {
        // Handling SQL exceptions
        Logger.getLogger(BloodRequestController.class.getName()).log(Level.SEVERE, null, e);
        e.printStackTrace();
    }
}
