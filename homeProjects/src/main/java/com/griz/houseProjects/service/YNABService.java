// package main.java.com.griz.houseProjects.service;

// class YNABService {
//     private static final String BASE_URL = "https://api.youneedabudget.com/v1/";
//     private static final String API_KEY = "your_ynab_api_key"; // You'll get this from YNAB
//     private final YNABApi api;
    
//     public YNABService() {
//         Retrofit retrofit = new Retrofit.Builder()
//             .baseUrl(BASE_URL)
//             .addConverterFactory(GsonConverterFactory.create())
//             .build();
            
//         api = retrofit.create(YNABApi.class);
//     }


    // NOT SURE I NEED THIS PART > planning to use YNAB for its data, not so much to interface with it

//     public String createExpense(String projectName, double amount) {
//         Map<String, Object> transaction = new HashMap<>();
//         transaction.put("amount", Math.round(amount * 1000)); // YNAB uses milliunits
//         transaction.put("payee_name", projectName);
//         transaction.put("memo", "House Project Expense");
        
//         try {
//             Response<Map<String, Object>> response = api.createTransaction(
//                 "Bearer " + API_KEY,
//                 "your_budget_id", // You'll get this from YNAB
//                 transaction
//             ).execute();
            
//             if (response.isSuccessful() && response.body() != null) {
//                 Map<String, Object> data = response.body();
//                 // Extract and return the transaction ID
//                 return data.get("id").toString();
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return null;
//     }
// }
