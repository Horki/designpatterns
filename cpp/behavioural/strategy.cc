#include <iostream>
#include <memory>

namespace Behavioural {
namespace Interface {
class Fly {
 public:
  virtual void fly() const noexcept = 0;

  virtual ~Fly() = default;
};

class Quack {
 public:
  virtual void quack() const noexcept = 0;

  virtual ~Quack() = default;
};
}  // namespace Interface

namespace Implementation {
class FlyHigh : public virtual Interface::Fly {
 public:
  void fly() const noexcept override { std::cout << "Flying High\n"; }
};

class FlyLow : public virtual Interface::Fly {
 public:
  void fly() const noexcept override { std::cout << "Flying Low\n"; }
};

class FlyRocket : public virtual Interface::Fly {
 public:
  void fly() const noexcept override { std::cout << "Fly with Rocket\n"; }
};

class QuackLoud : public virtual Interface::Quack {
 public:
  void quack() const noexcept override { std::cout << "Quack Loud\n"; }
};

class QuackMute : public virtual Interface::Quack {
 public:
  void quack() const noexcept override { std::cout << "Quack Mute\n"; }
};
}  // namespace Implementation

namespace Abstract {
class Duck {
 protected:
  std::unique_ptr<Interface::Fly> runFly;
  std::unique_ptr<Interface::Quack> runQuack;

 public:
  virtual ~Duck() = default;

  void performFly() const noexcept { runFly->fly(); }

  void setFly(std::unique_ptr<Interface::Fly> f) noexcept {
    //    std::swap(runFly, f);
    runFly = std::move(f);
  }

  void setQuack(std::unique_ptr<Interface::Quack> q) noexcept {
    //    std::swap(runQuack, q);
    runQuack = std::move(q);
  }

  void performQuack() const noexcept { runQuack->quack(); }

  virtual void display() const noexcept = 0;

  void swim() const noexcept { std::cout << "all ducks swim\n"; }
};
}  // namespace Abstract

class MallardDuck : public Abstract::Duck {
 public:
  MallardDuck() {
    runFly = std::make_unique<Implementation::FlyHigh>();
    runQuack = std::make_unique<Implementation::QuackMute>();
  }

  void display() const noexcept override { std::cout << "mallard runs\n"; }
};

class RedDuck : public Abstract::Duck {
 public:
  RedDuck() {
    runFly = std::make_unique<Implementation::FlyLow>();
    runQuack = std::make_unique<Implementation::QuackLoud>();
  }

  void display() const noexcept override { std::cout << "red runs\n"; }
};
}  // namespace Behavioural

void run(const Behavioural::Abstract::Duck &d) noexcept {
  std::cout << "=================\n";
  d.display();
  d.performFly();
  d.performQuack();
  d.swim();
  std::cout << "=================\n";
}

int main() {
  using namespace Behavioural;
  MallardDuck mallard;
  RedDuck redhead;
  run(mallard);
  run(redhead);
  mallard.setFly(std::make_unique<Implementation::FlyRocket>());
  mallard.setQuack(std::make_unique<Implementation::QuackLoud>());
  run(mallard);
}