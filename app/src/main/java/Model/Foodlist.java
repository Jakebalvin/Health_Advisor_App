package Model;

public class Foodlist {
    public String Name, Calories;

    public Foodlist(String Name, String Calories) {
        this.Name = Name;
        this.Calories = Calories;
    }
    public Foodlist(){

    }

    public String getName() {
        return Name;
    }

    public void setFood(String food) {
        this.Name = Name;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String calories) {
        this.Calories = Calories;
    }
}
