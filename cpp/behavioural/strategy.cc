#include <iostream>
#include <string>
#include <memory>

namespace Behavioural {
namespace Interface {
class Fly {
 public:
  virtual void fly() const = 0;

  virtual ~Fly() = default;
};

class Quack {
 public:
  virtual void quack() const = 0;

  virtual ~Quack() = default;
};
}

namespace Implementation {
class FlyHigh : public virtual Interface::Fly {
 public:
  void fly() const override {
    std::cout << "fly high\n";
  }
};

class QuackHigh : public virtual Interface::Quack {
 public:
  void quack() const override {
    std::cout << "quack high\n";
  }
};

class QuackLow : public virtual Interface::Quack {
 public:
  void quack() const override {
    std::cout << "quack low\n";
  }
};
}

namespace Abstract {
class Duck {
 protected:
  std::unique_ptr<Interface::Fly> runFly;
  std::unique_ptr<Interface::Quack> runQuack;
 public:
  virtual ~Duck() = default;

  void doFly() const {
    runFly->fly();
  }

  void setFly(std::unique_ptr<Interface::Fly> f) {
    runFly = std::move(f);
  }

  void setQuack(std::unique_ptr<Interface::Quack> q) {
    runQuack = std::move(q);
  }

  void doQuack() const {
    runQuack->quack();
  }

  virtual void run() const = 0;

  static void swim() {
    std::cout << " all ducks swim\n";
  }
};
}

class MallordDuck : public Abstract::Duck {
 public:
  MallordDuck() {
    runFly = std::make_unique<Implementation::FlyHigh>();
    runQuack = std::make_unique<Implementation::QuackHigh>();
  }

  void run() const override {
    std::cout << "mallord runs\n";
  }
};

class RedDuck : public Abstract::Duck {
 public:
  RedDuck() {
    runFly = std::make_unique<Implementation::FlyHigh>();
    runQuack = std::make_unique<Implementation::QuackHigh>();
  }

  void run() const override {
    std::cout << "red runs\n";
  }
};
}

void run(const Behavioural::Abstract::Duck &d) {
  d.run();
  d.doFly();
  d.swim();
  d.doQuack();
}

int main() {
  Behavioural::MallordDuck d;
  Behavioural::RedDuck r;
  run(d);
  run(r);
  r.setQuack(std::make_unique<Behavioural::Implementation::QuackLow>());
  run(r);
}