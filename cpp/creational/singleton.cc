#include <iostream>
#include <mutex>
#include <thread>
#include <vector>

namespace Creational {
namespace ThreadUnsafe {
class ChocolateBoiler {
 private:
  bool empty, boiled;
  static ChocolateBoiler* unique_instance;
  ChocolateBoiler() : empty{true}, boiled{false} {}

 public:
  // no copy
  ChocolateBoiler(const ChocolateBoiler&) = delete;
  ChocolateBoiler& operator=(const ChocolateBoiler&) = delete;
  // no move
  ChocolateBoiler(ChocolateBoiler&&) = delete;
  ChocolateBoiler& operator=(ChocolateBoiler&&) = delete;
  // RAII
  ~ChocolateBoiler() = default;
  static ChocolateBoiler* get_singleton() noexcept {
    if (unique_instance == nullptr) {
      std::cout << "creating instance\n";
      unique_instance = new ChocolateBoiler{};
    }
    return unique_instance;
  }
  [[nodiscard]] bool is_empty() const noexcept { return empty; }
  [[nodiscard]] bool is_boiled() const noexcept { return boiled; }
  void fill() noexcept {
    if (is_empty()) {
      empty = false;
      boiled = false;
    }
  }
  [[maybe_unused]] void drain() noexcept {
    if (!is_empty() && is_boiled()) {
      empty = true;
    }
  }
  void boil() noexcept {
    if (!is_empty() && !is_boiled()) {
      boiled = true;
    }
  }
};
ChocolateBoiler* ChocolateBoiler::unique_instance = nullptr;
}  // namespace ThreadUnsafe
namespace ThreadSafe {
class ChocolateBoiler {
 private:
  bool empty, boiled;
  ChocolateBoiler() : empty{true}, boiled{false} {}

 public:
  // no copy
  ChocolateBoiler(const ChocolateBoiler&) = delete;
  ChocolateBoiler& operator=(const ChocolateBoiler&) = delete;
  // no move
  ChocolateBoiler(ChocolateBoiler&&) = delete;
  ChocolateBoiler& operator=(ChocolateBoiler&&) = delete;
  // RAII
  ~ChocolateBoiler() = default;
  static ChocolateBoiler* get_singleton() noexcept {
    static auto* unique_instance = new ChocolateBoiler{};
    return unique_instance;
  }
  [[nodiscard]] bool is_empty() const noexcept { return empty; }
  [[nodiscard]] bool is_boiled() const noexcept { return boiled; }
  void fill() noexcept {
    if (is_empty()) {
      empty = false;
      boiled = false;
    }
  }
  [[maybe_unused]] void drain() noexcept {
    if (!is_empty() && is_boiled()) {
      empty = true;
    }
  }
  void boil() noexcept {
    if (!is_empty() && !is_boiled()) {
      boiled = true;
    }
  }
};
}  // namespace ThreadSafe
}  // namespace Creational

int main() {
  // Not a real-life example, for educational purposes only!
  using namespace Creational;
  std::mutex mut;
  std::vector<std::thread> threads_unsafe;
  std::cout << "Thread unsafe singleton:\n";
  auto unsafe_sing = ThreadUnsafe::ChocolateBoiler::get_singleton();
  std::cout << "unsafe singleton: [" << unsafe_sing << "]\n";

  threads_unsafe.emplace_back(std::thread([&mut]() {
    std::lock_guard<std::mutex> lck{mut};
    auto singleton = ThreadUnsafe::ChocolateBoiler::get_singleton();
    singleton->fill();
    singleton->boil();
    std::cout << "[unsafe thread1] Is Boiled: " << singleton->is_boiled()
              << ", is empty: " << singleton->is_empty() << " [" << singleton
              << "]\n";
  }));

  threads_unsafe.emplace_back(std::thread([&mut]() {
    std::lock_guard<std::mutex> lck{mut};
    auto singleton = ThreadUnsafe::ChocolateBoiler::get_singleton();
    std::cout << "[unsafe thread2] Is Boiled: " << singleton->is_boiled()
              << ", is empty: " << singleton->is_empty() << " [" << singleton
              << "]\n";
  }));

  for (auto& t : threads_unsafe) {
    t.join();
  }

  std::vector<std::thread> threads_safe;
  std::cout << "Thread safe singleton:\n";
  auto sing = ThreadSafe::ChocolateBoiler::get_singleton();
  std::cout << "safe singleton: [" << sing << "]\n";

  threads_safe.emplace_back(std::thread([&mut]() {
    std::lock_guard<std::mutex> lck{mut};
    auto singleton = ThreadSafe::ChocolateBoiler::get_singleton();
    singleton->fill();
    singleton->boil();
    std::cout << "[safe thread1] Is Boiled: " << singleton->is_boiled()
              << ", is empty: " << singleton->is_empty() << " [" << singleton
              << "]\n";
  }));

  threads_safe.emplace_back(std::thread([&mut]() {
    std::lock_guard<std::mutex> lck{mut};
    auto singleton = ThreadSafe::ChocolateBoiler::get_singleton();
    std::cout << "[safe thread2] Is Boiled: " << singleton->is_boiled()
              << ", is empty: " << singleton->is_empty() << " [" << singleton
              << "]\n";
  }));

  for (auto& t : threads_safe) {
    t.join();
  }
}
