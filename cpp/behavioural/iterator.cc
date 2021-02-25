#include <algorithm>
#include <iostream>
#include <list>
#include <memory>
#include <string_view>
#include <unordered_map>
#include <utility>
#include <vector>

namespace Behavioural {
namespace Interfaces {
template <typename T>
class Iter {
 public:
  virtual void begin() = 0;
  virtual void next() = 0;
  virtual bool is_done() const = 0;
  virtual const T& item() const = 0;
  virtual ~Iter() = default;
};

template <typename T>
class Aggregate {
 public:
  virtual void add_item(std::string_view n, std::string_view d, bool v,
                        double p) = 0;
  [[nodiscard]] virtual std::unique_ptr<Iter<T>> create_iterator() const = 0;
  virtual ~Aggregate() = default;
};
}  // namespace Interfaces
class MenuItem {
 private:
  std::string_view name, description;
  bool vegetarian;
  double price;

 public:
  MenuItem(std::string_view n, std::string_view d, bool v, double p)
      : name{n}, description{d}, vegetarian{v}, price{p} {
    //
  }
  [[nodiscard]] std::string_view get_name() const noexcept { return name; }
  [[nodiscard]] std::string_view get_description() const noexcept {
    return description;
  }
  [[nodiscard]] bool is_vegetarian() const noexcept { return vegetarian; }
  [[nodiscard]] double get_price() const noexcept { return price; }
  friend std::ostream& operator<<(std::ostream& os, const MenuItem& m) {
    os << m.get_name() << ", ";
    os << m.get_price() << " -- ";
    if (m.is_vegetarian()) {
      os << " (v) ";
    }
    os << m.get_description();
    return os;
  }
};

class CafeMenuIterator : public virtual Interfaces::Iter<MenuItem> {
  using cont = std::unordered_map<std::string_view, MenuItem>;
  using iter = cont::const_iterator;
  cont container;
  iter position;

 public:
  // copy constructor
  explicit CafeMenuIterator(const cont& c) { container = c; }
  void begin() override { position = container.cbegin(); }
  bool is_done() const override { return position == container.cend(); }
  void next() override { ++position; }
  const MenuItem& item() const override { return position->second; }
};

class PancakeHouseMenuIterator : public virtual Interfaces::Iter<MenuItem> {
  using cont = std::list<MenuItem>;
  using iter = cont::const_iterator;
  cont container;
  iter position;

 public:
  // copy constructor
  explicit PancakeHouseMenuIterator(const cont& c) {
    std::copy(c.cbegin(), c.cend(), std::back_inserter(container));
  }
  void begin() override { position = container.cbegin(); }
  [[nodiscard]] bool is_done() const override {
    return position == container.cend();
  }
  void next() override { ++position; }
  [[nodiscard]] const MenuItem& item() const override { return *position; }
};

class DinerMenuIterator : public virtual Interfaces::Iter<MenuItem> {
  using cont = std::vector<MenuItem>;
  using iter = cont::const_iterator;
  cont container;
  iter position;

 public:
  // copy constructor
  explicit DinerMenuIterator(const cont& c) {
    std::copy(c.cbegin(), c.cend(), std::back_inserter(container));
  }
  void begin() override { position = container.cbegin(); }
  [[nodiscard]] bool is_done() const override {
    return position == container.cend();
  }
  void next() override { ++position; }
  [[nodiscard]] const MenuItem& item() const override { return *position; }
};

class CafeAggregateMenu : public virtual Interfaces::Aggregate<MenuItem> {
  std::unordered_map<std::string_view, MenuItem> menu_items;

 public:
  CafeAggregateMenu() : menu_items{} {
    add_item("Veggie Burger and Air Fries",
             "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
             true, 3.99);
    add_item("Soup of the day",
             "A cup of the soup of the day, with a side salad", false, 3.69);
    add_item("Burrito",
             "A large burrito, with whole pinto beans, salsa, guacamole", true,
             4.29);
  }
  void add_item(std::string_view n, std::string_view d, bool v,
                double p) override {
    menu_items.insert(std::make_pair(n, MenuItem{n, d, v, p}));
  }
  [[nodiscard]] std::unique_ptr<Interfaces::Iter<MenuItem>> create_iterator()
      const override {
    return std::make_unique<CafeMenuIterator>(menu_items);
  }
};

class DinerAggregateMenu : public virtual Interfaces::Aggregate<MenuItem> {
  std::vector<MenuItem> menu_items;
  std::size_t cnt;
  static constexpr std::size_t MAX{6};

 public:
  DinerAggregateMenu() : menu_items{}, cnt{0} {
    add_item("Vegetarian BLT",
             "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
    add_item("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
    add_item("Soup of the day", "Soup of the day, with a side of potato salad",
             true, 3.29);
    add_item("Hot dog",
             "A hot dog, with saurkraut, relish, onions, topped with cheese",
             false, 3.05);
  }
  void add_item(std::string_view n, std::string_view d, bool v,
                double p) override {
    if (menu_items.size() < MAX) {
      menu_items.emplace_back(MenuItem{n, d, v, p});
      ++cnt;
      return;
    }
    std::cerr << "Sorry, menu is full! Can't add item to menu\n";
  }
  [[nodiscard]] std::unique_ptr<Interfaces::Iter<MenuItem>> create_iterator()
      const override {
    return std::make_unique<DinerMenuIterator>(menu_items);
  }
  auto begin() {
    auto r = menu_items.cbegin();
    return r;
  }
};
class PancakeHouseAggregateMenu
    : public virtual Interfaces::Aggregate<MenuItem> {
  std::list<MenuItem> menu_items;

 public:
  PancakeHouseAggregateMenu() : menu_items{} {
    add_item("K&B's Pancake Breakfast",
             "Pancakes with scrambled eggs, and toast", true, 2.99);
    add_item("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage",
             false, 2.99);
    add_item("Blueberry Pancakes", "Pancakes made with fresh blueberries", true,
             3.49);
    add_item("Waffles",
             "Waffles, with your choice of blueberries or strawberries", true,
             3.59);
  }
  void add_item(std::string_view n, std::string_view d, bool v,
                double p) override {
    menu_items.emplace_back(MenuItem{n, d, v, p});
  }

  [[nodiscard]] std::unique_ptr<Interfaces::Iter<MenuItem>> create_iterator()
      const override {
    return std::make_unique<PancakeHouseMenuIterator>(menu_items);
  }
};

class Waitress {
 private:
  using cont_ptr = std::unique_ptr<Interfaces::Aggregate<MenuItem>>;
  using iter_ptr = std::unique_ptr<Interfaces::Iter<MenuItem>>;
  cont_ptr pancake, diner, cafe;

  static void print_menu(const iter_ptr& p) {
    for (p->begin(); !p->is_done(); p->next()) {
      std::cout << p->item() << std::endl;
    }
  }

 public:
  Waitress(cont_ptr p, cont_ptr d, cont_ptr c)
      : pancake{std::move(p)}, diner{std::move(d)}, cafe{std::move(c)} {
    //
  }
  void print_menu() const {
    auto pancake_iterator = pancake->create_iterator();
    auto diner_iterator = diner->create_iterator();
    auto cafe_iterator = cafe->create_iterator();
    std::cout << "MENU\n----\nBREAKFAST\n";
    print_menu(pancake_iterator);
    std::cout << "\nLUNCH\n";
    print_menu(diner_iterator);
    std::cout << "\nDINNER\n";
    print_menu(cafe_iterator);
  }
};
}  // namespace Behavioural

int main() {
  using namespace Behavioural;
  Waitress w{std::make_unique<PancakeHouseAggregateMenu>(),
             std::make_unique<DinerAggregateMenu>(),
             std::make_unique<CafeAggregateMenu>()};
  w.print_menu();
}