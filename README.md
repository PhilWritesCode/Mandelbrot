# Mandelbrot
Graph the Mandelbrot Set

  The application	displays the Mandelbrot Set for bounds passed as arguments:

 	args[0] = upper left real point on the Complex plane
 	args[1] = upper left imaginary point on the Complex plane
 	args[2] = lower right real point on the Complex plane
 	args[3] = lower right imaginary point on the Complex plane

 	Complex Plane:
 	                  ^
 	(args[0],args[1]) |
 	                  |
 	                  |
 	                  |
 	                  |
 	                  |
 	                  |-----------------> (args[2],args[3])

 	Sample input include:
 	-2 1.5 1 -1.5 for the full set
 	-0.736 0.226 -0.726 0.214 for a small sample
 	.2869 .01429 .2870 .01427 for an interesting perspective

The application is launched from the command line:  java Mandelbrot -2 1.5 1 -1.5

If no parameters are passed, or the passed parameters are invalid, the application will default to -2 1.5 1 -1.5, which displays the entire Mandelbrot Set.

Screenshot
---
![Mandelbrot](http://i.imgur.com/bUITTrd.png)

Disclaimer:  In researching the mathematics of complex numbers during the early phases of this application, I stumbled upon http://www.cs.unc.edu/~stotts/144/assignments/1/.  That site defines an assignment for what appears to be a UNC Computer Science class.  Since it dealt with exactly what I was trying to write, I used it as a guideline for my program -- you'll notice my input parameters are in the same format.  I did not attend UNC, and all code within this application is my own.

