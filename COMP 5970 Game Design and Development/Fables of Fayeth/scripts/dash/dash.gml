///@func dash(speed, direction)
/// @arg speed
/// @arg direction

var spd = argument0;
var dir = argument1;
var dir_rounded = round(dir)
var ghosts = ceil(dir_rounded / 64);
hspd = lengthdir_x(spd*4, dir);
vspd = lengthdir_y(spd*4, dir);


phy_position_x += hspd;
phy_position_y += vspd;

for (var i = .96; i >= 0; i -= .9 /ghosts)
{
	var dash_ghost = instance_create_depth(phy_position_xprevious, phy_position_yprevious, 0, obj_HeroDashGhost);
	dash_ghost.image_xscale = image_xscale;
}

//dashing = false;
//limit dashing
//screen shake
