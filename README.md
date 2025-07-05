# fan-Animation
一个用java实现的风扇实现，能够使用按钮对风扇进行转速、方向以及开关的控制；通过鼠标控制风扇的停止和开始；绑定风扇，使得当拖动窗口时，风扇始终居中

![example](https://github.com/abao1041/fan-/blob/main/FanAnimation/img.png)

## 1.ActionEvent on buttons
(1)When cursor is on the button, change cursor into hand;

(2)Click > button to start fan running;

(3)Click || button to pause fan running;

(4)Click ← button to make fan running turn left;

(5)Click → button to make fan running turn right;

(6)Click ↑ button to speed up fan running;

(7)Click ↓ button to speed down fan running;

## 2.MouseEvent on fan
Click mouse on the fan to change its current status. For example, 

(1)If the fan is running and click mouse on the fan, change it into paused; 

(2)If the fan is paused and click mouse on the fan, change it into running;

## 3.KeyEvent on FanPane
(1)Press Enter on keyboard to start and pause fan running;

(2)Press Up on keyboard to speed up fan running;

(3)Press Down on keyboard to speed up fan running;

## 4.Binding properties
(1)Bind the position of the fan to its outer pane properties. So that no matter how we change the window’s size, the position of fan is always in the center of the window.
