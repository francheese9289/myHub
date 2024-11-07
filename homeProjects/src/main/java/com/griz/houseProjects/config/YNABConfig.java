package main.java.com.griz.houseProjects.config;

public class YNABConfig {
    private static final String BASE_URL = "https://api.youneedabudget.com/v1/";
    private static final String API_KEY = "${ynab.api.key}"; // From properties file
    private static final String BUDGET_ID = "${ynab.budget.id}"; // From properties file
    
    public static String getBaseUrl() { return BASE_URL; }
    public static String getApiKey() { return API_KEY; }
    public static String getBudgetId() { return BUDGET_ID; }
}

//