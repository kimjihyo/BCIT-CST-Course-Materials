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
CMAKE_SOURCE_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/lvaluervalue4.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/lvaluervalue4.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/lvaluervalue4.dir/flags.make

CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.o: CMakeFiles/lvaluervalue4.dir/flags.make
CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.o: ../lvaluervalue4.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.o -c /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/lvaluervalue4.cpp

CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/lvaluervalue4.cpp > CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.i

CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/lvaluervalue4.cpp -o CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.s

# Object files for target lvaluervalue4
lvaluervalue4_OBJECTS = \
"CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.o"

# External object files for target lvaluervalue4
lvaluervalue4_EXTERNAL_OBJECTS =

lvaluervalue4.exe: CMakeFiles/lvaluervalue4.dir/lvaluervalue4.cpp.o
lvaluervalue4.exe: CMakeFiles/lvaluervalue4.dir/build.make
lvaluervalue4.exe: CMakeFiles/lvaluervalue4.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable lvaluervalue4.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/lvaluervalue4.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/lvaluervalue4.dir/build: lvaluervalue4.exe

.PHONY : CMakeFiles/lvaluervalue4.dir/build

CMakeFiles/lvaluervalue4.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/lvaluervalue4.dir/cmake_clean.cmake
.PHONY : CMakeFiles/lvaluervalue4.dir/clean

CMakeFiles/lvaluervalue4.dir/depend:
	cd /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4 /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4 /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3512Winter/Week11/lvaluervalue4/cmake-build-debug/CMakeFiles/lvaluervalue4.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/lvaluervalue4.dir/depend
