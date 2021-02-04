package Structural.Composite;

public class CompositeMain {
    public static void main(String[] args) {
        MenuComponent allMenusParentNode = new MenuComposite("ALL MENUS", "All menus combined");
        MenuComponent pancakeHouseMenuComposite = new MenuComposite("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenuComposite = new MenuComposite("DINER MENU", "Lunch");
        MenuComponent cafeMenuComposite = new MenuComposite("CAFE MENU", "Dinner");
        MenuComponent dessertMenuComposite = new MenuComposite("DESSERT MENU", "Dessert of course!");

        allMenusParentNode.add(pancakeHouseMenuComposite);
        allMenusParentNode.add(dinerMenuComposite);
        allMenusParentNode.add(cafeMenuComposite);

        {
            pancakeHouseMenuComposite.add(new MenuItemLeaf(
                    "K&B's Pancake Breakfast",
                    "Pancakes with scrambled eggs and toast",
                    true,
                    2.99));
            pancakeHouseMenuComposite.add(new MenuItemLeaf(
                    "Regular Pancake Breakfast",
                    "Pancakes with fried eggs, sausage",
                    false,
                    2.99));
            pancakeHouseMenuComposite.add(new MenuItemLeaf(
                    "Blueberry Pancakes",
                    "Pancakes made with fresh blueberries and blueberry syrup",
                    true,
                    3.49));
            pancakeHouseMenuComposite.add(new MenuItemLeaf(
                    "Waffles",
                    "Waffles with your choice of blueberries or strawberries",
                    true,
                    3.59));
        }
        {
            dinerMenuComposite.add(new MenuItemLeaf(
                    "Vegetarian BLT",
                    "(Fakin') Bacon with lettuce & tomato on whole wheat",
                    true,
                    2.99));
            dinerMenuComposite.add(new MenuItemLeaf(
                    "BLT",
                    "Bacon with lettuce & tomato on whole wheat",
                    false,
                    2.99));
            dinerMenuComposite.add(new MenuItemLeaf(
                    "Soup of the day",
                    "A bowl of the soup of the day, with a side of potato salad",
                    false,
                    3.29));
            dinerMenuComposite.add(new MenuItemLeaf(
                    "Hot Dog",
                    "A hot dog, with saurkraut, relish, onions, topped with cheese",
                    false,
                    3.05));
            dinerMenuComposite.add(new MenuItemLeaf(
                    "Steamed Veggies and Brown Rice",
                    "A medly of steamed vegetables over brown rice",
                    true,
                    3.99));

            dinerMenuComposite.add(new MenuItemLeaf(
                    "Pasta",
                    "Spaghetti with marinara sauce, and a slice of sourdough bread",
                    true,
                    3.89));
            //
            dinerMenuComposite.add(dessertMenuComposite);
            //
            dessertMenuComposite.add(new MenuItemLeaf(
                    "Apple Pie",
                    "Apple pie with a flaky crust, topped with vanilla ice cream",
                    true,
                    1.59));
            dessertMenuComposite.add(new MenuItemLeaf(
                    "Cheesecake",
                    "Creamy New York cheesecake, with a chocolate graham crust",
                    true,
                    1.99));
            dessertMenuComposite.add(new MenuItemLeaf(
                    "Sorbet",
                    "A scoop of raspberry and a scoop of lime",
                    true,
                    1.89));
        }
        {
            cafeMenuComposite.add(new MenuItemLeaf(
                    "Veggie Burger and Air Fries",
                    "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                    true,
                    3.99));
            cafeMenuComposite.add(new MenuItemLeaf(
                    "Soup of the day",
                    "A cup of the soup of the day, with a side salad",
                    false,
                    3.69));
            cafeMenuComposite.add(new MenuItemLeaf(
                    "Burrito",
                    "A large burrito, with whole pinto beans, salsa, guacamole",
                    true,
                    4.29));
        }
        Waitress waitress = new Waitress(allMenusParentNode);
        waitress.printMenu();
        System.out.println("----------------------------------------");
        waitress.printVegetarianMenu();
    }
}
