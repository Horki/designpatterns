cmake_minimum_required(VERSION 3.6)
project(patterns)

set(CMAKE_CXX_COMPILER /usr/bin/clang++)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_VERBOSE_MAKEFILE ON)

find_package(Threads REQUIRED)

add_compile_options(-Wall -Wextra -pedantic -Werror)

add_executable(strategy behavioural/strategy.cc)
add_executable(observer behavioural/observer.cc)
add_executable(decorator structural/decorator.cc)
add_executable(factory_method creational/factory_method.cc)
add_executable(abstract_factory creational/abstract_factory.cc)
add_executable(singleton creational/singleton.cc)
add_executable(command behavioural/command.cc)
add_executable(adapter structural/adapter.cc)
add_executable(facade structural/facade.cc)
add_executable(template_method behavioural/template_method.cc)
add_executable(composite structural/composite.cc)
add_executable(iterator behavioural/iterator.cc)
add_executable(state behavioural/state.cc)
add_executable(proxy structural/proxy.cc)

target_link_libraries(singleton Threads::Threads)
