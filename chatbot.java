
import java.util.Scanner;

public class chatbot {
    
    public static void main(String[] args) {

        System.out.println("Welcome!");
        //create new scanner
        // read user input
        Scanner scanner = new Scanner(System.in);
        // call the methods
        String purpose = setPurpose(scanner);
        String budget = setBudget(scanner);
        String brand = setBrand(scanner);
        simulateLoading();
        recommendLaptop(purpose, budget, brand);
        

        
    }

    // SET BUDGET EITHER LOW, MEDIUM, HIGH
    public static String setBudget(Scanner scanner){
        int budget;
        
        while (true) {

            System.out.println("Please enter your budget for the laptop: e.g. 200");
            
            if (scanner.hasNextInt()){
                budget = scanner.nextInt();
                // to prevent errors so an empty string isn't input into the setBrand method which is called after setBudget in main
                scanner.nextLine();

                if (budget <= 250){
                    System.out.println("Budget set to: low");
                    return "low";
                }    
                else if(budget <= 500){
                    System.out.println("Budget set to: medium");
                    return "medium";
                }
                else if (budget > 500){
                    System.out.println("Budget set to: high");
                    return "high";
                }
            }
            else {
            System.out.println("Invalid input, try again");
            if (scanner.hasNextLine()){
                scanner.nextLine();
            }
            
        
            
            }

        }
            
            

    }
       
    
    // SET PURPOSE EITHER WORK, STUDY, OR GAMING
    public static String setPurpose(Scanner scanner){
    
        String purpose;
        while (true){
            System.out.println("Please enter what the purpose of the laptop is, either study, work, or gaming");
            purpose = scanner.nextLine().toLowerCase();
            

            if (purpose.equals("work") || purpose.equals("study") || purpose.equals("gaming")){
                System.out.println("Purpose set to: "+purpose);
                return purpose;
            }
            else{
                System.out.println("Invalid input, try again");
            }
        }
    }
    // SET BRAND EITHER APPLE, ASUS, OR LENOVO
    public static String setBrand(Scanner scanner){
    
        String brand;
        while (true){
            System.out.println("Please enter what brand of laptop you prefer, either apple, asus, or lenovo");
            brand = scanner.nextLine().toLowerCase();

            if (brand.equals("apple") || brand.equals("asus") || brand.equals("lenovo")){
                System.out.println("Brand set to: "+brand);
                return brand;
            }
            else{
                System.out.println("Invalid input, try again");
            }
        }
    }

    // RECOMMEND LAPTOP METHOD - takes in the return values of the three previous methods
    public static void recommendLaptop(String purpose, String budget, String brand){

        //show user choices
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("Your requirements: ");
        System.out.println("Purpose: " + purpose);
        System.out.println("Budget: " + budget);
        System.out.println("Brand: " + brand);
        

        
        System.out.println("Generating recomendation: ");
        
        




        // HELPER VARIABLES TO MAKE THE LOGIC BEHIND SUGGESTING A LAPTOP EASIER TO READ/ UNDERSTAND
        boolean purposeGaming = purpose.equals("gaming");
        boolean purposeStudy = purpose.equals("study");
        boolean purposeWork = purpose.equals("work");

        boolean budgetLow = budget.equals("low");
        boolean budgetMedium = budget.equals("medium");
        boolean budgetHigh = budget.equals("high");

        boolean brandApple = brand.equals("apple");
        boolean brandAsus = brand.equals("asus");
        boolean brandLenovo = brand.equals("lenovo");

        if (purposeGaming && brandApple){
            System.out.println("Apple may not be the best choice for gaming, perhaps reconsider");
            }

            else if(purposeGaming && budgetHigh && brandAsus){
                suggest("Asus TUF Gaming F15", "durable, high performance, reasonably priced");
            }

            else if(purposeStudy && budgetLow && brandLenovo){
                suggest("Lenovo Ideapad 3", "Budget friendly and lightweight - perfect for university");
            }
            else if(purposeWork && budgetMedium && brandApple){
                suggest("Macbook air M1", "Quiet, efficient, ideal for an office enviroment");
            }
            else if(purposeGaming && budgetMedium && brandLenovo){
                suggest("Lenovo ideapad 3 gaming", "Good middle of the range laptop for gaming");
            }
            else if (purposeWork || purposeStudy && budgetLow && brandAsus){
                suggest("Used asus chromebook", "Affordable and capable of light work or study");
            }
            //fallback option
            else {
                suggest("Lenovo Flex 5", "Safe option to fill a variety of needs");
            }



        
        
        
        
        }


        
        
        
    
          
    // suggest method to print suggestion for cleaner code in the reccomend method
    public static void suggest(String laptopName, String features) {
    System.out.println(laptopName + " features: " + features);
    }


    // adds slight delay and visual feedback so the UI is a bit less confusing / hectic spitting out many lines in 1ms
    public static void simulateLoading() {
        System.out.print("Generating laptop recommendation");
        try {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(700); // Wait 700 milliseconds
            System.out.print(".");
        }
        
        // new line
        System.out.println();
        } 
     catch (InterruptedException e){
        System.out.println("Interuppted");
     }
    
    }
    
}

   
