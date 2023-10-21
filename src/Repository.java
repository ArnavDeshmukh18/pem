import java.util.*;

public class Repository {
    public List<Expense> expenseList=new ArrayList<>();
    public List<Category>categoryList=new ArrayList<>();
    private static Repository repository;

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    private Repository()
    {

    }

    public static Repository getRepository()
    {
        if(repository==null)
        {
            repository=new Repository();
        }
        return repository;
    }


}
