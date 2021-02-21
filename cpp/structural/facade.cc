#include <iostream>
#include <string_view>

namespace Structural {
namespace Items {
class TheatreLights {
  unsigned short level;
  std::string_view description;

 public:
  explicit TheatreLights(std::string_view d) : level{0}, description{d} {}
  void on() const noexcept { std::cout << description << " on\n"; }
  void off() const noexcept { std::cout << description << " off\n"; }
  [[nodiscard]] unsigned short get_level() const noexcept { return level; }
  void dim(const unsigned short l) noexcept {
    level = l % 100;
    std::cout << *this << std::endl;
  }
  friend std::ostream& operator<<(std::ostream& os, const TheatreLights& t) {
    return os << t.description << ", dimming to: " << t.level << "%";
  }
};
class Screen {
  std::string_view description;

 public:
  explicit Screen(std::string_view d) : description{d} {}
  void up() const noexcept { std::cout << *this << " going up\n"; }
  void down() const noexcept { std::cout << *this << " going down\n"; }
  friend std::ostream& operator<<(std::ostream& os, const Screen& s) {
    return os << s.description;
  }
};
class PopcornPopper {
  std::string_view description;

 public:
  explicit PopcornPopper(std::string_view d) : description{d} {}
  void on() const noexcept { std::cout << *this << " on\n"; }
  void off() const noexcept { std::cout << *this << " off\n"; }
  void pop() const noexcept { std::cout << *this << " popping popcorn!\n"; }
  friend std::ostream& operator<<(std::ostream& os, const PopcornPopper& s) {
    return os << s.description;
  }
};
class DvdPlayer {
  std::string_view description;

 public:
  explicit DvdPlayer(std::string_view d) : description{d} {}
  void on() const noexcept { std::cout << *this << " on\n"; }
  void off() const noexcept { std::cout << *this << " off\n"; }
  void eject() const noexcept { std::cout << *this << " eject\n"; }
  void play(std::string_view movie) const noexcept {
    std::cout << *this << " playing: " << movie << std::endl;
  }
  void stop() const noexcept { std::cout << *this << " stopped\n"; }
  void pause() const noexcept { std::cout << *this << " paused\n"; }

  friend std::ostream& operator<<(std::ostream& os, const DvdPlayer& d) {
    return os << d.description;
  }
};
class Projector {
  std::string_view description;

 public:
  explicit Projector(std::string_view d) : description{d} {}
  void on() const noexcept { std::cout << *this << " on\n"; }
  void off() const noexcept { std::cout << *this << " off\n"; }
  void wide_screen_mode() const noexcept {
    std::cout << *this << " in widescreen mode (16x9 aspect ratio)\n";
  }
  void tv_mode() const noexcept {
    std::cout << *this << " in tv mode (4x3 aspect ratio)\n";
  }

  friend std::ostream& operator<<(std::ostream& os, const Projector& p) {
    return os << p.description;
  }
};

class Tuner {
  float frequency;
  std::string_view description;

 public:
  explicit Tuner(std::string_view d) : frequency{0.0}, description{d} {}
  void on() const noexcept { std::cout << *this << " on\n"; }
  void off() const noexcept { std::cout << *this << " off\n"; }
  void set_am() const noexcept { std::cout << *this << " setting AM mode\n"; }
  void set_fm() const noexcept { std::cout << *this << " setting FM mode\n"; }
  void set_frequency(const float f) noexcept {
    frequency = f;
    std::cout << *this << " setting frequency to " << frequency << std::endl;
  }

  friend std::ostream& operator<<(std::ostream& os, const Tuner& t) {
    return os << t.description << ", current frequency: " << t.frequency;
  }
};

class CdPlayer {
  unsigned short track;
  std::string_view description, title;

 public:
  explicit CdPlayer(std::string_view d)
      : track{0}, description{d}, title{"UNKNOWN TRACK"} {}
  void on() const noexcept { std::cout << *this << " on\n"; }
  void off() const noexcept { std::cout << *this << " off\n"; }
  void eject() noexcept {
    title = "EJECTED";
    std::cout << description << " eject\n";
  }
  void play(std::string_view t) noexcept {
    title = t;
    track = 1;
    std::cout << *this << std::endl;
  }
  void play(const unsigned short t) noexcept {
    track = t;
    std::cout << *this << std::endl;
  }
  void pause() const noexcept { std::cout << *this << " paused\n"; }
  void stop() noexcept {
    track = 0;
    std::cout << *this << " stopped\n";
  }

  friend std::ostream& operator<<(std::ostream& os, const CdPlayer& c) {
    return os << c.description << ", track: " << c.track << ": " << c.title;
  }
};

class Amplifier {
  unsigned short volume;
  std::string_view description;

 public:
  explicit Amplifier(std::string_view d) : volume{0}, description{d} {}
  void on() const noexcept { std::cout << *this << " on\n"; }
  void off() const noexcept { std::cout << *this << " off\n"; }
  void set_stereo_sound() const noexcept {
    std::cout << *this << " stereo mode on\n";
  }
  void set_surround_sound() const noexcept {
    std::cout << *this << " surround sound on (5 speakers, 1 subwoofer)\n";
  }
  void set_volume(const unsigned short v) noexcept {
    volume = v % 10;
    std::cout << "setting volume to: " << volume << "," << *this << std::endl;
  }
  void set_tuner(const Tuner& t) const noexcept {
    std::cout << *this << " setting tuner to: " << t << std::endl;
  }
  void set_dvd(const DvdPlayer& d) const noexcept {
    std::cout << *this << " setting streaming player to: " << d << std::endl;
  }

  friend std::ostream& operator<<(std::ostream& os, const Amplifier& a) {
    return os << a.description << " [" << a.volume << "]";
  }
};

}  // namespace Items
namespace Facades {
class Facade {
 public:
  virtual void watch_movie(std::string_view) noexcept = 0;
  virtual void end_movie() noexcept = 0;
  virtual void listen_radio(const float) noexcept = 0;
  virtual void end_radio() noexcept = 0;
  virtual ~Facade() = default;
};
class HomeTheaterFacade : public virtual Facade {
 private:
  Items::Amplifier amplifier;
  Items::Tuner tuner;
  Items::DvdPlayer dvd_player;
  Items::CdPlayer cd_player;
  Items::Projector projector;
  Items::TheatreLights theatre_lights;
  Items::Screen screen;
  Items::PopcornPopper popcorn_popper;

 public:
  HomeTheaterFacade(const Items::Amplifier& a, const Items::Tuner t,
                    const Items::DvdPlayer d, const Items::CdPlayer& c,
                    const Items::Projector& p, const Items::TheatreLights& tl,
                    const Items::Screen& s, const Items::PopcornPopper& pc)
      : amplifier{a},
        tuner{t},
        dvd_player{d},
        cd_player{c},
        projector{p},
        theatre_lights{tl},
        screen{s},
        popcorn_popper{pc} {
    // Init! THIS IS ONLY LEARNING MATERIAL!!!
  }
  void watch_movie(std::string_view m) noexcept override {
    std::cout << "Get ready to watch a movie...\n";
    popcorn_popper.on();
    popcorn_popper.pop();
    theatre_lights.dim(10);
    screen.down();
    projector.on();
    projector.wide_screen_mode();
    amplifier.on();
    amplifier.set_dvd(dvd_player);
    amplifier.set_surround_sound();
    amplifier.set_volume(5);
    dvd_player.on();
    dvd_player.play(m);
  }
  void end_movie() noexcept override {
    std::cout << "Shutting movie theater down...\n";
    popcorn_popper.off();
    theatre_lights.on();
    screen.up();
    projector.off();
    amplifier.off();
    dvd_player.stop();
    dvd_player.eject();
    dvd_player.off();
  }
  void listen_radio(const float f) noexcept override {
    std::cout << "Tuning in the airwaves...\n";
    tuner.on();
    tuner.set_frequency(f);
    amplifier.on();
    amplifier.set_volume(5);
    amplifier.set_tuner(tuner);
  }
  void end_radio() noexcept override {
    std::cout << "Shutting down the tuner...\n";
    tuner.off();
    amplifier.off();
  }
};
}  // namespace Facades
}  // namespace Structural

int main() {
  using namespace Structural;
  auto amp = Items::Amplifier{"Amplifier"};
  auto tuner = Items::Tuner{"AM/FM Tuner"};
  auto player = Items::DvdPlayer{"Streaming Player"};
  auto cd = Items::CdPlayer{"CD Player"};
  auto projector = Items::Projector{"Projector"};
  auto lights = Items::TheatreLights{"Theater Ceiling Lights"};
  auto screen = Items::Screen{"Theater Screen"};
  auto popper = Items::PopcornPopper{"Popcorn Popper"};

  auto homeTheater = Facades::HomeTheaterFacade(
      amp, tuner, player, cd, projector, lights, screen, popper);

  homeTheater.watch_movie("Raiders of the Lost Ark");
  homeTheater.end_movie();
}