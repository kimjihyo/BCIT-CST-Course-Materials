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
CMAKE_COMMAND = /cygdrive/c/Users/a00257049/.CLion2018.3/system/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/c/Users/a00257049/.CLion2018.3/system/cygwin_cmake/bin/cmake.exe -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/random_c.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/random_c.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/random_c.dir/flags.make

CMakeFiles/random_c.dir/random_c.cpp.o: CMakeFiles/random_c.dir/flags.make
CMakeFiles/random_c.dir/random_c.cpp.o: ../random_c.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/random_c.dir/random_c.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/random_c.dir/random_c.cpp.o -c /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/random_c.cpp

CMakeFiles/random_c.dir/random_c.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/random_c.dir/random_c.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/random_c.cpp > CMakeFiles/random_c.dir/random_c.cpp.i

CMakeFiles/random_c.dir/random_c.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/random_c.dir/random_c.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/random_c.cpp -o CMakeFiles/random_c.dir/random_c.cpp.s

# Object files for target random_c
random_c_OBJECTS = \
"CMakeFiles/random_c.dir/random_c.cpp.o"

# External object files for target random_c
random_c_EXTERNAL_OBJECTS =

random_c.exe: CMakeFiles/random_c.dir/random_c.cpp.o
random_c.exe: CMakeFiles/random_c.dir/build.make
random_c.exe: CMakeFiles/random_c.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable random_c.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/random_c.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/random_c.dir/build: random_c.exe

.PHONY : CMakeFiles/random_c.dir/build

CMakeFiles/random_c.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/random_c.dir/cmake_clean.cmake
.PHONY : CMakeFiles/random_c.dir/clean

CMakeFiles/random_c.dir/depend:
	cd /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/cmake-build-debug /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/cmake-build-debug /cygdrive/c/Users/a00257049/CLionProjects/COMP3512Winter/Week2/random_c/cmake-build-debug/CMakeFiles/random_c.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/random_c.dir/depend
