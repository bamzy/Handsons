# CSS gradient builds transitions between two or more colors
there are 3 types of gradients
- **Linear** : goes down, up, left, right and diagonal
- **Radial** : defined by the center
- **Conic** : rotated around a center

## Linear:
* _linear-gradient(direction, color-stop1,color-stop2, ...)_

default direction is **Top to Bottom**<br>

give a direction and then list the colors, each color can have a starting point
`background: linear-gradient(
to left,
red 50%,
orange  ,
yellow ,
green ,
blue
);`

* Instead of direction you can define angles:<br>
_linear-gradient(angel, color-stop1,color-stop2, ...)_
* **0deg** is equivalent of **To Top**
* **90deg** is equivalent of **To Right**
* **180deg** is equivalent of **To Bottom**
* you can have transparent colors as well for example use rgba color
  `background: linear-gradient(
  to right,
  rgba(255,0,0,0),
  rgba(255,0,0,1)
  );`

## Radial:
Evenly Spaced Color shapes w Stops
* _radial-gradient(shape size at position, start-color, ..., last-color);_
* default shape is ellipse + default position is center and default size is the farthest-corner
* above means that colors start from center outwards

* `radial-gradient(red 5%,blue 10%, green 40%)`
* `radial-gradient(circle,red 5%,blue 10%, green 40%)`

## Conic:
A conic gradient is a gradient with color transitions rotated around a center point.
* _background-image: conic-gradient([from angle] [at position,] color [degree], color [degree], ...);_

* `background-image: conic-gradient(red, yellow, green);`