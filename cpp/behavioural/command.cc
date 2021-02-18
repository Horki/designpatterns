#include <iostream>
#include <memory>

namespace Behavioural {
class Command {
 public:
  virtual void execute() const noexcept = 0;
  virtual ~Command() = default;
};
class Invoker {
 protected:
  std::unique_ptr<Command> command;

 public:
  void set_command(std::unique_ptr<Command> c) noexcept {
    command = std::move(c);
  }
  virtual void run() const noexcept = 0;
  virtual ~Invoker() = default;
};

namespace Button {
class Light {
 public:
  void on() const noexcept { std::cout << "Light is on\n"; }
  void off() const noexcept { std::cout << "Light is off\n"; }
};
class GarageDoor {
 public:
  void up() const noexcept { std::cout << "Garage door is open\n"; }

  void down() const noexcept { std::cout << "Garage door is closed\n"; }

  void stop() const noexcept { std::cout << "Garage door is stopped\n"; }

  void light_on() const noexcept { std::cout << "Garage light is on\n"; }

  void light_off() const noexcept { std::cout << "Garage light is off\n"; }
};
// Invoker
class SimpleRemoteControl : public Invoker {
 public:
  void run() const noexcept { command->execute(); }
};
}  // namespace Button
class GarageDoorCommand : public virtual Command {
  Button::GarageDoor garage_door;

 public:
  explicit GarageDoorCommand(const Button::GarageDoor& g) { garage_door = g; }
  void execute() const noexcept override { garage_door.up(); }
};
class LightOffCommand : public virtual Command {
  Button::Light light;

 public:
  explicit LightOffCommand(const Button::Light& g) { light = g; }
  void execute() const noexcept override { light.off(); }
};
class LightOnCommand : public virtual Command {
  Button::Light light;

 public:
  explicit LightOnCommand(const Button::Light& g) { light = g; }
  void execute() const noexcept override { light.on(); }
};
}  // namespace Behavioural

int main() {
  using namespace Behavioural;
  auto invoker_remote = Button::SimpleRemoteControl{};
  auto light = Button::Light{};
  auto garage_door = Button::GarageDoor{};
  invoker_remote.set_command(std::make_unique<LightOnCommand>(light));
  invoker_remote.run();
  invoker_remote.set_command(std::make_unique<LightOffCommand>(light));
  invoker_remote.run();
  invoker_remote.set_command(std::make_unique<GarageDoorCommand>(garage_door));
  invoker_remote.run();
}
