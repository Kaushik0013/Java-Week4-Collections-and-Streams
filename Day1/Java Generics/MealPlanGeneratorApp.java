import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealName();
    int getCalories();
    String getPlanType();
}

class VegetarianMeal implements MealPlan {
    private String name;
    private int calories;

    public VegetarianMeal(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getMealName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    private String name;
    private int calories;

    public VeganMeal(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getMealName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    private String name;
    private int calories;

    public KetoMeal(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getMealName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    private String name;
    private int calories;

    public HighProteinMeal(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getMealName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public String getPlanType() {
        return "High-Protein";
    }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public List<T> getMeals() {
        return meals;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> mealPlan) {
        System.out.println("Meal Plan (" + (mealPlan.getMeals().isEmpty() ? "Empty" : mealPlan.getMeals().get(0).getPlanType()) + "):");
        for (T meal : mealPlan.getMeals()) {
            System.out.println("- " + meal.getMealName() + " (" + meal.getCalories() + " kcal)");
        }
    }
}

public class MealPlanGeneratorApp {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianPlan = new Meal<>();
        vegetarianPlan.addMeal(new VegetarianMeal("Grilled Tofu Salad", 350));
        vegetarianPlan.addMeal(new VegetarianMeal("Lentil Soup", 250));

        Meal<VeganMeal> veganPlan = new Meal<>();
        veganPlan.addMeal(new VeganMeal("Vegan Buddha Bowl", 400));
        veganPlan.addMeal(new VeganMeal("Chickpea Curry", 450));

        Meal<KetoMeal> ketoPlan = new Meal<>();
        ketoPlan.addMeal(new KetoMeal("Keto Chicken Bowl", 500));
        ketoPlan.addMeal(new KetoMeal("Zucchini Noodles", 300));

        Meal<HighProteinMeal> highProteinPlan = new Meal<>();
        highProteinPlan.addMeal(new HighProteinMeal("Egg White Omelette", 200));
        highProteinPlan.addMeal(new HighProteinMeal("Grilled Chicken Breast", 350));

        MealPlanGenerator.generateMealPlan(vegetarianPlan);
        System.out.println();
        MealPlanGenerator.generateMealPlan(veganPlan);
        System.out.println();
        MealPlanGenerator.generateMealPlan(ketoPlan);
        System.out.println();
        MealPlanGenerator.generateMealPlan(highProteinPlan);
    }
}
