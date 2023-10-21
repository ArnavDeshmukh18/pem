public class Budget {
    private Float totalBudget;
   private Float currentAmount;

    public Budget(Float totalBudget) {
        this.totalBudget = totalBudget;
    }

    public void setTotalBudget(Float totalBudget) {
        this.totalBudget = totalBudget;
        currentAmount=totalBudget;
    }

    public Budget() {
    }

    public void addAmount(Float amount)
    {
        currentAmount+=amount;
    }

    public void subAmount(Float amount)
    {
        currentAmount-=amount;
    }

    public Float getTotalBudget() {
        return totalBudget;
    }

    public Float getCurrentAmount() {
        return currentAmount;
    }
}
