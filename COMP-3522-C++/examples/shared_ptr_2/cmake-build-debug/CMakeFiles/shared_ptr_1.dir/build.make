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
CMAKE_SOURCE_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/shared_ptr_1.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/shared_ptr_1.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/shared_ptr_1.dir/flags.make

CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.o: CMakeFiles/shared_ptr_1.dir/flags.make
CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.o: ../shared_ptr_1.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.o -c /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/shared_ptr_1.cpp

CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/shared_ptr_1.cpp > CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.i

CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/shared_ptr_1.cpp -o CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.s

# Object files for target shared_ptr_1
shared_ptr_1_OBJECTS = \
"CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.o"

# External object files for target shared_ptr_1
shared_ptr_1_EXTERNAL_OBJECTS =

shared_ptr_1.exe: CMakeFiles/shared_ptr_1.dir/shared_ptr_1.cpp.o
shared_ptr_1.exe: CMakeFiles/shared_ptr_1.dir/build.make
shared_ptr_1.exe: CMakeFiles/shared_ptr_1.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable shared_ptr_1.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/shared_ptr_1.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/shared_ptr_1.dir/build: shared_ptr_1.exe

.PHONY : CMakeFiles/shared_ptr_1.dir/build

CMakeFiles/shared_ptr_1.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/shared_ptr_1.dir/cmake_clean.cmake
.PHONY : CMakeFiles/shared_ptr_1.dir/clean

CMakeFiles/shared_ptr_1.dir/depend:
	cd /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2 /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2 /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/cmake-build-debug /cygdrive/c/Users/A00257049/CLionProjects/COMP3522Fall2019/Week12Review/Day1/shared_ptr_2/cmake-build-debug/CMakeFiles/shared_ptr_1.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/shared_ptr_1.dir/depend

