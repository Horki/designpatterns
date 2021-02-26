#include <chrono>
#include <cstdlib>
#include <iostream>
#include <memory>
#include <string_view>

namespace Behavioural {
enum class States : char {
  HAS_QUARTER,
  NO_QUARTER,
  SOLD_OUT,
  SOLD,
  WINNER,
};

class State {
 public:
  virtual void insert() = 0;
  virtual void eject() = 0;
  virtual void turn_crank() = 0;
  virtual void dispense() = 0;
  virtual void refill() = 0;
  virtual void print() const noexcept = 0;
  virtual ~State() = default;
};

class GumballMachine {
 private:
  std::unique_ptr<State> state;
  unsigned count;

 public:
  explicit GumballMachine(unsigned c);
  void insert() { state->insert(); }
  void eject() { state->eject(); }
  void turn_crank() {
    state->turn_crank();
    state->dispense();
  }
  void set_state(const States);
  void release_ball() {
    std::cout << "A gumball comes rolling out the slot...\n";
    if (count > 0) {
      --count;
    }
  }
  std::size_t get_count() const noexcept { return count; }
  void refill(const std::size_t c) {
    count += c;
    std::cout << "The gumball machine was just refilled; its new count is: "
              << count << std::endl;
    state->refill();
  }
  friend std::ostream& operator<<(std::ostream& os, const GumballMachine& g) {
    os << "\nMighty Gumball, Inc.\n";
    os << "C++-enabled Standing Gumball Model #2021\n";
    os << "Inventory " << g.get_count() << " gumball";
    if (g.get_count() != 1) {
      os << "s";
    }
    os << "\nMachine is: ";
    g.state->print();
    return os;
  }
};

class HasQuarterState : public virtual State {
  GumballMachine* gumball_machine;

 public:
  explicit HasQuarterState(GumballMachine* g) : gumball_machine{g} {}
  void insert() override { std::cout << "You can't insert another quarter\n"; }
  void eject() override {
    std::cout << "Quarter returned\n";
    gumball_machine->set_state(States::NO_QUARTER);
  }
  void turn_crank() override {
    std::cout << "You turned...\n";
    std::srand(std::time(0));
    std::size_t winner = static_cast<std::size_t>(std::rand()) % 10;
    if ((winner == 0) && (gumball_machine->get_count() > 1)) {
      gumball_machine->set_state(States::WINNER);
    } else {
      gumball_machine->set_state(States::SOLD);
    }
  }
  void dispense() override { std::cout << "No gumball dispensed\n"; }
  void refill() override {}
  void print() const noexcept override {
    std::cout << "Waiting for turn of Crank";
  }
};

class NoQuarterState : public virtual State {
  GumballMachine* gumball_machine;

 public:
  explicit NoQuarterState(GumballMachine* g) : gumball_machine{g} {}
  void insert() override {
    std::cout << "You inserted a quarter\n";
    gumball_machine->set_state(States::HAS_QUARTER);
  }
  void eject() override { std::cout << "You haven't inserted a quarter\n"; }
  void turn_crank() override {
    std::cout << "You turned, but there's no quarter\n";
  }
  void dispense() override { std::cout << "You need to pay first\n"; }
  void refill() override {}
  void print() const noexcept override { std::cout << "Waiting for a Quarter"; }
};

class SoldState : public virtual State {
  GumballMachine* gumball_machine;
  std::string_view n;

 public:
  explicit SoldState(GumballMachine* g)
      : gumball_machine{g}, n{"Dispensing a Gumball"} {}
  void insert() override {
    std::cout << "Please wait, we're already giving you a gumball\n";
  }
  void eject() override {
    std::cout << "Sorry, you already turned the crank\n";
  }
  void turn_crank() override {
    std::cout << "Turning twice doesn't get you another gumball!\n";
  }
  void dispense() override {
    gumball_machine->release_ball();
    if (gumball_machine->get_count() > 0) {
      gumball_machine->set_state(States::NO_QUARTER);
    } else {
      std::cout << "Oops, out of gumballs!\n";
      gumball_machine->set_state(States::SOLD_OUT);
    }
  }
  void refill() override {}
  void print() const noexcept override { std::cout << "Waiting for a Quarter"; }
};

class SoldOutState : public virtual State {
  GumballMachine* gumball_machine;

 public:
  explicit SoldOutState(GumballMachine* g) : gumball_machine{g} {}
  void insert() override {
    std::cout << "You can't insert a quarter, the machine is sold out\n";
  }
  void eject() override {
    std::cout << "You can't eject, you haven't inserted a quarter yet\n";
  }
  void turn_crank() override {
    std::cout << "You turned, but there are no gumballs\n";
  }
  void dispense() override { std::cout << "No gumball dispensed\n"; }
  void refill() override { gumball_machine->set_state(States::NO_QUARTER); }
  void print() const noexcept override { std::cout << "Sold Out"; }
};

class WinnerState : public virtual State {
  GumballMachine* gumball_machine;

 public:
  explicit WinnerState(GumballMachine* g) : gumball_machine{g} {}
  void insert() override {
    std::cout << "Please wait, we're already giving you a Gumball\n";
  }
  void eject() override {
    std::cout << "Please wait, we're already giving you a Gumball\n";
  }
  void turn_crank() override {
    std::cout << "Turning again doesn't get you another gumball!\n";
  }
  void dispense() override {
    gumball_machine->release_ball();
    if (gumball_machine->get_count() == 0) {
      gumball_machine->set_state(States::SOLD_OUT);
    } else {
      gumball_machine->release_ball();
      std::cout << "YOU'RE A WINNER! You got two gumballs for your quarter\n";
      if (gumball_machine->get_count() > 0) {
        gumball_machine->set_state(States::NO_QUARTER);
      } else {
        std::cout << "Oops, out of gumballs!\n";
        gumball_machine->set_state(States::SOLD_OUT);
      }
    }
  }
  void refill() override {}
  void print() const noexcept override {
    std::cout
        << "Dispensing two gumballs for your quarter, because YOU'RE A WINNER!";
  }
};

GumballMachine::GumballMachine(unsigned c)
    : state{std::make_unique<SoldState>(this)}, count{c} {}

// TODO: make this better!
void GumballMachine::set_state(const States s) {
  switch (s) {
    case States::HAS_QUARTER:
      state = std::make_unique<HasQuarterState>(this);
      break;
    case States::SOLD:
      state = std::make_unique<SoldState>(this);
      break;
    case States::NO_QUARTER:
      state = std::make_unique<NoQuarterState>(this);
      break;
    case States::SOLD_OUT:
      state = std::make_unique<SoldOutState>(this);
      break;
    case States::WINNER:
      state = std::make_unique<WinnerState>(this);
      break;
  }
}
}  // namespace Behavioural

int main() {
  using namespace Behavioural;
  GumballMachine gumball_machine = GumballMachine{5};
  std::cout << gumball_machine << std::endl;

  for (std::size_t i{0}; i < 5; ++i) {
    gumball_machine.insert();
    gumball_machine.turn_crank();
    gumball_machine.insert();
    gumball_machine.turn_crank();
    std::cout << gumball_machine << std::endl;
  }
}