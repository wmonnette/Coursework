/// @function scr_calculate_dist
var dist1, dist2, dist3, dist4, dist5, dist6, dist7, dist8, nearestAttackTile;

nearestAttackTile = instance_nearest(mouse_x, mouse_y, obj_TileAttack);

if (instance_position(nearestAttackTile.x-64, nearestAttackTile.y, obj_TileWalkable))
{
	dist1 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x-64, nearestAttackTile.y);
} else
{
	dist1 = 10000;
}

if (instance_position(nearestAttackTile.x+64, nearestAttackTile.y, obj_TileWalkable))
{
	dist2 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x+64, nearestAttackTile.y);
} else
{
	dist2 = 10000;
}

if (instance_position(nearestAttackTile.x, nearestAttackTile.y-64, obj_TileWalkable))
{
	dist3 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x, nearestAttackTile.y-64);
} else
{
	dist3 = 10000;
}

if (instance_position(nearestAttackTile.x, nearestAttackTile.y+64, obj_TileWalkable))
{
	dist4 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x, nearestAttackTile.y+64);
} else
{
	dist4 = 10000;
}

if (instance_position(nearestAttackTile.x-64, nearestAttackTile.y-64, obj_TileWalkable))
{
	dist5 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x-64, nearestAttackTile.y-64);
} else
{
	dist5 = 10000;
}

if (instance_position(nearestAttackTile.x-64, nearestAttackTile.y+64, obj_TileWalkable))
{
	dist6 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x-64, nearestAttackTile.y+64);
} else
{
	dist6 = 10000;
}

if (instance_position(nearestAttackTile.x+64, nearestAttackTile.y-64, obj_TileWalkable))
{
	dist7 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x+64, nearestAttackTile.y-64);
} else
{
	dist7 = 10000;
}

if (instance_position(nearestAttackTile.x+64, nearestAttackTile.y+64, obj_TileWalkable))
{
	dist8 = point_distance(global.selected.x, global.selected.y, nearestAttackTile.x+64, nearestAttackTile.y+64);
} else
{
	dist8 = 10000;
}

var dest = min(dist1, dist2, dist3, dist4, dist5, dist6, dist7, dist8);

if (dest == dist1)
{
	global.attack_travel_x = nearestAttackTile.x-64;
	global.attack_travel_y = nearestAttackTile.y;
}
if (dest == dist2)
{
	global.attack_travel_x = nearestAttackTile.x+64;
	global.attack_travel_y = nearestAttackTile.y;
}
if (dest == dist3)
{
	global.attack_travel_x = nearestAttackTile.x;
	global.attack_travel_y = nearestAttackTile.y-64;
}
if (dest == dist4)
{
	global.attack_travel_x = nearestAttackTile.x;
	global.attack_travel_y = nearestAttackTile.y+64;
}
if (dest == dist5)
{
	global.attack_travel_x = nearestAttackTile.x-64;
	global.attack_travel_y = nearestAttackTile.y-64;
}
if (dest == dist6)
{
	global.attack_travel_x = nearestAttackTile.x-64;
	global.attack_travel_y = nearestAttackTile.y+64;
}
if (dest == dist7)
{
	global.attack_travel_x = nearestAttackTile.x+64;
	global.attack_travel_y = nearestAttackTile.y-64;
}
if (dest == dist8)
{
	global.attack_travel_x = nearestAttackTile.x+64;
	global.attack_travel_y = nearestAttackTile.y+64;
}