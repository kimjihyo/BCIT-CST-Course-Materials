# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.15

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
CMAKE_COMMAND = /cygdrive/c/Users/chira/.CLion2019.2/system/cygwin_cmake/bin/cmake.exe

# The command to remove a file.
RM = /cygdrive/c/Users/chira/.CLion2019.2/system/cygwin_cmake/bin/cmake.exe -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/fileIO.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/fileIO.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/fileIO.dir/flags.make

CMakeFiles/fileIO.dir/main.cpp.o: CMakeFiles/fileIO.dir/flags.make
CMakeFiles/fileIO.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/fileIO.dir/main.cpp.o"
	C:/cygwin64/bin/g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/fileIO.dir/main.cpp.o -c "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/main.cpp"

CMakeFiles/fileIO.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/fileIO.dir/main.cpp.i"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/main.cpp" > CMakeFiles/fileIO.dir/main.cpp.i

CMakeFiles/fileIO.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/fileIO.dir/main.cpp.s"
	C:/cygwin64/bin/g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/main.cpp" -o CMakeFiles/fileIO.dir/main.cpp.s

# Object files for target fileIO
fileIO_OBJECTS = \
"CMakeFiles/fileIO.dir/main.cpp.o"

# External object files for target fileIO
fileIO_EXTERNAL_OBJECTS =

fileIO.exe: CMakeFiles/fileIO.dir/main.cpp.o
fileIO.exe: CMakeFiles/fileIO.dir/build.make
fileIO.exe: CMakeFiles/fileIO.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable fileIO.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/fileIO.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/fileIO.dir/build: fileIO.exe

.PHONY : CMakeFiles/fileIO.dir/build

CMakeFiles/fileIO.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/fileIO.dir/cmake_clean.cmake
.PHONY : CMakeFiles/fileIO.dir/clean

CMakeFiles/fileIO.dir/depend:
	cd "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO" "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO" "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/cmake-build-debug" "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/cmake-build-debug" "/cygdrive/c/Users/chira/Desktop/BCIT/Term 3/comp_3522/Week 1/Week2Day1Sample/fileIO/cmake-build-debug/CMakeFiles/fileIO.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/fileIO.dir/depend

