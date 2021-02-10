#include <iostream>
#include <memory>
#include <vector>

namespace Behavioural {
template <typename T>
class Observer {
 public:
  virtual void update(const T &) noexcept = 0;
  virtual ~Observer() = default;
};

template <typename T>
using ObserveContainer = std::vector<std::weak_ptr<Observer<T>>>;

template <typename T>
class Observable {
  ObserveContainer<T> observers;

 public:
  Observable() = default;
  ~Observable() = default;
  Observable(const Observable &) = delete;
  Observable &operator=(const Observable &) = delete;
  Observable(Observable &&) = delete;
  Observable &operator=(Observable &&) = delete;
  void registerObserver(std::weak_ptr<Observer<T>> o) {
    observers.emplace_back(std::move(o));
  }
  // No need for remove observer with weak pointers
  void notifyObservers(const T &source) {
    for (const auto &obs : observers) {
      if (const auto &r = obs.lock()) {
        r->update(source);
      }
    }
  }
};

class WeatherData : public Observable<WeatherData> {
  float temperature, humidity, pressure;

 public:
  WeatherData() : temperature{}, humidity{}, pressure{} {}
  void setMeasurements(float t, float h = .0f, float p = .0f) noexcept {
    temperature = t;
    humidity = h;
    pressure = p;
    notifyObservers(*this);
  }
  [[nodiscard("TEMPERATURE")]] float getTemperature() const noexcept {
    return temperature;
  }
  [[nodiscard("HUMIDITY")]] float getHumidity() const noexcept {
    return humidity;
  }
  [[nodiscard("PRESSURE")]] float getPressure() const noexcept {
    return pressure;
  }
};

class ForecastConditions : public virtual Observer<WeatherData> {
  float current_pressure;

 public:
  ForecastConditions() : current_pressure{29.9f} {}
  void update(const WeatherData &w) noexcept override {
    if (w.getPressure() == current_pressure) {
      std::cout << "More of the same.\n";
    } else if (w.getPressure() < current_pressure) {
      std::cout << "Improving weather on the way!\n";
    } else {
      std::cout << "Watch out for cooler, rainy weather.\n";
    }
    current_pressure = w.getPressure();
  }
};

class CurrentConditions : public virtual Observer<WeatherData> {
 public:
  void update(const WeatherData &w) noexcept override {
    std::cout << "Current conditions: " << w.getTemperature()
              << " F degrees and " << w.getHumidity() << "% humidity\n";
  }
};

class HeatIndex : public virtual Observer<WeatherData> {
 public:
  void update(const WeatherData &w) noexcept override {
    std::cout << "Heat Index: " << compute(w.getTemperature(), w.getHumidity())
              << std::endl;
  }

 private:
  static float compute(const float t, const float h) noexcept {
    return ((16.923f + (0.185'212f * t) + (5.379'41f * h) -
             (0.100'254f * t * h) + (0.009'416'95f * (t * t)) +
             (0.007'288'98f * (h * h)) + (0.000'345'372f * (t * t * h)) -
             (0.000'814'971f * (t * h * h)) +
             (0.000'010'210'2f * (t * t * h * h)) -
             (0.000'038'646f * (t * t * t)) + (0.000'029'158'3f * (h * h * h)) +
             (0.000'001'427'21f * (t * t * t * h)) +
             (0.000'000'197'483f * (t * h * h * h)) -
             (0.000'000'021'842'9f * (t * t * t * h * h)) +
             0.000'000'000'843'296f * (t * t * h * h * h)) -
            (0.000'000'000'048'197'5f * (t * t * t * h * h * h)));
  }
};
}  // namespace Behavioural

int main() {
  using namespace Behavioural;
  WeatherData publisher;
  auto subscriber1 = std::make_shared<CurrentConditions>();
  publisher.registerObserver(subscriber1);

  auto subscriber2 = std::make_shared<HeatIndex>();
  publisher.registerObserver(subscriber2);
  publisher.setMeasurements(80.f, 65.f, 30.4f);
  auto subscriber3 = std::make_shared<ForecastConditions>();
  publisher.registerObserver(subscriber3);
  publisher.setMeasurements(82.f, 70.f, 29.2f);
  // unsubscribe Heat Index
  subscriber2.reset();
  publisher.setMeasurements(78.f, 90.f, 29.2f);
}