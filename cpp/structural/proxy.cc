#include <iostream>
#include <memory>
#include <stdexcept>
#include <string_view>
#include <unordered_map>

namespace Structural {
namespace ProtectionProxy {
class PersonBean {
 public:
  [[nodiscard]] virtual std::string_view get_name() const noexcept = 0;
  [[nodiscard]] virtual std::string_view get_gender() const noexcept = 0;
  [[nodiscard]] virtual std::string_view get_interest() const noexcept = 0;
  [[nodiscard]] virtual std::size_t get_hot_or_not_rating() const = 0;
  virtual void set_name(std::string_view) = 0;
  virtual void set_gender(std::string_view) = 0;
  virtual void set_interest(std::string_view) = 0;
  virtual void set_hot_or_not_rating(const std::size_t) = 0;
  virtual ~PersonBean() = default;
};
class Person : public virtual PersonBean {
  std::string_view name, gender, interest;
  std::size_t rating, rating_cnt;

 public:
  Person() : rating{0}, rating_cnt{0} {}
  [[nodiscard]] std::string_view get_name() const noexcept override {
    return name;
  }
  [[nodiscard]] std::string_view get_gender() const noexcept override {
    return gender;
  }
  [[nodiscard]] std::string_view get_interest() const noexcept override {
    return interest;
  }
  [[nodiscard]] std::size_t get_hot_or_not_rating() const override {
    if (rating_cnt == 0) {
      return rating;
    }
    return static_cast<std::size_t>(rating / rating_cnt);
  }
  void set_name(std::string_view n) override { name = n; }
  void set_gender(std::string_view g) override { gender = g; }
  void set_interest(std::string_view i) override { interest = i; }
  void set_hot_or_not_rating(const std::size_t r) override {
    rating += r;
    ++rating_cnt;
  }
};
class OwnerInvocationHandler : public virtual PersonBean {
  std::unique_ptr<PersonBean> person;

 public:
  explicit OwnerInvocationHandler(std::unique_ptr<PersonBean> p)
      : person{std::move(p)} {
    //
  }
  [[nodiscard]] std::string_view get_name() const noexcept override {
    return person->get_name();
  }
  [[nodiscard]] std::string_view get_gender() const noexcept override {
    return person->get_gender();
  }
  [[nodiscard]] std::string_view get_interest() const noexcept override {
    return person->get_interest();
  }
  [[nodiscard]] std::size_t get_hot_or_not_rating() const override {
    return person->get_hot_or_not_rating();
  }
  void set_name(std::string_view n) noexcept override { person->set_name(n); }
  void set_gender(std::string_view g) noexcept override {
    person->set_gender(g);
  }
  void set_interest(std::string_view i) noexcept override {
    person->set_interest(i);
  }
  void set_hot_or_not_rating(const std::size_t r) override {
    std::cerr << r << std::endl;
    throw std::runtime_error{"Can't access set Hot or Not!"};
  }
};
class NonOwnerInvocationHandler : public virtual PersonBean {
  std::unique_ptr<PersonBean> person;

 public:
  explicit NonOwnerInvocationHandler(std::unique_ptr<PersonBean> p)
      : person{std::move(p)} {
    //
  }
  [[nodiscard]] std::string_view get_name() const noexcept override {
    return person->get_name();
  }
  [[nodiscard]] std::string_view get_gender() const noexcept override {
    return person->get_gender();
  }
  [[nodiscard]] std::string_view get_interest() const noexcept override {
    return person->get_interest();
  }
  [[nodiscard]] std::size_t get_hot_or_not_rating() const override {
    return person->get_hot_or_not_rating();
  }
  void set_name(std::string_view n) override {
    std::cerr << n << std::endl;
    throw std::runtime_error{"Can't access set name"};
  }
  void set_gender(std::string_view g) override {
    std::cerr << g << std::endl;
    throw std::runtime_error{"Can't access set gender"};
  }
  void set_interest(std::string_view i) override {
    std::cerr << i << std::endl;
    throw std::runtime_error{"Can't access set interest"};
  }
  void set_hot_or_not_rating(const std::size_t r) override {
    person->set_hot_or_not_rating(r);
  }
};
}  // namespace ProtectionProxy
namespace VirtualProxy {
class ImageProxy {
 public:
  virtual void draw() const noexcept = 0;
  [[nodiscard]] virtual std::optional<std::size_t> get_height()
      const noexcept = 0;
  [[nodiscard]] virtual std::optional<std::size_t> get_width()
      const noexcept = 0;
  virtual ~ImageProxy() = default;
};
class Jpg : public virtual ImageProxy {
  std::string_view img;

 public:
  explicit Jpg(std::string_view path) : img{path} {}
  void draw() const noexcept override {
    std::cout << "JPG: " << img << ".jpg" << std::endl;
  }
  [[nodiscard]] std::optional<std::size_t> get_height()
      const noexcept override {
    if (img.length() < 3) {
      return {};
    }
    return 420;
  }
  [[nodiscard]] std::optional<std::size_t> get_width() const noexcept override {
    if (img.length() < 3) {
      return {};
    }
    return 620;
  }
};
class Png : public virtual ImageProxy {
  std::string_view img;

 public:
  explicit Png(std::string_view path) : img{path} {}
  void draw() const noexcept override {
    std::cout << "PNG: " << img << ".png" << std::endl;
  }
  [[nodiscard]] std::optional<std::size_t> get_height()
      const noexcept override {
    if (img.length() < 2) {
      return {};
    }
    return 620;
  }
  [[nodiscard]] std::optional<std::size_t> get_width() const noexcept override {
    if (img.length() < 2) {
      return {};
    }
    return 420;
  }
};

}  // namespace VirtualProxy
}  // namespace Structural

void run_protection_proxy() {
  using namespace Structural::ProtectionProxy;
  using map = std::unordered_map<std::string_view, Person>;
  std::cout << "Protection Proxy example\n";
  auto init_db = [](map& m) -> void {
    // Joe
    auto joe = Person{};
    joe.set_name("Joe Cppbean");
    joe.set_interest("cars, computers, music");
    joe.set_hot_or_not_rating(7);
    m.insert(std::make_pair(joe.get_name(), std::move(joe)));
    // Kelly
    auto kelly = Person{};
    kelly.set_name("Kelly Klosure");
    kelly.set_interest("ebay, movies, music");
    kelly.set_hot_or_not_rating(6);
    m.insert(std::make_pair(kelly.get_name(), std::move(kelly)));
  };
  map m{};
  init_db(m);
  auto i_joe = m.find("Joe Cppbean");
  auto i_kelly = m.find("Kelly Klosure");
  // copy
  auto unique_joe = std::unique_ptr<PersonBean>(new Person(i_joe->second));
  // copy
  auto unique_kelly = std::unique_ptr<PersonBean>(new Person(i_kelly->second));
  try {
    OwnerInvocationHandler o(std::move(unique_joe));
    std::cout << "name is " << o.get_name() << std::endl;
    o.set_interest("bowling, go");
    std::cout << "Interests set from owner proxy: " << o.get_interest()
              << std::endl;
    // throws error
    o.set_hot_or_not_rating(10);
  } catch (const std::runtime_error& e) {
    std::cerr << "owner proxy: " << e.what() << std::endl;
  }
  try {
    NonOwnerInvocationHandler no(std::move(unique_kelly));
    std::cout << "name is " << no.get_name() << std::endl;
    // throws error
    no.set_interest("bowling, go");
  } catch (const std::runtime_error& e) {
    std::cerr << "non-owner proxy: " << e.what() << std::endl;
  }
}

void run_virtual_proxy() {
  using namespace Structural::VirtualProxy;
  std::cout << "Virtual Proxy\n";
  std::unique_ptr<ImageProxy> jpg = std::make_unique<Jpg>("aphex");
  std::unique_ptr<ImageProxy> png = std::make_unique<Png>("other");
  jpg->draw();
  if (auto w = jpg->get_width()) {
    std::cout << "\njpg width = " << *w << std::endl;
  }
  png->draw();
  if (auto h = jpg->get_height()) {
    std::cout << "\npng height = " << *h << std::endl;
  }
}

int main() {
  run_protection_proxy();
  run_virtual_proxy();
}