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
CMAKE_SOURCE_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/virtual.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/virtual.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/virtual.dir/flags.make

CMakeFiles/virtual.dir/virtual.cpp.o: CMakeFiles/virtual.dir/flags.make
CMakeFiles/virtual.dir/virtual.cpp.o: ../virtual.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/virtual.dir/virtual.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/virtual.dir/virtual.cpp.o -c /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/virtual.cpp

CMakeFiles/virtual.dir/virtual.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/virtual.dir/virtual.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/virtual.cpp > CMakeFiles/virtual.dir/virtual.cpp.i

CMakeFiles/virtual.dir/virtual.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/virtual.dir/virtual.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/virtual.cpp -o CMakeFiles/virtual.dir/virtual.cpp.s

# Object files for target virtual
virtual_OBJECTS = \
"CMakeFiles/virtual.dir/virtual.cpp.o"

# External object files for target virtual
virtual_EXTERNAL_OBJECTS =

virtual.exe: CMakeFiles/virtual.dir/virtual.cpp.o
virtual.exe: CMakeFiles/virtual.dir/build.make
virtual.exe: CMakeFiles/virtual.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable virtual.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/virtual.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/virtual.dir/build: virtual.exe

.PHONY : CMakeFiles/virtual.dir/build

CMakeFiles/virtual.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/virtual.dir/cmake_clean.cmake
.PHONY : CMakeFiles/virtual.dir/clean

CMakeFiles/virtual.dir/depend:
	cd /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/virtual/cmake-build-debug/CMakeFiles/virtual.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/virtual.dir/depend

