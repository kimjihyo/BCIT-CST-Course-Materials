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
CMAKE_SOURCE_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/oop_abstract.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/oop_abstract.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/oop_abstract.dir/flags.make

CMakeFiles/oop_abstract.dir/oop_abstract.cpp.o: CMakeFiles/oop_abstract.dir/flags.make
CMakeFiles/oop_abstract.dir/oop_abstract.cpp.o: ../oop_abstract.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/oop_abstract.dir/oop_abstract.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/oop_abstract.dir/oop_abstract.cpp.o -c /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/oop_abstract.cpp

CMakeFiles/oop_abstract.dir/oop_abstract.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/oop_abstract.dir/oop_abstract.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/oop_abstract.cpp > CMakeFiles/oop_abstract.dir/oop_abstract.cpp.i

CMakeFiles/oop_abstract.dir/oop_abstract.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/oop_abstract.dir/oop_abstract.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/oop_abstract.cpp -o CMakeFiles/oop_abstract.dir/oop_abstract.cpp.s

# Object files for target oop_abstract
oop_abstract_OBJECTS = \
"CMakeFiles/oop_abstract.dir/oop_abstract.cpp.o"

# External object files for target oop_abstract
oop_abstract_EXTERNAL_OBJECTS =

oop_abstract.exe: CMakeFiles/oop_abstract.dir/oop_abstract.cpp.o
oop_abstract.exe: CMakeFiles/oop_abstract.dir/build.make
oop_abstract.exe: CMakeFiles/oop_abstract.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable oop_abstract.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/oop_abstract.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/oop_abstract.dir/build: oop_abstract.exe

.PHONY : CMakeFiles/oop_abstract.dir/build

CMakeFiles/oop_abstract.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/oop_abstract.dir/cmake_clean.cmake
.PHONY : CMakeFiles/oop_abstract.dir/clean

CMakeFiles/oop_abstract.dir/depend:
	cd /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week5/Day1Code/oop_abstract/cmake-build-debug/CMakeFiles/oop_abstract.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/oop_abstract.dir/depend

