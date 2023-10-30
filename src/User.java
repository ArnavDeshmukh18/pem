import java.util.Objects;

public class User {
    String userName;
    String passWord;

    private Repository repository;

 Budget budget;

    boolean loggedIn=false;


    public void signUp(String userName,String passWord) {
        this.userName = userName;
        this.passWord=passWord;

    }





    public void login(String userName,String passWord)
    {
        if(Objects.equals(this.userName, userName) && Objects.equals(this.passWord, passWord))
        {
            System.out.println("User Logged In ! ");
            setLoggedIn(true);

        }
        else {
            System.out.println("Incorrect Credentials !");
            setLoggedIn(false);
        }

    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void createRepository() {
        if (repository == null) {
            repository = new Repository();
            repository.setUser(this);
            System.out.println("Repository Created For User ! ");
            // Associate the user with the repository
        } else {
            System.out.println("User can have only one associated repository");
        }
    }

    public Repository getRepository() {
        return repository;
    }


    public void createBudget(long amount)
    {
        if(budget == null)
        {
            budget=new Budget();
            budget.setTotalBudget(amount);
            budget.setUser(this);
            System.out.println("Initial Budget : "+amount);
        }
        else {
            System.out.println("No Budget Is Initialized !");
        }
    }


}
