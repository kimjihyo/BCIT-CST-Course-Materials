# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.13

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /cygdrive/c/Users/A00257049/.CLion2018.3/system/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/c/Users/A00257049/.CLion2018.3/system/cygwin_cmake/bin/cmake.exe -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/EvaluationOrder.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/EvaluationOrder.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/EvaluationOrder.dir/flags.make

CMakeFiles/EvaluationOrder.dir/main.cpp.o: CMakeFiles/EvaluationOrder.dir/flags.make
CMakeFiles/EvaluationOrder.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/EvaluationOrder.dir/main.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/EvaluationOrder.dir/main.cpp.o -c /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/main.cpp

CMakeFiles/EvaluationOrder.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/EvaluationOrder.dir/main.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/main.cpp > CMakeFiles/EvaluationOrder.dir/main.cpp.i

CMakeFiles/EvaluationOrder.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/EvaluationOrder.dir/main.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/main.cpp -o CMakeFiles/EvaluationOrder.dir/main.cpp.s

# Object files for target EvaluationOrder
EvaluationOrder_OBJECTS = \
"CMakeFiles/EvaluationOrder.dir/main.cpp.o"

# External object files for target EvaluationOrder
EvaluationOrder_EXTERNAL_OBJECTS =

EvaluationOrder.exe: CMakeFiles/EvaluationOrder.dir/main.cpp.o
EvaluationOrder.exe: CMakeFiles/EvaluationOrder.dir/build.make
EvaluationOrder.exe: CMakeFiles/EvaluationOrder.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable EvaluationOrder.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/EvaluationOrder.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/EvaluationOrder.dir/build: EvaluationOrder.exe

.PHONY : CMakeFiles/EvaluationOrder.dir/build

CMakeFiles/EvaluationOrder.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/EvaluationOrder.dir/cmake_clean.cmake
.PHONY : CMakeFiles/EvaluationOrder.dir/clean

CMakeFiles/EvaluationOrder.dir/depend:
	cd /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/EvaluationOrder/cmake-build-debug/CMakeFiles/EvaluationOrder.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/EvaluationOrder.dir/depend

