#include <iostream>
#include <memory>

namespace Structural {
class Beverage {
 protected:
  std::string description;

 public:
  [[nodiscard("DESCRIPTION")]] virtual std::string get_description()
      const noexcept {
    return description;
  }
  [[nodiscard("COST")]] virtual constexpr double get_cost() const noexcept = 0;
  friend std::ostream &operator<<(std::ostream &os, const Beverage &b) {
    return os << b.get_description() << " " << b.get_cost() << "$";
  }
  virtual ~Beverage() = default;
};

template <typename T,
          typename = std::enable_if_t<std::is_base_of_v<Beverage, T>>>
class CondimentDecorator : public T {
 protected:
  std::unique_ptr<T> b;

 public:
  explicit CondimentDecorator(std::unique_ptr<Beverage> p) : b{std::move(p)} {}
};

namespace Beverages {
class HouseBlend : public Beverage {
 public:
  HouseBlend() { description = "House Blend"; }
  [[nodiscard("HOUSE BLEND")]] constexpr double get_cost()
      const noexcept override {
    return .89;
  }
};

class DarkRoast : public Beverage {
 public:
  DarkRoast() { description = "Dark Roast"; }
  [[nodiscard("DARK ROAST")]] constexpr double get_cost()
      const noexcept override {
    return .99;
  }
};

class Decaf : public Beverage {
 public:
  Decaf() { description = "Decaf"; }
  [[nodiscard("DECAF")]] constexpr double get_cost() const noexcept override {
    return 1.05;
  }
};

class Espresso : public Beverage {
 public:
  Espresso() { description = "Espresso"; }
  [[nodiscard("ESPRESSO")]] constexpr double get_cost()
      const noexcept override {
    return 1.99;
  }
};
}  // namespace Beverages

namespace Condiments {
class Mocha : public CondimentDecorator<Beverage> {
 public:
  explicit Mocha(std::unique_ptr<Beverage> b)
      : CondimentDecorator(std::move(b)) {}
  [[nodiscard("MOCHA DESCRIPTION")]] std::string get_description()
      const noexcept override {
    return b->get_description() + ", Mocha";
  }
  [[nodiscard("MOCHA COST")]] constexpr double get_cost()
      const noexcept override {
    return b->get_cost() + 0.2;
  }
};

class Soy : public CondimentDecorator<Beverage> {
 public:
  explicit Soy(std::unique_ptr<Beverage> b)
      : CondimentDecorator(std::move(b)) {}
  [[nodiscard("SOY DESCRIPTION")]] std::string get_description()
      const noexcept override {
    return b->get_description() + ", Soy";
  }
  [[nodiscard("SOY COST")]] constexpr double get_cost()
      const noexcept override {
    return b->get_cost() + 0.15;
  }
};

class SteamMilk : public CondimentDecorator<Beverage> {
 public:
  explicit SteamMilk(std::unique_ptr<Beverage> b)
      : CondimentDecorator(std::move(b)) {}
  [[nodiscard("STEM MILK DESCRIPTION")]] std::string get_description()
      const noexcept override {
    return b->get_description() + ", Steamed milk";
  }
  [[nodiscard("STEM MILK COST")]] constexpr double get_cost()
      const noexcept override {
    return b->get_cost() + 0.1;
  }
};

class Whip : public CondimentDecorator<Beverage> {
 public:
  explicit Whip(std::unique_ptr<Beverage> b)
      : CondimentDecorator(std::move(b)) {}
  [[nodiscard("WHIP DESCRIPTION")]] std::string get_description()
      const noexcept override {
    return b->get_description() + ", Whip";
  }
  [[nodiscard("WHIP COST")]] constexpr double get_cost()
      const noexcept override {
    return b->get_cost() + 0.1;
  }
};
}  // namespace Condiments
}  // namespace Structural

int main() {
  using namespace Structural;
  auto p = std::make_unique<Condiments::Whip>(
      std::make_unique<Condiments::Mocha>(std::make_unique<Condiments::Soy>(
          std::make_unique<Condiments::SteamMilk>(
              std::make_unique<Beverages::HouseBlend>()))));
  std::cout << *p << std::endl;
  auto house_blend_whip = std::make_unique<Condiments::Whip>(
      std::make_unique<Beverages::HouseBlend>());
  auto dark_roast_mocha = std::make_unique<Condiments::Mocha>(
      std::make_unique<Beverages::DarkRoast>());
  auto decaf_soy =
      std::make_unique<Condiments::Soy>(std::make_unique<Beverages::Decaf>());
  auto espresso_steam = std::make_unique<Condiments::SteamMilk>(
      std::make_unique<Beverages::Espresso>());
  std::cout << *house_blend_whip << std::endl;
  std::cout << *dark_roast_mocha << std::endl;
  std::cout << *decaf_soy << std::endl;
  std::cout << *espresso_steam << std::endl;
}
