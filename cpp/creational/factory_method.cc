#include <algorithm>
#include <iostream>
#include <iterator>
#include <memory>
#include <string_view>
#include <vector>

namespace Creational {
namespace Product {
using iter = std::ostream_iterator<std::string_view>;
class Pizza {
 protected:
  std::string_view name, dough, sauce;
  std::vector<std::string_view> toppings;

 public:
  void prepare() const noexcept {
    std::cout << "Preparing " << name << std::endl;
    std::cout << "Tossing dough... " << dough << std::endl;
    std::cout << "Adding sauce... " << sauce << std::endl;
    std::cout << "Adding toppings: ";
    std::copy(toppings.cbegin(), toppings.cend(), iter(std::cout, ", "));
    std::cout << std::endl;
  }
  [[nodiscard("PIZZA::GET_NAME")]] std::string_view get_name() const noexcept {
    return name;
  }
  virtual void bake() const noexcept {
    std::cout << "Bake for 25 minutes at 350\n";
  }
  virtual void cut() const noexcept {
    std::cout << "Cutting the pizza into diagonal slices\n";
  }
  virtual void box() const noexcept {
    std::cout << "Place pizza in official PizzaStore box\n";
  }
  virtual ~Pizza() = default;
};
class NYStylePizza : public Pizza {
 public:
  NYStylePizza() {
    name = "NY Style Sauce Pizza";
    dough = "Thin Regular Dough";
    sauce = "Regular Sauce";
    toppings.emplace_back("Grated Nothing");
  }
};
class NYStyleCheesePizza : public Pizza {
 public:
  NYStyleCheesePizza() {
    name = "NY Style Sauce and Cheese Pizza";
    dough = "Thin Crust Dough";
    sauce = "Marinara Sauce";
    toppings.emplace_back("Grated Reggiano Cheese");
  }
};
class ChicagoStylePizza : public Pizza {
 public:
  ChicagoStylePizza() {
    name = "Chicago Style Pizza";
    dough = "Regular Dough";
    sauce = "Regular Sauce";
    toppings.emplace_back("Shredded Regular Sauce");
  }
};
class ChicagoStyleCheesePizza : public Pizza {
 public:
  ChicagoStyleCheesePizza() {
    name = "Chicago Style Deep Dish Cheese Pizza";
    dough = "Extra Thick Crust Dough";
    sauce = "Plum Tomato Sauce";
    toppings.emplace_back("Shredded Mozzarella Sauce");
  }
  void cut() const noexcept override {
    std::cout << "Cutting pizza into square slices\n";
  }
};
}  // namespace Product
namespace Creator {
enum class PizzaType : char {
  CHEESE,
  OTHER,
};
class PizzaStore {
 protected:
  virtual std::unique_ptr<Product::Pizza> create_pizza(
      const PizzaType) noexcept = 0;

 public:
  std::unique_ptr<Product::Pizza> order_pizza(const PizzaType p) noexcept {
    auto pizza = create_pizza(p);
    pizza->prepare();
    pizza->bake();
    pizza->cut();
    pizza->box();
    return pizza;
  }
  virtual ~PizzaStore() = default;
};
class ChicagoStylePizzaStore : public PizzaStore {
 protected:
  std::unique_ptr<Product::Pizza> create_pizza(
      const PizzaType p) noexcept override {
    switch (p) {
      case PizzaType::CHEESE:
        return std::make_unique<Product::ChicagoStyleCheesePizza>();
      case PizzaType::OTHER:
        return std::make_unique<Product::ChicagoStylePizza>();
    }
  }
};
class NYStylePizzaStore : public PizzaStore {
 protected:
  std::unique_ptr<Product::Pizza> create_pizza(
      const PizzaType p) noexcept override {
    switch (p) {
      case PizzaType::CHEESE:
        return std::make_unique<Product::NYStyleCheesePizza>();
      case PizzaType::OTHER:
        return std::make_unique<Product::NYStylePizza>();
    }
  }
};
}  // namespace Creator
}  // namespace Creational

int main() {
  using namespace Creational;
  auto ny_store = Creator::NYStylePizzaStore{};
  auto chicago_store = Creator::ChicagoStylePizzaStore{};
  auto cheese_ny = ny_store.order_pizza(Creator::PizzaType::CHEESE);
  std::cout << "Ethan ordered a " << cheese_ny->get_name();
  auto regular_chicago = chicago_store.order_pizza(Creator::PizzaType::OTHER);
  std::cout << "Joel ordered a " << regular_chicago->get_name() << std::endl;
}