#include <cctype>
#include <iostream>
#include <string_view>

namespace Behavioural {
namespace Abstract {
class CaffeineBeverage {
 protected:
  std::string_view description;
  virtual void brew() const noexcept = 0;
  virtual void add_condiments() const noexcept = 0;
  [[nodiscard]] virtual bool costumer_wants_condiments() const noexcept {
    return true;
  }
  void boil_water() const noexcept {
    std::cout << "Boil some Water for: " << description << std::endl;
  }
  void pour() const noexcept {
    std::cout << "Pour: " << description << " in boiling water\n";
  }

 public:
  void prepare() const noexcept {
    boil_water();
    brew();
    pour();
    if (costumer_wants_condiments()) {
      add_condiments();
    }
  }
  virtual ~CaffeineBeverage() = default;
};
}  // namespace Abstract
namespace TemplateMethods {
class Tea : public Abstract::CaffeineBeverage {
 protected:
  void brew() const noexcept override { std::cout << "Stepping the tea\n"; }
  void add_condiments() const noexcept override {
    std::cout << "Adding Lemon\n";
  }

 public:
  Tea() { description = "tea"; }
};
class CoffeeWithHook : public Abstract::CaffeineBeverage {
 protected:
  void brew() const noexcept override {
    std::cout << "Dripping Coffee through filter\n";
  }
  void add_condiments() const noexcept override {
    std::cout << "Adding Sugar and Milk\n";
  }
  [[nodiscard]] bool costumer_wants_condiments() const noexcept override {
    std::cout << "Would you like milk and sugar with coffee? [y]es/no ";
    std::string s;
    std::cin >> s;
    if (tolower(s.at(0)) == 'y') {
      return true;
    }
    return false;
  }

 public:
  CoffeeWithHook() { description = "coffee"; }
};
}  // namespace TemplateMethods
}  // namespace Behavioural

static void run(const Behavioural::Abstract::CaffeineBeverage &) noexcept;

int main() {
  using namespace Behavioural;

  auto tea = TemplateMethods::Tea{};
  auto coffee = TemplateMethods::CoffeeWithHook{};
  run(tea);
  run(coffee);
}

static void run(const Behavioural::Abstract::CaffeineBeverage &c) noexcept {
  c.prepare();
}