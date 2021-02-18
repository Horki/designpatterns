#include <iostream>
#include <memory>
#include <string_view>
#include <vector>

namespace Creational {
namespace Factory {
namespace Ingredients {
class Ingredient {
 public:
  virtual std::string_view to_string() const noexcept = 0;
  virtual ~Ingredient() = default;
};
class Cheese : public virtual Ingredient {};
class Clams : public virtual Ingredient {};
class Dough : public virtual Ingredient {};
class Pepperoni : public virtual Ingredient {};
class Sauce : public virtual Ingredient {};
class Veggies : public virtual Ingredient {};
class PizzaIngredientFactory {
 public:
  virtual std::unique_ptr<Dough> create_dough() noexcept = 0;
  virtual std::unique_ptr<Sauce> create_sauce() noexcept = 0;
  virtual std::unique_ptr<Cheese> create_cheese() noexcept = 0;
  virtual std::unique_ptr<Pepperoni> create_pepperoni() noexcept = 0;
  virtual std::unique_ptr<Clams> create_clams() noexcept = 0;
  virtual std::vector<std::unique_ptr<Veggies>>
  create_veggies() noexcept = 0;
  virtual ~PizzaIngredientFactory() = default;
};
class BlackOliveVeggie : public virtual Veggies {
 public:
  [[nodiscard("BLACK_OLIVE_VEGGIE")]] std::string_view to_string()
      const noexcept override {
    return "Black Olive";
  }
};
class EggPlantVeggie : public virtual Veggies {
 public:
  [[nodiscard("EGG_PLANT_VEGGIE")]] std::string_view to_string()
      const noexcept override {
    return "Egg Plant";
  }
};

class GarlicVeggie : public virtual Veggies {
 public:
  [[nodiscard("GARLIC_VEGGIE")]] std::string_view to_string()
      const noexcept override {
    return "Garlic";
  }
};

class MushroomVeggie : public virtual Veggies {
 public:
  [[nodiscard("MUSHROOM_VEGGIE")]] std::string_view to_string()
      const noexcept override {
    return "Mushroom";
  }
};

class OnionVeggie : public virtual Veggies {
 public:
  [[nodiscard("ONION_VEGGIE")]] std::string_view to_string()
      const noexcept override {
    return "Onion";
  }
};

class SpinachVeggie : public virtual Veggies {
 public:
  [[nodiscard("SPINACH_VEGGIE")]] std::string_view to_string()
      const noexcept override {
    return "Spinach";
  }
};

class FreshClams : public virtual Clams {
 public:
  [[nodiscard("FRESH_CLAMS")]] std::string_view to_string()
      const noexcept override {
    return "Fresh Clams";
  }
};

class FrozenClams : public virtual Clams {
 public:
  [[nodiscard("FROZEN_CLAMS")]] std::string_view to_string()
      const noexcept override {
    return "Frozen Clams";
  }
};

class LungoPepperoni : public virtual Pepperoni {
 public:
  [[nodiscard("LUNGO_PEPPERONI")]] std::string_view to_string()
      const noexcept override {
    return "Lungo Pepperoni";
  }
};

class MarinaraSauce : public virtual Sauce {
 public:
  [[nodiscard("MARINARA_SAUCE")]] std::string_view to_string()
      const noexcept override {
    return "Marinara Sauce";
  }
};

class MozzarellaCheese : public virtual Cheese {
 public:
  [[nodiscard("MOZZARELLA_CHEESE")]] std::string_view to_string()
      const noexcept override {
    return "Mozzarella Cheese";
  }
};

class PlumTomatoSauce : public virtual Sauce {
 public:
  [[nodiscard("PLUM_TOMATO_SAUCE")]] std::string_view to_string()
      const noexcept override {
    return "Plum Tomato Sauce";
  }
};

class ReggianoCheese : public virtual Cheese {
 public:
  [[nodiscard("REGGIANO_CHEESE")]] std::string_view to_string()
      const noexcept override {
    return "Reggiano Cheese";
  }
};

class SlicedPepperoni : public virtual Pepperoni {
 public:
  [[nodiscard("SLICED_PEPPERONI")]] std::string_view to_string()
      const noexcept override {
    return "Sliced Pepperoni";
  }
};

class ThickCrustDough : public virtual Dough {
 public:
  [[nodiscard("THICK_CRUST_DOUGH")]] std::string_view to_string()
      const noexcept override {
    return "Thick Crust Dough";
  }
};

class ThinCrustDough : public virtual Dough {
 public:
  [[nodiscard("THIN_CRUST_DOUGH")]] std::string_view to_string()
      const noexcept override {
    return "Thin Crust Dough";
  }
};
}  // namespace Ingredients
}  // namespace Factory
namespace Product {
class Pizza {
 protected:
  std::string_view name;
  std::unique_ptr<Factory::Ingredients::Dough> dough;
  std::unique_ptr<Factory::Ingredients::Sauce> sauce;
  std::unique_ptr<Factory::Ingredients::Cheese> cheese;
  std::unique_ptr<Factory::Ingredients::Pepperoni> pepperoni;
  std::unique_ptr<Factory::Ingredients::Clams> clams;
  std::vector<std::unique_ptr<Factory::Ingredients::Veggies>> veggies;

 public:
  virtual void prepare() noexcept = 0;
  void bake() const noexcept { std::cout << "Bake for 25 minutes at 350\n"; }
  void cut() const noexcept {
    std::cout << "Cutting the pizza into diagonal slices\n";
  }
  void box() const noexcept {
    std::cout << "Place pizza in official PizzaStore box\n";
  }
  void set_name(std::string_view n) noexcept { name = n; }
  [[nodiscard("PIZZA:GET_NAME")]] std::string_view get_name() const noexcept {
    return name;
  }
  friend std::ostream& operator<<(std::ostream& os, const Pizza& p) {
    os << p.get_name();
    if (p.dough) {
      os << ", [dough]: " << p.dough->to_string();
    }
    if (p.sauce) {
      os << ", [sauce]: " << p.sauce->to_string();
    }
    if (p.cheese) {
      os << ", [cheese]: " << p.cheese->to_string();
    }
    if (p.pepperoni) {
      os << ", [pepperoni]: " << p.pepperoni->to_string();
    }
    if (p.clams) {
      os << ", [clams]: " << p.clams->to_string();
    }
    if (!p.veggies.empty()) {
      os << ", [veggies]: ";
      for (const auto& i : p.veggies) {
        std::cout << i->to_string() << ", ";
      }
    }
    return os;
  }
  virtual ~Pizza() = default;
};
class CheesePizza : public Pizza {
  std::unique_ptr<Factory::Ingredients::PizzaIngredientFactory>
      ingredient_factory;

 public:
  explicit CheesePizza(
      std::unique_ptr<Factory::Ingredients::PizzaIngredientFactory> i) {
    ingredient_factory = std::move(i);
  }
  void prepare() noexcept override {
    std::cout << "Preparing " << name << std::endl;
    dough = ingredient_factory->create_dough();
    sauce = ingredient_factory->create_sauce();
    cheese = ingredient_factory->create_cheese();
    pepperoni = ingredient_factory->create_pepperoni();
    veggies = ingredient_factory->create_veggies();
  }
};
class ClamPizza : public Pizza {
  std::unique_ptr<Factory::Ingredients::PizzaIngredientFactory>
      ingredient_factory;

 public:
  explicit ClamPizza(
      std::unique_ptr<Factory::Ingredients::PizzaIngredientFactory> i) {
    ingredient_factory = std::move(i);
  }
  void prepare() noexcept override {
    std::cout << "Preparing " << name << std::endl;
    dough = ingredient_factory->create_dough();
    sauce = ingredient_factory->create_sauce();
    cheese = ingredient_factory->create_cheese();
    clams = ingredient_factory->create_clams();
    veggies = ingredient_factory->create_veggies();
  }
};

}  // namespace Product
namespace Factory {
enum class PizzaType : char { CHEESE, OTHER };
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
};
class ChicagoPizzaIngredientFactory
    : public virtual Ingredients::PizzaIngredientFactory {
 public:
  std::unique_ptr<Ingredients::Dough> create_dough() noexcept override {
    return std::make_unique<Ingredients::ThickCrustDough>();
  }
  std::unique_ptr<Ingredients::Cheese> create_cheese() noexcept override {
    return std::make_unique<Ingredients::MozzarellaCheese>();
  }
  std::unique_ptr<Ingredients::Pepperoni> create_pepperoni() noexcept override {
    return std::make_unique<Ingredients::SlicedPepperoni>();
  }
  std::unique_ptr<Ingredients::Clams> create_clams() noexcept override {
    return std::make_unique<Ingredients::FrozenClams>();
  }
  std::unique_ptr<Ingredients::Sauce> create_sauce() noexcept override {
    return std::make_unique<Ingredients::MarinaraSauce>();
  }
  std::vector<std::unique_ptr<Ingredients::Veggies>> create_veggies() noexcept
      override {
    std::vector<std::unique_ptr<Ingredients::Veggies>> result{};
    result.emplace_back(std::make_unique<Ingredients::BlackOliveVeggie>());
    result.emplace_back(std::make_unique<Ingredients::SpinachVeggie>());
    result.emplace_back(std::make_unique<Ingredients::EggPlantVeggie>());
    return result;
  }
};

class NYPizzaIngredientFactory
    : public virtual Ingredients::PizzaIngredientFactory {
 public:
  std::unique_ptr<Ingredients::Dough> create_dough() noexcept override {
    return std::make_unique<Ingredients::ThinCrustDough>();
  }
  std::unique_ptr<Ingredients::Cheese> create_cheese() noexcept override {
    return std::make_unique<Ingredients::ReggianoCheese>();
  }
  std::unique_ptr<Ingredients::Pepperoni> create_pepperoni() noexcept override {
    return std::make_unique<Ingredients::LungoPepperoni>();
  }
  std::unique_ptr<Ingredients::Clams> create_clams() noexcept override {
    return std::make_unique<Ingredients::FreshClams>();
  }
  std::unique_ptr<Ingredients::Sauce> create_sauce() noexcept override {
    return std::make_unique<Ingredients::PlumTomatoSauce>();
  }
  std::vector<std::unique_ptr<Ingredients::Veggies>> create_veggies() noexcept
      override {
    std::vector<std::unique_ptr<Ingredients::Veggies>> result{};
    result.emplace_back(std::make_unique<Ingredients::GarlicVeggie>());
    result.emplace_back(std::make_unique<Ingredients::OnionVeggie>());
    result.emplace_back(std::make_unique<Ingredients::MushroomVeggie>());
    return result;
  }
};

class ChicagoPizzaStore : public PizzaStore {
 protected:
  std::unique_ptr<Product::Pizza> create_pizza(
      const PizzaType p) noexcept override {
    std::unique_ptr<Product::Pizza> pizza;
    switch (p) {
      case PizzaType::CHEESE:
        pizza = std::make_unique<Product::CheesePizza>(
            std::make_unique<ChicagoPizzaIngredientFactory>());
        pizza->set_name("Chicago Style Cheese Pizza");
        break;
      case PizzaType::OTHER:
        pizza = std::make_unique<Product::ClamPizza>(
            std::make_unique<ChicagoPizzaIngredientFactory>());
        pizza->set_name("Chicago Style Clam Pizza");
        break;
    }
    return pizza;
  }
};

class NYPizzaStore : public PizzaStore {
 protected:
  std::unique_ptr<Product::Pizza> create_pizza(
      const PizzaType p) noexcept override {
    std::unique_ptr<Product::Pizza> pizza;
    switch (p) {
      case PizzaType::CHEESE:
        pizza = std::make_unique<Product::CheesePizza>(
            std::make_unique<NYPizzaIngredientFactory>());
        pizza->set_name("NY Cheese Pizza");
        break;
      case PizzaType::OTHER:
        pizza = std::make_unique<Product::ClamPizza>(
            std::make_unique<NYPizzaIngredientFactory>());
        pizza->set_name("NY Clam Pizza");
        break;
    }
    return pizza;
  }
};

}  // namespace Factory
}  // namespace Creational

int main() {
  using namespace Creational;
  auto ny_store = Factory::NYPizzaStore{};
  auto chicago_store = Factory::ChicagoPizzaStore{};
  auto ny_pizza = ny_store.order_pizza(Factory::PizzaType::CHEESE);
  auto chicago_pizza = chicago_store.order_pizza(Factory::PizzaType::OTHER);
  std::cout << *ny_pizza << std::endl;
  std::cout << *chicago_pizza << std::endl;
}