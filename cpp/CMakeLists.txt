cmake_minimum_required(VERSION 3.6)
project(patterns)

set(CMAKE_CXX_COMPILER /usr/bin/clang++)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_VERBOSE_MAKEFILE ON)

add_compile_options(-Wall -Wextra -pedantic -Werror)

add_executable(strategy behavioural/strategy.cc)

