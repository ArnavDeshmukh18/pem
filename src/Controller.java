import java.io.*;
import java.util.*;

public class Controller {
    private final Scanner sc=new Scanner(System.in);
    private  int choice;

    Repository repository=Repository.getRepository();
    Budget budget=new Budget();
    public void displayMenu() throws FileNotFoundException {
        while(true)
        {
            createMenu();
            switch (choice) {
                case 1 :

                    //TODO:Add Budget
                    System.out.println("******* Add Budget *******");
                    onAddBudget();
                    pressKey();
                    break;


                case 2 :
                    //TODO:Add Expense
                    System.out.println("******* Add Category *******");
                    onAddCategory();
                    pressKey();
                    break;
                case 3 :
                    //TODO:Add Budget
                    System.out.println("******* Add Expense *******");
                    onAddExpense();
                    pressKey();
                    break;
                case 4 :
                    //TODO:Add Budget
                    System.out.println("******* Display Budget *******");
                    pressKey();
                    break;
                case 5 :
                    //TODO:Add Budget
                    System.out.println("******* Display Categorise Expense *******");
                    displayCategoryList();
                    pressKey();
                    break;
                case 6 :
                    //TODO:Add Budget
                    System.out.println("******* Display Monthly Expense *******");
                    displayExpenseList();
                    pressKey();
                    break;

                case 7 :
                    //TODO:Add Budget
                    System.out.println("******* Display Yearly Expense *******");
                    displayExpenseList();
                    pressKey();
                    break;


                case 0 : System.exit(0);
            }

        }
    }

    public void createMenu()
    {
        System.out.println("*******Expense Manager*******");
        System.out.println("1.Add Budget");
        System.out.println("2.Add Category");
        System.out.println("3.Add Expense");
        System.out.println("4.Display Budget");
        System.out.println("5.Display Categorise Expense");
        System.out.println("6.Display Monthly Expense");
        System.out.println("7.Display Yearly Expense");
        System.out.println("0.Exit");
        System.out.print("Enter Your Choice : ");
        choice=sc.nextInt();

    }

    public void pressKey()  {
        try{
            System.out.println("Enter Any Key to Continue....");
            System.in.read();
        }catch (IOException ex)
        {
          ex.printStackTrace();
        }
    }

    public void onAddBudget()
    {
        sc.nextLine();
        System.out.println("******* Adding Budget *******");
     System.out.print("Enter the Amount : ");
     Float bud=sc.nextFloat();
     budget.setTotalBudget(bud);

    }

    public void onAddCategory()
    {
        sc.nextLine();
        System.out.print("Enter the Category : ");
        String cat=sc.nextLine();
        Category category=new Category();
        category.setName(cat);
        repository.categoryList.add(category);

    }

    public void onAddExpense()
    {

        System.out.println("******* Adding Expense *******");
        displayCategoryList();
        System.out.print("Enter Category Choice : ");
        int index= sc.nextInt();
        Category selectedCat=repository.getCategoryList().get(index-1);
        System.out.print("Enter the Amount : ");
        Float amount=sc.nextFloat();
        budget.subAmount(amount);
        System.out.print("Enter Category Id : ");
        Long id= sc.nextLong();


        Date date=new Date();
        sc.nextLine();
        System.out.print("Enter Description : ");
        String dis=sc.nextLine();
        Expense exp=new Expense(id,amount,date,dis);
        repository.expenseList.add(exp);


    }

    public void displayCategoryList()
    {   sc.nextLine();
        System.out.println("******* Displaying Categorises *******");
       List<Category>catList=repository.categoryList;
       System.out.println(" "+"Category Name");
       for (int i=0;i<catList.size();i++)
       {
           Category c=catList.get(i);
           System.out.println((i+1)+" "+c.getName());
       }
       System.out.println();

    }


    public void displayExpenseList() throws FileNotFoundException {   sc.nextLine();
        String strPath=" ",strName=" ";
        try{
             PrintStream originalOut=System.out;
            System.out.println("******* Displaying Expenses *******");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Enter File Name : ");
            strName=br.readLine();
            File file=new File("D:\\"+strName+".txt");
            PrintStream stream=new PrintStream(file);
            List<Expense>expList=repository.expenseList;
            System.setOut(stream);
            System.out.println(" "+"CategoryId"+" "+"Date"+" "+"Description"+" "+"Amount");
            for (int i=0;i<expList.size();i++)
            {
                Expense e =expList.get(i);
                System.out.println((i+1)+" "+e.categoryId+" "+DateUtil.displayString(e.date)+" "+" "+e.getDescription()+" "+e.getAmount());
            }
            System.setOut(originalOut);
            System.out.println(" "+"CategoryId"+" "+"Date"+" "+"Description"+" "+"Amount");
            for (int i=0;i<expList.size();i++)
            {
                Expense e =expList.get(i);
                System.out.println((i+1)+" "+e.categoryId+" "+DateUtil.displayString(e.date)+" "+" "+e.getDescription()+" "+e.getAmount());
            }

            System.out.println();
        }catch (FileNotFoundException ex)
        {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
