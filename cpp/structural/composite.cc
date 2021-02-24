#include <iostream>
#include <memory>
#include <string_view>
#include <vector>

namespace Structural {
class MenuComponent {
 public:
  virtual void add(std::unique_ptr<MenuComponent>) {
    throw std::runtime_error{""};
  }
  [[nodiscard]] virtual std::string_view get_name() const {
    throw std::runtime_error{""};
  }
  [[nodiscard]] virtual std::string_view get_description() const {
    throw std::runtime_error{""};
  }
  [[nodiscard]] virtual double get_price() const {
    throw std::runtime_error{""};
  }
  [[nodiscard]] virtual bool is_vegetarian() const {
    throw std::runtime_error{""};
  }
  virtual void print() const { throw std::runtime_error{""}; }
  virtual void print_vegetarian() const { throw std::runtime_error{""}; }

  virtual ~MenuComponent() = default;
};
class MenuComposite : public MenuComponent {
 private:
  std::vector<std::unique_ptr<MenuComponent>> menu_components;
  std::string_view name, description;

 public:
  MenuComposite(std::string_view n, std::string_view d)
      : name{n}, description{d} {
    //
  }
  void add(std::unique_ptr<MenuComponent> c) override {
    menu_components.emplace_back(std::move(c));
  }
  [[nodiscard]] std::string_view get_name() const override { return name; }
  [[nodiscard]] std::string_view get_description() const override {
    return description;
  }
  void print() const override {
    std::cout << std::endl << get_name();
    std::cout << ", " << get_description();
    std::cout << "\n---------------------\n";
    for (const auto& i : menu_components) {
      i->print();
    }
  }
  void print_vegetarian() const override {
    std::cout << std::endl << get_name();
    std::cout << ", " << get_description();
    std::cout << "\n---------------------\n";
    for (const auto& i : menu_components) {
      i->print_vegetarian();
    }
  }
};
class MenuItemLeaf : public MenuComponent {
 private:
  std::string_view name, description;
  bool vegetarian;
  double price;

 public:
  MenuItemLeaf(std::string_view n, std::string_view d, bool v, double p)
      : name{n}, description{d}, vegetarian{v}, price{p} {}
  [[nodiscard]] std::string_view get_name() const override { return name; }
  [[nodiscard]] std::string_view get_description() const override {
    return description;
  }
  [[nodiscard]] bool is_vegetarian() const override { return vegetarian; }
  [[nodiscard]] double get_price() const override { return price; }
  void print() const override { std::cout << *this; }
  void print_vegetarian() const override {
    if (!is_vegetarian()) {
      return;
    }
    std::cout << *this;
  }
  friend std::ostream& operator<<(std::ostream& os, const MenuItemLeaf& m) {
    os << " " << m.get_name();
    if (!m.is_vegetarian()) {
      os << "(v)";
    }
    os << ", " << m.get_price() << std::endl;
    os << "\t-- " << m.get_description() << std::endl;
    return os;
  }
};
class Waitress {
 private:
  std::unique_ptr<MenuComponent> menu_component;

 public:
  explicit Waitress(std::unique_ptr<MenuComponent> m) {
    menu_component = std::move(m);
  }
  void print_menu() const { menu_component->print(); }
  void print_vegetarian_menu() const { menu_component->print_vegetarian(); }
};
}  // namespace Structural

int main() {
  using namespace Structural;
  try {
    auto all_menus_parent_node =
        std::make_unique<MenuComposite>("ALL MENUS", "All menus combined");
    auto pancake_house_menu_composite =
        std::make_unique<MenuComposite>("PANCAKE HOUSE MENU", "Breakfast");
    auto diner_menu_composite =
        std::make_unique<MenuComposite>("DINER MENU", "Lunch");
    auto cafe_menu_composite =
        std::make_unique<MenuComposite>("CAFE MENU", "Dinner");
    auto desert_menu_composite =
        std::make_unique<MenuComposite>("DESSERT MENU", "Dessert of course!");
    // Pancakes
    pancake_house_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "K&B's Pancake Breakfast", "Pancakes with scrambled eggs and toast",
        true, 2.99));
    pancake_house_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false,
        2.99));
    pancake_house_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Blueberry Pancakes",
        "Pancakes made with fresh blueberries and blueberry syrup", true,
        3.49));
    pancake_house_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Waffles", "Waffles with your choice of blueberries or strawberries",
        true, 3.59));
    // Diner
    diner_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat",
        true, 2.99));
    diner_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
    diner_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Soup of the day",
        "A bowl of the soup of the day, with a side of potato salad", false,
        3.29));
    diner_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Hot Dog",
        "A hot dog, with saurkraut, relish, onions, topped with cheese", false,
        3.05));
    diner_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Steamed Veggies and Brown Rice",
        "A medly of steamed vegetables over brown rice", true, 3.99));
    diner_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Pasta",
        "Spaghetti with marinara sauce, and a slice of sourdough bread", true,
        3.89));
    // Dessert
    desert_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Apple Pie",
        "Apple pie with a flaky crust, topped with vanilla ice cream", true,
        1.59));
    desert_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Cheesecake",
        "Creamy New York cheesecake, with a chocolate graham crust", true,
        1.99));
    desert_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89));
    // Cafe
    cafe_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Veggie Burger and Air Fries",
        "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true,
        3.99));
    cafe_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Soup of the day", "A cup of the soup of the day, with a side salad",
        false, 3.69));
    cafe_menu_composite->add(std::make_unique<MenuItemLeaf>(
        "Burrito", "A large burrito, with whole pinto beans, salsa, guacamole",
        true, 4.29));
    diner_menu_composite->add(std::move(desert_menu_composite));
    all_menus_parent_node->add(std::move(pancake_house_menu_composite));
    all_menus_parent_node->add(std::move(diner_menu_composite));
    all_menus_parent_node->add(std::move(cafe_menu_composite));
    auto waitress = Waitress(std::move(all_menus_parent_node));
    waitress.print_menu();
    std::cout << "=========Print Vegetarian=========\n";
    waitress.print_vegetarian_menu();

  } catch (const std::runtime_error& e) {
    std::cerr << e.what() << std::endl;
  } catch (...) {
    std::cerr << "unknown error\n";
  }
}
