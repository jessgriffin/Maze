/****************************************************************************
 *
 * Created by: Jess 
 * Created on: Nov 2016
 * Assignment 5b
 * This program solves a maze and shows you the path through it.
 * you need to change some text and numbers around to be able to put in a different maze
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// MUST BE 10X5 ARRAY 

public class TheMaze {

	public static void main(String[] args) throws IOException {
		
		//input the text file. test.txt should be whatever your maze is
		String inputDoc = "test.txt";
		FileReader fr = new FileReader(inputDoc);
	    BufferedReader br = new BufferedReader(fr);
	    
	    
		
		//if your maze has dimensions different than 10x5, change these x and y values accordingly
		int x = 5;
		int y = 10;
		char [][] maze = new char [x][y];
		int xPosition = 0;
		int yPosition = 0;
		
		//now... to get the string into the 2d char array.
		for (int rows = 0; rows < maze.length; rows++) {
					
			String thisLineString;
			char thisLineArray[] = new char [x];
			thisLineString = br.readLine();
			thisLineArray = thisLineString.toCharArray();
			
			for (int columns = 0; columns < maze[0].length; columns++) {
				
				maze[rows][columns] = thisLineArray[columns];
				
			}	
			
		}
		
		//find starting position
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				
				if (maze[i][j] == 'S') {
					
					xPosition = i;
					yPosition = j;
					
				}
				
			}
		}
		
		
		// i dont think this actually does anything because we end up printing the solved maze withib the function. cant make
		//it a void because that would mess up the recursion stuff going on
		char randomArray [][] = FindPath(maze , xPosition, yPosition);
		
		


	}

	
	public static char [][] FindPath( char [][]maze, int xPosition, int yPosition) {
		
		//first if to see if inbounds
		if (0 <= xPosition && maze.length > xPosition && 0 <= yPosition && maze[0].length > yPosition) {
		
			if (maze[xPosition][yPosition] == 'G') {
				//solution found ,
				
				// FIGURE OUT HOW TO print solved maze
				
				//using for loops you kind of reverse engineer what you did putting it from a string to 2d char array
				for (int one = 0; one < maze.length; one++) {
					//resets the line after it's printed, first time around this does nothing
					String lineOfMaze = "";
					
					for (int two = 0; two < maze[0].length; two++) {
						
						lineOfMaze = lineOfMaze + maze[one][two];
					}
					
					System.out.println(lineOfMaze);
					
				}
				
				return maze;
				
			} else if (maze[xPosition][yPosition] == '#') {
				
				// wall
				return maze; 
				
			} else if (maze[xPosition][yPosition] == '+') {
				//already been here
				
				return maze;
			} else if (maze[xPosition][yPosition] == 'S' || maze[xPosition][yPosition] == '.'){
				//when youre at the start, or on an open path
				
				if (maze[xPosition][yPosition] == '.') {
					
					//marks the spot as part of the path
					maze[xPosition][yPosition] = '+';
					
				}
				if (FindPath(maze, xPosition, yPosition+1) != maze) {
					//checks to the north
					
					return maze;
				} else if (FindPath(maze, xPosition+1, yPosition) != maze) {
					//checks east
					
					return maze;
				} else if (FindPath(maze, xPosition, yPosition-1) != maze) {
					//check south
					
					return maze;
				} else if (FindPath(maze, xPosition-1, yPosition) != maze) {
					//checks west
					
					return maze;
				} else {
					// no path found, start backtracking and remove this spot as being a place on the path, unless youre still at the start
					//in which case it just doesn't do anything
					if (maze[xPosition][yPosition] == '+') {
							
							maze[xPosition][yPosition] = '.';
							
					}
					
					return maze;
				}
				
				
			}
		
			
		}
		return maze; 
	}
}
					
				}
				
			}
		}
		
		
		// i dont think this actually does anything because we end up printing the solved maze withib the function. cant make
		//it a void because that would mess up the recursion stuff going on
		char randomArray [][] = FindPath(maze , xPosition, yPosition);
		
		


	}

	
	public static char [][] FindPath( char [][]maze, int xPosition, int yPosition) {
		
		//first if to see if inbounds
		if (0 <= xPosition && maze.length > xPosition && 0 <= yPosition && maze[0].length > yPosition) {
		
			if (maze[xPosition][yPosition] == 'G') {
				//solution found ,
				
				// FIGURE OUT HOW TO print solved maze
				
				//using for loops you kind of reverse engineer what you did putting it from a string to 2d char array
				for (int one = 0; one < maze.length; one++) {
					//resets the line after it's printed, first time around this does nothing
					String lineOfMaze = "";
					
					for (int two = 0; two < maze[0].length; two++) {
						
						lineOfMaze = lineOfMaze + maze[one][two];
					}
					
					
				}
				
				return maze;
				
			} else if (maze[xPosition][yPosition] == '#') {
				
				// wall
				return maze; 
				
			} else if (maze[xPosition][yPosition] == '+') {
				//already been here
				
				return maze;
			} else if (maze[xPosition][yPosition] == 'S' || maze[xPosition][yPosition] == '.'){
				//when youre at the start, or on an open path
				
				if (maze[xPosition][yPosition] == '.') {
					
					//marks the spot as part of the path
					maze[xPosition][yPosition] = '+';
					
				}
				if (FindPath(maze, xPosition, yPosition+1) != maze) {
					//checks to the north
					
					return maze;
				} else if (FindPath(maze, xPosition+1, yPosition) != maze) {
					//checks east
					
					return maze;
				} else if (FindPath(maze, xPosition, yPosition-1) != maze) {
					//check south
					
					return maze;
				} else if (FindPath(maze, xPosition-1, yPosition) != maze) {
					//checks west
					
					return maze;
				} else {
					// no path found, start backtracking and remove this spot as being a place on the path, unless youre still at the start
					//in which case it just doesn't do anything
					if (maze[xPosition][yPosition] == '+') {
							
							maze[xPosition][yPosition] = '.';
							
					}
					
					return maze;
				}
				
				
			}
		
			
		}
		return maze; 
	}

}
