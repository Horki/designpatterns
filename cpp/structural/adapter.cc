#include <iostream>
#include <memory>

namespace Structural {
namespace Interfaces {
class Duck {
 public:
  virtual void fly() const noexcept = 0;
  virtual void quack() const noexcept = 0;
  virtual ~Duck() = default;
};
class Turkey {
 public:
  virtual void gobble() const noexcept = 0;
  virtual void fly() const noexcept = 0;
  virtual ~Turkey() = default;
};
}  // namespace Interfaces
class MallardDuck : public virtual Interfaces::Duck {
 public:
  void fly() const noexcept override { std::cout << "I'm flying\n"; }
  void quack() const noexcept override { std::cout << "Quack\n"; }
};
class WildTurkey : public virtual Interfaces::Turkey {
 public:
  void gobble() const noexcept override { std::cout << "Gobble gobble\n"; }
  void fly() const noexcept override {
    std::cout << "I'm flying a short distance\n";
  }
};
namespace Adapters {
class DuckAdapter : public virtual Interfaces::Turkey {
  std::unique_ptr<Interfaces::Duck> duck;

 public:
  explicit DuckAdapter(std::unique_ptr<Interfaces::Duck> d) {
    duck = std::move(d);
  }
  DuckAdapter(const DuckAdapter&) = delete;
  DuckAdapter& operator=(const DuckAdapter&) = delete;
  DuckAdapter(DuckAdapter&&) = delete;
  DuckAdapter& operator=(DuckAdapter&&) = delete;
  void gobble() const noexcept override { duck->quack(); }
  void fly() const noexcept override { duck->fly(); }
};
class TurkeyAdapter : public virtual Interfaces::Duck {
  std::unique_ptr<Interfaces::Turkey> turkey;

 public:
  explicit TurkeyAdapter(std::unique_ptr<Interfaces::Turkey> t) {
    turkey = std::move(t);
  }
  TurkeyAdapter(const TurkeyAdapter&) = delete;
  TurkeyAdapter& operator=(const TurkeyAdapter&) = delete;
  TurkeyAdapter(TurkeyAdapter&&) = delete;
  TurkeyAdapter& operator=(TurkeyAdapter&&) = delete;
  void fly() const noexcept override { turkey->fly(); }
  void quack() const noexcept override { turkey->gobble(); }
};

}  // namespace Adapters
}  // namespace Structural

static void run_turkey(const Structural::Interfaces::Turkey&) noexcept;
static void run_duck(const Structural::Interfaces::Duck&) noexcept;

int main() {
  using namespace Structural;
  auto mallard_duck = MallardDuck{};
  auto turkey = WildTurkey{};
  run_turkey(turkey);
  run_duck(mallard_duck);
  auto turkey_duck = Adapters::DuckAdapter(std::make_unique<MallardDuck>());
  auto duck_turkey = Adapters::TurkeyAdapter(std::make_unique<WildTurkey>());
  run_turkey(turkey_duck);
  run_duck(duck_turkey);
}

static void run_turkey(const Structural::Interfaces::Turkey& t) noexcept {
  std::cout << "running turkey interface\n";
  t.gobble();
  t.fly();
}

static void run_duck(const Structural::Interfaces::Duck& d) noexcept {
  std::cout << "running duck interface\n";
  d.fly();
  d.quack();
}