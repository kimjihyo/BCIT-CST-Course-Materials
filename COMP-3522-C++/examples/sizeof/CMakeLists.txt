cmake_minimum_required(VERSION 3.13)
project(sizeof)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(sizeof
        sizeof.cpp)
