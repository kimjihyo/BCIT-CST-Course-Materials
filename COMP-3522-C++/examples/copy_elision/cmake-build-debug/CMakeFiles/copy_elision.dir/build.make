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
CMAKE_SOURCE_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/copy_elision.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/copy_elision.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/copy_elision.dir/flags.make

CMakeFiles/copy_elision.dir/copy_elision.cpp.o: CMakeFiles/copy_elision.dir/flags.make
CMakeFiles/copy_elision.dir/copy_elision.cpp.o: ../copy_elision.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/copy_elision.dir/copy_elision.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/copy_elision.dir/copy_elision.cpp.o -c /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/copy_elision.cpp

CMakeFiles/copy_elision.dir/copy_elision.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/copy_elision.dir/copy_elision.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/copy_elision.cpp > CMakeFiles/copy_elision.dir/copy_elision.cpp.i

CMakeFiles/copy_elision.dir/copy_elision.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/copy_elision.dir/copy_elision.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/copy_elision.cpp -o CMakeFiles/copy_elision.dir/copy_elision.cpp.s

# Object files for target copy_elision
copy_elision_OBJECTS = \
"CMakeFiles/copy_elision.dir/copy_elision.cpp.o"

# External object files for target copy_elision
copy_elision_EXTERNAL_OBJECTS =

copy_elision.exe: CMakeFiles/copy_elision.dir/copy_elision.cpp.o
copy_elision.exe: CMakeFiles/copy_elision.dir/build.make
copy_elision.exe: CMakeFiles/copy_elision.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable copy_elision.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/copy_elision.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/copy_elision.dir/build: copy_elision.exe

.PHONY : CMakeFiles/copy_elision.dir/build

CMakeFiles/copy_elision.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/copy_elision.dir/cmake_clean.cmake
.PHONY : CMakeFiles/copy_elision.dir/clean

CMakeFiles/copy_elision.dir/depend:
	cd /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week4/copy_elision/cmake-build-debug/CMakeFiles/copy_elision.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/copy_elision.dir/depend

