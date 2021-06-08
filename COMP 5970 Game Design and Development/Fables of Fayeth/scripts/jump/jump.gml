///@func jump(speed, direction)
/// @arg speed
/// @arg direction

var spd = argument0;
var dir = argument1;

hspd = lengthdir_x(spd*2, dir);
vspd = lengthdir_y(spd*2, dir);


phy_position_x += hspd;
phy_position_y += vspd;


